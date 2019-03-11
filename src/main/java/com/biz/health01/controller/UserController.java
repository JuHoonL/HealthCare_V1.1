package com.biz.health01.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.health01.service.UserService;
import com.biz.health01.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	UserService uS;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(@ModelAttribute UserVO vo, Model model, HttpSession session) {
		
		UserVO sVO = uS.user_FindByUserId(vo.getUserId());
		
		String retMsg = "";
		if(sVO == null) {
			retMsg = "false";
		} else {
			if(passwordEncoder.matches(vo.getPassword(),sVO.getPassword())) {
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
		
		String bcPassword = passwordEncoder.encode(vo.getPassword());
		
		vo.setPassword(bcPassword);
		
		uS.user_Insert(vo);
		
		return "redirect:home2";
	}
	
	@ResponseBody
	@RequestMapping(value="id_check", method=RequestMethod.POST, produces="text/html;charset=utf8")
	public String id_check(@RequestParam String userId) {
		String ret = "";
		
		UserVO vo = uS.user_FindByUserId(userId);
		
		if(vo == null) ret = "true";
		
		else ret = "false";
		
		return ret;
	}
	
	@RequestMapping(value="user_DB", method = RequestMethod.GET)
	public String user_DB(Model model, HttpSession session) {
		
		model.addAttribute("BODY","USERDB");
		
		UserVO vo = (UserVO)session.getAttribute("LOGIN");
		
		vo = uS.user_FindByUserId(vo.getUserId());
		
		model.addAttribute("USER",vo);
		
		return "home02";
	}
	
	@RequestMapping(value="user_update", method = RequestMethod.POST)
	public String user_update(@ModelAttribute UserVO vo, Model model, HttpSession session) {
		
		UserVO uservo = (UserVO)session.getAttribute("LOGIN");
		
		uservo = uS.user_FindByUserId(uservo.getUserId());
		
		vo.setPassword(uservo.getPassword());
		
		uS.user_Update(vo); 
		
		session.setAttribute("LOGIN",vo);
		
		return "redirect:home2";
	}
	
	@RequestMapping(value="user_delete", method = RequestMethod.POST)
	public String user_delete(HttpSession session, Model model) {
		
		UserVO uservo = (UserVO)session.getAttribute("LOGIN");
		
		uservo = uS.user_FindByUserId(uservo.getUserId());
		
		uS.user_Delete(""+uservo.getId());
		
		session.removeAttribute("LOGIN");
		
		return "redirect:home2";
	}
	
	@RequestMapping(value="confirm_pw", method=RequestMethod.GET)
	public String password_confirm(String PASSMSG, Model model, HttpSession session) {
		
		model.addAttribute("BODY","CHPASS");
		
		UserVO uservo = (UserVO)session.getAttribute("LOGIN");
		
		uservo = uS.user_FindByUserId(uservo.getUserId());
		
		model.addAttribute("USER",uservo);
		
		model.addAttribute("PASSMSG",PASSMSG);
		
		return "home02";
	}
	
	@RequestMapping(value="password_check", method=RequestMethod.POST)
	public String password_check(@ModelAttribute UserVO vo, Model model, HttpSession session) {
		
		UserVO uservo = uS.user_FindByUserId(vo.getUserId());
		
		if(passwordEncoder.matches(vo.getPassword(),uservo.getPassword())) {
			return "redirect:change_pw";
		} else {
			model.addAttribute("PASSMSG","false");
			return "redirect:confirm_pw";
		}
	}
	
	@RequestMapping(value="change_pw", method=RequestMethod.GET)
	public String password_change(Model model, HttpSession session) {
		
		model.addAttribute("BODY","CHPASS2");
		
		return "home02";
	}
	
	@RequestMapping(value="change_pw", method=RequestMethod.POST)
	public String password_change2(@ModelAttribute UserVO vo, Model model, HttpSession session) {
		
		UserVO uservo = (UserVO)session.getAttribute("LOGIN");
		
		uservo = uS.user_FindByUserId(uservo.getUserId());
		
		String bcPassword = passwordEncoder.encode(vo.getPassword());
		
		uservo.setPassword(bcPassword);
		
		uS.user_Update(uservo);
		
		return "redirect:/";
	}
	
}
