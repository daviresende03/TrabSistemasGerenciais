/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.viewModels.ClientVM;
import model.entities.ClientModel;
import model.enums.PersonTypeEnum;
import model.interfaces.services.IClientService;
import model.valueObjects.Address;
import service.ClientService;

/**
 *
 * @author Davi
 */
public class ClientController {
    private IClientService clientService;
    
    public ClientController(){
        clientService = new ClientService();
    }
    
    public String insert(ClientVM clientVM){        
        PersonTypeEnum clientType = clientVM.type.equals("PF") ? PersonTypeEnum.PF : PersonTypeEnum.PJ;
        Address clientAddress = new Address(clientVM.street, clientVM.number,clientVM.neighborhood,clientVM.city,clientVM.state,clientVM.postalCode,clientVM.country);
        ClientModel clientModel = new ClientModel(clientVM.name, clientVM.document, clientType, clientAddress, clientVM.birthDate);
        
        String messageResponse = clientService.insert(clientModel);
        return (messageResponse.isBlank() ? "Cliente cadastrado com sucesso!" : messageResponse);
    }
}
