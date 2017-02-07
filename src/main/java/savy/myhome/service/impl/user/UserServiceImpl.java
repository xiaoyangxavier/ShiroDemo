package savy.myhome.service.impl.user;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import savy.myhome.dao.user.UserDao;
import savy.myhome.service.user.UserService;
import savy.myhome.vo.user.User;

@Service
public class UserServiceImpl implements UserService {

	  
	@Resource
	private UserDao userDao;
	
	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}

	public Set<String> getRoles(String username) {
		return userDao.getRoles(username);
	}

	public Set<String> getPermissions(String username) {
		Set<String> myPermission = userDao.getPermissions(username);
		System.out.println("权限为："+myPermission.toString());
		return myPermission;
	}
	
	public User authentication(String username, String password){
		
		return userDao.login(username,password);
	}

	//查询所有的用户
		public List<User> getUserAll(){
			List<User> myList = userDao.getUserAll();
			return myList;
		}
}
