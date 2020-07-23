package cn.hxl.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.hxl.entity.Sex;
import cn.hxl.entity.User;
import cn.hxl.service.Service;
import cn.hxl.utils.PrintUtil;
import cn.hxl.utils.ReturnResult;

@Controller
public class userController {
	
	@Autowired
	private Service service;
	
	/**
	 * 主页面
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/index.html")
	public String index(HttpServletRequest req,Model model) {
		String name = req.getParameter("name");
		if(name==null)name="";
		//获取全部用户
		List<User> userList = service.getAllUserList(name);
		//获取性别
		List<Sex> sexList = service.getAllSexList();
		//返回前端
		model.addAttribute("userList", userList);
		model.addAttribute("sexList", sexList);
		model.addAttribute("name", name);
		return "index";
	}
	
	
	/**
	 * 添加用户页面跳转
	 * @return
	 */
	@RequestMapping("/add")
	public String add() {
		return "insert";
	}
	
	
	/**
	 * 修改用户页面跳转
	 * @param ids
	 * @param model
	 * @return
	 */
	@RequestMapping("/up")
	public String up(@RequestParam("ids")Integer ids,Model model) {
		//标识修改
		model.addAttribute("show", "show");
		//根据id获取用户信息
		User user = service.getUser(ids);
		//返回前端
		model.addAttribute("user", user);
		return "insert";
	}
	
	
	
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping("/add.html")
	public void addUser(User user,HttpServletResponse resp) {
		ReturnResult rr = new ReturnResult();
		//新增
		if(service.addUser(user)) {
			rr.returnSuccess("添加成功");
		}else {
			rr.returnFail("添加失败!");
		}
		PrintUtil.getJsonString(resp, rr);
	}
	
	
	/**
	 * 修改用户
	 * @return
	 */
	@RequestMapping("/upUser.html")
	public void upUser(User user,HttpServletResponse resp) {
		ReturnResult rr = new ReturnResult();
		//修改
		if(service.upUser(user)) {
			rr.returnSuccess("修改成功");
		}else {
			rr.returnFail("修改失败!");
		}
		PrintUtil.getJsonString(resp, rr);
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	@RequestMapping("/delUser.html")
	public void delUser(@RequestParam("ids")Integer[] ids,HttpServletResponse resp) {
		ReturnResult rr = new ReturnResult();
		List<Integer> list = new ArrayList<Integer>();
		for(Integer i : ids) {
			list.add(i);
		}
		
		//删除
		if(service.delUser(list)) {
			rr.returnSuccess("删除成功");
		}else {
			rr.returnFail("删除失败!");
		}
		PrintUtil.getJsonString(resp, rr);
	}
	
	
	

}

