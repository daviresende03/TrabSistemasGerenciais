package domain.services;

import domain.interfaces.repositories.ICashRegisterRepository;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.services.ICashRegisterService;
import domain.model.entities.CashRegisterModel;
import domain.model.entities.ResponseService;
import domain.model.enums.ResponseTypeEnum;

import java.util.Date;
import java.util.List;

public class CashRegisterService extends BaseService implements ICashRegisterService {
    private final ICashRegisterRepository cashRegisterRepository;

    public CashRegisterService(IDataContext dataContext, ICashRegisterRepository cashRegisterRepository) {
        super(dataContext);
        this.cashRegisterRepository = cashRegisterRepository;
    }

    @Override
    public void insert(CashRegisterModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(CashRegisterModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CashRegisterModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CashRegisterModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CashRegisterModel open(){
        try{
            if(cashRegisterRepository.selectIdThatStatusIsOpen()>1){
                responseService.setResponse(ResponseTypeEnum.ERROR, "É necessário primeiramente fechar o caixa em aberto.");
                return new CashRegisterModel();
            }

            CashRegisterModel cashReg = new CashRegisterModel();
            cashReg.setIsClosed(false);
            cashReg.setOpenedDate(new Date());
            cashReg.setAmount(0);
            cashReg.setCreatedDate(new Date());
            cashReg.setUpdatedDate(new Date());

            cashRegisterRepository.insert(cashReg);

            if(cashReg.getId() <= 0){
                dataContext.rollback();
                responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível abrir o caixa.");
                return new CashRegisterModel();
            }

            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Caixa aberto com sucesso.");
            return cashReg;
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao abrir o caixa.");
            return new CashRegisterModel();
        }
    }

    @Override
    public void close(int id){
        try{
            CashRegisterModel cashReg = new CashRegisterModel();
            cashReg.setId(id);
            cashReg.setIsClosed(true);
            cashReg.setClosedDate(new Date());
            cashReg.setUpdatedDate(new Date());
            cashRegisterRepository.update(cashReg);

            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Caixa fechado com sucesso.");
        }catch(Exception ex) {
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao fechar o caixa.");
        }
    }

    @Override
    public boolean existCashRegisterOpen(){
        try{
            boolean existCashOpen = cashRegisterRepository.selectIdThatStatusIsOpen()>1;
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
            return existCashOpen;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao obter o status do caixa.");
            return false;
        }
    }

    @Override
    public int selectIdThatStatusIsOpen(){
        try{
            int cashRegisterOpenId = cashRegisterRepository.selectIdThatStatusIsOpen();
            if(cashRegisterOpenId<=0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Não foi possível recuperar o id do caixa em aberto.");
            }
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
            return cashRegisterOpenId;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao obter o status do caixa.");
            return 0;
        }
    }
}
