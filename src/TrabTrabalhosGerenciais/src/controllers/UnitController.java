package controllers;

import Infra.DependencyInjections.UnitDI;
import application.applications.UnitApplication;
import application.viewModels.UnitVM;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.IUnitService;
import domain.model.entities.ResponseService;
import java.util.List;

public class UnitController {
    private final IDataContext dataContext;
    private final UnitDI unitDependencyInjection;
    private final IUnitService unitService;
    private final UnitApplication unitApplication;

    public UnitController() {
        unitDependencyInjection = new UnitDI();
        dataContext = unitDependencyInjection.getDataContext();
        
        unitService = unitDependencyInjection.getUnitService(dataContext, unitDependencyInjection.getUnitRepository(dataContext.getConnection()));
        unitApplication = new UnitApplication(unitService);
    }
    
    public ResponseService getResponseService(){
        return unitApplication.getResponseService();
    } 
    
    public void create(UnitVM unitVM){
        unitApplication.create(unitVM);
    }
    
    public List<UnitVM> getAll(){
        return unitApplication.getAll();
    }
    
}
