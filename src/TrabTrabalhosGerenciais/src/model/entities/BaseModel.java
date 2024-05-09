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
    
    public void setId(int id){
        this.id = id;
    }
    public void setCreatedDate(Date date){
        createdDate = date;
    }
    public void setUpdatedDate(Date date){
        updatedDate = date;
    }
}
