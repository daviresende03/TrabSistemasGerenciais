package controllers;

import Infra.DependencyInjections.ProductDI;
import Infra.DependencyInjections.UnitDI;
import application.applications.ProductApplication;
import application.viewModels.ProductVM;
import domain.model.entities.ResponseService;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.IProductService;
import java.util.List;
import domain.services.ProductService;

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
    
    public List<ProductVM> getAll(){
        return productApplication.getAll();
    }
    
    public void delete(int id){
        this.productApplication.delete(id);
    }
    
    public void update(ProductVM productVM){
        this.productApplication.update(productVM);
    }
    
    public ProductVM get(int id){
        return this.productApplication.get(id);
    }
    
}
