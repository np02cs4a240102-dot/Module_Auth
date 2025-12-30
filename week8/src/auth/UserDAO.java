package auth;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {

    // Simulating a database with a HashMap
    private Map<Integer, User> userDB = new HashMap<>();

    // Save user
    public boolean saveUser(User user) {
        userDB.put(user.getUserId(), user);
        return true;
    }

    // Find user by username
    public User findByUsername(String username) {
        for (User user : userDB.values()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    // Find user by ID
    public User findById(int userId) {
        return userDB.get(userId);
    }

    // Update password
    public boolean updatePassword(int userId, String newPassword) {
        User user = userDB.get(userId);
        if (user != null) {
            user.setPassword(newPassword);
            return true;
        }
        return false;
    }

    // Delete user
    public boolean deleteUser(int userId) {
        return userDB.remove(userId) != null;
    }
}
