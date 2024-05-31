package application;

import controller.viewModels.UnitVM;
import model.entities.ResponseService;
import model.entities.UnitModel;
import model.interfaces.services.IUnitService;

public class UnitApplication {
    private final IUnitService unitService;
    
    public UnitApplication(IUnitService unitService){
        this.unitService = unitService;
    }
    
    public ResponseService create(UnitVM unitVM){
        UnitModel unitModel = new UnitModel(unitVM.name, unitVM.symbol);
        return unitService.insert(unitModel);
    }
    
    public ResponseService update(UnitVM unitVM){
        UnitModel unitModel = new UnitModel(unitVM.id, unitVM.name, unitVM.symbol);
        return unitService.update(unitModel);
    }
    
    public ResponseService delete(int id){
        return unitService.remove(id);
    }
    
    public ResponseService get(int id){
        return unitService.get(id);
    }
    
    public ResponseService getAll(){
        return unitService.getAll();
    }
}
