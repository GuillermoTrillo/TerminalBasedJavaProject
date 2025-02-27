package UserPackage;

public class UserService {

    public User emailVerification(String email) {
        User doesUserExist = PseudoDataBase.doesUserExist(email);
        if(doesUserExist == null && email.contains("@") == false)
            return null;

        return doesUserExist;
    }

    public boolean passwordVerification(User userToCompare, String password) {
        if(userToCompare.getPasswordUser().compareTo(password) == 0)
            return true;

        return false;
    }

    public boolean confirmEmailIsCorrect(String newEmail) {
        if(newEmail.contains("@"))
            return true;
        else
            return false;
    }
    public boolean confirmPasswordIsCorrect(String newPassword) {
        if(newPassword.length() >= 8)
            return true;
        else
            return false;
    }

    public void completeUserRegistration(User newUser) {

        newUser.setIdUser(PseudoDataBase.getLastId()+1);

        PseudoDataBase.addUser(newUser);
    }
}
