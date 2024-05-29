/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Infra.DependencyInjection.ProductDI;
import controller.viewModels.ProductVM;
import model.entities.ProductModel;
import model.entities.UnitModel;
import model.enums.ProductTypeEnum;
import model.interfaces.repositories.IDataContext;
import model.interfaces.services.IProductService;
import service.ProductService;

public class ProductController {
    private final ProductDI productDependencyInjection;
    private final IProductService productService;
    private final IDataContext dataContext;
    
    
    public ProductController(){
        productDependencyInjection = new ProductDI();
        dataContext = productDependencyInjection.getDataContext();
        productService = new ProductService(dataContext, productDependencyInjection.getProductRepository(dataContext.getConnection()));
    }
    
    public void Create(ProductVM productVM){
    }
    
}
