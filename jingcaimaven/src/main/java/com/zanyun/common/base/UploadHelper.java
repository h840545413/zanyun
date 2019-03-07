package com.zanyun.common.base;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadHelper {
	//上传图片到服务器指定位置
	public String saveImage (MultipartFile file,HttpServletRequest request,HttpServletResponse response)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String imgpath=null;
		if (!file.isEmpty()) {
			String type = file.getOriginalFilename().substring(
					file.getOriginalFilename().indexOf("."));
			String[] namearray = file.getOriginalFilename().split("\\.");
			
			String filename = namearray[0]
					+ sdf.format(System.currentTimeMillis()) + type;// 取当前时间戳作为文件名
			String path = request.getSession().getServletContext()
					.getRealPath("/upload/modelimg/" + filename);// 存放位置
			imgpath="/ylmj/upload/modelimg/"+filename;
		//	path=path.replace("ylmj", "ConcordanceForSTHW");
			File destFile = new File(path);
			try {
				// FileUtils.copyInputStreamToFile()这个方法里对IO进行了自动操作，不需要额外的再去关闭IO流
				FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);// 复制临时文件到指定目录下
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			
		} 
		return imgpath;
	}
//删除照片
	//上传文件
	
	public String saveFile(MultipartFile file,HttpServletRequest request,HttpServletResponse response,Integer modelId)
	{
		String hompath=null;
		if (!file.isEmpty()) {
			//String[] arr= file.getOriginalFilename().split(".");
			/*String type = file.getOriginalFilename().substring(
					file.getOriginalFilename().indexOf("."));*/
			String filename =modelId.toString()+ ".hom";// 
			String path = request.getSession().getServletContext()
					.getRealPath("/upload/Clicent/" + filename);// 存放位置
			path=path.replace("ylmj", "3vhome");
			File destFile = new File(path);
			hompath="/upload/Clicent/"+filename;
			try {
				// FileUtils.copyInputStreamToFile()这个方法里对IO进行了自动操作，不需要额外的再去关闭IO流
				FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);// 复制临时文件到指定目录下
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			
		}
		
		return hompath;
		
	}
	
	public String saveRoomImage (MultipartFile file,HttpServletRequest request,HttpServletResponse response)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String imgpath=null;
		if (!file.isEmpty()) {
			String type = file.getOriginalFilename().substring(
					file.getOriginalFilename().indexOf("."));
			String[] namearray = file.getOriginalFilename().split("\\.");
			
			String filename = namearray[0]
					+ sdf.format(System.currentTimeMillis()) + type;// 取当前时间戳作为文件名
			String path = request.getSession().getServletContext()
					.getRealPath("/upload/roomimg/" + filename);// 存放位置
			imgpath="/ylmj/upload/roomimg/"+filename;
		//	path=path.replace("ylmj", "ConcordanceForSTHW");
			File destFile = new File(path);
			try {
				// FileUtils.copyInputStreamToFile()这个方法里对IO进行了自动操作，不需要额外的再去关闭IO流
				FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);// 复制临时文件到指定目录下
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			
		} 
		return imgpath;
	}
	
}
