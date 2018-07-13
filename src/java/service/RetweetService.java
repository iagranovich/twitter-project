/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.RetweetDao;
import entity.Retweet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author user129
 */
public class RetweetService {
    
    @Autowired
    RetweetDao retweetDao;
    
    
    public void addRetweet(Retweet retweet){
        retweetDao.addRetweet(retweet);
    }
    
    public List <Integer> getListRetweetsByUserName(String name){
        return retweetDao.getListRetweetsByUserName(name);
    }
}
