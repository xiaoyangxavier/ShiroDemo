package savy.myhome.dao.user;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import savy.myhome.vo.user.User;

public interface UserDao {

	/**
	 * 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	public User getByUsername(String username);
	
	//查询所有的用户
	public List<User> getUserAll();
	
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
	public User login(@Param("username") String username, @Param("password") String password);
}
