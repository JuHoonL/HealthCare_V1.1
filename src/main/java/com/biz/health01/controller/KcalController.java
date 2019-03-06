package com.biz.health01.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.health01.service.FkcalService;
import com.biz.health01.service.KcalService;
import com.biz.health01.service.UserService;
import com.biz.health01.vo.KcalVO;
import com.biz.health01.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class KcalController {

	@Autowired
	FkcalService fkS;
	@Autowired
	KcalService kS;
	@Autowired
	UserService uS;
	
	
	
	@RequestMapping(value="food_select", method=RequestMethod.GET)
	public String food_select(Model model) {
		
		model.addAttribute("BODY","FOOD");
		
		List<KcalVO> foodList = fkS.food_selectGroupCate();
		
		model.addAttribute("ALLFOODCATE",foodList);
	
		return "home02";
	}
	
	@RequestMapping(value="food_select_ajax", method=RequestMethod.POST,  produces="text/plan;charset=utf8")
	public String food_select01(@RequestParam(value="cate_code", required=false) String cate_code, Model model) {
		List<KcalVO> foodcateList = new ArrayList<KcalVO>();
		
		log.debug(cate_code);
		
		foodcateList = fkS.food_FindByCate_Code(cate_code);
		
		model.addAttribute("CATEFOOD",foodcateList);
		
		return "include/food_selectHome3";
	}
	
	@ResponseBody
	@RequestMapping(value="user_select_food1", method=RequestMethod.POST,  produces="application/json;charset=utf8")
	public List<KcalVO> user_select_food1(@RequestParam List<String> foodList) {
		
		List<KcalVO> foodselectList = new ArrayList<KcalVO>();
		
		for(String vo : foodList) {
			log.debug(vo.toString());
		}
		
		if(foodList != null) {
			for(String vo : foodList) {
				long id = Long.valueOf(vo);
				KcalVO kvo = fkS.food_FindById(id);
				foodselectList.add(kvo);
			}
		}
		
		return foodselectList;		
	}
	
	@ResponseBody
	@RequestMapping(value="user_select_food", method=RequestMethod.POST,  produces="application/json;charset=utf8")
	public KcalVO user_select_food(@RequestParam String code) {
		
		long id = Long.valueOf(code);
		KcalVO kvo = fkS.food_FindById(id);
		
		return kvo;		
	}
	
	@RequestMapping(value="sports", method=RequestMethod.GET)
	public String sports(@RequestParam String totalKcal, Model model, HttpSession session) {
		
	//	UserVO uVO = uS.user_FindByUserId(session.getAttribute(userId));
	//	String Kal = foodselect에서 합해진 총 음식 칼로리 TOTALKCAL값 받아온거
		
		model.addAttribute("BODY","SPORTS");
		
		UserVO vo = (UserVO) session.getAttribute("LOGIN");
		
		vo = uS.user_FindByUserId(vo.getUserId());
		String Kg = vo.getWeight();
		String Kal = totalKcal;
		
		int standardKcal = Math.round(fkS.calcestandardKcal(vo));
		
		String Kcal = fkS.overKcal(vo, Kal);
		
		List<String> spoList = kS.Kcal(Kg, Kcal);
		
		for(String s : spoList) {
			System.out.println(s);
		}
		
		model.addAttribute("STANDKCAL",standardKcal);
		model.addAttribute("TOTALKCAL",totalKcal);
		model.addAttribute("WEIGHT",Kg);
		model.addAttribute("OVERKCAL",Kcal);
		model.addAttribute("SLIST",spoList);
		
		return "home02";
	}
	
	@ResponseBody
	@RequestMapping(value="sports_AJAX", method=RequestMethod.POST, produces="text/plan;charset=utf8")
	public String sports(@RequestParam String kG, @RequestParam String kCAL, @RequestParam String num, Model model) {
		
		String msg = kS.Kcal(kG, kCAL, num);
		
		return msg;
	}
}
