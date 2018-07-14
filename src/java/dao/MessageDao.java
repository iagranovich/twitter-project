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
    JdbcTemplate jdbcTemplate;
    
    
    public void addMessage(Message message){
        String sql="INSERT INTO messages (date, text, user_name, reply_id) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, message.getDate(), message.getText(), message.getUsername(), message.getReplyid());        
    }
    
    public void updateMessage(Message message){
        String sql = "UPDATE messages SET text=? WHERE id=?";
        jdbcTemplate.update(sql, message.getText(), message.getId());
    }
    
     public List<Message> finedAll(){
        String sql = "SELECT m.id, m.date, m.text, m.user_name, u.nickname "
                   + "FROM messages AS m, users AS u "
                   + "WHERE m.user_name=u.username";
        return jdbcTemplate.query(sql, new MessageMapper());
    }
     
    public List <Message> getMessagesByUserId(int id){        
        String sql ="SELECT m.id, m.date, m.text, m.user_name, u.nickname " +
                    "FROM messages AS m, users AS u " +
                    "WHERE m.user_name=u.username AND u.id=?";
        return jdbcTemplate.query(sql, new MessageMapper(), id);
    }
    
    public Message getMessageById(int id){        
        String sql ="SELECT m.id, m.date, m.text, m.user_name, u.nickname "
                  + "FROM messages AS m, users AS u "
                  + "WHERE m.user_name=u.username AND m.id=?";
        return jdbcTemplate.queryForObject(sql, new MessageMapper(), id);
    }
    
    public List <Message> getMessagesFromRetweetsByUserId(int id){
        String sql = "SELECT m.id, m.date, m.text, m.user_name, u.nickname " +
                     "FROM messages AS m, retweets AS r, users AS u " +                     
                     "WHERE m.id=r.message_id AND r.user_name=u.username AND u.id=?";        
        return jdbcTemplate.query(sql, new MessageMapper(), id);
    } 
    
    public List <Message> getRepliesByMessageId(int id){
        String sql = "SELECT m.id, m.date, m.text, m.user_name, u.nickname "
                   + "FROM messages AS m, users AS u "
                   + "WHERE m.user_name=u.username AND m.reply_id=?";
        return jdbcTemplate.query(sql, new MessageMapper(), id);
    }
    
}
