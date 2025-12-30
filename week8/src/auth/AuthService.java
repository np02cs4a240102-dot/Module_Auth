package auth;

public class AuthService {

    private UserDAO userDAO;

    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // Authenticate user
    public boolean authenticate(String username, String password) {
        User user = userDAO.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    // Change password
    public boolean changePassword(int userId, String oldPassword, String newPassword) {
        User user = userDAO.findById(userId);
        if (user != null && user.getPassword().equals(oldPassword)) {
            return userDAO.updatePassword(userId, newPassword);
        }
        return false;
    }
}
