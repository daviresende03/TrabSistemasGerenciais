package domain.services;

import domain.interfaces.repositories.IDataContext;
import domain.interfaces.repositories.IOperatorRepository;
import domain.interfaces.services.IOperatorService;
import domain.model.entities.OperatorModel;
import domain.model.entities.ResponseService;
import domain.model.enums.ResponseTypeEnum;
import domain.utils.PasswordUtil;

public class OperatorService extends BaseService implements IOperatorService {

    private final IOperatorRepository operatorRepository;

    public OperatorService(IDataContext dataContext, IOperatorRepository operatorRepository){
        super(dataContext);
        this.operatorRepository = operatorRepository;
    }

    @Override
    public ResponseService getResponseService(){
        return responseService;
    }

    @Override
    public OperatorModel login(OperatorModel operator) {
        try{
            if(operator.getUsername().isEmpty()){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Favor informar seu usuário");
                return new OperatorModel();
            }
            if(operator.getPassword().isEmpty()){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Favor informar sua senha");
                return new OperatorModel();
            }

            String passwordHashRequest = PasswordUtil.hashPassword(operator.getPassword());
            OperatorModel operatorDataBase = operatorRepository.selectByPasswordHash(passwordHashRequest);

            if(operatorDataBase.getId() <= 0 || !operatorDataBase.getUsername().equals(operator.getUsername())){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Credenciais inválidas");
                return new OperatorModel();
            }

            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Login efetuado com sucesso");
            return operatorDataBase;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Erro ao realizar login");
            return new OperatorModel();
        }
    }
}
