package pacagepontocom;

import java.util.Scanner;

public class UserInputManager {
    private int userChoice;
    private Scanner scanner;
    private Menu menus;
    private UserService userService;

    public UserInputManager() {
        scanner = new Scanner(System.in);
        menus = new Menu();
        userService = new UserService();
    }
  

    public void startingLoginInput() {
        menus.enteringTheSystem();
        setUserNumericChoice();
        switch (userChoice) {
            case 1:
                loginEmailInput();
                break;
            case 2:
                
                break;
            default:
            startingLoginInput();
                break;
        }
    }
    private void setUserNumericChoice() {
        try {
            this.userChoice = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            menus.somethingWentWrong();
            startingLoginInput();
        }
    }

    private void loginEmailInput() {
        menus.askingForEmail();
        
        String userEmail = scanner.nextLine();
        if(userEmail.compareTo("0") == 0) {
            startingLoginInput();
            return;
        }

        User userFound = userService.emailVerification(userEmail);
        
        if(userFound == null) {
            menus.somethingWentWrong();
            loginEmailInput();
            scanner.close();
            return;
        }
        loginPasswordInput(userFound);
    }

    private void loginPasswordInput(User userFound) {
        Scanner scanner = new Scanner(System.in);

        menus.askingForPassword();
        String userPassword = scanner.nextLine();

        
        userService.passwordVerification(userFound, userPassword);
        scanner.close();
    }
}
