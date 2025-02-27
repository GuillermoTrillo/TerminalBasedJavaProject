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

    //*Funções do login
    private void loginEmailInput() {
        String userEmail = emailInput();

        if(returningToLoginPage(userEmail))
            return;

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

        if(returningToLoginPage(userPassword))
            return;
        
        if(userService.passwordVerification(userFound, userPassword)) {
            Session.setUserInSession(userFound);
            menu.clearingConsole();
        }
        else {
            menu.somethingWentWrong();
            loginPasswordInput(userFound);
        }
        scanner.close();
    }

    //* Funções de registro
    private void registerEmailInput() {
        String newUserEmail = emailInput();
        if(returningToLoginPage(newUserEmail))
            return;

        User userFound = userService.emailVerification(newUserEmail);
        if(userFound != null) {
            menu.userAlreadyExists();
            registerEmailInput();
            scanner.close();
            return;
        }

        boolean IsEmailCorrect = userService.confirmEmailIsCorrect(newUserEmail);
        if(!IsEmailCorrect) {
            menu.somethingWentWrong();
            registerEmailInput();
            scanner.close();
            return;
        }
        User newUser = new User(0, "", "null", newUserEmail);
        registerNameInput(newUser);
    }
    private void registerNameInput(User newUser) {
        String newUserName = NameInput();
        if(returningToLoginPage(newUserName))
            return;

        newUser.setNameUser(newUserName);
        registerPasswordInput(newUser);
    }
    private void registerPasswordInput(User newUser) {
        menu.passwordNeeds();
        String newPassword = passwordInput();
        
        boolean IsPasswordCorrect = userService.confirmPasswordIsCorrect(newPassword);
        if(!IsPasswordCorrect) {
            menu.somethingWentWrong();
            registerPasswordInput(newUser);
            scanner.close();
            return;
        }

        newUser.setPasswordUser(newPassword);

        userService.completeUserRegistration(newUser);
        startingLoginInput();
    }


    //* funçoes de suporte. Pequenas e reutilizaveis.
    private boolean returningToLoginPage(String newInput) {
        if(newInput.compareTo("0") == 0) {
            startingLoginInput();
            scanner.close();
            return true;
        }
        return false;
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
