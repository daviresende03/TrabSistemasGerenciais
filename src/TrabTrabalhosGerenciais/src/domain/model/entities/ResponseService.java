package domain.model.entities;

import java.util.Objects;
import domain.model.enums.ResponseTypeEnum;

public class ResponseService {
    private ResponseTypeEnum type;
    private String message;
    
    public void setResponse(ResponseTypeEnum type, String message){
        this.type = Objects.requireNonNullElse(type, ResponseTypeEnum.ERROR);
        this.message = Objects.requireNonNullElse(message,"");
    }

    public ResponseTypeEnum getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
