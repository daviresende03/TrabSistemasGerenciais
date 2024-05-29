package service;

import model.entities.ProductModel;
import model.interfaces.repositories.IDataContext;
import model.interfaces.repositories.IProductRepository;
import repository.ProductRepository;
import repository.context.DataContext;

public class ProductService {
    private final IProductRepository productRepository;
    private final IDataContext dataContext;
    
    public ProductService(){
        dataContext = new DataContext();
        productRepository = new ProductRepository(dataContext.getConnection());
    }
    
    public void create(ProductModel product){
        try{
            productRepository.insert(product);
            dataContext.commit();
        }catch(Exception ex){
            dataContext.rollback();
        }
    }
}
