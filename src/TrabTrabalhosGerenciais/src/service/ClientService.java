/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.entities.ClientModel;
import model.interfaces.services.IClientService;

/**
 *
 * @author Davi
 */
public class ClientService implements IClientService{
    
    @Override
    public String insert(ClientModel model){
        if(!validate(model)){
            return model.getMessage();
        }
        return null;
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
