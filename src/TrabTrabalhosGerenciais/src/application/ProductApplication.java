package application;

import controller.viewModels.ProductVM;
import model.entities.ProductModel;
import model.entities.ResponseService;
import model.entities.UnitModel;
import model.enums.ProductTypeEnum;
import model.interfaces.services.IProductService;

public class ProductApplication {
    private final IProductService productService;
    
    public ProductApplication(IProductService productService){
        this.productService = productService;
    }
    
    public ResponseService create(ProductVM productVM){
        ProductModel productModel = new ProductModel(
                productVM.name,
                ProductTypeEnum.fromInteger(productVM.type),
                new UnitModel(productVM.unitName, productVM.unitSymbol),
                productVM.costPrice,
                productVM.salePrice,
                productVM.stock
        );
        return productService.insert(productModel);
    }
    
    public ResponseService update(ProductVM productVM){
        ProductModel productModel = new ProductModel(
                productVM.id,
                productVM.name,
                ProductTypeEnum.fromInteger(productVM.type),
                new UnitModel(productVM.unitName, productVM.unitSymbol),
                productVM.costPrice,
                productVM.salePrice,
                productVM.stock
        );
        return productService.update(productModel);
    }
    
    public ResponseService delete(int id){
        return productService.remove(id);
    }
    
    public ResponseService get(int id){
        return productService.get(id);
    }
    
    public ResponseService getAll(){
        return productService.getAll();
    }
}
