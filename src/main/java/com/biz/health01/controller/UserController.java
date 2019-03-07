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
		
		System.out.println(sVO);
		
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
		
		if(vo == null) ret = "사용할 수 있는 ID 입니다";
		
		else ret = "이미 등록된 ID 입니다";
		
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
	
	
}
