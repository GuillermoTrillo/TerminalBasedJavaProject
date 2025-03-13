package Controller;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import Service.UserService;
import View.UserMenu;

public class UserController {
    protected int userChoice;
    protected Scanner scanner;
    protected UserMenu menu;
    protected UserService userService;

    public UserController() {
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        menu = new UserMenu();
        userService = new UserService();
    }

    //* funçoes de suporte. Pequenas e reutilizaveis.
    protected String NameInput() {
        menu.askingForName();
        return scanner.nextLine();
    }
    protected String emailInput() {
        menu.askingForEmail();
        return scanner.nextLine();
    }
    protected String passwordInput() {
        menu.askingForPassword();
        return scanner.nextLine();
    }

}
