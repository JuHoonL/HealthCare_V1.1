package com.biz.health01.model;

public class health_Sql {

	public static final String USER_SELECTALL 
	= " SELECT * FROM tbl_user ";
	
	public static final String USER_FINDBYID
	= " SELECT * FROM tbl_user WHERE id = #{id} ";
	
	public static final String USER_FINDBYUSERID
	= " SELECT * FROM tbl_user WHERE userId = #{userId} ";
	
	public static final String USER_FINDBYNAME
	= " SELECT * FROM tbl_user WHERE userName = #{userName} ";
	
	public static final String USER_INSERT
	= " INSERT INTO tbl_user(id, userId, userName, password, birth, height, weight, activityindex) "
			+ " VALUES(SEQ_USER.NEXTVAL, #{userId}, #{userName}, #{password}, #{birth}, #{height}, #{weight}, #{activityindex}) ";
	
	public static final String USER_UPDATE
	= " UPDATE tbl_user SET userId=#{userId}, userName=#{userName}, password=#{password}, "
			+ " birth=#{birth}, height=#{height}, weight=#{weight}, activityindex=#{activityindex} "
			+ " WHERE id = #{id} ";
	
	public static final String USER_DELETE
	= " DELETE FROM tbl_user WHERE id = #{id} ";

	

	public static final String FOOD_SELECTALL 
	= " SELECT * FROM tbl_kcal ";
	
	public static final String FOOD_SELECTGROUPCATE
	= " SELECT cate, cate_code FROM tbl_kcal GROUP BY cate, cate_code ";
	
	public static final String FOOD_FINDBYID
	= " SELECT * FROM tbl_kcal WHERE id = #{id} ";
	
	public static final String FOOD_FINDBYNAME
	= " SELECT * FROM tbl_kcal WHERE foodName = #{foodName} ";
	
	public static final String FOOD_FINDBYCATE_CODE
	= " SELECT * FROM tbl_kcal WHERE cate_code = #{cate_code} ";
			
}
