package domain.services;

import domain.interfaces.repositories.ICashRegisterRepository;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.repositories.IFinanceRepository;
import domain.interfaces.services.IFinanceService;
import domain.model.entities.CashRegisterModel;
import domain.model.entities.FinanceModel;
import domain.model.entities.ResponseService;
import domain.model.enums.FinanceTypeEnum;
import domain.model.enums.ResponseTypeEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinanceService extends BaseService implements IFinanceService {
    private final IFinanceRepository financeRepository;
    private final ICashRegisterRepository cashRegisterRepository;
    
    public FinanceService(IDataContext dataContext, IFinanceRepository financeRepository, ICashRegisterRepository cashRegisterRepository){
        super(dataContext);
        this.financeRepository = financeRepository;
        this.cashRegisterRepository = cashRegisterRepository;
    }
    
    @Override
    public ResponseService getResponseService(){
        return responseService;
    }

    @Override
    public void insert(FinanceModel model) {
        try{
            CashRegisterModel cashRegister = cashRegisterRepository.select(model.getCashRegisterId());
            if(cashRegister.getId()<=0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível encontrar o caixa relacionado.");
                return;
            }
            if(cashRegister.getIsClosed()){
                responseService.setResponse(ResponseTypeEnum.ERROR, "O caixa relacionado está fechado, não será possível realizar o lançamento.");
                return;
            }

            model.setCreatedDate(new Date());
            model.setUpdatedDate(new Date());

            if(model.validate()){
                financeRepository.insert(model);
                if(model.getType() == FinanceTypeEnum.PAYMENT){
                    cashRegister.decreaseValue(model.getValue());
                }else{
                    cashRegister.increaseValue(model.getValue());
                }
                cashRegister.setUpdatedDate(new Date());
                cashRegisterRepository.updateAmount(cashRegister);
            }else{
                responseService.setResponse(ResponseTypeEnum.ERROR, model.getMessage());
                return;
            }
            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Registro lançado com sucesso.");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao realizar o lançamento do registro.");
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
            List<FinanceModel> financeList = financeRepository.selectByCashRegisterId(cashRegisterId);
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
            dataContext.commit();
            return financeList;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar os lançamentos do caixa.");
            return new ArrayList<FinanceModel>();
        }
    }
}
