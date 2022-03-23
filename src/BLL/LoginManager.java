package BLL;

import BE.User;
import DLL.UserDAO;

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
        User user = userDAO.GetUserByUsername(username);
        if (user == null || !user.getPassword().equals(password)) return false;

        loggedInUser = user;
        return true;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}
