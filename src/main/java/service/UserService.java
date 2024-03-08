package main.java.service;


import main.java.Repository.UserDAO;
import main.java.models.User;

public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User createUser(String username, String email, String password) {
        // Implement user creation logic, validate inputs, and save to the database
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setReputation(0);
        return userDAO.saveUser(user);
    }

    public User getUser(int userId) {
        return userDAO.getUserByID(userId);
    }

}