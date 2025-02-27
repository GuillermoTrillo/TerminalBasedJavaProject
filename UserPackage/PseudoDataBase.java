package UserPackage;

import java.util.HashMap;

public class PseudoDataBase {
    public static HashMap<Integer, User> users = new HashMap<Integer, User>();

    public static void addUser(User newUser) {
        users.put(newUser.getIdUser(), newUser);
    }

    public static void deleteUser(User userToDelete) {
        users.remove(userToDelete.getIdUser());
    }

    public static void editUser(User newUser) {
        users.replace(newUser.getIdUser(), newUser);
    }

    public static User getUserById(int idUser) {
        return users.get(idUser);
    }

    public static User doesUserExist(String email) {
        for(int i = 0; i <= users.size(); i++) {
            if(users.get(i) != null) {
                if(users.get(i).getEmailUser().compareTo(email) == 0) {
                    return users.get(i);
                }
            }
            
        }
        return null;
    }
}
