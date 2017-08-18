package com.permission.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloCtrl {
	
	@RequestMapping("/list")
	public String list(){
		return "list" ;
	}
	
	
	@RequestMapping("/edit")
	public String edit(){
		return "edit" ;
	}
}
