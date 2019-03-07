package com.biz.health01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.health01.model.KcalDao;

@Service
public class KcalService {
	

	@Autowired
	KcalDao kcalMapper;
	
	String[] active= {"3.8","7","8","2.5","10","8","7","7","8","4","11","7"};
	
	public List<String> Kcal(String Kg, String Kal) {
		int length = active.length;
		
		List<String> sportsList = new ArrayList<String>();
		
		for(int i = 0; i < length ; i ++) {
			float fActiver = Float.valueOf(active[i]);
			float intkg = (float)(Integer.valueOf(Kg)*3.5*fActiver)/200;
			
			float floatKal = Float.valueOf(Kal);
			
			int time = Math.round(floatKal/intkg);
			String s = "";
			
			switch(i) {
				case 0 : 
					String walk = "걷기운동은 " + time + "분이 필요합니다.";
					sportsList.add(walk);
					break;
				case 1 :
					String climb = "등산운동은 " + time + "분이 필요합니다.";
					sportsList.add(climb);
					break;
				case 2 :
					String cycle = "싸이클운동은 " + time + "분이 필요합니다.";
					sportsList.add(cycle);
					break;
				case 3 :
					String hulahoop = "훌라후프운동은 " + time + "분이 필요합니다.";
					sportsList.add(hulahoop);
					break;
					
				case 4 :
					String riding = "자전거운동은 " + time + "분이 필요합니다.";
					sportsList.add(riding);
					break;
				case 5 :
					String ropeskipping = "줄넘기운동은 " + time + "분이 필요합니다.";
					sportsList.add(ropeskipping);
					break;
				case 6 :
					String running = "달리기운동은 " + time + "분이 필요합니다.";
					sportsList.add(running);
					break;
				case 7 :
					String situp = "윗몸운동은 " + time + "분이 필요합니다.";
					sportsList.add(situp);
					break;
				case 8 :
					String squat = "스쿼트운동은 " + time + "분이 필요합니다.";
					sportsList.add(squat);
					break;
				case 9 :
					String Treadmill = "런닝머신운동은 " + time + "분이 필요합니다.";
					sportsList.add(Treadmill);
					break;
				case 10 :
					String yoga = "요가운동은 " + time + "분이 필요합니다.";
					sportsList.add(yoga);
					break;
				case 11 :
					String stair = "계단운동은 " + time + "분이 필요합니다.";
					sportsList.add(stair);
					break;
			}
		}
		return sportsList;
	}
	
	public String Kcal(String Kg, String Kal, String num) {
		int length = active.length;
		
		String sportsList = "";
		int n1 = Integer.valueOf(num);
		
			float fActiver = Float.valueOf(active[n1]);
			float intkg = (float)(Integer.valueOf(Kg)*3.5*fActiver)/200;
			
			float floatKal = Float.valueOf(Kal);
			
			int time = Math.round(floatKal/intkg);
			
			switch(n1) {
				case 0 : 
					sportsList = "걷기운동은 " + time + "분이 필요합니다.";
					return sportsList;
				case 1 :
					sportsList = "등산운동은 " + time + "분이 필요합니다.";
					return sportsList;
				case 2 :
					sportsList = "싸이클운동은 " + time + "분이 필요합니다.";
					return sportsList;
				case 3 :
					sportsList = "훌라후프운동은 " + time + "분이 필요합니다.";
					return sportsList;
				case 4 :
					sportsList = "자전거운동은 " + time + "분이 필요합니다.";
					return sportsList;
				case 5 :
					sportsList = "줄넘기운동은 " + time + "분이 필요합니다.";
					return sportsList;
				case 6 :
					sportsList = "달리기운동은 " + time + "분이 필요합니다.";
					return sportsList;
				case 7 :
					sportsList = "윗몸운동은 " + time + "분이 필요합니다.";
					return sportsList;
				case 8 :
					sportsList = "스쿼트운동은 " + time + "분이 필요합니다.";
					return sportsList;
				case 9 :
					sportsList = "런닝머신운동은 " + time + "분이 필요합니다.";
					return sportsList;
				case 10 :
					sportsList = "요가운동은 " + time + "분이 필요합니다.";
					return sportsList;
				case 11 :
					sportsList = "계단운동은 " + time + "분이 필요합니다.";
					return sportsList;
			
		}
		return sportsList;
	}

}
