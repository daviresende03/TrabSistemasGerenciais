/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.viewModels.ClientVM;
import model.entities.ClientModel;
import model.enums.DocumentType;
import model.enums.PersonTypeEnum;
import model.interfaces.services.IClientService;
import model.valueObjects.Address;
import model.valueObjects.Document;
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
    
    public void insert(ClientVM clientVM){        
        DocumentType documentType = clientVM.typeDocument.equals("CPF") ? DocumentType.CPF : DocumentType.CNPJ;
        Document clientDocument = new Document(documentType, clientVM.numberDocument);
        PersonTypeEnum clientType = clientVM.type.equals("PF") ? PersonTypeEnum.PF : PersonTypeEnum.PJ;
        Address clientAddress = new Address(clientVM.street, clientVM.number,clientVM.neighborhood,clientVM.city,clientVM.state,clientVM.postalCode,clientVM.country);
        
        ClientModel clientModel = new ClientModel(clientVM.name, clientDocument, clientType, clientAddress, clientVM.birthDate);
        clientService.insert(clientModel);
    }
}
