package cn.hxl.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hxl.dao.Dao;
import cn.hxl.entity.Sex;
import cn.hxl.entity.User;

/**
 * Service接口实现类
 * @author hp
 *
 */
@Service("ServiceImpl")
@Transactional
public class ServiceImpl implements cn.hxl.service.Service{
	
	/**
	 * Dao
	 */
	@Autowired
	private Dao dao;
	
	
	
	
	/**
	 * 获取全部用户信息
	 * @param name 根据姓名模糊查询
	 * @return
	 */
	@Override
	public List<User> getAllUserList(String name) {
		return this.dao.getAllUserList(name);
	}
	/**
	 * 获取全部性别信息
	 * @return
	 */
	@Override
	public List<Sex> getAllSexList() {
		return this.dao.getAllSexList();
	}
	/**
	 * 根据id获取用户信息
	 * @param id 用户id
	 * @return
	 */
	@Override
	public User getUser(Integer id) {
		return this.dao.getUser(id);
	}
	/**
	 * 添加用户 返回主键id
	 * @param user 前台新增用户信息
	 * @return
	 */
	@Override
	public Boolean addUser(User user) {
		if (this.dao.addUser(user) == 1)
			return true;
		return false;
	}
	/**
	 * 修改用户
	 * @param user 修改用户信息
	 * @return
	 */
	@Override
	public Boolean upUser(User user) {
		if (this.dao.upUser(user) == 1)
			return true;
		return false;
	}
	/**
	 * 删除用户
	 * @param ids 要删除的id  批量删除
	 * @return
	 */
	@Override
	public Boolean delUser(List<Integer> ids) {
		if (this.dao.delUser(ids) >0)
			return true;
		return false;
	}
	

}
