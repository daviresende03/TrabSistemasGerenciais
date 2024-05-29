package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.entities.ProductModel;
import model.interfaces.repositories.IProductRepository;

public class ProductRepository implements IProductRepository{
    
    private final Connection connect;
    
    public ProductRepository(Connection connect){
        this.connect = connect;
    }
    
    @Override
    public void insert(ProductModel product) throws SQLException { 
        String query = "INSERT INTO product(product_unit_id, name, type, cost_price, sale_price, stock) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connect.prepareStatement(query);
        
        statement.setInt(1, product.getUnit().getId());
        statement.setString(2, product.getName());
        statement.setInt(3,product.getType().getValue());
        statement.setDouble(4, product.getCostPrice());
        statement.setDouble(5, product.getSalePrice());
        statement.setDouble(6, product.getStock());
        
        statement.executeUpdate();
    }

    @Override
    public void update(ProductModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductModel select(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ProductModel> select() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
