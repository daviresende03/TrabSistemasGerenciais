package application.applications;

import application.mappers.ProductMap;
import application.viewModels.ProductVM;
import java.util.ArrayList;
import java.util.List;
import domain.model.entities.ProductModel;
import domain.model.entities.ResponseService;
import domain.model.entities.UnitModel;
import domain.model.enums.ProductTypeEnum;
import domain.interfaces.services.IProductService;

public class ProductApplication {
    private final IProductService productService;
    
    public ProductApplication(IProductService productService){
        this.productService = productService;
    }
    
    public ResponseService getResponseService(){
        return productService.getResponseService();
    }
    
    public void create(ProductVM productVM){
        productService.insert(ProductMap.getProduct(productVM));
    }
    
    public void update(ProductVM productVM){
        productService.update(ProductMap.getProduct(productVM));
    }
    
    public void delete(int id){
        productService.remove(id);
    }
    
    public ProductVM get(int id){
        return ProductMap.getProductVM(productService.get(id));
    }
    
    public List<ProductVM> getAll(){
        return ProductMap.getProductsVM(productService.getAll());
    }
}
