package UserPackage;

public class Menu {
    public void enteringTheSystem() {
        
        printing("-----------------");
        printing("1. Login"); 
        printing("2. Registrar");
        printing("-----------------");
    }
    public void askingForEmail() {
        printing("-----------------");
        printing("Write your email. To turn back, write 0.");
        printing("Email:");
    }
    public void askingForPassword() {
        printing("-----------------");
        printing("Password:");
    }
    public void somethingWentWrong() {
        printing("\n");
        printing("-----------------");
        printing("Something went wrong. Try again.");
        printing("-----------------");
        printing("\n");
    }
    public void passwordNeeds() {
        printing("-----------------");
        printing("Password needs at least 8 characters.");
    }
    public void askingForName() {
        printing("-----------------");
        printing("Name:");
    }
    public void userAlreadyExists() {
        printing("-----------------");
        printing("User already exists.");
        printing("-----------------");
        printing("\n");
    }

    public void indexMenu() {
        printing("-----------------");
        printing("1. Entrar na trilha"); 
        printing("2. Ver sua ");
        printing("-----------------");
    }



    private void printing(String string) {
        System.out.println(string);
    }
    public void clearingConsole() {
        System.out.print("\033[H\033[2J");
    }
}
