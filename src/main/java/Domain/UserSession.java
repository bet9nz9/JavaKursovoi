package Domain;

import Entity.User;

public class UserSession {
    private static User sessionUser;

    //Constructors

    public UserSession() {
    }
    //Getters and setters

    public static User getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(User sessionUser) {
        UserSession.sessionUser = sessionUser;
    }
}
