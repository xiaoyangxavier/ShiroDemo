package savy.myhome.controller.outlay;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import savy.myhome.service.outlay.OutlayService;
import savy.myhome.vo.outlay.Outlay;

@Controller
@RequestMapping("/outlay")
public class OutlayController {

	 @Resource
	    private OutlayService outlayService;
	
	
	@RequestMapping("/list")
	public String goAdmin(ModelMap modelMap,HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("进入支出列表！");
		
	List<Outlay> myList = outlayService.getOutlayList();
	modelMap.addAttribute("outlayList", myList);
		return "/outlay/outlay_list";
	}
	
}
