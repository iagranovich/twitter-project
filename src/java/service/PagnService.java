/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Message;
import java.util.List;

/**
 *
 * @author user129
 */
public interface PagnService {
    
    public List<Message> list();
    
    public List<Message> getMessagesByUserId(int id);
    
}
