package savy.myhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import savy.myhome.vo.User;

/**
 *  控制器
 * @author AdminTC
 */
@Controller
@RequestMapping(value="")
public class UserController {
 
	/**
	 * 用户注册，只能接收POST请求
	 */
	@RequestMapping(method=RequestMethod.POST,value="/user/login")
	public String registerMethod(User user,Model model) throws Exception{
		System.out.println("用户注册:" + user.toString());
		//将user绑定到model对象中
		model.addAttribute("user",user);
		//转发到success.jsp页面
		return "/success";
		
	}
}