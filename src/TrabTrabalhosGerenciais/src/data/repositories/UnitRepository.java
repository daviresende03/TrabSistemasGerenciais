package data.repositories;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.model.entities.UnitModel;
import domain.interfaces.repositories.IUnitRepository;

public class UnitRepository implements IUnitRepository{
    
    private final Connection connect;
    
    public UnitRepository(Connection connect){
        this.connect = connect;
    }

    @Override
    public void insert(UnitModel model) throws SQLException {
        String query = "INSERT INTO product_unit("
                        + "name,"
                        + "symbol,"
                        + "created_at,"
                        + "updated_at)"
                        + "VALUES(?, ?, ?, ?)";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setString(1, model.getName());
        statement.setString(2, model.getSymbol());
        statement.setDate(3, new Date(model.getCreatedDate().getTime()));
        statement.setDate(4, new Date(model.getUpdatedDate().getTime()));
        statement.executeUpdate();
    }

    @Override
    public void update(UnitModel model) throws SQLException {
        String query = "UPDATE product_unit SET"
                        + "name =                  ?,"
                        + "symbol =                ?,"
                        + "updated_at =            ?,"
                        + "WHERE product_unit_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setString(1, model.getName());
        statement.setString(2, model.getSymbol());
        statement.setDate(3, new Date(model.getUpdatedDate().getTime()));
        statement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM product_unit WHERE id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public UnitModel select(String name) throws SQLException{
        UnitModel unit = new UnitModel();
        try{
            String sql = "SELECT * FROM product_unit WHERE name = ?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("product_unit_id");
                String symbol = resultSet.getString("symbol");
                return new UnitModel(id, name, symbol);
            }
            return unit;
        }catch(Exception ex){
            return unit;
        }
    }
    
    @Override
    public UnitModel select(int id) throws SQLException{
        UnitModel unit = new UnitModel();
        try{
            String sql = "SELECT * FROM product_unit WHERE product_unit_id = ?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String symbol = resultSet.getString("symbol");
                return new UnitModel(id, name, symbol);
            }
            return unit;
        }catch(Exception ex){
            return unit;
        }
    }

    @Override
    public List<UnitModel> select() throws SQLException {
        List<UnitModel> units = new ArrayList<UnitModel>();
        try{
            String sql = "SELECT * FROM product_unit";
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("product_unit_id");
                String name = resultSet.getString("name");
                String symbol = resultSet.getString("symbol");
                
                units.add(new UnitModel(id, name, symbol));
            }
            return units;
        }catch(Exception ex){
            return units;
        }
    }
    
    @Override
    public boolean exist(String name) throws SQLException {
        try{
            String query = "SELECT null FROM product_unit WHERE name = ?";
            
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            
            return resultSet.next();
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean exist(int id) throws SQLException {
        try{
            String query = "SELECT null FROM product_unit WHERE product_unit = ?";
            
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            return resultSet.next();
        }catch(Exception ex){
            return false;
        }
    }
}
