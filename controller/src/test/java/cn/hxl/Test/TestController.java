package cn.hxl.Test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hxl.entity.Sex;
import cn.hxl.entity.User;
import cn.hxl.service.Service;


public class TestController {
	
	static ApplicationContext context = null;
	static Service service = null;
	
	public static void main(String[] args) {
		context =  new ClassPathXmlApplicationContext("ApplicationContext.xml");
		service = (Service) context.getBean("ServiceImpl");
		System.out.println("启动");
		//根据id查询用户
		System.out.println(service.getUser(1).getName());
		//获取所有性别
		List<Sex> sex = service.getAllSexList();
		//查询所有用户
		//name 姓名模糊查询
		String name = ""; 
		for(User u : service.getAllUserList(name)) {
			System.out.print("姓名:"+u.getName()+"\t");
			for(Sex s : sex) {
				if(u.getSex()==s.getId()) {
					System.out.println("性别:\t"+s.getName());
				}
			}
		}
		
		
		
	}
}
