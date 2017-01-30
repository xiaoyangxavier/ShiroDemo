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
     * 
     * @param request
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request) {
        return "/login";
    }
    
    /**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
        return "404";
    }

    
}
