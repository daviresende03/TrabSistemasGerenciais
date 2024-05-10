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
    public void insert(ClientModel model){}
    
    @Override
    public void remove(int id){}
    
    @Override
    public void update(ClientModel model){}
    
    @Override
    public ClientModel get(int id){
        return null;
    }
    
    @Override
    public ArrayList<ClientModel> getAll(){
        return null;
    }
}
