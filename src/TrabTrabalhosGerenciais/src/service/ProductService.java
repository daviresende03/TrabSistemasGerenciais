package service;

import java.util.ArrayList;
import model.entities.ProductModel;
import model.interfaces.repositories.IDataContext;
import model.interfaces.repositories.IProductRepository;
import model.interfaces.services.IProductService;

public class ProductService implements IProductService {
    private final IProductRepository productRepository;
    private final IDataContext dataContext;
    
    public ProductService(IDataContext dataContext, IProductRepository productRepository){
        this.dataContext = dataContext;
        this.productRepository = productRepository;
    }
    
    @Override
    public String insert(ProductModel product){
        try{
            productRepository.insert(product);
            dataContext.commit();
            return "";
        }catch(Exception ex){
            dataContext.rollback();
            return "";
        }
    }

    @Override
    public String remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(ProductModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ProductModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
