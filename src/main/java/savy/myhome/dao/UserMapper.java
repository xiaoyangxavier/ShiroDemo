package savy.myhome.dao;

import java.util.Set;

import savy.myhome.vo.User;

public interface UserMapper {

	/**
	 * 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	public User getByUsername(String username);
	
	/**
	 * 通过用户名查询角色信息
	 * @param userName
	 * @return
	 */
	public Set<String> getRoles(String username);
	
	/**
	 * 通过用户名查询权限信息
	 * @param userName
	 * @return
	 */
	public Set<String> getPermissions(String username);
	
	/**
	 * 根据用户名和密码进行登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password);
}
