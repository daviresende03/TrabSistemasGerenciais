package repository;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.model.entities.OrderItemModel;
import domain.model.entities.OrderModel;
import domain.model.entities.ProductModel;
import domain.interfaces.repositories.IOrderItemRepository;


public class OrderItemRepository implements IOrderItemRepository{
    private final Connection connect;

    public OrderItemRepository(Connection connect) {
        this.connect = connect;
    }

    @Override
    public void insert(OrderItemModel model) throws SQLException {
        String query = "INSERT INTO order_item("
                + "order_id,"
                + "product_id,"
                + "quantity,"
                + "sale_price,"
                + "total_item,"
                + "created_at,"
                + "updated_at"
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, model.getOrder().getId());
        statement.setInt(2, model.getProduct().getId());
        statement.setDouble(3, model.getQuantity());
        statement.setDouble(4, model.getSalePrice());
        statement.setDouble(5, model.totalPrice());
        statement.setDate(6, new Date(model.getCreatedDate().getTime()));
        statement.setDate(7, new Date(model.getUpdatedDate().getTime()));
        
        statement.executeUpdate();
    }

    @Override
    public void update(OrderItemModel model) throws SQLException {
        String query = "UPDATE order_item SET"
                + "order_id = ?"
                + "product_id = ?"
                + "quantity = ?"
                + "sale_price = ?,"
                + "total_item = ?"
                + "updated_at = ?"
                + "WHERE order_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, model.getOrder().getId());
        statement.setInt(2, model.getProduct().getId());
        statement.setDouble(3, model.getQuantity());
        statement.setDouble(4, model.getSalePrice());
        statement.setDouble(5, model.totalPrice());
        statement.setDate(6, new Date(model.getUpdatedDate().getTime()));
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM order_item WHERE order_item_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public OrderItemModel select(int id) throws SQLException {
        OrderItemModel orderItem = new OrderItemModel();
        try{
            String query = "SELECT * FROM order_item WHERE order_item_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            int orderId = resultSet.getInt("order_id");
            int productId = resultSet.getInt("product_id");
            double quantity = resultSet.getDouble("quantity");
            double salePrice = resultSet.getDouble("sale_price");
            
            return new OrderItemModel(id, new OrderModel(orderId), new ProductModel(productId), quantity, salePrice);
        }
        return orderItem;
        }catch(Exception ex){
            return orderItem;
        }
    }

    @Override
    public List<OrderItemModel> select() throws SQLException {
        List<OrderItemModel> orderItems = new ArrayList<OrderItemModel>();
        try{
            String query = "SELECT * FROM order_item";
        
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            int id = resultSet.getInt("order_item_id");
            int orderId = resultSet.getInt("order_id");
            int productId = resultSet.getInt("product_id");
            double quantity = resultSet.getDouble("quantity");
            double salePrice = resultSet.getDouble("sale_price");
            
            orderItems.add(new OrderItemModel(id, new OrderModel(orderId), new ProductModel(productId), quantity, salePrice));
        }
        return orderItems;
        }catch(Exception ex){
            return orderItems;
        }
    }

    @Override
    public List<OrderItemModel> selectByOrderId(int orderId) throws SQLException {
        List<OrderItemModel> orderItems = new ArrayList<OrderItemModel>();
        try{
            String query = "SELECT * FROM order_item WHERE order_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, orderId);
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            int id = resultSet.getInt("order_item_id");
            int productId = resultSet.getInt("product_id");
            double quantity = resultSet.getDouble("quantity");
            double salePrice = resultSet.getDouble("sale_price");
            
            orderItems.add(new OrderItemModel(id, new OrderModel(orderId), new ProductModel(productId), quantity, salePrice));
        }
        return orderItems;
        }catch(Exception ex){
            return orderItems;
        }
    }

    @Override
    public void deleteByOrderId(int orderId) throws SQLException {
        String query = "DELETE FROM order_item WHERE order_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, orderId);
        statement.executeUpdate();
    }
}
