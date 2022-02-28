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
    
    
    
    public List<User> getAllUser(){
        return userDao.getAllUser();
    }

   public void addUser(User user){
       userDao.addUser(user);
   }
   public void deleteUser(int id){
       userDao.deleteUser(id);
   }
   public User getUserById(int id) throws SQLException{
        
       return userDao.getUserById(id);
   }
   public int updateUser(User user){
      return userDao.updateUser(user);
   }
}
