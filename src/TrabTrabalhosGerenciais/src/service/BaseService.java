
package service;

import domain.model.entities.ResponseService;
import domain.interfaces.repositories.IDataContext;


public abstract class BaseService {
    protected final IDataContext dataContext;
    protected ResponseService responseService;

    public BaseService(IDataContext dataContext) {
        this.dataContext = dataContext;
        this.responseService = new ResponseService();
    }
    
    public ResponseService getResponseService(){
        return responseService;
    }
}
