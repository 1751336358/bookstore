package cn.itcast.ssm.controller;


//ʹ��ע�⿪����������Ҫ����İ�

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.ssm.pojo.Item;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.service.ItemService;

@Controller
public class ItemController{
	private ItemService itemService;
	
	//�ύ����
	@RequestMapping("/upItem.action")
	public String item(Item item,HttpServletRequest request) throws Exception{
		int userid = item.getUserId();
		int bookid = item.getBookId();
		String bookname = item.getBookName();
		bookname = new String(bookname.getBytes("iso-8859-1"),"utf-8");
		item.setBookName(bookname);
		double bookprice = item.getBookPrice();
		int booknum = item.getBookNum();
		
		
		
		//ɾ���û��Ĺ��ﳵ
		itemService.deleteShop(item);
		//������д��item��
		itemService.addItem(item);
		//��ѯ�ҵĶ���
		
		//��ת���ҵĶ���ҳ��
		return "redirect:/gotoMyItem.action";
	}
	
	//�ҵĶ���,����session�е�userid�鿴�ҵĶ���
	@RequestMapping("/gotoMyItem.action")
	public String gotoMyItem(HttpSession session,HttpServletRequest request) throws Exception{
		User u = (User) session.getAttribute("u");
		
		List<Item> myItemList = itemService.getMyItemsById(u.getId());
		
		
		request.setAttribute("myItemList", myItemList);
		return "/WEB-INF/jsp/myitems.jsp";
	}
	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

}
