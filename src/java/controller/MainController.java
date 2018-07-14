/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Message;
import entity.Retweet;
import entity.User;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import service.RetweetService;
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
    
    @Autowired
    RetweetService retweetService;
    
        
    @RequestMapping({"/","/index"})
    public String index(Model model){
        
        //для определения сообщений, которые текущий пользователь УЖЕ ретвитнул
        String name = SecurityContextHolder.getContext().getAuthentication().getName();        
        model.addAttribute("retweets", retweetService.getListRetweetsByUserName(name));

        model.addAttribute("message", new Message());
        model.addAttribute("list", messageService.findAll());        
        //model.addAttribute("list", pagnService.list());
        
        return "message";
    }    
    
    @RequestMapping(method=RequestMethod.POST, value="/message/new")
    public String addMessage(@Valid @ModelAttribute("message") Message message, 
            BindingResult bindingResult, Model model){       
        
        String name = SecurityContextHolder.getContext().getAuthentication().getName();        
        model.addAttribute("retweets", retweetService.getListRetweetsByUserName(name));
        model.addAttribute("list", messageService.findAll());
        //model.addAttribute("list", pagnService.list());    
        
        if(bindingResult.hasErrors()){
            return "message";
        }  
        
        messageService.addMessage(message);         
        return "redirect:/index";
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
        
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        
        model.addAttribute("retweets", retweetService.getListRetweetsByUserName(name));
        model.addAttribute("message", new Message());
        model.addAttribute("list", messageService.getMessagesAndRetweetsByUserId(id));        
        //model.addAttribute("list", messageService.getMessagesByUserId(id));
        //model.addAttribute("list", pagnService.getMessagesByUserId(id));
        
        return "message";        
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/message/edit/{id}")
    public String openMessage(@PathVariable("id") int id, Model model){
        model.addAttribute("message", messageService.getMessageById(id));
        //model.addAttribute("list", messageService.findAll());
        //model.addAttribute("list", pagnService.list());
        
        return "edit";
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method=RequestMethod.POST, value="message/edit")
    public String editMessage(@Valid @ModelAttribute("message") Message message, BindingResult bindingResult, Model model){       
        
        //model.addAttribute("list", messageService.findAll()); 
        //model.addAttribute("list", pagnService.list());
        
        if(bindingResult.hasErrors()){
            return "edit";
        }  
        
        messageService.updateMessage(message);         
        return "redirect:/index";
    }
    
    @RequestMapping("/message/retweet/{id}")
    public String addRetweetByMessageId(@PathVariable int id){
        
        Retweet retweet = new Retweet();
        retweet.setMessageid(id);       
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        retweet.setUsername(name);
        
        retweetService.addRetweet(retweet);
        
        return "redirect:/index";
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/profile")
    public String profile(Model model){
        
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user", userService.findUser(name));
        
        return "profile";
    }
        
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method=RequestMethod.POST, value="/profile")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){       
        
        if(bindingResult.hasErrors()){
            return "profile";
        } 
        
        userService.updateUser(user);         
        return "redirect:/profile";
    }
    
    @RequestMapping("/message/{id}")
    public String profile(@PathVariable int id, Model model){
                
        model.addAttribute("parentMessage", messageService.getMessageById(id));
        model.addAttribute("message", new Message()); //new message for reply
        model.addAttribute("list", messageService.getRepliesByMessgeId(id));
        
        return "reply";
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
