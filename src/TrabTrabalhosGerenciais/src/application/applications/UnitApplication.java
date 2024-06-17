package application.applications;

import application.mappers.UnitMap;
import application.viewModels.UnitVM;
import java.util.ArrayList;
import java.util.List;
import domain.model.entities.ResponseService;
import domain.model.entities.UnitModel;
import domain.interfaces.services.IUnitService;

public class UnitApplication {
    private final IUnitService unitService;
    
    public UnitApplication(IUnitService unitService){
        this.unitService = unitService;
    }
    
    public ResponseService getResponseService(){
        return unitService.getResponseService();
    }
    
    public void create(UnitVM unitVM){
        UnitModel unitModel = new UnitModel(unitVM.name, unitVM.symbol);
        unitService.insert(unitModel);
    }
    
    public void update(UnitVM unitVM){
        unitService.update(UnitMap.getUnit(unitVM));
    }
    
    public void delete(int id){
        unitService.remove(id);
    }
    
    public UnitVM get(int id){
        return UnitMap.getUnitVM(unitService.get(id));
    }
    
    public List<UnitVM> getAll(){
        return UnitMap.getUnitsVM(unitService.getAll());
    }
}
