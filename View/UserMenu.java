package View;

import SERVER.Session;

public class UserMenu extends Menu{
    public void enteringTheSystem() {
        printing("-----------------");
        printing("1. Login"); 
        printing("2. Registrar");
        printing("-----------------");
    }
    public void warningPasswordNeeded() {
        printing("-----------------");
        printing("To continue, write your password. Else, 0 to turn back.");
    }
    public void askingForEmail() {
        printing("-----------------");
        printing("Write your email. To turn back, write 0.");
        printing("Email:");
    }
    public void askingForPassword() {
        printing("-----------------");
        printing("Password:");
    }
    public void passwordNeeds() {
        printing("-----------------");
        printing("Password needs at least 8 characters.");
    }
    public void askingForName() {
        printing("-----------------");
        printing("Name:");
    }
    
    public void AlreadyExists() {
        printing("-----------------");
        printing("User already exists.");
        printing("-----------------");
        printing("\n");
    }

    public void showCurrentUser() {
        printing("-----------------");
        printing("Nome: "+ Session.getUserInSession().getNameUser());
        printing("--------");
        printing("Email: "+ Session.getUserInSession().getEmailUser());
        printing("--------");
        printing("Password: *****");
        printing("-----------------");
    }
    public void profileMenu() {
        printing("-----------------");
        printing("1. Edit user");
        printing("0. Go back");
    }
}
