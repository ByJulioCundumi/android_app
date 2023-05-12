package com.example.apppersonasucn.util;
import com.example.apppersonasucn.entity.User;
import java.util.*;

public class UserList {

    private static List<User> userList = new ArrayList<>();

    public static void addUser(User user) {
        userList.add(user);
    }

    public static int getUserCount(){
        if(userList.size() == 0){
            return 0;
        }else{
            return userList.size();
        }
    }

    public static double getAverageAge() {
        int totalAge = 0;
        for (User user : userList) {
            totalAge += user.getAge();
        }

        if (userList.size() > 0) {
            double averageAge = (double) totalAge / userList.size();
            return Math.round(averageAge * 10.0) / 10.0;
        } else {
            return 0;
        }
    }

    public static List<User> getUserList(){
        return userList;
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

    public static void updateUser(int index, User user){
        userList.set(index, user);
    }

    public static void deleteUser(User user) {
        userList.remove(user);
    }
}
