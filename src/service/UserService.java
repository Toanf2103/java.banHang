/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Dao.XuLy;
import java.sql.SQLException;
import java.util.List;
import model.User;

/**
 *
 * @author Toàn
 */
public class UserService {
    private XuLy userDao;

    public UserService() {
        userDao= new XuLy();
    }
    
    
    
    public List<User> getAllUser() throws SQLException{
        return userDao.getAllUser();
    }

   public void addUser(User user) throws SQLException{
       userDao.addUser(user);
   }
   public void deleteUser(int id) throws SQLException{
       userDao.deleteUser(id);
   }
   public User getUserById(int id) throws SQLException{
        
       return userDao.getUserById(id);
   }
   public int updateUser(User user) throws SQLException{
      return userDao.updateUser(user);
   }
}
