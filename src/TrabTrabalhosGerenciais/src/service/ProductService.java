package service;

import java.util.Date;
import java.util.List;
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
    public ResponseService insert(ProductModel model){
        try{
            UnitModel unit = unitRepository.select(model.getUnit().getName());
            if(unit.getId() == 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível recuperar a unidade informada.");
            }
            model.setUnit(unit);
            
            Date dateNow = new Date();
            model.setUpdatedDate(dateNow);
            model.setCreatedDate(dateNow);
            
            if(model.validate()){
                productRepository.insert(model);
            }else{
                return responseService.setResponse(ResponseTypeEnum.ERROR, model.getMessage());
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
        try{
            if(id <= 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
            }
            
            ProductModel product = productRepository.select(id);
            
            if(product.getId() <= 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "Produto não encontrado.");
            }
            
            productRepository.delete(id);
            
            dataContext.commit();
            
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Produto deletado com sucesso.");
        }catch(Exception ex){
            dataContext.rollback();
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar o produto.");
        }
    }

    @Override
    public ResponseService update(ProductModel model) {
        try{
            if(model.getId() <= 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
            }
            
            ProductModel product = productRepository.select(model.getId());
            if(product.getId() <= 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "Produto não encontrado.");
            }
            
            UnitModel unit = unitRepository.select(model.getUnit().getName());
            if(unit.getId() == 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível recuperar a unidade informada.");
            }
            model.setUnit(unit);
            
            Date dateNow = new Date();
            model.setUpdatedDate(dateNow);
            
            if(model.validate()){
                productRepository.insert(model);
            }else{
                return responseService.setResponse(ResponseTypeEnum.ERROR, model.getMessage());
            }
            dataContext.commit();
            return responseService.setResponse(ResponseTypeEnum.SUCCESS, "Produto atualizado com sucesso!");
        }catch(Exception ex){
            dataContext.rollback();
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar o produto.");
        }
    }

    @Override
    public ResponseService<ProductModel> get(int id) {
        try{
            if(id <= 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
            }
            
            ProductModel product = productRepository.select(id);
            
            if(product.getId() >= 0){
                return responseService.setResponse(ResponseTypeEnum.SUCCESS, "", product);
            }
            
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Produto não encontrado.");
        }catch(Exception ex){
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar o produto.");
        }
    }

    @Override
    public ResponseService<List<ProductModel>> getAll() {
         try{            
            List<ProductModel> products = productRepository.select();
            return responseService.setResponse(ResponseTypeEnum.SUCCESS, "", products);
        }catch(Exception ex){
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar todos os produtos.");
        }
    }
}
