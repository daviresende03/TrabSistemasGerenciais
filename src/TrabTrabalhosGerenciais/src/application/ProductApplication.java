package application;

import controller.viewModels.ProductVM;
import model.entities.ProductModel;
import model.entities.UnitModel;
import model.enums.ProductTypeEnum;
import model.interfaces.services.IProductService;

public class ProductApplication {
    private final IProductService productService;
    
    public ProductApplication(IProductService productService){
        this.productService = productService;
    }
    
    public void create(ProductVM productVM){
        ProductModel productModel = new ProductModel(
                productVM.name,
                ProductTypeEnum.fromInteger(productVM.type),
                new UnitModel(productVM.unit.name, productVM.unit.symbol),
                productVM.costPrice,
                productVM.salePrice,
                productVM.stock
        );
        productService.insert(productModel);
    }
}
