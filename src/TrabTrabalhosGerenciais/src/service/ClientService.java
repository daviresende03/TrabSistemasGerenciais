/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.entities.ClientModel;
import model.interfaces.repositories.IClientRepository;
import model.interfaces.services.IClientService;
import repository.ClientRepository;

/**
 *
 * @author Davi
 */
public class ClientService implements IClientService{
    private IClientRepository clientRepository;
    
    public ClientService(){
        clientRepository = new ClientRepository();
    }
    
    @Override
    public String insert(ClientModel model){
        try{
            if(!validate(model)){
                return model.getMessage();
            }
            clientRepository.insert(model);
            return "";
        }catch(Exception ex){
            return "Houve um erro ao incluir o produto\nErro: " + ex.getMessage();
        }
    }
    
    @Override
    public String remove(int id){
        return null;
    }
    
    @Override
    public String update(ClientModel model){
        return null;
    }
    
    @Override
    public ClientModel get(int id){
        return null;
    }
    
    @Override
    public ArrayList<ClientModel> getAll(){
        return null;
    }
    
    private boolean validate(ClientModel client){
        if(client.getName().isEmpty()){
            client.addMessage("Nome é obrigatório.");
        }
        
        if(client.getDocument().isEmpty()){
            client.addMessage("Documento é obrigatório.");
        }
        return client.isValid();
    }
}
