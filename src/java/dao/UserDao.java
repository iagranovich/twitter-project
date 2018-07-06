/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author user129
 */
public class UserDao {
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public void newUser(User user){
        String sql_user = "INSERT INTO users (username, password, enabled) VALUES (?,?,'true')";
        jdbcTemplate.update(sql_user, user.getUsername(), user.getPassword());
        
        String sql_role = "INSERT INTO authorities (username, authority) VALUES (?, 'User')";
        jdbcTemplate.update(sql_role, user.getUsername());
    }
    
}
