package Controller;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import View.Menu;

public class EntryController implements Controller{
    private Menu menu;
    protected Scanner scanner;
    private int entryChoice;
    

    public EntryController() {
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);
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
                break;

            case 3:
                //todo options
                break;

            case 4:
                //todo log out
                break;

            case 0:
                //todo turn the system off
                break;
            default:
                break;
        }
    }



    @Override
    public void setNumericChoice() {
        try {
            System.err.println(scanner.hasNextLine());
            
            this.entryChoice = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.err.println(e);
            menu.genericErrorMessage();

        }
    }
}
