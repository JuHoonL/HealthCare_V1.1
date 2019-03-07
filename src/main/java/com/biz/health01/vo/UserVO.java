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
public class UserVO {

	private long id;
	private String userId;
	private String userName;
	private String password;
	private String re_password;
	private String birth;
	private String height;
	private String weight;
	private String activityindex;
}
	
	