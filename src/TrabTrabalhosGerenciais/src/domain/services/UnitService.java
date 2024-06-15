package domain.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import domain.model.entities.ResponseService;
import domain.model.entities.UnitModel;
import domain.model.enums.ResponseTypeEnum;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.repositories.IUnitRepository;
import domain.interfaces.services.IUnitService;

public class UnitService extends BaseService implements IUnitService {
    private final IUnitRepository unitRepository;
    
    public UnitService(IDataContext dataContext, IUnitRepository unitRepository){
        super(dataContext);
        this.unitRepository = unitRepository;
    }
    
    @Override
    public ResponseService getResponseService(){
        return responseService;
    }

    @Override
    public void insert(UnitModel model) {
        try{ 
            Date dateNow = new Date();
            model.setUpdatedDate(dateNow);
            model.setCreatedDate(dateNow);
            
            if(model.validate()){
                if(unitRepository.exist(model.getName())){
                    responseService.setResponse(ResponseTypeEnum.ERROR, "Unidade já cadastrada!");
                    return;
                }
                
                unitRepository.insert(model);
            }else{
                responseService.setResponse(ResponseTypeEnum.ERROR, model.getMessage());
                return;
            }
            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Unidade cadastrada com sucesso!");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao realizar o cadastro da unidade.");
        }
    }

    @Override
    public void remove(int id) {
        try{
            if(id <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
                return;
            }
            
            if(unitRepository.exist(id)){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Unidade não encontrada.");
                return;
            }
            
            unitRepository.delete(id);
            
            dataContext.commit();
            
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Unidade deletada com sucesso.");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao deletar a unidade.");
        }
    }

    @Override
    public void update(UnitModel model) {
        try{
            if(model.getId() <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
                return;
            }
            
            if(!unitRepository.exist(model.getId())){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Unidade não encontrada.");
                return;
            }
            
            Date dateNow = new Date();
            model.setUpdatedDate(dateNow);
            
            if(model.validate()){
                unitRepository.update(model);
            }else{
                responseService.setResponse(ResponseTypeEnum.ERROR, model.getMessage());
                return;
            }
            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Unidade atualizada com sucesso!");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao atualizar a unidade.");
        }
    }

    @Override
    public UnitModel get(int id) {
        try{
            if(id <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
                return new UnitModel();
            }
            
            UnitModel unit = unitRepository.select(id);
            
            if(unit.getId() >= 0){
                responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
            }else{
                responseService.setResponse(ResponseTypeEnum.ERROR, "Unidade não encontrada.");
            }
            return unit;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar a unidade.");
            return new UnitModel();
        }
    }

    @Override
    public List<UnitModel> getAll() {
        try{            
            List<UnitModel> units = unitRepository.select();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
            dataContext.commit();
            return units;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar todas as unidades.");
            return new ArrayList<UnitModel>();
        }
    }    
}
