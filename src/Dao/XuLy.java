/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author Toàn
 */
public class XuLy {
    public List<User> getAllUser(){
        List<User> users = new ArrayList<User>();
        Connection connect = Connect.getJDBCConection();
        String sql ="SELECT * FROM user";
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                User user =new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phoneNumber"));
                user.setUsername(rs.getString("userName"));
                user.setPass(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setFavorite(rs.getString("favorite"));
                user.setAbout(rs.getString("about"));
                
                users.add(user);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(XuLy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
}
