package UserPackage;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User newUser = new User(0, "admin", "admin", "admin@gmail.com");
        PseudoDataBase.addUser(newUser);

        UserInputManager userInput = new UserInputManager();
         userInput.startingLoginInput();
    }
}