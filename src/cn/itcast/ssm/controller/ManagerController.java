package cn.itcast.ssm.controller;


//ʹ��ע�⿪����������Ҫ����İ�

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.ssm.pojo.Item;
import cn.itcast.ssm.service.ManagerService;

@Controller
public class ManagerController{
	private ManagerService managerService;
	
	@RequestMapping("/gotoItemList.action")
	public void gotoItemList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//��ѯ���ж���
		List<Item> itemList = managerService.getAllItem();
		request.setAttribute("itemList",itemList);
		request.getRequestDispatcher("/WEB-INF/jsp/itemlist.jsp").forward(request, response);	//��ת�����ж����б�
	}
	
	//�ı䷢����״̬
	@RequestMapping("/chstatus.action")
	public String chstatus(HttpServletRequest request,Item item) throws Exception{
		
		
		//����userid��bookid�ı�item���status�ֶΣ�0-->1����
		managerService.chstatus(item);
		//�ض��򵽺�̨��Ʒ�б�
		return "redirect:/gotoItemList.action";
	}
	
	
	
	public ManagerService getManagerService() {
		
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
}
