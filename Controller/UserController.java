package Controller;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import SERVER.Session;
import Service.UserService;
import View.UserMenu;

public class UserController implements Controller{
    protected int userChoice;
    protected Scanner scanner;
    protected UserMenu menu;
    protected UserService userService;
    private EntryController entryController;

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
                getPasswordForEditing();
            break;
            case 0:
            entryController = new EntryController();
            entryController.mainMenu();
            break;
            default:
                profile();
                break;
        }
    }

    private void getPasswordForEditing() {
        menu.warningPasswordNeeded();
        String userPassword = passwordInput();

        if((userPassword).compareToIgnoreCase("0") == 0)
            profile();
        
        else if(userService.passwordVerification(Session.getUserInSession(), userPassword)) {
            menu.clearingConsole();
            editUser();
        }
        else {
            menu.genericErrorMessage();
            getPasswordForEditing();
        }
        
    }


    private void editUser() {
        //todo

        menu.showCurrentUser();
        menu.editMenu();
    	setNumericChoice();
        switch (userChoice) {
            case 1:
                editEmail();
            break;
            case 2:
                editPassword();
            break;
            case 3:
                editName();
            break;
            case 0:
                profile();
            break;
            default:
                editUser();
                break;
        }
    }

    private void editEmail() {
        String newEmail = emailInput();
        userService.editEmail(newEmail);
        editUser();
    }
    private void editPassword() {
        String newPassword = passwordInput();
        userService.editPassword(newPassword);
        editUser();
    }
    private void editName() {
        String newName = NameInput();
        userService.editName(newName);
        editUser();
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
