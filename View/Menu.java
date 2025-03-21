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
        printing("4. Log out.");
        printing("0. Turn the system off.");
        printing("-----------------");
    }

    public void indexMenuAdmin() {
        printing("-----------------");
        printing("1. Check the paths.");
        printing("2. Check other players.");
        printing("3. Options.");
        printing("5. Log out.");
        printing("0. Turn the system off.");
        printing("-----------------");
    }


    public void specificErrorMessage(String errorMessage) {    
        System.out.println("\n");
        System.out.println("-----------------");

        printing(errorMessage);

        System.out.println("-----------------");
        System.out.println("\n");
    }
}
