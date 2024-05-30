package Infra.DependencyInjection;

import java.sql.Connection;
import model.interfaces.repositories.IDataContext;
import model.interfaces.repositories.IProductRepository;
import model.interfaces.repositories.IUnitRepository;
import model.interfaces.services.IProductService;
import repository.ProductRepository;
import repository.context.DataContext;
import service.ProductService;

public class ProductDI {
    public IDataContext getDataContext(){
       return new DataContext(); 
    }
    
    public IProductRepository getProductRepository(Connection con){
        return new ProductRepository(con);
    }
    
    public IProductService getProductService(IDataContext dataContext, IProductRepository productRepository, IUnitRepository unitRepository){
        return new ProductService(dataContext, productRepository, unitRepository);
    }
}
