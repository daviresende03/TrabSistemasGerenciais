package model.entities;

import model.enums.ResponseTypeEnum;

public class ResponseService<T> {
    private ResponseTypeEnum type;
    private String message;
    private T data;
    
    public ResponseService setResponse(ResponseTypeEnum type, String message){
        this.type = type;
        this.message = message;
        return this;
    }
    public ResponseService setResponse(ResponseTypeEnum type, String message, T obj){
        this.type = type;
        this.message = message;
        this.data = obj;
        return this;
    }

    public ResponseTypeEnum getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
