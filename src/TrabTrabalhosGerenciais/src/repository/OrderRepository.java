package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.entities.OrderItemModel;
import model.entities.OrderModel;
import model.entities.PersonModel;
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
                + "order_total,"
                + "discount_total,"
                + "observation,"
                + "created_at,"
                + "updated_at"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, order.getCustomer().getId());
        statement.setInt(2, order.getWaiter().getId());
        statement.setDouble(3, order.getOrderTotal());
        statement.setDouble(4, order.getDiscountTotal());
        statement.setString(5, order.getObservation());
        statement.setDate(6, new Date(order.getCreatedDate().getTime()));
        statement.setDate(7, new Date(order.getUpdatedDate().getTime()));
        
        statement.executeUpdate();
    }

    @Override
    public void update(OrderModel model) throws SQLException {
        String query = "UPDATE order SET"
                + "customer = ?"
                + "waiter = ?"
                + "order_total = ?"
                + "discount_total = ?,"
                + "observation = ?"
                + "updated_at = ?"
                + "WHERE order_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, model.getCustomer().getId());
        statement.setInt(2, model.getWaiter().getId());
        statement.setDouble(3, model.getOrderTotal());
        statement.setDouble(4, model.getDiscountTotal());
        statement.setString(5, model.getObservation());
        statement.setDate(6, new Date(model.getUpdatedDate().getTime()));
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
        OrderModel order = new OrderModel();
        try{
            String query = "SELECT * FROM order WHERE order_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            int customer = resultSet.getInt("customer");
            int waiter = resultSet.getInt("waiter");
            double order_total = resultSet.getDouble("order_total");
            double discount_total = resultSet.getDouble("discount_total");
            String observation = resultSet.getString("observation");
            
            return new OrderModel(id, new PersonModel(customer), new PersonModel(waiter), new ArrayList<OrderItemModel>(), order_total, discount_total, observation);
        }
        return order;
        }catch(Exception ex){
            return order;
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
            int id = resultSet.getInt("order_id");
            int customer = resultSet.getInt("customer");
            int waiter = resultSet.getInt("waiter");
            double order_total = resultSet.getDouble("order_total");
            double discount_total = resultSet.getDouble("discount_total");
            String observation = resultSet.getString("observation");
            
            orders.add(new OrderModel(id, new PersonModel(customer), new PersonModel(waiter), new ArrayList<OrderItemModel>(), order_total, discount_total, observation));
        }
        return orders;
        }catch(Exception ex){
            return orders;
        }
    }
}
