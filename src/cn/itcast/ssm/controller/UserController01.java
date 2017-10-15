package cn.itcast.ssm.controller;

import java.security.MessageDigest;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.BASE64Encoder;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.service.UserService;

@Controller
public class UserController01{
	private UserService userService;
	
	//�û�ע��ʱ����û����Ƿ����
	public boolean findUserByUsername(User u) throws Exception{
		List<User> userList = userService.findUserByUsername(u);
		if(userList == null || userList.size()<=0)	//��������ڣ�˵������ע��
			return true;
		return false;
	}
	
	//����ע����û���ӵ����ݿ���
	@RequestMapping("/insertUser.action")
	public ModelAndView insertUser(User u,String randomNum,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		if(u.getUsername().equals("") || u.getPassword().equals("")){//����û������û���������
			session.removeAttribute("randomNum");//��ʱ��ȥsession�е���֤����Ϣ
			modelAndView.addObject("warning","�������û���������");
			modelAndView.setViewName("/WEB-INF/jsp/register.jsp");
			return modelAndView;
		}
		boolean Register = this.findUserByUsername(u);
		if(Register == true){//��ʾ����ע��
			if(randomNum.equals(session.getAttribute("randomNum"))){//��֤��Ҳ������ȷ
				session.removeAttribute("randomNum");//��ʱ��ȥsession�е���֤����Ϣ
				//��ע�������תΪMD5��������ݿ�
				String password = u.getPassword();
				MessageDigest md = MessageDigest.getInstance("md5");	//Ҳ���Ը�ΪSHA�㷨
				byte [] md5 = md.digest(password.getBytes());
				BASE64Encoder encoder = new BASE64Encoder();
				password = encoder.encode(md5);
				System.out.println("ת���������ǣ�"+password);
				u.setPassword(password);
				userService.insertUser(u);	//��ע����Ϣ��ӵ����ݿ�
				request.getRequestDispatcher("/index.jsp").forward(request, response);	//��ת����ҳ
			}else{	//�û���������ȷ����֤���������
				session.removeAttribute("randomNum");//��ʱ��ȥsession�е���֤����Ϣ
				request.setAttribute("warning","��֤���������");
				request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);	//��ת��ע��ҳ��ҳ������ע��
			}
		}else{	//��ʾ����ע��,�û����Ѵ���
			session.removeAttribute("randomNum");//��ʱ��ȥsession�е���֤����Ϣ
			modelAndView.addObject("warning","�Բ��𣬸��û����Ѵ���");
			modelAndView.setViewName("/WEB-INF/jsp/register.jsp");	//��ת��ע��ҳ��ҳ������ע��
		}
		return modelAndView;
	}
	
	//�û���¼ʱ�ж��û����û�������������ȷ
	@RequestMapping("/findUsernameAndPassword.action")
	public String findUsernameAndPassword(User u,String randomNum,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		if(u.getUsername().equals("") || u.getPassword().equals("")){//����û������û���������
			session.removeAttribute("randomNum");//��ʱ��ȥsession�е���֤����Ϣ
			/*~~*/
			request.setAttribute("warning","�������û���������");			
			return "/WEB-INF/jsp/login.jsp";
		}
		//���û��ĵ�½��ϢתΪMD5�������ݿ�ȶ�
		String password = u.getPassword();
		MessageDigest md = MessageDigest.getInstance("md5");	//Ҳ���Ը�ΪSHA�㷨
		byte [] md5 = md.digest(password.getBytes());
		BASE64Encoder encoder = new BASE64Encoder();
		password = encoder.encode(md5);
		u.setPassword(password);
		
		System.out.println("��½�������ǣ�"+u.getPassword());
		User user = userService.findUsernameAndPassword(u);	//�����ݿ���鵽���û���������
		System.out.println("�����ݿ���鵽�������ǣ�"+user.getPassword());
		
		
		if(user != null){	//
			if(user.getUsername() != null && user.getPassword()!=null){
				//�û�����������ȷ
				if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())){
					if(randomNum.equals(session.getAttribute("randomNum"))){//�������֤����ȷ
						session.removeAttribute("randomNum");//��ʱ��ȥsession�е���֤����Ϣ
						session.setAttribute("u",user);	//����¼��Ϣ��ŵ�session��
						
						Cookie cookie = new Cookie("JSESSIONID",session.getId());
						cookie.setPath("/bookstore");
						cookie.setMaxAge(60*30);	//cookie����Ч����30min
						response.addCookie(cookie);
						/*~~*/
						response.sendRedirect("/bookstore/index.jsp");//��¼�ɹ�,�ض�����ҳ
					
						return null;
					}else{//�û���������ȷ����֤�����
						session.removeAttribute("randomNum");//��ʱ��ȥsession�е���֤����Ϣ
						
						/*~~*/
						request.setAttribute("warning","��֤�����");
						return "/WEB-INF/jsp/login.jsp";//��֤�������ת����¼ҳ�����µ�¼
					}		
				}else{
					session.removeAttribute("randomNum");//��ʱ��ȥsession�е���֤����Ϣ
					
					/*~~*/
					request.setAttribute("warning","�Բ��������û����������������");
					return "/WEB-INF/jsp/login.jsp";//��¼ʧ�ܣ���ת����¼ҳ�����µ�¼
				}
			}	
		}
		/*~~*/
		request.setAttribute("warning","�Բ��������û����������������");
		return "/WEB-INF/jsp/login.jsp";//��¼ʧ�ܣ���ת����¼ʧ��ҳ�����µ�¼
	}
	
	
	//��ת���û���¼
	@RequestMapping("/login.action")
	public ModelAndView login() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/login.jsp");
		return modelAndView;	
	}
	
	//ע���û�
	@RequestMapping("/invalidate.action")
	public ModelAndView invalidate(HttpSession session) throws Exception{
		session.invalidate();//ע���û�
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/index.jsp");//��ת����ҳ
		return modelAndView;
	}
	
	//��ת���û�ע��
	@RequestMapping("/register.action")
	public ModelAndView register() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/register.jsp");
		return modelAndView;	
	}
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
