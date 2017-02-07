package savy.myhome.controller.outlay;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import savy.myhome.vo.outlay.Outlay;
import savy.myhome.vo.outlay.OutlayTypeOne;
import savy.myhome.vo.outlay.OutlayTypeTwo;
import savy.myhome.vo.user.User;

@Controller
@RequestMapping("/outlay")
public class OutlayController {

	@Resource
	private OutlayService outlayService;

	@RequestMapping("/list")
	public String goAdmin(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入支出列表！");

		List<Outlay> myList = outlayService.getOutlayList();
		modelMap.addAttribute("outlayList", myList);
		return "/outlay/outlay_list";
	}

	@RequestMapping("/addpre")
	public String goAdmin(Model model, RedirectAttributes redirectAttributes, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("跳转到新增页面！");

		List<OutlayTypeOne> myList = outlayService.getOutlayTypeOneList();
		model.addAttribute("allType", myList);
		return "/outlay/outlay_add";
	}

	@RequestMapping("/getTypeTwo")
	@ResponseBody
	public Map<String, Object> getTypeTwo(Integer id) {
		System.out.println("获取二级类别列表！");
		List<OutlayTypeTwo> myList = outlayService.getOutlayTypeTwoList(id);
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("data", myList);
		modelMap.put("success", "true");
		return modelMap;
	}

	@RequestMapping(value = "/addOutlay", method = RequestMethod.POST)
	public String addOutlay(Outlay outlay, @RequestParam(value = "file", required = false) MultipartFile file,
			RedirectAttributesModelMap redirectModelMap, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("新增支出记录！" + outlay.toString());

		String info = null;
		if (file.getSize() > 1024 * 1024) {
			info = "图片大小不能大于 1M";
		} else {
			String path = request.getSession().getServletContext().getRealPath("upload");
			UUID uuid = UUID.randomUUID();
			// String fileName = file.getOriginalFilename();
			// String fileName = new Date().getTime()+".jpg";
			String fileName = uuid.toString();
			System.out.println("图片保存地址为：" + path);
			File targetFile = new File(path, fileName);
			if (!targetFile.getParentFile().exists()) { // 父路径不存在
				targetFile.getParentFile().mkdirs(); // 创建目录
			}
			if (!targetFile.exists()) { // 文件不存在
				targetFile.mkdirs(); // 创建文件
			}

			// 保存
			try {
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String fileUrl = request.getContextPath() + "/upload/" + fileName;
			System.out.println("图片地址为：" + fileUrl);

			outlay.setPictureUrl(fileUrl);

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
			
			//测试
			outlay.setUserId(1);
			outlay.setUserRealName("测试");
			outlay.setOperator("测试");
			outlay.setOutlayDate(new Date());
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
