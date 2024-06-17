package controllers;

import data.repositories.OrderItemRepository;
import infra.dependencyInjections.OrderDI;
import infra.dependencyInjections.ProductDI;
import infra.dependencyInjections.UnitDI;
import application.applications.ProductApplication;
import application.viewModels.ProductVM;
import domain.model.entities.ResponseService;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.IProductService;
import java.util.List;
import domain.services.ProductService;

public class ProductController {

    private final ProductApplication productApplication;
    
    
    public ProductController(){
        ProductDI productDependencyInjection = new ProductDI();
        UnitDI unitDependencyInjection = new UnitDI();
        OrderDI orderDependencyInjection = new OrderDI();

        IDataContext dataContext = productDependencyInjection.getDataContext();
        IProductService productService = new ProductService(dataContext,
                productDependencyInjection.getProductRepository(dataContext.getConnection()),
                unitDependencyInjection.getUnitRepository(dataContext.getConnection()),
                orderDependencyInjection.getOrderItemRepository(dataContext.getConnection()));

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
