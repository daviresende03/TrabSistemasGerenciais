package data.repositories;

import domain.interfaces.repositories.IOperatorRepository;
import domain.model.entities.OperatorModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OperatorRepository implements IOperatorRepository {

    private final Connection connect;

    public OperatorRepository(Connection connect){
        this.connect = connect;
    }

    @Override
    public void insert(OperatorModel model) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(OperatorModel model) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OperatorModel select(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<OperatorModel> select() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public OperatorModel selectByPasswordHash(String passwordHash){
        try{
            String query = "SELECT * FROM operator WHERE password = ?";
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setString(1, passwordHash);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                int id = resultSet.getInt("operator_id");
                String username = resultSet.getString("username");
                boolean isAdmin = resultSet.getInt("admin")==1;
                return new OperatorModel(id, username, passwordHash, isAdmin);
            }
            return new OperatorModel();
        }catch (Exception ex){
            return new OperatorModel();
        }
    }
}
