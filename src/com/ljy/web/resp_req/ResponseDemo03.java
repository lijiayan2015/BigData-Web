package com.ljy.web.resp_req;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resp03")
public class ResponseDemo03 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String filename = getServletContext().getRealPath("\\WEB-INF\\classes\\com\\ljy\\web\\res\\傻2.jpg");
		File file = new File(filename);
		filename = URLEncoder.encode(file.getName());
		resp.setHeader("content-disposition", "attachment;filename="+filename );
		FileInputStream fis = new FileInputStream(file);
		ServletOutputStream sos = resp.getOutputStream();
		byte[]arr = new byte[1024];
		int len = 0;
		while((len = fis.read(arr))!=-1){
			sos.write(arr, 0, len);
		}
		sos.flush();
		sos.close();
		fis.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

}
