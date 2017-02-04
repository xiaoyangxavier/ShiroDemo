package savy.myhome.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("")
	public String goAdmin(){
		System.out.println("进入后台");
		return "/admin/admin";
	}
	
	
}
