/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PagnDao;
import entity.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user129
 */

@Service
public class PagnServiceImpl implements PagnService{
    
    @Autowired
    PagnDao pagnDao;
    
    @Override
    public List<Message> list(){        
        return pagnDao.list();
    }
    
    @Override
    public List<Message> getMessagesByUserId(int id){
        return pagnDao.getMessagesByUserId(id);
    }
    
}
