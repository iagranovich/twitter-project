/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserInfoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author user129
 */
public class UserInfoService {
    
    @Autowired
    UserInfoDao userInfoDao;
    
    public List <Integer> getListRetweetsByUserName(String name){
        return userInfoDao.getListRetweetsByUserName(name);
    }
    
    public List <Integer> getListLikesByUserName(String name){
        
        return null;
    }
    
}
