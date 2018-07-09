/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Message;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user129
 */

@Repository
public class PagnDaoImpl implements PagnDao{
        
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException{
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Message> list() {
        String sql = "SELECT id, date, text, user_name FROM messages";
        
        List<Message> list = namedParameterJdbcTemplate.query(sql, new MessageMapper());
        
        return list;
    }
    
    public List<Message> getMessagesByUserId(int id){
        String sql = "SELECT id, date, text, user_name FROM messages WHERE id=?";
        
        //List<Message> list = namedParameterJdbcTemplate.query(sql, new MessageMapper(), id);
        
        return null;
    }
    
    private static final class MessageMapper implements RowMapper<Message>{
        public Message mapRow(ResultSet rs, int rowNum) throws SQLException{
            Message message = new Message();
            message.setId(rs.getInt("id"));
            message.setDate(rs.getString("date"));
            message.setText(rs.getString("text"));
            message.setUsername(rs.getString("user_name"));
            
            return message;
        }
    }
    
}
