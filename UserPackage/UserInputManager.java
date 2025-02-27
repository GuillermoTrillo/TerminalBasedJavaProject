package UserPackage;

import java.util.Scanner;

public class UserInputManager {
    private int userChoice;
    private Scanner scanner;
    private Menu menu;
    private UserService userService;

    public UserInputManager() {
        scanner = new Scanner(System.in);
        menu = new Menu();
        userService = new UserService();
    }
  
    public void startingLoginInput() {
        menu.enteringTheSystem();
        setUserNumericChoice();
        switch (userChoice) {
            case 1:
                loginEmailInput();
                break;
            case 2:
                registerEmailInput();
                break;
            default:
                startingLoginInput();
                break;
        }
    }

    private void loginEmailInput() {
        String userEmail = emailInput();

        if(userEmail.compareTo("0") == 0) {
            startingLoginInput();
            return;
        }
        User userFound = userService.emailVerification(userEmail);
        if(userFound == null) {
            menu.somethingWentWrong();
            loginEmailInput();
            scanner.close();
            return;
        }
        loginPasswordInput(userFound);
    }
    private void loginPasswordInput(User userFound) {
        String userPassword = passwordInput();

        if(userPassword.compareTo("0") == 0) {
            startingLoginInput();
            scanner.close();
            return;
        }
        
        if(userService.passwordVerification(userFound, userPassword)) {
            //todo guardar os dados na sessão e entrar no sistema 
        }
        else {
            menu.somethingWentWrong();
            loginPasswordInput(userFound);
        }
        scanner.close();
    }


    private void registerEmailInput() {
        String userEmail = emailInput();

        if(userEmail.compareTo("0") == 0) {
            startingLoginInput();
            return;
        }
    }


    private String NameInput() {
        menu.askingForName();
        return scanner.nextLine();
    }
    private String emailInput() {
        menu.askingForEmail();
        return scanner.nextLine();
    }
    private String passwordInput() {
        menu.askingForPassword();
        return scanner.nextLine();
    }
    private void setUserNumericChoice() {
        try {
            this.userChoice = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            menu.somethingWentWrong();
            startingLoginInput();
        }
    }

}
