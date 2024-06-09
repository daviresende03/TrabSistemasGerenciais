package Infra.DependencyInjections;

import java.sql.Connection;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.repositories.IProductRepository;
import domain.interfaces.repositories.IUnitRepository;
import domain.interfaces.services.IProductService;
import data.repositories.ProductRepository;
import data.context.DataContext;
import domain.services.ProductService;

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
