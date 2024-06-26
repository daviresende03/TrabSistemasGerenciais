package application.viewModels;

public class OrderItemVM {
    public int id;
    public ProductVM product;
    public double quantity;
    public double salePrice;
    
    public OrderItemVM(ProductVM product, double quantity, double salePrice){
        this.product = product;
        this.quantity = quantity;
        this.salePrice = salePrice;
    }

    public OrderItemVM(int id, ProductVM product, double quantity, double salePrice){
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.salePrice = salePrice;
    }
}
