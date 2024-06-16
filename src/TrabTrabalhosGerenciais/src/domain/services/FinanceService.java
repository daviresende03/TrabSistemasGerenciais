package domain.services;

import domain.interfaces.repositories.IDataContext;
import domain.interfaces.repositories.IFinanceRepository;
import domain.interfaces.services.IFinanceService;
import domain.model.entities.FinanceModel;
import domain.model.entities.ResponseService;
import domain.model.enums.ResponseTypeEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinanceService extends BaseService implements IFinanceService {
    private final IFinanceRepository financeRepository;
    
    public FinanceService(IDataContext dataContext, IFinanceRepository financeRepository){
        super(dataContext);
        this.financeRepository = financeRepository;
    }
    
    @Override
    public ResponseService getResponseService(){
        return responseService;
    }
   
    @Override
    public void insert(FinanceModel model) {
        try{ 
            Date dateNow = new Date();
            model.setCreatedDate(dateNow);
            
            if(model.validate()){                
                financeRepository.insert(model);
            }else{
                responseService.setResponse(ResponseTypeEnum.ERROR, model.getMessage());
                return;
            }
            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Registro cadastrado com sucesso!");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao realizar o cadastro do registro.");
        }
    }
    
    @Override
    public void remove(int id) {
        try{
            if(id <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
                return;
            }
            
            if(financeRepository.exist(id)){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Registro não encontrado.");
                return;
            }
            
            financeRepository.delete(id);
            
            dataContext.commit();
            
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Registro deletado com sucesso.");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao deletar o registro.");
        }
    }
    
    @Override
    public List<FinanceModel> getAll() {
        try{            
            List<FinanceModel> financeList = financeRepository.select();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
            dataContext.commit();
            return financeList;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar todos os registros.");
            return new ArrayList<FinanceModel>();
        }
    }  

    @Override
    public void update(FinanceModel model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FinanceModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<FinanceModel> getAllByCashRegisterId(int cashRegisterId){
        try{
            List<FinanceModel> financeList = financeRepository.select();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
            dataContext.commit();
            return financeList;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar os lançamentos do caixa.");
            return new ArrayList<FinanceModel>();
        }
    }
}
