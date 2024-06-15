package controllers;

import infra.dependencyInjections.UnitDI;
import application.applications.UnitApplication;
import application.viewModels.UnitVM;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.IUnitService;
import domain.model.entities.ResponseService;
import java.util.List;

public class UnitController {
    private final UnitApplication unitApplication;

    public UnitController() {
        UnitDI unitDependencyInjection = new UnitDI();
        IDataContext dataContext = unitDependencyInjection.getDataContext();
        IUnitService unitService = unitDependencyInjection.getUnitService(dataContext,
                unitDependencyInjection.getUnitRepository(dataContext.getConnection()));
        
        unitApplication = new UnitApplication(unitService);
    }
    
    public ResponseService getResponseService(){
        return unitApplication.getResponseService();
    } 
    
    public void create(UnitVM unitVM){
        unitApplication.create(unitVM);
    }
    
    public void update(UnitVM unitVM){
        this.unitApplication.update(unitVM);
    }
    
    public List<UnitVM> getAll(){
        return unitApplication.getAll();
    }
    
    public UnitVM get(int id){
        return this.unitApplication.get(id);
    }
    
    public void delete(int id){
        this.unitApplication.delete(id);
    }
}
