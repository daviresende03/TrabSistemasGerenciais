/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.Date;
import model.enums.PersonTypeEnum;
import model.valueObjects.Address;
import model.valueObjects.Document;

/**
 *
 * @author Davi
 */
public abstract class PersonModel extends BaseModel{
    private String name;
    private Document document;
    private PersonTypeEnum type;
    private Address address;
    private Date birthDate;

    public PersonModel(String name, Document document, PersonTypeEnum type, Address address, Date birthDate) {
        this.name = name;
        this.document = document;
        this.type = type;
        this.address = address;
        this.birthDate = birthDate;
    }

    public PersonTypeEnum getType() {
        return type;
    }

    public void setType(PersonTypeEnum type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
