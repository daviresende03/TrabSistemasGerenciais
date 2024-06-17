package data.repositories;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.model.entities.OrderItemModel;
import domain.model.entities.OrderModel;
import domain.model.entities.PersonModel;
import domain.interfaces.repositories.IOrderRepository;

public class OrderRepository implements IOrderRepository {
    private final Connection connect;
    
    public OrderRepository(Connection connect){
        this.connect = connect;
    }
    
    @Override
    public void insert(OrderModel order) throws SQLException { 
        String query = "INSERT INTO `order`("
                + "customer_id,"
                + "waiter_id,"
                + "canceled,"
                + "invoiced,"
                + "discount_total,"
                + "order_total,"                
                + "observation,"
                + "created_at,"
                + "updated_at)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, order.getCustomer().getId());
        statement.setInt(2, order.getWaiter().getId());
        statement.setInt(3, order.getIsCanceled() ? 1 : 0);
        statement.setInt(4, order.getInvoiced() ? 1 : 0);
        statement.setDouble(5, order.getDiscountTotal());
        statement.setDouble(6, order.getOrderTotal());
        statement.setString(7, order.getObservation());
        statement.setDate(8, new Date(order.getCreatedDate().getTime()));
        statement.setDate(9, new Date(order.getUpdatedDate().getTime()));
        
        statement.executeUpdate();
        
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if(generatedKeys.next()){
            int orderId = generatedKeys.getInt(1);
            order.setId(orderId);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM `order` WHERE order_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public OrderModel select(int id) throws SQLException {
        OrderModel order = new OrderModel();
        try{
            String query = "SELECT "
                    + "customer_id,"
                    + "(SELECT name FROM person WHERE person_id = customer_id) AS customer_name,"
                    + "waiter_id,"
                    + "(SELECT name FROM person WHERE person_id = waiter_id) AS waiter_name,"
                    + "canceled,"
                    + "invoiced,"
                    + "discount_total,"
                    + "order_total,"
                    + "observation "
                    + "FROM `order` WHERE order_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            int customer_id = resultSet.getInt("customer_id");
            String customer_name = resultSet.getString("customer_name");
            int waiter_id = resultSet.getInt("waiter_id");
            String waiter_name = resultSet.getString("waiter_name");
            boolean isCanceled = resultSet.getInt("canceled")==1;
            boolean invoiced = resultSet.getInt("invoiced")==1;
            double discount_total = resultSet.getDouble("discount_total");
            double amount = resultSet.getDouble("order_total");
            String observation = resultSet.getString("observation");

            PersonModel customer = new PersonModel(customer_id);
            customer.setName(customer_name);
            PersonModel waiter = new PersonModel(waiter_id);
            waiter.setName(waiter_name);

            order = new OrderModel(id, customer, waiter, new ArrayList<OrderItemModel>(), isCanceled, invoiced, discount_total, observation);
            order.setAmount(amount);
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
            String query = "SELECT * FROM `order`";
        
        PreparedStatement statement = connect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            int id = resultSet.getInt("order_id");
            int customer_id = resultSet.getInt("customer_id");
            int waiter_id = resultSet.getInt("waiter_id");
            double discount_total = resultSet.getDouble("discount_total");
            String observation = resultSet.getString("observation");
            boolean isCanceled = resultSet.getInt("canceled")==1;
            boolean invoiced = resultSet.getInt("invoiced")==1;
            
            orders.add(new OrderModel(id, new PersonModel(customer_id), new PersonModel(waiter_id), new ArrayList<OrderItemModel>(), isCanceled, invoiced, discount_total, observation));
        }
        return orders;
        }catch(Exception ex){
            return orders;
        }
    }

    @Override
    public List<OrderModel> select(boolean invoiced) throws SQLException {
        List <OrderModel> orders = new ArrayList<OrderModel>();
        try{
            String query = "SELECT "
                    +"order_id,"
                    + "customer_id,"
                    + "(SELECT name FROM person WHERE person_id = customer_id) AS customer_name,"
                    + "waiter_id,"
                    + "(SELECT name FROM person WHERE person_id = waiter_id) AS waiter_name,"
                    + "canceled,"
                    + "discount_total,"
                    + "order_total,"
                    + "observation "
                    + "FROM `order` WHERE invoiced = ?";

            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1,invoiced ? 1 : 0);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("order_id");
                int customer_id = resultSet.getInt("customer_id");
                String customer_name = resultSet.getString("customer_name");
                int waiter_id = resultSet.getInt("waiter_id");
                String waiter_name = resultSet.getString("waiter_name");
                boolean isCanceled = resultSet.getInt("canceled")==1;
                double discount_total = resultSet.getDouble("discount_total");
                double amount = resultSet.getDouble("order_total");
                String observation = resultSet.getString("observation");

                PersonModel customer = new PersonModel(customer_id);
                customer.setName(customer_name);
                PersonModel waiter = new PersonModel(waiter_id);
                waiter.setName(waiter_name);
                
                OrderModel order = new OrderModel(id, customer, waiter, new ArrayList<OrderItemModel>(), isCanceled, invoiced, discount_total, observation);
                order.setAmount(amount);
                orders.add(order);
            }
            return orders;
        }catch(Exception ex){
            return orders;
        }
    }

    @Override
    public void update(OrderModel order) throws SQLException {
        String query = "UPDATE `order` SET "
                + "customer_id =    ?,"
                + "waiter_id =      ?,"
                + "invoiced =       ?,"
                + "discount_total = ?,"
                + "order_total =    ?,"
                + "observation =    ?,"
                + "updated_at =     ? "
                + "WHERE order_id = ?";

        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, order.getCustomer().getId());
        statement.setInt(2, order.getWaiter().getId());
        statement.setInt(3, order.getInvoiced() ? 1 : 0);
        statement.setDouble(4, order.getDiscountTotal());
        statement.setDouble(5, order.getOrderTotal());
        statement.setString(6, order.getObservation());
        statement.setDate(7, new Date(order.getUpdatedDate().getTime()));
        statement.setInt(8, order.getId());
        statement.executeUpdate();
    }

    @Override
    public void invoice(OrderModel order) throws SQLException {
        String query = "UPDATE `order` SET "
                + "invoiced =       ?,"
                + "updated_at =     ? "
                + "WHERE order_id = ?";

        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, order.getInvoiced() ? 1 : 0);
        statement.setDate(2, new Date(order.getUpdatedDate().getTime()));
        statement.setInt(3, order.getId());
        statement.executeUpdate();
    }

    @Override
    public int count(boolean invoiced) throws SQLException {
        try{
            String query = "SELECT COUNT(*) FROM `order` WHERE invoiced = ? AND canceled = ?";

            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1,invoiced ? 1 : 0);
            statement.setInt(2,0);
            ResultSet resultSet = statement.executeQuery();

            int count = 0;
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return count;
        }catch(Exception ex){
            return 0;
        }
    }

    @Override
    public int countCanceleds() throws SQLException {
        try{
            String query = "SELECT COUNT(*) FROM `order` WHERE canceled = ?";

            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1,1);
            ResultSet resultSet = statement.executeQuery();

            int count = 0;
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return count;
        }catch(Exception ex){
            return 0;
        }
    }

    @Override
    public void cancel(int id) throws SQLException{
        String query = "UPDATE `order` SET "
                + "canceled =       ?,"
                + "updated_at =     ? "
                + "WHERE order_id = ?";

        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, 1);
        statement.setDate(2, new Date(new java.util.Date().getTime()));
        statement.setInt(3, id);
        statement.executeUpdate();
    }

    @Override
    public boolean existByPersonId(int personId){
        try{
            String query = "SELECT null FROM `order` WHERE customer_id = ? OR waiter_id = ?";

            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1,personId);
            statement.setInt(2,personId);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        }catch(Exception ex){
            return false;
        }
    }
}
