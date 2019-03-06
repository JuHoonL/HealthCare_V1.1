package com.biz.health01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.health01.model.UserDao;
import com.biz.health01.vo.UserVO;

@Service
public class UserService {

	@Autowired
	UserDao userMapper;
	
	public List<UserVO> user_SelectAll() {
		
		List<UserVO> userList = userMapper.selectAll();
		
		return userList;
	}
	
	public UserVO user_FindById(String id) {
		
		UserVO vo = userMapper.findById(id);
		
		return vo;
	}
	
	public UserVO user_FindByUserId(String userId) {
		
		UserVO vo = userMapper.findByUserId(userId);
		
		return vo;
	}
	
	public UserVO user_FindByName(String userName) {
		
		UserVO vo = userMapper.findByName(userName);
		
		return vo;
	}
	
	public int user_Insert(UserVO vo) {
		
		int ret = userMapper.insert(vo);
		
		return ret;
	}
	
	public int user_Update(UserVO vo) {
		
		int ret = userMapper.update(vo);
		
		return ret;
	}
	
	public int user_Delete(String id) {
		
		int ret = userMapper.delete(id);
		
		return ret;
	}
}
