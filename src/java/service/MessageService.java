/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MessageDao;
import entity.Message;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author user129
 */
public class MessageService {
    
    @Autowired
    MessageDao messageDao;
    
    public void addMessage(Message message){        
        Date date = new Date();
        message.setDate(date.toString());
        messageDao.addMessage(message);
    }
    
    public List<Message> findAll(){
        return messageDao.finedAll();
    }
    
}
