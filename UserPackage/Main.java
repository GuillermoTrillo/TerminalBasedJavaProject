package UserPackage;

public class Main {
    public static void main(String[] args) {
        User administrator = new User(0, "admin", "admin", "admin@gmail.com");
        administrator.setIsAdministrator(true);
        PseudoDataBase.addUser(administrator);

        UserInputManager userInput = new UserInputManager();
        userInput.startingLoginInput();

    }
}