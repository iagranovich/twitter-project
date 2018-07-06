/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Message;
import java.util.List;
import mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author user129
 */
public class MessageDao {
    
    @Autowired
    JdbcTemplate jdbcTemplate; //why fianl??
    
    
    public void addMessage(Message message){
        String sql="INSERT INTO messages (date, text) VALUES (?,?)";
        jdbcTemplate.update(sql, message.getDate(), message.getText());
        
    }
    
     public List<Message> finedAll(){
        String sql = "SELECT * FROM messages";
        return jdbcTemplate.query(sql, new MessageMapper());
    }
}
