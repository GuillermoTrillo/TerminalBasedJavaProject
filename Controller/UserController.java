package Controller;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import Service.UserService;
import View.UserMenu;

public class UserController implements Controller{
    protected int userChoice;
    protected Scanner scanner;
    protected UserMenu menu;
    protected UserService userService;

    public UserController() {
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        menu = new UserMenu();
        userService = new UserService();
    }

    public void profile() {
        menu.clearingConsole();
        menu.showCurrentUser();
        menu.profileMenu();

        setNumericChoice();
        switch (userChoice) {
            case 1:
                editUser();
                break;
            case 0:
            //todo find a way to go back into Entry Controller
            break;
            default:
                profile();
                break;
        }
    }

    private void editUser() {
        //todo
    }
    //* funçoes de suporte. Pequenas e reutilizaveis.
    @Override
    public void setNumericChoice() {
        try {
            this.userChoice = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            menu.genericErrorMessage();
        }
    }
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
