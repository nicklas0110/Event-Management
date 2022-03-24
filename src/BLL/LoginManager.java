package BLL;

import BE.User;
import DAL.UserDAO;

import java.io.IOException;

public class LoginManager {

    private static LoginManager instance;
    private User loggedInUser = null;


    private UserDAO userDAO;

    private LoginManager() throws IOException {
        userDAO = new UserDAO();
    }

    public static LoginManager getLoginManager() throws IOException {
        if (instance == null) {
            instance = new LoginManager();
        }

        return instance;
    }

    public boolean login(String username, String password) {
        User user = userDAO.GetUserByUsername(username, password);
        if (user == null ) return false;

        loggedInUser = user;
        return true;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}
