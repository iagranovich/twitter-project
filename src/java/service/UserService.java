/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author user129
 */
public class UserService {
    
    @Autowired
    UserDao userDao;
    
    public void newUser(User user){
        userDao.newUser(user);
    }

    public User findUser(String name) {
        return userDao.findUser(name);
    }
    
    public void updateUser(User user){
        userDao.updateUser(user);
    }
    
}
