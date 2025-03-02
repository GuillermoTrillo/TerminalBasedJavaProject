package Controller;

import Model.User;

public class Session {
    private static User userInSession;

    public static void setUserInSession(User userOpeningSession) {
        userInSession = userOpeningSession;
    }    

    public static User getUserInSession() {
        return userInSession;
    }

}
