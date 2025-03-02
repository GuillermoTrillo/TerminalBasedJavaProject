package View;

public class Menu {     


    public void printing(String string) {
        System.out.println(string);
    }

    public void clearingConsole() {
        System.out.print("\033[H\033[2J");
    }  

    public void genericErrorMessage() {
        printing("\n");
        printing("-----------------");
        printing("Something went wrong. Try again.");
        printing("-----------------");
        printing("\n");
    }

    public void indexMenu() {
        printing("-----------------");
        printing("1. Enter your Path!");
        printing("2. See your progress.");
        printing("3. Options.");
        printing("5. Log out.");
        printing("-----------------");
    }   

    public void AlreadyExists() {
        
    }
}
