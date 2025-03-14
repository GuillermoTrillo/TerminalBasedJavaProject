package Controller;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import View.Menu;

public class EntryController implements Controller{
    private Menu menu;
    protected Scanner scanner;
    private int entryChoice;
    private LoginController loginController;
    private UserController userController;

    public EntryController() {
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        userController = new UserController();
        loginController = new LoginController();
        this.menu = new Menu();
    }

    public void mainMenuAdmin() {
        menu.indexMenuAdmin();
    }

    public void mainMenu() {
        menu.indexMenu();
        
        setNumericChoice();
        switch (entryChoice) {
            case 1:
                //todo enter your path
                break;

            case 2:
                //todo see your progress
                userController.profile();
                break;

            case 3:
                //todo options
                break;

            case 4:
                //todo log out
                break;

            case 0:
                turnTheSystemOff();
                break;
            default:
                break;
        }
    }
    

    private void turnTheSystemOff() {
        menu.specificErrorMessage("Turning off the system. Goodbye, chief.");
    }

    @Override
    public void setNumericChoice() {
        try {            
            this.entryChoice = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            menu.genericErrorMessage();

        }
    }
}
