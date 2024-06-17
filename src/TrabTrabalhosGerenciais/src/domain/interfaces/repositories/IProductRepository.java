package domain.interfaces.repositories;

import java.sql.SQLException;
import domain.model.entities.ProductModel;

public interface IProductRepository extends IBaseRepository<ProductModel>{
    void updateStock(int id, double quantity) throws SQLException;
    boolean exist(int id) throws SQLException;
    boolean existByUnitId(int unitId);
}
