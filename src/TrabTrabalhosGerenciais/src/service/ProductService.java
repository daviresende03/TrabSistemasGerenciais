package service;

import java.util.ArrayList;
import java.util.Date;
import model.entities.ProductModel;
import model.entities.ResponseService;
import model.entities.UnitModel;
import model.enums.ResponseTypeEnum;
import model.interfaces.repositories.IDataContext;
import model.interfaces.repositories.IProductRepository;
import model.interfaces.repositories.IUnitRepository;
import model.interfaces.services.IProductService;

public class ProductService implements IProductService {
    private final IProductRepository productRepository;
    private final IUnitRepository unitRepository;
    private final IDataContext dataContext;
    private ResponseService responseService;
    
    public ProductService(IDataContext dataContext, IProductRepository productRepository, IUnitRepository unitRepository){
        this.dataContext = dataContext;
        this.productRepository = productRepository;
        this.unitRepository = unitRepository;
        this.responseService = new ResponseService();
    }
    
    @Override
    public ResponseService insert(ProductModel product){
        try{
            UnitModel unit = unitRepository.select(product.getUnit().getName());
            if(unit.getId() == 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível recuperar a unidade informada.");
            }
            
            product.setUnit(unit);
            
            Date dateNow = new Date();
            product.setUpdatedDate(dateNow);
            product.setCreatedDate(dateNow);
            
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
