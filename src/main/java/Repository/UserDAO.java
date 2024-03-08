package main.java.Repository;

import main.java.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAO implements UserRepository {
    Map<Integer, User> userList = new HashMap<>();
    private int userCounter;

    public UserDAO() {
    }

    @Override
    public User saveUser(User user) {
        user.setUserID(userCounter++);
        userList.put(user.getUserID(), user);
        return user;
    }

    @Override
    public User getUserByID(int userID) {
        if (userList.containsKey(userID)) {
            return userList.get(userID);
        }
        return null;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserDAO)) return false;
        final UserDAO other = (UserDAO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$userList = this.getUserList();
        final Object other$userList = other.getUserList();
        if (this$userList == null ? other$userList != null : !this$userList.equals(other$userList)) return false;
        if (this.getUserCounter() != other.getUserCounter()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserDAO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $userList = this.getUserList();
        result = result * PRIME + ($userList == null ? 43 : $userList.hashCode());
        result = result * PRIME + this.getUserCounter();
        return result;
    }

    public String toString() {
        return "UserDAO(userList=" + this.getUserList() + ", userCounter=" + this.getUserCounter() + ")";
    }

    public Map<Integer, User> getUserList() {
        return this.userList;
    }

    public int getUserCounter() {
        return this.userCounter;
    }

    public void setUserList(Map<Integer, User> userList) {
        this.userList = userList;
    }

    public void setUserCounter(int userCounter) {
        this.userCounter = userCounter;
    }
}