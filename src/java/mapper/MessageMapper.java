/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import entity.Message;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author user129
 */
public class MessageMapper implements RowMapper<Message>{

    @Override
    public Message mapRow(ResultSet rs, int i) throws SQLException {
        Message message = new Message();
        message.setId(rs.getInt("id"));
        message.setDate(rs.getString("date"));
        message.setText(rs.getString("text"));
        return message;
    }
    
}
