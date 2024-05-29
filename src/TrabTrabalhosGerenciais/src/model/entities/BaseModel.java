/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.Date;

/**
 *
 * @author Davi
 */
public abstract class BaseModel {
    private int id;
    private Date createdDate;
    private Date updatedDate;
    private String message = "";
    
    public void setId(int id){
        this.id = id;
    }
    public void setCreatedDate(Date date){
        createdDate = date;
    }
    public void setUpdatedDate(Date date){
        updatedDate = date;
    }
    public void addMessage(String message){
        
        if(!message.isEmpty()){
            this.message += "\n";
        }
        
        this.message += message;
    }
    public int getId(){
        return id;
    }
    
    public String getMessage(){
        return message;
    }
    
    public boolean isValid(){
        return message.isEmpty();
    }
}
