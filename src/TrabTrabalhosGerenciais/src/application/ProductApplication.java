package application;

import controller.viewModels.ProductVM;
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
        ProductModel productModel = new ProductModel(
                productVM.name,
                ProductTypeEnum.fromInteger(productVM.type),
                new UnitModel(productVM.unitName, productVM.unitSymbol),
                productVM.costPrice,
                productVM.salePrice,
                productVM.stock
        );
        productService.insert(productModel);
    }
    
    public void update(ProductVM productVM){
        ProductModel productModel = new ProductModel(
                productVM.id,
                productVM.name,
                ProductTypeEnum.fromInteger(productVM.type),
                new UnitModel(productVM.unitName, productVM.unitSymbol),
                productVM.costPrice,
                productVM.salePrice,
                productVM.stock
        );
        productService.update(productModel);
    }
    
    public void delete(int id){
        productService.remove(id);
    }
    
    public ProductVM get(int id){
        return new ProductVM(productService.get(id));
    }
    
    public List<ProductVM> getAll(){
        List<ProductModel> productsModel = productService.getAll();
        List<ProductVM> productsVM = new ArrayList<ProductVM>();
        
        for(ProductModel productModel : productsModel){
            productsVM.add(new ProductVM(productModel));
        }
        return productsVM;
    }
}
