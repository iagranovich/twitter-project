/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Message;
import entity.User;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.MessageService;
import service.PagnService;
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
        model.addAttribute("message", new Message());
        //model.addAttribute("messages", messageService.findAll());        
        model.addAttribute("list", pagnService.list());
        
        return "message";
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/index")
    public String addMessage(@Valid @ModelAttribute("message") Message message, BindingResult bindingResult, Model model){       
        
        //model.addAttribute("messages", messageService.findAll());
        model.addAttribute("list", pagnService.list());    
        
        if(bindingResult.hasErrors()){
            return "message";
        }  
        
        messageService.addMessage(message);         
        return "redirect:/message";
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
    
    @RequestMapping("/user/{id}")
    public String userPage(@PathVariable("id") int id, Model model){
        model.addAttribute("message", new Message());
        model.addAttribute("list", messageService.getMessagesByUserId(id));
        //model.addAttribute("list", pagnService.getMessagesByUserId(id));
        
        return "message";        
    }
    
    @RequestMapping("/message/edit/{id}")
    public String openMessage(@PathVariable("id") int id, Model model){
        model.addAttribute("message", messageService.getMessageById(id));
        //model.addAttribute("messages", messageService.findAll());
        model.addAttribute("list", pagnService.list());
        return "edit";
    }
    
    @RequestMapping(method=RequestMethod.POST, value="message/edit")
    public String editMessage(@Valid @ModelAttribute("message") Message message, BindingResult bindingResult, Model model){       
        
        //model.addAttribute("messages", messageService.findAll()); 
        model.addAttribute("list", pagnService.list());
        
        if(bindingResult.hasErrors()){
            return "edit";
        }  
        
        messageService.updateMessage(message);         
        return "redirect:/index";
    }
    
    //Pagination
    @Autowired
    PagnService pagnService;    
    
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("list");
        model.addObject("list", pagnService.list());       
        
        return model;
    }
    
}
