package com.ljy.web.fileupload;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件上传--原理分析
 * @author lijiayan
 *
 */
@WebServlet("/fileupload")
public class FileUploadServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;chaset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		ServletInputStream sis = req.getInputStream();
		int len = -1;
		byte b[] = new byte[1024];
		while((len=sis.read(b))!=-1){
			System.out.println(new String(b,0,len));
		}
		sis.close();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
