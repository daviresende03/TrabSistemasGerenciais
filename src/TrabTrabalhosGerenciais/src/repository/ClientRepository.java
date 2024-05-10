/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import model.entities.ClientModel;
import model.interfaces.repositories.IClientRepository;

/**
 *
 * @author Davi
 */
public class ClientRepository implements IClientRepository{
    
    @Override
    public void insert(ClientModel model){}
    @Override
    public void update(ClientModel model){}
    @Override
    public void delete(int id){}
    @Override
    public ClientModel select(int id){
        return null;
    }
    @Override
    public ArrayList<ClientModel> select(){
        return null;
    }
}
