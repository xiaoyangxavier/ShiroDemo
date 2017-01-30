package savy.myhome.controller;

import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import savy.myhome.util.MD5Code;
import savy.myhome.vo.User;
import sun.misc.BASE64Encoder;

/**
 * 用户
 * @author Savvy
 *
 */
@Controller
@RequestMapping(value="")
public class UserController {
 
	/**
	 * 用户注册，只能接收POST请求
	 */
	@RequestMapping(method=RequestMethod.POST,value="/user/login")
	public String registerMethod(User user,HttpServletRequest request) throws Exception{
		
		user.setPassword(new MD5Code().getMD5ofStr(user.getPassword()));
		System.out.println("用户注册:" + user.toString());
		
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try{
			subject.login(token);
			Session session=subject.getSession();
			System.out.println("sessionId:"+session.getId());
			System.out.println("sessionHost:"+session.getHost());
			System.out.println("sessionTimeout:"+session.getTimeout());
			session.setAttribute("info", "session的数据");
			return "/success";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "/login";
		}
		
	}
}