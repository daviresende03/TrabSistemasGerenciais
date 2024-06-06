package controller;

import infra.DependencyInjection.ProductDI;
import infra.DependencyInjection.UnitDI;
import application.ProductApplication;
import controller.viewModels.ProductVM;
import domain.model.entities.ResponseService;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.IProductService;
import service.ProductService;

public class ProductController {
    private final ProductDI productDependencyInjection;
    private final UnitDI unitDependencyInjection;
    
    
    private final IProductService productService;
    private final IDataContext dataContext;
    private final ProductApplication productApplication;
    
    
    public ProductController(){
        productDependencyInjection = new ProductDI();
        unitDependencyInjection = new UnitDI();
        
        
        
        dataContext = productDependencyInjection.getDataContext();
        productService = new ProductService(dataContext, 
                                productDependencyInjection.getProductRepository(dataContext.getConnection()),
                                unitDependencyInjection.getUnitRepository(dataContext.getConnection()));
        productApplication = new ProductApplication(productService);
    }
    
    public ResponseService getResponseService(){
        return productApplication.getResponseService();
    }
    
    public void create(ProductVM productVM){
        productApplication.create(productVM);
    }
    
}
