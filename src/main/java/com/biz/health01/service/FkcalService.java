package com.biz.health01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.health01.model.KcalDao;
import com.biz.health01.vo.KcalVO;
import com.biz.health01.vo.UserVO;

@Service
public class FkcalService {
	
	@Autowired
	KcalDao kcalMapper;
	
	public List<KcalVO> food_SelectAll() {
		
		List<KcalVO> foodList = kcalMapper.selectAll();
		
		return foodList;
	}
	
	public List<KcalVO> food_selectGroupCate() {
		
		List<KcalVO> foodList = kcalMapper.selectGroupCate();
		
		return foodList;
	}
	
	public KcalVO food_FindById(long id) {
		
		KcalVO vo = kcalMapper.findById(id);
		
		return vo;
	}
	
	public KcalVO food_FindByName(String foodName) {
		
		KcalVO vo = kcalMapper.findByName(foodName);
		
		return vo;
	}
	
	public List<KcalVO> food_FindByCate_Code(String cate_code) {
		
		List<KcalVO> foodList = kcalMapper.findByCate_Code(cate_code);
		
		return foodList;
	}
	
	
	
	//	List<KcalVO>에는 user가 먹은거 선택한 그 목록 리스트
	public void viewList(List<KcalVO> kList) {
		for(KcalVO vo : kList) {
			System.out.println(vo);
		}
	}

	// user가 고른 음식 총 칼로리
	public int totalKcal(List<KcalVO> kList) {
		int SumKcal = 0;
		for(KcalVO vo : kList) {
			SumKcal += Float.valueOf(vo.getFoodkcal());
		}
		return SumKcal;
	}
	
	// user의 키를 넣어서 표준 체중 구하는 메서드
	public float standardweight(String stheight) {
		float fweight = (Float.valueOf(stheight) - 100) * 0.9f;
		
		return fweight;
	}
	
	// 위 메서드를 이용한 하루 권장 칼로리 구하는 메서드
	public float calcestandardKcal(UserVO vo) {
		float stweight = standardweight(vo.getHeight());
		
		float standardKcal = stweight * Float.valueOf(vo.getActivityindex());
		
		return standardKcal ;
	}
	
	// (음식칼로리 - 권장칼로리) 계산 메서드
	public String overKcal(UserVO vo, String totalKcal) {
		int SumKcal = Integer.valueOf(totalKcal);
		int standardKcal = Math.round(calcestandardKcal(vo));
		
		int overKcal = SumKcal - standardKcal;
		
		if(overKcal < 0) overKcal = 0;
		
		return "" + overKcal;
	}
	
}
