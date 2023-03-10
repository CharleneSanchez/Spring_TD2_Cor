package com.inti.SpringTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MainController {
	
	@GetMapping("hel")
	public String hello()
	{
		return "hello";
	}
	
	

}
