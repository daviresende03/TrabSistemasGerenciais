package application.viewModels;

public class OperatorVM {
    public int id;
    public String username;
    public String password;
    public boolean isAdmin;

    public OperatorVM(){}
    public OperatorVM(int id, String username, String password, boolean isAdmin){
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}
