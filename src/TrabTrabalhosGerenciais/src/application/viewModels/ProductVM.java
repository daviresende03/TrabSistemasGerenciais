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

    public ProductVM(){}

    public ProductVM(int id, String name, int type, String unitName, String unitSymbol, double costPrice, double salePrice, double stock) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.unitName = unitName;
        this.unitSymbol = unitSymbol;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.stock = stock;
    }
}
