package savy.myhome.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

//工具类
public class MyUtil {

	//存储图片，返回文件名
	public String savePicture(MultipartFile file,HttpServletRequest request){
		
		String path = request.getSession().getServletContext().getRealPath("upload");
		UUID uuid = UUID.randomUUID();
		// String fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+".jpg";
		String fileName = uuid.toString()+".jpg";
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
			return null;
		}
		String fileUrl = request.getContextPath() + "/upload/" + fileName;
		System.out.println("图片地址为：" + fileUrl);
		return fileUrl;
	}
}
