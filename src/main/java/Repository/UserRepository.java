package main.java.Repository;

import main.java.models.User;

public interface UserRepository {
    User saveUser(User user);

    User getUserByID(int userID);
}
