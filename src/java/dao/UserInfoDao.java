/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author user129
 */
public class UserInfoDao {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public List<Integer> getListRetweetsByUserName(String name){
        String sql = "SELECT message_id FROM retweets WHERE user_name=?";
        return jdbcTemplate.queryForList(sql, Integer.class, name);
    }
    
    public List <Integer> getListLikesByUserName(String name){
        
        return null;
    }
    
}
