package controller;

import Infra.DependencyInjection.ProductDI;
import application.ProductApplication;
import controller.viewModels.ProductVM;
import model.interfaces.repositories.IDataContext;
import model.interfaces.services.IProductService;
import service.ProductService;

public class ProductController {
    private final ProductDI productDependencyInjection;
    private final IProductService productService;
    private final IDataContext dataContext;
    private final ProductApplication productApplication;
    
    
    public ProductController(){
        productDependencyInjection = new ProductDI();
        dataContext = productDependencyInjection.getDataContext();
        productService = new ProductService(dataContext, productDependencyInjection.getProductRepository(dataContext.getConnection()));
        productApplication = new ProductApplication(productService);
    }
    
    public void create(ProductVM productVM){
        productApplication.create(productVM);
    }
    
}
