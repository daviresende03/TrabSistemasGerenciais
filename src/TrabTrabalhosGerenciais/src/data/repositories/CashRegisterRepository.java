package data.repositories;

import domain.interfaces.repositories.ICashRegisterRepository;
import domain.model.entities.CashRegisterModel;

import javax.xml.transform.Result;
import java.sql.*;
import java.time.Instant;
import java.util.List;

public class CashRegisterRepository implements ICashRegisterRepository {
    private final Connection connect;

    public CashRegisterRepository(Connection connect) { this.connect = connect; }

    @Override
    public void insert(CashRegisterModel model) throws SQLException {
        String query = "INSERT INTO `cash_register`("
                + "closed,"
                + "opened_date,"
                + "opened_time,"
                + "amount,"
                + "created_at,"
                + "updated_at) "
                + "VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, model.getIsClosed() ? 1 : 0);
        statement.setDate(2, new Date(model.getOpenedDate().getTime()));
        statement.setTime(3, new Time(model.getOpenedDate().getTime()));
        statement.setDouble(4, model.getAmount());
        statement.setDate(5, new Date(model.getCreatedDate().getTime()));
        statement.setDate(6, new Date(model.getUpdatedDate().getTime()));

        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if(generatedKeys.next()){
            int modelId = generatedKeys.getInt(1);
            model.setId(modelId);
        }
    }

    @Override
    public void update(CashRegisterModel model) throws SQLException {
        String query = "UPDATE cash_register SET "
                + "closed = ?,"
                + "closed_date = ?,"
                + "closed_time = ?,"
                + "updated_at = ? "
                + "WHERE cash_register_id = ?";

        PreparedStatement statement = connect.prepareStatement(query);
        statement.setInt(1, model.getIsClosed() ? 1 : 0);
        statement.setDate(2, new Date(model.getClosedDate().getTime()));
        statement.setTime(3, new Time(model.getClosedDate().getTime()));
        statement.setDate(4, new Date(model.getUpdatedDate().getTime()));
        statement.setInt(5, model.getId());
        statement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CashRegisterModel select(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public List<CashRegisterModel> select() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int selectIdThatStatusIsOpen() {
        try{
            String query = "SELECT cash_register_id FROM cash_register WHERE closed = ? AND opened_date = ? LIMIT 1";
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1, 0);
            statement.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("cash_register_id");
            }
            return 0;
        }catch (Exception ex){
            return 0;
        }
    }
}
