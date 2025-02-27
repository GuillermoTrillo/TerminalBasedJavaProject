package pacagepontocom;

public class User {
    private int idUser;
    private String nomeUser;
    private String passwordUser;
    private String emailUser;
    private boolean isAdministrator;
    
    protected User(int id, String nome, String password, String email) {
        this.idUser = id;
        this.nomeUser = nome;
        this.passwordUser = password;
        this.emailUser = email;
    }

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNomeUser() {
        return this.nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
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
