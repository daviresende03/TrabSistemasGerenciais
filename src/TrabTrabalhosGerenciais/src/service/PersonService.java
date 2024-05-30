package service;

import java.util.ArrayList;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseService update(PersonModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseService<PersonModel> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseService<List<PersonModel>> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
