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
    public List<User> getAllUser() throws SQLException{
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
         connect.close();
       
       
        return users;
    }
    
    public void addUser(User user) throws SQLException{
        Connection connect = Connect.getJDBCConection();
        String sql=" INSERT INTO user( name, phoneNumber, userName, password, role, favorite, about)"
                + " VALUE(?,?,?,?,?,?,?) ";
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPass());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getFavorite());
            preparedStatement.setString(7, user.getAbout());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(XuLy.class.getName()).log(Level.SEVERE, null, ex);
        }
         connect.close();
    }
    
    public int updateUser(User user) throws SQLException{
        Connection connect = Connect.getJDBCConection();
        String sql = " UPDATE user SET name=?,phoneNumber=?, userName=?, password=?, role=?, "
                + "favorite=?, about=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPhone());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4,user.getPass());
            preparedStatement.setString(5,user.getRole());
            preparedStatement.setString(6,user.getFavorite());
            preparedStatement.setString(7,user.getAbout());
            preparedStatement.setInt(8,user.getId());
            
            int rs =preparedStatement.executeUpdate();
            System.out.println(rs);
             connect.close();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(XuLy.class.getName()).log(Level.SEVERE, null, ex);
             connect.close();
            return 0;
        }
        
    }
    
    public void deleteUser(int id) throws SQLException{
        Connection connect = Connect.getJDBCConection();
        String sql="delete from User where id =?";
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int rs=preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(XuLy.class.getName()).log(Level.SEVERE, null, ex);
        }
         connect.close();
    }
    public User getUserById(int id) throws SQLException {
        User user =new User();
        Connection connect = Connect.getJDBCConection();
        String sql ="SELECT * FROM user WHERE id=?";
       
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phoneNumber"));
                user.setUsername(rs.getString("userName"));
                user.setPass(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setFavorite(rs.getString("favorite"));
                user.setAbout(rs.getString("about"));
                       
            }
            connect.close();
            return user; 
            
        
         
    }
}
