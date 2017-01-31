package savy.myhome.controller;

import java.security.MessageDigest;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
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
@RequestMapping(value="/user")
public class UserController {
 
	/**
	 * 用户注册，只能接收POST请求
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginMethod(User user,Model model,HttpServletRequest request) throws Exception{
		
		System.out.println("用户登录:" + user.toString());
		user.setPassword(new MD5Code().getMD5ofStr(user.getPassword()));
		
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try{
			subject.login(token);
			Session session=subject.getSession();
			System.out.println("sessionId:"+session.getId());
			System.out.println("sessionHost:"+session.getHost());
			System.out.println("sessionTimeout:"+session.getTimeout());
			session.setAttribute("info", "session的数据");
			model.addAttribute("user", session.getAttribute("user"));
			 
			return "/index";
		}catch(AuthenticationException e){
//			e.printStackTrace();//继续正常执行，无需打印异常
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "/login";
		}
		
	}
	
	/**
	 * 用户注册，只能接收POST请求
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutMethod(HttpSession session){
		
		  session.removeAttribute("userInfo");
	        // 登出操作
	        Subject subject = SecurityUtils.getSubject();
	        subject.logout();
	        
		return "/index";
	}
}