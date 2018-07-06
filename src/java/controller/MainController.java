/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Message;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.MessageService;
import service.UserService;

/**
 *
 * @author user129
 */

@Controller
public class MainController {
    
    @Autowired
    MessageService messageService;
    
    @Autowired
    UserService userService;
    
    @RequestMapping({"/","/index"})
    public String index(Model model){
        model.addAttribute("message", model);
        model.addAttribute("messages", messageService.findAll());
        return "index";
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/index")
    public String addMessage(@ModelAttribute("message") Message message){       
        messageService.addMessage(message);         
        return "redirect:/index.htm";
    }
    
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    
    @RequestMapping("/signup")
    public String signup(Model model){
        model.addAttribute("newUser", model);
        return "signup";
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/signup")
    public String newUser(@ModelAttribute("newUser") User user){       
        userService.newUser(user);         
        return "redirect:/login";
    }
}
