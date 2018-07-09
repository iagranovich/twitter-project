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
        String sql="INSERT INTO messages (date, text, user_name) VALUES (?,?,?)";
        jdbcTemplate.update(sql, message.getDate(), message.getText(), message.getUsername());        
    }
    
    public void updateMessage(Message message){
        String sql = "UPDATE messages SET text=? WHERE id=?";
        jdbcTemplate.update(sql, message.getText(), message.getId());
    }
    
     public List<Message> finedAll(){
        String sql = "SELECT * FROM messages";
        return jdbcTemplate.query(sql, new MessageMapper());
    }
     
    public List <Message> getMessagesByUserId(int id){        
        String sql ="SELECT messages.id, messages.date, messages.text, messages.user_name " +
                    "FROM messages INNER JOIN users " +
                    "ON messages.user_name=users.username " +   
                    "WHERE users.id=?";
        return jdbcTemplate.query(sql, new MessageMapper(), id);
    }
    
    public Message getMessageById(int id){        
        String sql ="SELECT * FROM messages WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new MessageMapper(), id);
    }
}
