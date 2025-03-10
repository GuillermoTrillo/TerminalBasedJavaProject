package SERVER;

import Controller.LoginController;
import Controller.EntryController;
import DAO.PseudoDataBase;
import Model.User;

public class Main {
    public static void main(String[] args) {
        User administrator = new User(0, "admin", "admin", "admin@gmail.com");
        administrator.setIsAdministrator(true);
        PseudoDataBase.addUser(administrator);

        LoginController loginController = new LoginController();
        loginController.startingLoginInput();   

        EntryController entryController = new EntryController();

        if(Session.getUserInSession().getIsAdministrator())
            entryController.mainMenuAdmin();
        else 
            entryController.mainMenu();
    }
}