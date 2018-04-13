package com.ljy.web.fileupload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * 借助commons-fileupload实现文件上传
 * 
 * @author lijiayan
 *
 */
@WebServlet("/fileupload4")
public class FileUploadServlet4 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		boolean b = ServletFileUpload.isMultipartContent(req);
		if(b){
			FileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
			try {
				List<FileItem>items = servletFileUpload.parseRequest(req);
				for(FileItem item:items){
					if(item.isFormField()){
						processFormField(item);
					}else{
						processUploadField(item,resp);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}else{
			
		}
		
	}

	// 处理上传字段
	private boolean processUploadField(FileItem item,HttpServletResponse resp) {
		
		String filename = item.getName();
		filename =new GUID().getToken()+"_"+FilenameUtils.getName(filename);
		String realPath = getServletContext().getRealPath("files");
		String childDir = genChildDir(realPath);
		try {
			item.write(new File(childDir, filename));
			resp.getWriter().append(filename+"上传完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	/**
	 * 按照日期生成子目录
	 * @param realPath
	 * @return
	 */
	private String genChildDir(String realPath) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String str = format.format(date);
		File file = new File(realPath,str);
		if(!file.exists()){
			file.mkdirs();
		}
		return file.getAbsolutePath();
	}

	// 处理普通字段
	private void processFormField(FileItem item) {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
