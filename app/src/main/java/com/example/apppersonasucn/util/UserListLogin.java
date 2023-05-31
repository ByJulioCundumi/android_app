package com.example.apppersonasucn.util;

import com.example.apppersonasucn.entity.User;
import com.example.apppersonasucn.entity.UserLogin;

import java.util.ArrayList;
import java.util.List;

public class UserListLogin {
    private static List<UserLogin> userListLogin = new ArrayList<>();
    public static void addUser(UserLogin user) {
        userListLogin.add(user);
    }

    public static boolean validateUserLogin(UserLogin user) {
        for (UserLogin item : userListLogin) {
            if (item.getEmail().equals(user.getEmail()) && item.getPassword().equals(user.getPassword())) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
