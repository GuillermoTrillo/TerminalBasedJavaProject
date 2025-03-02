package Model;

public class User {
    private int idUser;
    private String nameUser;
    private String passwordUser;
    private String emailUser;
    private boolean isAdministrator;
    
    public User(int id, String name, String password, String email) {
        this.idUser = id;
        this.nameUser = name;
        this.passwordUser = password;
        this.emailUser = email;
    }

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return this.nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPasswordUser() {
        return this.passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getEmailUser() {
        return this.emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
    
    public boolean getIsAdministrator() {
        return this.isAdministrator;
    }

    public void setIsAdministrator(boolean isAdministrator) {
        this.isAdministrator = isAdministrator;
    }
}
