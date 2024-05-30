package repository;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.entities.UnitModel;
import model.interfaces.repositories.IUnitRepository;

public class UnitRepository implements IUnitRepository{
    
    private final Connection connect;
    
    public UnitRepository(Connection connect){
        this.connect = connect;
    }

    @Override
    public void insert(UnitModel model) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(UnitModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UnitModel select(int id) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<UnitModel> select() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
}
