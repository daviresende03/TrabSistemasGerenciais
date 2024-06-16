package data.repositories;

import java.sql.Connection;
import domain.interfaces.repositories.IFinanceRepository;
import domain.model.entities.FinanceModel;
import domain.model.enums.FinanceTypeEnum;

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
                + "cash_register_id,"
                + "type,"
                + "value,"
                + "description,"
                + "created_at, "
                + "updated_at) "
                + "VALUES(?, ?, ?, ?, ?, ?)";
        
        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, model.getCashRegisterId());
        statement.setInt(2, model.getType().getValue());
        statement.setDouble(3, model.getValue());
        statement.setString(4, model.getDescription());
        statement.setDate(5, new Date(model.getCreatedDate().getTime()));
        statement.setDate(6, new Date(model.getUpdatedDate().getTime()));
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
        String sql = "SELECT * FROM finance WHERE finance_id = ?";
        PreparedStatement statement = connect.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()) {
            int cashRegisterId = resultSet.getInt("cash_register_id");
            int type = resultSet.getInt("type");
            double value = resultSet.getDouble("value");
            String description = resultSet.getString("description");

            return new FinanceModel(id, cashRegisterId, FinanceTypeEnum.fromInteger(type), value, description);
        }
        return new FinanceModel();
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
                int cashRegisterId = resultSet.getInt("cash_register_id");
                int type = resultSet.getInt("type");
                double value = resultSet.getDouble("value");
                String description = resultSet.getString("description");
                
                finances.add(new FinanceModel(financeId, cashRegisterId, FinanceTypeEnum.fromInteger(type), value, description));
            }
            return finances;
        }catch(Exception ex){
            return finances;
        }
    }

    @Override
    public List<FinanceModel> selectByCashRegisterId(int cashRegisterId) throws SQLException {
        List<FinanceModel> finances = new ArrayList<FinanceModel>();

        try{
            String sql = "SELECT * FROM finance WHERE cash_register_id = ?";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, cashRegisterId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int financeId = resultSet.getInt("finance_id");
                int type = resultSet.getInt("type");
                double value = resultSet.getDouble("value");
                String description = resultSet.getString("description");

                finances.add(new FinanceModel(financeId, cashRegisterId, FinanceTypeEnum.fromInteger(type), value, description));
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
