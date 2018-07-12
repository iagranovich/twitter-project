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
import org.springframework.security.access.prepost.PostAuthorize;

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
    
     public void updateMessage(Message message){          
        messageDao.updateMessage(message);
    }
        
    public List<Message> findAll(){
        return messageDao.finedAll();
    }
    
    public List <Message> getMessagesByUserId(int id){
        return messageDao.getMessagesByUserId(id);
    }
    
    //Можно редактировать только своё сообщение
   @PostAuthorize("returnObject.username == authentication.name")   
    public Message getMessageById(int id){
        return messageDao.getMessageById(id);
    }  
    
    public List <Message> getRetweetsByUserId(int id){
        return messageDao.getMessagesFromRetweetsByUserId(id);
    }
    
    public List <Message> getMessagesAndRetweetsByUserId(int id){
        return messageDao.getMessagesAndRetweetsByUserId(id);
    }
    
}
