/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Dao.XuLy;
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

   
    
}
