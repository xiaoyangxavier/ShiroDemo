package savy.myhome.service;

import java.util.Set;

import savy.myhome.vo.User;

public interface UserService {
	/**
	 * 通过用户名查询用户
	 * @param username
	 * @return
	 */
	public User getByUsername(String username);
	
	/**
	 * 通过用户名查询角色信息
	 * @param username
	 * @return
	 */
	public Set<String> getRoles(String username);
	
	/**
	 * 通过用户名查询权限信息
	 * @param username
	 * @return
	 */
	public Set<String> getPermissions(String username);
	
	/**
	 * 根据用户名密码验证登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User authentication(String username, String password);
}
