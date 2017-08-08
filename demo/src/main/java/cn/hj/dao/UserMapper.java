package cn.hj.dao;

import java.util.List;

import cn.hj.entity.User;

public interface UserMapper {

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(User record);
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User findUserByUsername(String username);
    /**
     * 获取用户所有信息
     * @return
     */
    List<User> getAllUser();
    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 根据id更新信息
     * @param user
     * @return
     */
    int updateByPrimaryKeySelective(User user);

}
