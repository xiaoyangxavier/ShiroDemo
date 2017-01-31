package savy.myhome.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import savy.myhome.vo.User;

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

    /**
     * api接口
     * @param request
     * @return
     */
    //直接返回中文需指定utf-8编码格式
    @RequestMapping(value = "/api", method = RequestMethod.GET, produces={"application/json;charset=UTF-8"})
    // 该注解用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter进行解析，然后把相应的数据绑定到要返回的对象上；
    @ResponseBody
    // 当使用@RequestMapping URI template 样式映射时， 即 /api/{data},
    // 这时的data可通过 @Pathvariable注解绑定它传过来的值到方法的参数上。
    public Object  getApi() {
    	System.out.println("返回api接口数据！");
  		return "接口返回数据";
    }
    
    
    /**
     * api接口
     * @param request
     * @return
     */
 // 路径参数{data}填入请求数据。我们设置为GET请求。
    @RequestMapping(value = "/api/{data}", method = RequestMethod.GET)
 // 该注解用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter进行解析，然后把相应的数据绑定到要返回的对象上；
    @ResponseBody
    // 当使用@RequestMapping URI template 样式映射时， 即 /api/{data},
    // 这时的data可通过 @Pathvariable注解绑定它传过来的值到方法的参数上。
    public Object  getApi(@PathVariable String data) {
    	System.out.println("返回api接口数据！");
 
    	List<User> myList = new ArrayList<User>();
    	User user = new User();
    	user.setRoleId(1);
    	user.setUsername(data);
    	myList.add(user);
    	myList.add(user);
    	myList.add(user);
    	myList.add(user);
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("msg", "登录成功");
    	map.put("code", "1");
    	map.put("array", myList);
		return map;//直接返回json数据
    }
    
    
  
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public void  test() {
    	System.out.println("开始测试数据！");
    	
    }
    
}
