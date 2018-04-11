package com.ljy.web.resp_req;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ljy.web.resp_req.entity.User;

@WebServlet("/req01")
public class RequestDemo01 extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//让客户端跟服务器端保持一致
		resp.setContentType("text/html;charset=utf-8");
		//post方式
		
		//客户端告诉服务器端客户端的编码格式---解决post下的中文乱码问题
		req.setCharacterEncoding("utf-8");
		
		/**
		 * 服务器端接受客户端的方式
		 * getParameter(key)
		 * getParamerNames();
		 * getParameterMap()
		 */
		//testParameter(req,resp);
		//testParameterNames(req,resp);
		try {
			testParameterMap(req,resp);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	void testParameterMap(HttpServletRequest req, HttpServletResponse resp) throws IOException, IllegalAccessException, InvocationTargetException{
		Map<String, String[]> map = req.getParameterMap();
		User bean = new User();
		BeanUtils.populate(bean, map);
		resp.getWriter().write(bean.toString());
	}
	
	void testParameterNames(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//得到一个枚举器
		Enumeration<String> names = req.getParameterNames();
		PrintWriter writer = resp.getWriter();
		while(names.hasMoreElements()){
			String key = names.nextElement();
			String[] values = req.getParameterValues(key);
			writer.append(key+"[");
			for(String value:values){
				writer.append(value+",");
			}
			writer.append("]");
		}
		writer.flush();
		writer.close();
	}
	
	@SuppressWarnings("unused")
	private void testParameter(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//从表单获取的数据,默认的数据类型都是字符串
		User user = new User();
		String username = req.getParameter("user");
		user.setUser(username);
		user.setPwd(req.getParameter("pwd"));
		user.setSex(req.getParameter("sex"));
		user.setArea(req.getParameter("area"));
		user.setHobby(req.getParameterValues("hobby"));
		
		System.out.println();
		resp.getWriter().write(user.toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
