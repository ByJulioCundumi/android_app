package com.example.apppersonasucn.util;
import com.example.apppersonasucn.entity.User;
import java.util.*;

public class UserList {

    public static List<User> userList = new ArrayList<>();

    public static void addUser(User user) {
        userList.add(user);
    }

    public static User getUserByEmail(String email) {
        for (User user : userList) {
            if (user.getEmail() == email) {
                return user;
            }
        }
        return null;
    }

    public static void updateUser(User user) {
        int index = userList.indexOf(user);
        if (index != -1) {
            userList.set(index, user);
        }
    }

    public static void deleteUser(User user) {
        userList.remove(user);
    }
}
