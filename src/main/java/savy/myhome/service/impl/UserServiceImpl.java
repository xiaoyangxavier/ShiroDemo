package savy.myhome.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import savy.myhome.dao.UserMapper;
import savy.myhome.service.UserService;
import savy.myhome.vo.User;

@Service
public class UserServiceImpl implements UserService {

	  
	@Resource
	private UserMapper userDao;
	
	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}

	public Set<String> getRoles(String username) {
		return userDao.getRoles(username);
	}

	public Set<String> getPermissions(String username) {
		return userDao.getPermissions(username);
	}
	
	public User authentication(String username, String password){
		
		return userDao.login(username,password);
	}

}
