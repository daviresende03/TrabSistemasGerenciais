package domain.model.entities;

import java.sql.Time;
import java.util.Date;

public class CashRegisterModel extends BaseModel{
    private boolean isClosed;
    private Date openedDate;
    private Time openedTime;
    private Date closedDate;
    private Time closedTime;
    private double amount;

    public CashRegisterModel(){}

    public CashRegisterModel(int id, boolean isClosed, Date openedDate, Time openedTime, Date closedDate, Time closedTime, double amount){
        setId(id);
        this.isClosed = isClosed;
        this.openedDate = openedDate;
        this.openedTime = openedTime;
        this.closedDate = closedDate;
        this.closedTime = closedTime;
        this.amount = amount;
    }

    public boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean closed) {
        isClosed = closed;
    }

    public Date getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(Date openingDate) {
        this.openedDate = openingDate;
    }

    public Time getOpenedTime() {
        return openedTime;
    }

    public void setOpenedTime(Time openingTime) {
        this.openedTime = openingTime;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    public Time getClosedTime() {
        return closedTime;
    }

    public void setClosedTime(Time closedTime) {
        this.closedTime = closedTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void increaseValue(double value){
        this.amount+=value;
    }

    public void decreaseValue(double value){
        this.amount-=value;
    }
}
