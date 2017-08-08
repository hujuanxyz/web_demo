package cn.hj.service;

import java.util.List;
import cn.hj.entity.User;

public interface UserService {
	/**
	 * 验证用户登录
	 * @param user
	 * @return
	 */
	public boolean userLogin(String username,String password);
	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return
	 */
	public User getUserById(int id);
	/**
	 * 获取所有用户的信息
	 * @return
	 */
	public List<User> getAllUser();
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	public String deleteUser(int id);
	/**
	 * 根据id更新信息
	 * @param user
	 * @return
	 */
	int updateByPrimaryKeySelective(User user);
}
