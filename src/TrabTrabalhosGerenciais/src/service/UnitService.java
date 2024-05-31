package service;

import java.util.Date;
import java.util.List;
import model.entities.ResponseService;
import model.entities.UnitModel;
import model.enums.ResponseTypeEnum;
import model.interfaces.repositories.IDataContext;
import model.interfaces.repositories.IUnitRepository;
import model.interfaces.services.IUnitService;

public class UnitService implements IUnitService {
    private final IUnitRepository unitRepository;
    private final IDataContext dataContext;
    private ResponseService responseService;
    
    public UnitService(IDataContext dataContext, IUnitRepository unitRepository){
        this.dataContext = dataContext;
        this.unitRepository = unitRepository;
        responseService = new ResponseService();
    }

    @Override
    public ResponseService insert(UnitModel model) {
        try{ 
            Date dateNow = new Date();
            model.setUpdatedDate(dateNow);
            model.setCreatedDate(dateNow);
            
            if(model.validate()){
                UnitModel modelDataBase = unitRepository.select(model.getName());
                if(modelDataBase.getId() > 0){
                    return responseService.setResponse(ResponseTypeEnum.ERROR, "Unidade já cadastrada!");
                }
                
                unitRepository.insert(model);
            }else{
                return responseService.setResponse(ResponseTypeEnum.ERROR, model.getMessage());
            }
            dataContext.commit();
            return responseService.setResponse(ResponseTypeEnum.SUCCESS, "Unidade cadastrada com sucesso!");
        }catch(Exception ex){
            dataContext.rollback();
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao realizar o cadastro da unidade.");
        }
    }

    @Override
    public ResponseService remove(int id) {
        try{
            if(id <= 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
            }
            
            UnitModel unit = unitRepository.select(id);
            
            if(unit.getId() <= 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "Unidade não encontrada.");
            }
            
            unitRepository.delete(id);
            
            dataContext.commit();
            
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Unidade deletada com sucesso.");
        }catch(Exception ex){
            dataContext.rollback();
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao deletar a unidade.");
        }
    }

    @Override
    public ResponseService update(UnitModel model) {
        try{
            if(model.getId() <= 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
            }
            
            UnitModel unit = unitRepository.select(model.getId());
            if(unit.getId() <= 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "Unidade não encontrada.");
            }
            
            Date dateNow = new Date();
            model.setUpdatedDate(dateNow);
            
            if(model.validate()){
                unitRepository.update(model);
            }else{
                return responseService.setResponse(ResponseTypeEnum.ERROR, model.getMessage());
            }
            dataContext.commit();
            return responseService.setResponse(ResponseTypeEnum.SUCCESS, "Unidade atualizada com sucesso!");
        }catch(Exception ex){
            dataContext.rollback();
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao atualizar a unidade.");
        }
    }

    @Override
    public ResponseService<UnitModel> get(int id) {
        try{
            if(id <= 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
            }
            
            UnitModel unit = unitRepository.select(id);
            
            if(unit.getId() >= 0){
                return responseService.setResponse(ResponseTypeEnum.SUCCESS, "", unit);
            }
            
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Unidade não encontrada.");
        }catch(Exception ex){
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar a unidade.");
        }
    }

    @Override
    public ResponseService<List<UnitModel>> getAll() {
        try{            
            List<UnitModel> unidades = unitRepository.select();
            return responseService.setResponse(ResponseTypeEnum.SUCCESS, "", unidades);
        }catch(Exception ex){
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar todas as unidades.");
        }
    }    
}
