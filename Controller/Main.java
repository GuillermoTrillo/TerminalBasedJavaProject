package Controller;

import DAO.PseudoDataBase;
import Model.User;
import View.Index;

public class Main {
    public static void main(String[] args) {
        User administrator = new User(0, "admin", "admin", "admin@gmail.com");
        administrator.setIsAdministrator(true);
        PseudoDataBase.addUser(administrator);

        UserController userInput = new UserController();
        userInput.startingLoginInput();
        Index index = new Index();
        index.index();
    }
}