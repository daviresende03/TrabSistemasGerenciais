package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.entities.OrderModel;
import model.entities.PersonModel;
import model.entities.ProductModel;
import model.interfaces.repositories.IOrderRepository;

public class OrderRepository implements IOrderRepository {
    private final Connection connect;
    
    public OrderRepository(Connection connect){
        this.connect = connect;
    }
    
    @Override
    public void insert(OrderModel order) throws SQLException { 
        String query = "INSERT INTO order("
                + "customer,"
                + "waiter,"
                + "products,"
                + "order_total,"
                + "discount_total,"
                + "observation,"
                + "created_at,"
                + "updated_at"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, order.getCustomer().getId());
        statement.setInt(2, order.getWaiter().getId());
        statement.setInt(3, order.getProducts());
        statement.setDouble(4, order.getOrderTotal());
        statement.setDouble(5, order.getDiscountTotal());
        statement.setString(6, order.getObservation());
        statement.setDate(7, new Date(order.getCreatedDate().getTime()));
        statement.setDate(8, new Date(order.getUpdatedDate().getTime()));
        
        statement.executeUpdate();
    }

    @Override
    public void update(OrderModel model) throws SQLException {
        String query = "UPDATE order SET"
                + "customer = ?"
                + "waiter = ?"
                + "products = ?"
                + "order_total = ?"
                + "discount_total = ?,"
                + "observation = ?"
                + "updated_at = ?"
                + "WHERE order_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, model.getCustomer().getId());
        statement.setInt(2, model.getWaiter().getId());
        statement.setInt(3, model.getProducts());
        statement.setDouble(4, model.getOrderTotal());
        statement.setDouble(5, model.getDiscountTotal());
        statement.setString(6, model.getObservation());
        statement.setDate(7, new Date(model.getUpdatedDate().getTime()));
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM order WHERE order_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public OrderModel select(int id) throws SQLException {
        OrderModel person = new OrderModel();
        try{
            String query = "SELECT * FROM order WHERE order_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            int customer = resultSet.getInt("customer");
            int waiter = resultSet.getInt("waiter");
            String products = resultSet.getString("products");
            double order_total = resultSet.getDouble("order_total");
            double discount_total = resultSet.getDouble("discount_total");
            String observation = resultSet.getString("observation");
            
            return new OrderModel(new PersonModel(customer), new PersonModel(waiter), new ArrayList<ProductModel>(), order_total, discount_total, observation);
        }
        return person;
        }catch(Exception ex){
            return person;
        }
    }
    
    @Override
    public List<OrderModel> select() throws SQLException {
        List <OrderModel> orders = new ArrayList<OrderModel>();
        
        try{
            String query = "SELECT * FROM order";
        
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            int customer = resultSet.getInt("customer");
            int waiter = resultSet.getInt("waiter");
            String products = resultSet.getString("products");
            double order_total = resultSet.getDouble("order_total");
            double discount_total = resultSet.getDouble("discount_total");
            String observation = resultSet.getString("observation");
            
            orders.add(new OrderModel(new PersonModel(customer), new PersonModel(waiter), new ArrayList<ProductModel>(), order_total, discount_total, observation));
        }
        return orders;
        }catch(Exception ex){
            return orders;
        }
    }
}
