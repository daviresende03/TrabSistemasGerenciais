package model.entities;

import model.enums.ResponseTypeEnum;

public class ResponseService {
    private ResponseTypeEnum type;
    private String message;
    
    public ResponseService setResponse(ResponseTypeEnum type, String message){
        this.type = type;
        this.message = message;
        return this;
    }

    public ResponseTypeEnum getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
