package auth;

public class Main {
    public static void main(String[] args) {

        // Initialize DAO and Service
        UserDAO userDAO = new UserDAO();
        AuthService authService = new AuthService(userDAO);

        // ===== Add Users =====
        User user1 = new User(1, "john", "1234");
        User user2 = new User(2, "alice", "abcd");
        userDAO.saveUser(user1);
        userDAO.saveUser(user2);

        System.out.println("Users added successfully.\n");

        // ===== Authenticate Users =====
        System.out.println("Authenticating users:");
        System.out.println("john with password 1234: " + authService.authenticate("john", "1234")); // true
        System.out.println("alice with password 123: " + authService.authenticate("alice", "123"));   // false
        System.out.println("alice with password abcd: " + authService.authenticate("alice", "abcd")); // true

        System.out.println("\n");

        // ===== Change Password =====
        System.out.println("Changing john's password from 1234 to 5678...");
        boolean changed = authService.changePassword(1, "1234", "5678");
        System.out.println("Password changed: " + changed);

        // ===== Authenticate Again =====
        System.out.println("\nAuthenticating john with new password 5678: " +
                authService.authenticate("john", "5678")); // true

        System.out.println("Authenticating john with old password 1234: " +
                authService.authenticate("john", "1234")); // false

        System.out.println("\nTest completed successfully.");
    }
}
