package Controller;

import Model.User;
import SERVER.Session;

public class LoginController extends UserController {
    public void startingLoginInput() {
        menu.enteringTheSystem();
        setNumericChoice();
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
            menu.genericErrorMessage();
            loginEmailInput();
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
            menu.genericErrorMessage();
            loginPasswordInput(userFound);
        }
        
    }

    //* Funções de registro
    private void registerEmailInput() {
        String newUserEmail = emailInput();
        if(returningToLoginPage(newUserEmail))
            return;

        User userFound = userService.emailVerification(newUserEmail);
        if(userFound != null) {
            menu.AlreadyExists();
            registerEmailInput();
            
            return;
        }

        boolean IsEmailCorrect = userService.confirmEmailIsCorrect(newUserEmail);
        if(!IsEmailCorrect) {
            menu.genericErrorMessage();
            registerEmailInput();
            
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
            menu.genericErrorMessage();
            registerPasswordInput(newUser);
            
            return;
        }

        newUser.setPasswordUser(newPassword);

        userService.completeUserRegistration(newUser);
        startingLoginInput();
    }

    
    private boolean returningToLoginPage(String newInput) {
        if(newInput.compareTo("0") == 0) {
            menu.clearingConsole();
            startingLoginInput();
            
            return true;
        }
        return false;
    }

    
}

