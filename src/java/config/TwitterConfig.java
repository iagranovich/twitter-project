/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import controller.MainController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    
}
    

