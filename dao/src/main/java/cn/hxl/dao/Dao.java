package cn.hxl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.hxl.entity.Sex;
import cn.hxl.entity.User;

/**
 * Dao接口
 * @author hp
 *
 */
public interface Dao {
	
	/**
	 * 获取全部用户信息
	 * @param name 根据姓名模糊查询
	 * @return
	 */
	List<User> getAllUserList(@Param("name")String name);
	
	/**
	 * 获取全部性别信息
	 * @return
	 */
	List<Sex> getAllSexList();
	
	/**
	 * 根据id获取用户信息
	 * @param id 用户id
	 * @return
	 */
	User getUser(@Param("id")Integer id);
	
	/**
	 * 添加用户 返回主键id
	 * @param user 前台新增用户信息
	 * @return
	 */
	int addUser(User user);
	
	/**
	 * 修改用户
	 * @param user 修改用户信息
	 * @return
	 */
	int upUser(User user);
	
	/**
	 * 删除用户
	 * @param ids 要删除的id  批量删除
	 * @return
	 */
	int delUser(List<Integer> ids);
	
	
	
}
