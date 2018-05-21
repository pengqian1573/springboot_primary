package com.pq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestController 
{

    @RequestMapping("/hi")
    @ResponseBody
    public String home() {
    	
      return "Hello World!";
    }
    
    
}
