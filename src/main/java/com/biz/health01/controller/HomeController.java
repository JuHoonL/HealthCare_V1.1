package com.biz.health01.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		model.addAttribute("BODY","MAIN");
		return "home02";
	}
	
	@RequestMapping(value = "home2", method = RequestMethod.GET)
	public String home02(Model model, String MSG) {
		
		model.addAttribute("BODY","MAIN");
		model.addAttribute("MSG",MSG);
		
		return "home02";
	}
	
}
