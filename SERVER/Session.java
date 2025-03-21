package SERVER;

import java.util.HashMap;

import Model.User;

public class Session {
    private static User userInSession;
    private static HashMap<String, String> sessionVariables = new HashMap<String, String>();

    public static void setUserInSession(User userOpeningSession) {
        userInSession = userOpeningSession;
    }    
    public static User getUserInSession() {
        return userInSession;
    }

    public static void setNewSessionVariable(String key, String variable) {
        sessionVariables.put(key, variable);
    }
    public static String getSessionVariableByKey(String key) {
        return sessionVariables.get(key);
    }

    public static void logOut() {
        userInSession = null;
        sessionVariables.clear();
    }
}
