package com.ljy.web.mvc.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.ljy.web.mvc.domain.User;
import com.ljy.web.mvc.service.UserService;
import com.ljy.web.mvc.service.impl.UserServiceImpl;

@WebServlet("/regist")
public class RegistServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		User user = new User();
		try {
			//给BeanUtils增加一个String-->Date的转换器
			ConvertUtils.register(new Converter() {
				
				@Override
				public Object convert(@SuppressWarnings("rawtypes") Class arg0, Object arg1) {
					java.util.Date date = null;
					if(arg1 instanceof String){
						String strDate = (String) arg1;
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						try {
							date =  format.parse(strDate);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
					return date;
				}
			}, java.util.Date.class);
			BeanUtils.populate(user, req.getParameterMap());
			//重新编码username
			//String username = user.getUsername();
			/*if(username!=null){
				byte[] bytes = username.getBytes("ISO8859-1");
				username = new String(bytes,"UTF-8");
				user.setUsername(username);
			}*/
			//访问service
			UserService userService = new UserServiceImpl();
			int result = userService.regiester(user);
			if(result>0){
				//注册成功
				req.getRequestDispatcher("/mvc/login.jsp").forward(req, resp);
			}else{
				//注册成功
				req.getRequestDispatcher("/mvc/regist.jsp").forward(req, resp);
			}
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
