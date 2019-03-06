package com.biz.health01.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.health01.vo.KcalVO;

public interface KcalDao {

	@Select(health_Sql.FOOD_SELECTALL)
	public List<KcalVO> selectAll();
	
	@Select(health_Sql.FOOD_SELECTGROUPCATE)
	public List<KcalVO> selectGroupCate();
	
	@Select(health_Sql.FOOD_FINDBYID)
	public KcalVO findById(long id);
	
	@Select(health_Sql.FOOD_FINDBYNAME)
	public KcalVO findByName(String foodName);
	
	@Select(health_Sql.FOOD_FINDBYCATE_CODE)
	public List<KcalVO> findByCate_Code(String cate_code);

}
