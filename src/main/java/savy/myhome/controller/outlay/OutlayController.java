package savy.myhome.controller.outlay;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import savy.myhome.service.outlay.OutlayService;
import savy.myhome.service.user.UserService;
import savy.myhome.util.MyUtil;
import savy.myhome.vo.outlay.Outlay;
import savy.myhome.vo.outlay.OutlayTypeOne;
import savy.myhome.vo.outlay.OutlayTypeTwo;
import savy.myhome.vo.user.User;

@Controller
@RequestMapping("/outlay")
public class OutlayController {

	@Resource
	private OutlayService outlayService;
	
	@Resource
	private UserService userService;

	@RequestMapping("/list")
	public String goAdmin(Integer pageNumber,Integer pageSize,ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入支出列表！"+pageNumber+"、"+pageSize);
	 
		if(pageNumber==null || pageNumber==0){
			pageNumber = 1;
		}
		if(pageSize==null || pageSize==0){
			pageSize = 10;
		}
		Map<String,Object> myMap = outlayService.getOutlayAll(pageNumber,pageSize,null,null,null);
		modelMap.addAttribute("allData", myMap.get("allData"));
		modelMap.addAttribute("count", myMap.get("count"));
		modelMap.addAttribute("pageNumber", pageNumber);
		modelMap.addAttribute("pageSize", pageSize);
		return "/outlay/outlay_list";
	}
	
	@RequestMapping("/listRefresh")
	@ResponseBody
	public Map<String, Object> listRefresh(Integer pageNumber,Integer pageSize) {
		System.out.println("刷新列表！");
		Map<String,Object> myMap = outlayService.getOutlayAll(pageNumber,pageSize,null,null,null);
		return myMap;
	}

	@RequestMapping("/addpre")
	public String goAdmin(Model model, RedirectAttributes redirectAttributes, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("跳转到新增页面！");

		List<OutlayTypeOne> outlayTypeList = outlayService.getOutlayTypeOneList();
		List<User> userList = userService.getUserAll();
		model.addAttribute("allType", outlayTypeList);
		model.addAttribute("userList", userList);
		return "/outlay/outlay_add";
	}

	@RequestMapping("/getTypeTwo")
	@ResponseBody
	public Map<String, Object> getTypeTwo(Integer id) {
		System.out.println("获取二级类别列表！");
		List<OutlayTypeTwo> myList = outlayService.getOutlayTypeTwoList(id);
		Map<String, Object> myMap = new HashMap<String, Object>(3);
		myMap.put("data", myList);
		myMap.put("success", "true");
		return myMap;
	}

	@RequestMapping(value = "/addOutlay", method = RequestMethod.POST)
	public String addOutlay(Outlay outlay, @RequestParam(value = "file", required = false) MultipartFile file,
			RedirectAttributesModelMap redirectModelMap, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("新增支出记录！" + outlay.toString());

		String info = null;
		if (file.getSize() > 1024 * 1024) {
			info = "图片大小不能大于 1M";
		} else {
			 MyUtil myUtil = new MyUtil();
			String fileUrl = myUtil.savePicture(file, request);
			if(fileUrl!=null){
			outlay.setPictureUrl(fileUrl);
			}else{
				info = "图片保存失败，请重试！";
			}
			//插入其他参数
			Subject subject=SecurityUtils.getSubject();
			Session session=subject.getSession();
			User user = (User) session.getAttribute("user");
//			outlay.setUserId(user.getUid());
//			outlay.setUserRealName(user.getRealname());
			outlay.setOperationDate(new Date());
			if(user!=null){
			outlay.setOperator(user.getRealname());
			}
			
			boolean flag = false;
			flag = outlayService.insertOutlay(outlay);
			if (flag) {
				info = "插入成功";
			} else {
				info = "插入失败";
			}
		}
		// redirectAttributes.addAttribute("info", info);
		// return "redirect:/outlay/addpre";
		redirectModelMap.addFlashAttribute("info", info);

		return "redirect:" + request.getHeader("Referer");
	}
}
