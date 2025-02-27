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

    private void printing(String string) {
        System.out.println(string);
    }
}
