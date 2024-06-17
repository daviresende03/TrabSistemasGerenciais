package application.mappers;

import application.viewModels.ProductVM;
import domain.model.entities.ProductModel;
import domain.model.entities.UnitModel;
import domain.model.enums.ProductTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class ProductMap {
    public static ProductModel getProduct(ProductVM productVM){
        return new ProductModel(
                productVM.id,
                productVM.name,
                ProductTypeEnum.fromInteger(productVM.type),
                new UnitModel(productVM.unitName, productVM.unitSymbol),
                productVM.costPrice,
                productVM.salePrice,
                productVM.stock
        );
    }

    public static ProductVM getProductVM(ProductModel productModel){
        return new ProductVM(
            productModel.getId(),
            productModel.getName(),
            productModel.getType().getValue(),
            productModel.getUnit().getName(),
            productModel.getUnit().getSymbol(),
            productModel.getCostPrice(),
            productModel.getSalePrice(),
            productModel.getStock()
        );
    }

    public static List<ProductVM> getProductsVM(List<ProductModel> models){
        List<ProductVM> products = new ArrayList<ProductVM>();
        for(ProductModel model : models){
            products.add(getProductVM(model));
        }
        return products;
    }
}
