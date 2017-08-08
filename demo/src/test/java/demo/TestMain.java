package demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hj.dao.UserMapper;
import cn.hj.entity.User;


public class TestMain {
	private static ApplicationContext aContext;
	static {
		aContext = new ClassPathXmlApplicationContext("spring_mybatis.xml");
	}
	
	public static void main(String[] args) {
		
		UserMapper userMapper = (UserMapper) aContext.getBean("UserMapper");
		User user = userMapper.selectByPrimaryKey(1);
		System.out.println(user.toString());
		
	}

}
