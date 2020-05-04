package Domain;

import Entity.Job;
import Entity.User;

public class UserSession {
    private static User sessionUser;
    private static Job job;
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


    public static Job getJob() {
        return job;
    }

    public static void setJob(Job job) {
        UserSession.job = job;
    }
}
