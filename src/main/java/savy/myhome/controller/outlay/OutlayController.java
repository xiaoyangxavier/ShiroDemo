package savy.myhome.controller.outlay;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import savy.myhome.service.outlay.OutlayService;
import savy.myhome.vo.outlay.Outlay;
import savy.myhome.vo.outlay.OutlayTypeOne;
import savy.myhome.vo.outlay.OutlayTypeTwo;

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
	
	@RequestMapping("/addpre")
	public String goAdmin(Model model,HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("跳转到新增页面！");
		
		List<OutlayTypeOne> myList = outlayService.getOutlayTypeOneList();
		model.addAttribute("allType", myList);
		return "/outlay/outlay_add";
	}
	
	@RequestMapping("/getTypeTwo")
	@ResponseBody
	public Map<String, Object> getTypeTwo(Integer id){
		System.out.println("获取二级类别列表！");
		List<OutlayTypeTwo> myList = outlayService.getOutlayTypeTwoList(id);
		 Map<String, Object> modelMap = new HashMap<String, Object>(3);
		    modelMap.put("data", myList);
		    modelMap.put("success", "true");
		    return modelMap;
	}
	
	
	@RequestMapping(value="/addOutlay", method = RequestMethod.POST)
	public String addOutlay(Outlay outlay,@RequestParam(value = "file", required = false) MultipartFile file,HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("新增支出记录！"+ outlay.toString());
		 
		
//		   String path = request.getSession().getServletContext().getRealPath("upload");  
//	        String fileName = file.getOriginalFilename();  
////	        String fileName = new Date().getTime()+".jpg";  
//	        System.out.println("图片保存地址为："+ path);  
//	        File targetFile = new File(path, fileName);  
//	        if(!targetFile.exists()){  
//	            targetFile.mkdirs();  
//	        }  
//	        //保存  
//	        try {  
//	            file.transferTo(targetFile);  
//	        } catch (Exception e) {  
//	            e.printStackTrace();  
//	        }  
//		String fileUrl = request.getContextPath()+"/upload/"+fileName;
//		 System.out.println("图片地址为："+ fileUrl); 
		 return "redirect:/outlay/list";
	}
}
