package com.biz.health01.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KcalVO {

	private long id;
	private String cate;
	private String cate_code;
	private String foodName;
	private String oneofsupply;
	private String foodkcal;
		
}
