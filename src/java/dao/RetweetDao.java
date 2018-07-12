/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Retweet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author user129
 */
public class RetweetDao {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public void addRetweet(Retweet retweet){
        String sql = "INSERT INTO retweets (user_name, message_id) VALUES (?,?)";
        jdbcTemplate.update(sql, retweet.getUsername(), retweet.getMessageid());
    }
    
    public List <Integer> getListRetweetsByUserName(String name){
        String sql = "SELECT message_id FROM retweets WHERE user_name=?";
        return jdbcTemplate.queryForList(sql, Integer.class, name);
    }
}
