package Domain;

import Entity.Job;
import Entity.User;

public class UserSession {
    private static User sessionUser;
    private static Job selectedJob;
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

    public static Job getSelectedJob() {
        return selectedJob;
    }

    public static void setSelectedJob(Job selectedJob) {
        UserSession.selectedJob = selectedJob;
    }
}
