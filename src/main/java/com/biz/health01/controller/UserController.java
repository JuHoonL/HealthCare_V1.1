package com.biz.health01.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.health01.service.UserService;
import com.biz.health01.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	UserService uS;
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(@ModelAttribute UserVO vo, Model model, HttpSession session) {
		
		UserVO sVO = uS.user_FindByUserId(vo.getUserId());
		
		System.out.println(sVO);
		
		String retMsg = "";
		if(sVO == null) {
			retMsg = "false";
		} else {
			if(sVO.getPassword().equals(vo.getPassword())) {
				retMsg = "true";
				session.setAttribute("LOGIN",sVO);
			} else {
				retMsg = "false";
			}
		}
		
		model.addAttribute("MSG",retMsg);
		
		return "redirect:home2";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("LOGIN");
		
		return "redirect:home2";
	}
	
	@RequestMapping(value = "user_join", method = RequestMethod.GET)
	public String user_join() {
		
		return "user_join";
	}
	
	@RequestMapping(value="user_join", method = RequestMethod.POST)
	public String user_join(@ModelAttribute UserVO vo, Model model) {
		
		uS.user_Insert(vo);
		
		return "redirect:home2";
	}
	
	@RequestMapping(value="user_DB", method = RequestMethod.GET)
	public String user_DB(@ModelAttribute UserVO vo, Model model) {
		
		
		
		return "user_DB";
	}
}
