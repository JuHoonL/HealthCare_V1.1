package com.biz.health01.model;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.biz.health01.vo.UserVO;

public interface UserDao {

	@Select(health_Sql.USER_SELECTALL)
	public List<UserVO> selectAll();
	
	@Select(health_Sql.USER_FINDBYID)
	public UserVO findById(String id);
	
	@Select(health_Sql.USER_FINDBYUSERID)
	public UserVO findByUserId(String USERId);
	
	@Select(health_Sql.USER_FINDBYNAME)
	public UserVO findByName(String userName);
	
	@Insert(health_Sql.USER_INSERT)
	public int insert(UserVO vo);
	
	@Update(health_Sql.USER_UPDATE)
	public int update(UserVO vo);
	
	@Delete(health_Sql.USER_DELETE)
	public int delete(String id);
}
