package pacagepontocom;

public class Main {
    public static void main(String[] args) {
        User newUser = new User(1, "asd", "coc", "bruh@gmail.com");
        PseudoDataBase.addUser(newUser);
        UserInputManager userInput = new UserInputManager();
         userInput.startingLoginInput();
    }
}