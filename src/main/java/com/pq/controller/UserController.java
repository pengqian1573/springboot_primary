package com.pq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pq.model.User;
import com.pq.service.UserService;


@Controller
public class UserController 
{

	@Autowired
    UserService userService;
	
    @RequestMapping("/findUser1")
    @ResponseBody
    public Object findUser(@RequestParam String username) {
    	
      return userService.findByUserName(username);
    }
    
    
    @RequestMapping("/findUser2")
    @ResponseBody
    public Object findUser2(@RequestParam String username,@RequestParam String password) {
    	
      return userService.findByUsernameAndPassword(username, password);
    }
    
    @RequestMapping("/findUser3")
    @ResponseBody
    public Object findUser3(@RequestParam String idCard) {
    	
      return userService.findUserByIdcard(idCard);
    }
    
  
    
    @RequestMapping("/findUser4")
    @ResponseBody
    public Object findUser4(@RequestParam Integer page,@RequestParam Integer size) {
    	
      return userService.findAll(page, size);
    }
    
    
    @RequestMapping("/saveUser")
    @ResponseBody
    public Object saveUser(@ModelAttribute User user) {
    	
      return userService.save(user);
    }
}
