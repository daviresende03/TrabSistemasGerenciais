package data.repositories;

import java.sql.Connection;
import domain.interfaces.repositories.IFinanceRepository;
import domain.model.entities.FinanceModel;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FinanceRepository implements IFinanceRepository {
    
    private final Connection connect;
    
    public FinanceRepository(Connection connect){
        this.connect = connect;
    }
    
    @Override
    public void insert(FinanceModel model) throws SQLException {
        String query = "INSERT INTO finance("
                + "type,"
                + "value,"
                + "description,"
                + "createdAt) "
                + "VALUES(?, ?, ?, ?)";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, model.getType());
        statement.setDouble(2, model.getValue());
        statement.setString(3, model.getDescription());
        statement.setDate(4, new Date(model.getCreatedDate().getTime()));
        statement.executeUpdate();
    }

    @Override
    public void update(FinanceModel model) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM finance WHERE finance_id = ?";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public FinanceModel select(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<FinanceModel> select() throws SQLException {
        List<FinanceModel> finances = new ArrayList<FinanceModel>();
        
        try{
            String sql = "SELECT * FROM finance";
            PreparedStatement statement = connect.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int financeId = resultSet.getInt("finance_id");                
                int type = resultSet.getInt("type");
                double value = resultSet.getDouble("value");
                String description = resultSet.getString("description");
                
                finances.add(new FinanceModel(financeId, type, value, description));
            }
            return finances;
        }catch(Exception ex){
            return finances;
        }
    }

    @Override
    public boolean exist(int id) throws SQLException {
        try{
            String query = "SELECT null FROM finance WHERE finance_id = ?";
            
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            return resultSet.next();
        }catch(Exception ex){
            return false;
        }
    }
}
