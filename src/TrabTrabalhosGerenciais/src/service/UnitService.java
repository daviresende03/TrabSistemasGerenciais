package service;

import java.util.ArrayList;
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
                UnitModel modelDataBase = unitRepository.select(model.getName());
                if(modelDataBase.getId() > 0){
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
            
            UnitModel unit = unitRepository.select(id);
            
            if(unit.getId() <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Unidade não encontrada.");
                return;
            }
            
            unitRepository.delete(id);
            
            dataContext.commit();
            
            responseService.setResponse(ResponseTypeEnum.ERROR, "Unidade deletada com sucesso.");
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
            
            UnitModel unit = unitRepository.select(model.getId());
            if(unit.getId() <= 0){
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
            return units;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar todas as unidades.");
            return new ArrayList<UnitModel>();
        }
    }    
}
