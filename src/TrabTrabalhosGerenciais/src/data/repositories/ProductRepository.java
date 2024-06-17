package data.repositories;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.model.entities.ProductModel;
import domain.model.entities.UnitModel;
import domain.model.enums.ProductTypeEnum;
import domain.interfaces.repositories.IProductRepository;

public class ProductRepository implements IProductRepository{
    
    private final Connection connect;
    
    public ProductRepository(Connection connect){
        this.connect = connect;
    }
    
    @Override
    public void insert(ProductModel model) throws SQLException { 
        String query = "INSERT INTO product("
                        + "product_unit_id,"
                        + "name,"
                        + "type,"
                        + "cost_price,"
                        + "sale_price,"
                        + "stock,"
                        + "created_at,"
                        + "updated_at)"
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, model.getUnit().getId());
        statement.setString(2, model.getName());
        statement.setInt(3,model.getType().getValue());
        statement.setDouble(4, model.getCostPrice());
        statement.setDouble(5, model.getSalePrice());
        statement.setDouble(6, model.getStock());
        statement.setDate(7, new Date(model.getCreatedDate().getTime()));
        statement.setDate(8, new Date(model.getUpdatedDate().getTime()));
        
        statement.executeUpdate();
    }

    @Override
    public void update(ProductModel model) throws SQLException {
        String query = "UPDATE product SET "
                        + "product_unit_id =  ?,"
                        + "name =             ?,"
                        + "type =             ?,"
                        + "cost_price =       ?,"
                        + "sale_price =       ?,"
                        + "stock =            ?,"
                        + "updated_at =       ? "
                        + "WHERE product_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, model.getUnit().getId());
        statement.setString(2, model.getName());
        statement.setInt(3,model.getType().getValue());
        statement.setDouble(4, model.getCostPrice());
        statement.setDouble(5, model.getSalePrice());
        statement.setDouble(6, model.getStock());
        statement.setDate(7, new Date(model.getUpdatedDate().getTime()));
        statement.setInt(8, model.getId());
        statement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM product WHERE product_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public ProductModel select(int id) throws SQLException {
        ProductModel product = new ProductModel();
        try{
            String query = "SELECT * FROM product WHERE product_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            int unit_id = resultSet.getInt("product_unit_id");
            String name = resultSet.getString("name");
            int type = resultSet.getInt("type");
            double costPrice = resultSet.getDouble("cost_price");
            double salePrice = resultSet.getDouble("sale_price");
            double stock = resultSet.getDouble("stock");
            
            return new ProductModel(id, name, ProductTypeEnum.fromInteger(type), new UnitModel(unit_id), costPrice, salePrice, stock);
        }
        return product;
        }catch(Exception ex){
            return product;
        }
    }

    @Override
    public List<ProductModel> select() throws SQLException {
        List<ProductModel> products = new ArrayList<ProductModel>();
        try{
            String query = "SELECT * FROM product";
        
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            int id = resultSet.getInt("product_id");
            int unit_id = resultSet.getInt("product_unit_id");
            String name = resultSet.getString("name");
            int type = resultSet.getInt("type");
            double costPrice = resultSet.getDouble("cost_price");
            double salePrice = resultSet.getDouble("sale_price");
            double stock = resultSet.getDouble("stock");
            
            products.add(new ProductModel(id, name, ProductTypeEnum.fromInteger(type), new UnitModel(unit_id), costPrice, salePrice, stock));
        }
        return products;
        }catch(Exception ex){
            return products;
        }
    }

    @Override
    public void updateStock(int id, double quantity) throws SQLException {
        String query = "UPDATE product SET "
                        + "stock =            ?,"
                        + "updated_at =       ? "
                        + "WHERE product_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setDouble(1, quantity);
        statement.setDate(2, new Date(new java.util.Date().getTime()));
        statement.setInt(3, id);
        statement.executeUpdate();
    }
    
    @Override
    public boolean exist(int id) throws SQLException {
        try{
            String query = "SELECT null FROM product WHERE product_id = ?";
            
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            return resultSet.next();
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean existByUnitId(int unitId) {
        try{
            String query = "SELECT null FROM product WHERE product_unit_id = ?";

            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1, unitId);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        }catch(Exception ex){
            return false;
        }
    }
    
}
