/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import controller.MainController;
import dao.MessageDao;
import dao.RetweetDao;
import dao.UserDao;
import dao.UserInfoDao;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import service.MessageService;
import service.RetweetService;
import service.UserInfoService;
import service.UserService;

/**
 *
 * @author user129
 */

@Configuration
public class TwitterConfig {     
    
    @Bean
    public MainController mainController(){
        return new MainController();
    }
    
     @Bean    
    public JdbcTemplate jdbcTemplate(){        
        return new JdbcTemplate(dataSource());
    }
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/twitter_project?useUnicode=yes&characterEncoding=UTF-8");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
    
    @Bean
    public MessageService messageService(){
        return new MessageService();
    }
    
    @Bean
    public MessageDao mesageDao(){
        return new MessageDao();
    }
    
    @Bean
    public UserService userService(){
        return new UserService();
    }
    
    @Bean
    public UserDao userDao(){
        return new UserDao();
    }
    
    @Bean
    public RetweetDao retweetDao(){
        return new RetweetDao();
    }
    
    @Bean
    public RetweetService retweetService(){
        return new RetweetService();
    }   
    
    @Bean
    public UserInfoService userInfoService(){
        return new UserInfoService();
    }
    
    @Bean
    public UserInfoDao userInfoDao(){
        return new UserInfoDao();
    }
            
}
    

