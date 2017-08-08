package demo;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.hj.entity.User;
import cn.hj.service.UserService;
import cn.hj.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring_mybatis.xml"}) 
public class TestDemo {
	
	private static Logger logger = Logger.getLogger(TestDemo.class); 
	@Resource
	private UserServiceImpl userService;
	
	@Test
	public void test1() {
		User user = userService.getUserById(2);
		System.err.println(user.toString());
	}
}
