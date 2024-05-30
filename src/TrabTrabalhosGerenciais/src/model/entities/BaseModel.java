package model.entities;

import java.util.Date;

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
}
