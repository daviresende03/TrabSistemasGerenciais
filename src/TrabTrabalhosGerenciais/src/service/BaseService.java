
package service;

import model.entities.ResponseService;
import model.interfaces.repositories.IDataContext;


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
