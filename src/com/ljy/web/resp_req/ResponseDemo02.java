package com.ljy.web.resp_req;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/resp02")
public class ResponseDemo02 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("charset=utf-8");//注意,这里如果写成text/html;charset=utf-8的话有些浏览器会直接将字节数组解析到页面,而不能正常的显示图片
		String filename = getServletContext().getRealPath("\\WEB-INF\\classes\\com\\ljy\\web\\res\\dog.jpg");
		File file = new File(filename);
		filename = file.getName();
		//resp.setHeader("content-disposition", "attachment;filename="+filename );
		ServletOutputStream sos = resp.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		byte[]arr =new byte[1024];
		int len = 0;
		while((len = fis.read(arr))!=-1){
			sos.write(arr,0,len);
		}
		sos.flush();
		sos.close();
		fis.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
