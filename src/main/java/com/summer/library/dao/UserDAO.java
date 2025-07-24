package com.summer.library.dao;

import com.summer.library.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    public boolean  insertUser(User user){
        try {
            Connection conn = DatabaseConnection.connect();
            String query = "INSERT INTO user (name, userName, contact) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setInt(3, user.getContact());
            if (ps.executeUpdate() > 0){
                return true;
            }
            else {
                return false;
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<User> getUser(){
        ArrayList<User> userList = new ArrayList<>();
        try{
            Connection conn = com.summer.library.dao.DatabaseConnection.connect();
            String query = "SELECT userID, name, userName, contact FROM user";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet userSet = ps.executeQuery();  //
            while(userSet.next()){
                User user = new User(
                        userSet.getInt("userID"),
                        userSet.getString("name"),
                        userSet.getString("userName"),
                        userSet.getInt("contact"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateUserDetail(int userID, int contact) {
        try {
            Connection conn = com.summer.library.dao.DatabaseConnection.connect();
            String query = "UPDATE user SET contact = ? WHERE userID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, contact);
            ps.setInt(2, userID);
            if(ps.executeUpdate() > 0){
                System.out.println("user updated");
            }else{
                System.out.println("Failed to update");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean deleteUserDetail(int userid){
        try {
            Connection conn = com.summer.library.dao.DatabaseConnection.connect();
            String query = "DELETE FROM user WHERE userID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,userid);
            if(ps.executeUpdate() > 0){
                System.out.println("User deleted");
                return true;
            }else{
                System.out.println("Failed to delete");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public User getUserInfo(int userID){
        User user = null;
        try{
            Connection conn = com.summer.library.dao.DatabaseConnection.connect();
            String query = "SELECT * FROM user WHERE userID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            ResultSet userSet = ps.executeQuery();
            while (userSet.next()){
                user = new User(
                        userSet.getInt("userID"),
                        userSet.getString("name"),
                        userSet.getString("username"),
                        userSet.getInt("contact"));

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
