package cn.hj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.hj.dao.UserMapper;
import cn.hj.entity.User;
import cn.hj.service.UserService;
/**
 * 实现接口UserService
 * @author user
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	private final static String DELE_SUCCESS = "删除成功";
	private final static String DELE_FAIL = "删除失败";
	@Resource
	private UserMapper userMapper;

	/**
	 * 根据id获取用户信息
	 */
	public User getUserById(int id) {
		
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}
	
	/**
	 * 根据username和password进行登录
	 */
	public boolean userLogin(String username, String password) {
		User user = userMapper.findUserByUsername(username);
		if(user != null) {
			System.err.println(user.getUsername()+"---"+user.getPassword());
			System.err.println(username+"~~~~~"+password);
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 获取所有用户的信息
	 */
	public List<User> getAllUser() {
		List<User> list = userMapper.getAllUser();
		return list;
	}
	/**
	 * 根据id删除用户
	 */
	public String deleteUser(int id) {
		if(userMapper.deleteByPrimaryKey(id) == 1) {
			return "DELE_SUCCESS";
		}else {
			return "DELE_FAIL";
		}
		
	}
	/**
	 * 根据id更新信息
	 */
	public int updateByPrimaryKeySelective(User user) {
		int flag = 0;
		if(user != null) {
			flag = userMapper.updateByPrimaryKeySelective(user);
		}
		return flag;
	}

}
