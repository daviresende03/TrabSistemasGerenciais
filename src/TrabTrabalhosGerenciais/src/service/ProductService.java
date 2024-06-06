package service;

import java.util.Date;
import java.util.List;
import domain.model.entities.ProductModel;
import domain.model.entities.UnitModel;
import domain.model.enums.ResponseTypeEnum;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.repositories.IProductRepository;
import domain.interfaces.repositories.IUnitRepository;
import domain.interfaces.services.IProductService;

public class ProductService extends BaseService implements IProductService {
    private final IProductRepository productRepository;
    private final IUnitRepository unitRepository;
    
    public ProductService(IDataContext dataContext, IProductRepository productRepository, IUnitRepository unitRepository){
        super(dataContext);
        this.productRepository = productRepository;
        this.unitRepository = unitRepository;
    }
    
    @Override
    public void insert(ProductModel model){
        try{
            UnitModel unit = unitRepository.select(model.getUnit().getName());
            if(unit.getId() == 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível recuperar a unidade informada.");
                return;
            }
            model.setUnit(unit);
            
            Date dateNow = new Date();
            model.setUpdatedDate(dateNow);
            model.setCreatedDate(dateNow);
            
            if(model.validate()){
                productRepository.insert(model);
            }else{
                responseService.setResponse(ResponseTypeEnum.ERROR, model.getMessage());
                return;
            }
            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Produto cadastrado com sucesso!");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao realizar o cadastro do produto.");
        }
    }

    @Override
    public void remove(int id) {
        try{
            if(id <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
                return;
            }
            
            if(!productRepository.exist(id)){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Produto não encontrado.");
                return;
            }
            
            productRepository.delete(id);
            
            dataContext.commit();
            
            responseService.setResponse(ResponseTypeEnum.ERROR, "Produto deletado com sucesso.");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao deletar o produto.");
        }
    }

    @Override
    public void update(ProductModel model) {
        try{
            if(model.getId() <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
                return;
            }
            
            if(!productRepository.exist(model.getId())){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Produto não encontrado.");
                return;
            }
            
            UnitModel unit = unitRepository.select(model.getUnit().getName());
            if(unit.getId() == 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível recuperar a unidade informada.");
                return;
            }
            model.setUnit(unit);
            
            Date dateNow = new Date();
            model.setUpdatedDate(dateNow);
            
            if(model.validate()){
                productRepository.update(model);
            }else{
                responseService.setResponse(ResponseTypeEnum.ERROR, model.getMessage());
                return;
            }
            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Produto atualizado com sucesso!");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao atualizar o produto.");
        }
    }

    @Override
    public ProductModel get(int id) {
        try{
            if(id <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
                return new ProductModel();
            }
            
            ProductModel product = productRepository.select(id);
            
            if(product.getId() <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Produto não encontrado.");
            }else{
                responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
            }
            return product;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar o produto.");
            return new ProductModel();
        }
    }

    @Override
    public List<ProductModel> getAll() {
         try{            
            List<ProductModel> products = productRepository.select();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
            return products;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar todos os produtos.");
            return null;
        }
    }
}
