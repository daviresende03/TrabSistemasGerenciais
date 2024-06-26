package domain.services;

import domain.interfaces.repositories.IOrderRepository;
import domain.utils.StringUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import domain.model.entities.PersonModel;
import domain.model.enums.ResponseTypeEnum;
import domain.interfaces.repositories.IDataContext;
import domain.interfaces.repositories.IPersonRepository;
import domain.interfaces.services.IPersonService;

public class PersonService extends BaseService implements IPersonService {
    private final IPersonRepository personRepository;
    private final IOrderRepository orderRepository;

    public PersonService(IDataContext dataContext, IPersonRepository personRepository, IOrderRepository orderRepository){
        super(dataContext);
        this.personRepository = personRepository;
        this.orderRepository = orderRepository;
    }
    
    @Override
    public void insert(PersonModel person){
        try{
            Date date = new Date();
            person.setUpdatedDate(date);
            person.setCreatedDate(date);
            
            person.setDocument(StringUtil.RemoveMask(person.getDocument()));
            
            if(personRepository.select(person.getDocument()).getId() > 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Já existe um cadastro com este documento.");
                return;
            }
            
            if(person.validate()){
                personRepository.insert(person);
            }else{
                responseService.setResponse(ResponseTypeEnum.ERROR, person.getMessage());
                return;
            }
            
            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Usuário cadastrado com sucesso.");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao realizar o cadastro do usuário.");
        }
    }

    @Override
    public void remove(int id) {
        try{
            if(id <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
                return;
            }
            
            if(!personRepository.exist(id)){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Usuário não encontrado.");
                return;
            }

            if(orderRepository.existByPersonId(id)){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Este usuário possui pedidos relacionados, não será possível remove-lo.");
                return;
            }
            
            personRepository.delete(id);
            
            dataContext.commit();            
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Usuário deletado com sucesso.");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao deletar o usuário.");
        }
    }

    @Override
    public void update(PersonModel model) {
        try{
            if(model.getId() <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
                return;
            }
            
            if(!personRepository.exist(model.getId())){
                responseService.setResponse(ResponseTypeEnum.ERROR, "Usuário não encontrado.");
                return;
            }
            
            Date dateNow = new Date();
            model.setUpdatedDate(dateNow);
            
            if(model.validate()){
                personRepository.update(model);
            }else{
                responseService.setResponse(ResponseTypeEnum.ERROR, model.getMessage());
                return;
            }
            dataContext.commit();
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "Usuário atualizado com sucesso!");
        }catch(Exception ex){
            dataContext.rollback();
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao atualizar o usuário.");
        }
    }

    @Override
    public PersonModel get(int id) {
        try{
            if(id <= 0){
                responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
                return new PersonModel();
            }
            
            PersonModel person = personRepository.select(id);
            
            if(person.getId() >= 0){
                responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
            }else{
                responseService.setResponse(ResponseTypeEnum.ERROR, "Usuário não encontrado.");
            }
            return person;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar o usuário.");
            return new PersonModel();
        }
    }
    
    @Override
    public List<PersonModel> getAll(boolean isCustomer, boolean isStaff, boolean isSupplier) {
        try{            
            List<PersonModel> people = personRepository.select(isCustomer, isStaff, isSupplier);
            responseService.setResponse(ResponseTypeEnum.SUCCESS, "");
            return people;
        }catch(Exception ex){
            responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar usuários.");
            return new ArrayList<PersonModel>();
        }
    }

    @Override
    public List<PersonModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
