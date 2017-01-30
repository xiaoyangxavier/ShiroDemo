package savy.myhome.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公共视图控制器
 * @author Savvy
 *
 */
@Controller
public class CommonController {
    /**
     * 首页
     * @param request
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
    	System.out.println("进入index页面！");
        return "/index";
    }

    /**
     * 登录页
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
    	System.out.println("进入login页面！");
        return "/login";
    }
    
    /**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
    	System.out.println("进入404找不到指定页面！");
        return "/404";
    }
    
    
    /**
     * 500页
     */
    @RequestMapping("/500")
    public String error500() {
    	System.out.println("进入500错误页面！");
        return "/500";
    }

    
}
