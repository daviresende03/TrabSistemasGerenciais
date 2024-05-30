package service;

import java.util.ArrayList;
import model.entities.ProductModel;
import model.entities.ResponseService;
import model.entities.UnitModel;
import model.enums.ResponseTypeEnum;
import model.interfaces.repositories.IDataContext;
import model.interfaces.repositories.IProductRepository;
import model.interfaces.services.IProductService;

public class ProductService implements IProductService {
    private final IProductRepository productRepository;
    private final IDataContext dataContext;
    private ResponseService responseService;
    
    public ProductService(IDataContext dataContext, IProductRepository productRepository){
        this.dataContext = dataContext;
        this.productRepository = productRepository;
        this.responseService = new ResponseService();
    }
    
    @Override
    public ResponseService insert(ProductModel product){
        try{
            
            // Search in database product.unit.id by product.unit.name and product.unit.symbol
            UnitModel unit = product.getUnit();
            unit.setId(1);
            product.setUnit(unit);
            
            if(product.validate()){
                productRepository.insert(product);
            }else{
                return responseService.setResponse(ResponseTypeEnum.ERROR, product.getMessage());
            }
            dataContext.commit();
            return responseService.setResponse(ResponseTypeEnum.SUCCESS, "Produto cadastrado com sucesso!");
        }catch(Exception ex){
            dataContext.rollback();
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao realizar o cadastro do produto.");
        }
    }

    @Override
    public ResponseService remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseService update(ProductModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseService<ProductModel> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseService<ArrayList<ProductModel>> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
