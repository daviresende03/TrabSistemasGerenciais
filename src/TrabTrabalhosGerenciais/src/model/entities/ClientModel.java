/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.Date;
import model.enums.PersonTypeEnum;
import model.valueObjects.Address;

/**
 *
 * @author Davi
 */
public class ClientModel extends PersonModel{ 

    public ClientModel(String name, String document, PersonTypeEnum type, Address address, Date birthDate, String obersevation) {
        super(name, document, type, address, birthDate, obersevation);
    }
    
}
