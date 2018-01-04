package com.mouri.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
     @Autowired
	private WelcomeService service;
	
	@RequestMapping("/WELCOME")
	public String welcome(){
		return service.retrivewelcomemessage();
	}
}
@Component
class WelcomeService{
	 public String retrivewelcomemessage(){
		  return "HAPPY NEW YEAR !!";
	 }
 }
