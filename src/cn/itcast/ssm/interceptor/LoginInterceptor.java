package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.pojo.User;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//��Ҫ���ص��Ǽ��빺�ﳵ��url
		///bookstore/findShopCart.action
		///bookstore/addIntoShopCart.action
		String url = request.getRequestURI();	//����Ǽ��繺�ﳵ�ĵ�ַ���鿴���ﳵ���鿴���������ж��Ƿ��ѵ�¼
		
		
		if(url.startsWith("/bookstore/findShopCart.action") || url.startsWith("/bookstore/addIntoShopCart.action") || url.startsWith("/bookstore/gotoMyItem.action")){
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("u");
			if(u != null){	//����Ѿ���¼������
				return true;
			}else{	//���û�е�¼����ת����¼ҳ��
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
				return false;
			}
		}
		
		//������ַ������
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object hander, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
