package domain.model.entities;

public class OperatorModel extends BaseModel{
    private int id;
    private String username;
    private String password;
    private String passwordHash;
    private boolean isAdmin;

    public OperatorModel(){}
    public OperatorModel(int id, String username, String password, boolean isAdmin){
        setId(id);
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }
}
