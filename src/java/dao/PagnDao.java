/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Message;
import java.util.List;

/**
 *
 * @author user129
 */
public interface PagnDao {
    
    public List<Message> list();
    
    public List<Message> getMessagesByUserId(int id);
    
}