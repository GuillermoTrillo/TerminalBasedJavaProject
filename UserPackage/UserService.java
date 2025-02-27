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
}
