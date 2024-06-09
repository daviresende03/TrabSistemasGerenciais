package application.viewModels;

import domain.model.entities.ProductModel;

public class ProductVM {
    public int id;
    public String name;
    public int type;
    public String unitName;
    public String unitSymbol;
    public double costPrice;
    public double salePrice;
    public double stock;
    
    public ProductVM(ProductModel productModel){
        id = productModel.getId();
        name = productModel.getName();
        type = productModel.getType().getValue();
        unitName = productModel.getUnit().getName();
        unitSymbol = productModel.getUnit().getSymbol();
        costPrice = productModel.getCostPrice();
        salePrice = productModel.getSalePrice();
        stock = productModel.getStock();
    }
    
    public ProductVM(){}
}
