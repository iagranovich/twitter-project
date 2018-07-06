/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import controller.MainController;
import dao.MessageDao;
import dao.UserDao;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import service.MessageService;
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
        dataSource.setUrl("jdbc:mysql://localhost:3306/twitter_project");
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
            
}
    

