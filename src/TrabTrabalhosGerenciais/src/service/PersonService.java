package service;

import java.util.Date;
import java.util.List;
import model.entities.PersonModel;
import model.entities.ResponseService;
import model.enums.ResponseTypeEnum;
import model.interfaces.repositories.IDataContext;
import model.interfaces.repositories.IPersonRepository;
import model.interfaces.services.IPersonService;

public class PersonService implements IPersonService {
    private final IPersonRepository personRepository;
    private final IDataContext dataContext;
    private ResponseService responseService;
    
    public PersonService(IDataContext dataContext, IPersonRepository personRepository){
        this.dataContext = dataContext;
        this.personRepository = personRepository;
        this.responseService = new ResponseService();
    }
    
    @Override
    public ResponseService insert(PersonModel person){
        try{
            Date date = new Date();
            person.setUpdatedDate(date);
            person.setCreatedDate(date);
            
            if(personRepository.select(person.getDocument()).getId() > 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "Já existe um cadastro com este documento.");
            }
            
            if(person.validate()){
                personRepository.insert(person);
            }else{
                return responseService.setResponse(ResponseTypeEnum.ERROR, person.getMessage());
            }
            dataContext.commit();
            return responseService.setResponse(ResponseTypeEnum.SUCCESS, "Usuário cadastrado com sucesso!");
        }catch(Exception ex){
            dataContext.rollback();
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao realizar o cadastro do usuário.");
        }
    }

    @Override
    public ResponseService remove(int id) {
        try{
            if(id <= 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
            }
            
            PersonModel person = personRepository.select(id);
            
            if(person.getId() <= 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "Usuário não encontrado.");
            }
            
            personRepository.delete(id);
            
            dataContext.commit();
            
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Usuário deletado com sucesso.");
        }catch(Exception ex){
            dataContext.rollback();
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar o usuário.");
        }
    }

    @Override
    public ResponseService update(PersonModel model) {
        try{
            if(model.getId() <= 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
            }
            
            PersonModel person = personRepository.select(model.getId());
            if(person.getId() <= 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "Usuário não encontrado.");
            }
            
            Date dateNow = new Date();
            model.setUpdatedDate(dateNow);
            
            if(model.validate()){
                personRepository.update(model);
            }else{
                return responseService.setResponse(ResponseTypeEnum.ERROR, model.getMessage());
            }
            dataContext.commit();
            return responseService.setResponse(ResponseTypeEnum.SUCCESS, "Usuário atualizado com sucesso!");
        }catch(Exception ex){
            dataContext.rollback();
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar o usuário.");
        }
    }

    @Override
    public ResponseService<PersonModel> get(int id) {
        try{
            if(id <= 0){
                return responseService.setResponse(ResponseTypeEnum.ERROR, "O id informado é inválido.");
            }
            
            PersonModel person = personRepository.select(id);
            
            if(person.getId() >= 0){
                return responseService.setResponse(ResponseTypeEnum.SUCCESS, "", person);
            }
            
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Usuário não encontrado.");
        }catch(Exception ex){
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar o usuário.");
        }
    }

    @Override
    public ResponseService<List<PersonModel>> getAll() {
        try{            
            List<PersonModel> people = personRepository.select();
            return responseService.setResponse(ResponseTypeEnum.SUCCESS, "", people);
        }catch(Exception ex){
            return responseService.setResponse(ResponseTypeEnum.ERROR, "Houve um erro ao buscar todos os usuários.");
        }
    }
}
