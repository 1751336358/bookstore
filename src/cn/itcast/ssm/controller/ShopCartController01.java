package cn.itcast.ssm.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.pojo.Shopcart;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.pojo.UserBook;
import cn.itcast.ssm.service.BookService;
import cn.itcast.ssm.service.ShopCartService;
import cn.itcast.ssm.service.UserService;

@Controller
public class ShopCartController01{
	private UserBook userBook;
	private ShopCartService shopcartService;
	
	//�鿴���ﳵ�����ݿͻ���id
	@RequestMapping("/findShopCart.action")
	public ModelAndView findShopCart(Integer userid) throws Exception{
		System.out.println("�鿴�û�id:"+userid);
		ModelAndView modelAndView = new ModelAndView();
		User u = shopcartService.findShopCart(userid);	//�����û�id�鿴�û��Ĺ��ﳵ
		
		
		modelAndView.addObject("user", u);
		modelAndView.setViewName("/WEB-INF/jsp/findshopcart.jsp");
		return modelAndView;
	}
	
	//���빺�ﳵ
	@RequestMapping("/addIntoShopCart.action")
	public String addIntoShopCart(UserBook userBook) throws Exception{
		this.userBook = userBook;
		
		//�Ȳ��ҹ��ﳵ���Ƿ��д���
		//select count(book_number) from shopcart where book_id=#{book_id} and user_id=#{user_id}
		int count = shopcartService.isInShopcart(userBook);//����1��0�������л���
		
		//���û�У���������빺�ﳵ
		if(count == 0){
			shopcartService.addToShopcart(userBook);
			
			return "redirect:/gotoShopCart.action";	//��ת�����ﳵ
		}
		//����У�����+1
		shopcartService.addCountOfBook(userBook);
		
		return "redirect:/gotoShopCart.action";	//�ض��򵽹��ﳵ
	}
	
	//�ض��򵽹��ﳵ
	@RequestMapping("/gotoShopCart.action")
	public String gotoShopcart(){
		
		return "/findShopCart.action?userid="+this.userBook.getUser_id();	//����user_id��ѯ���ﳵ
	}
	
	//�ڹ��ﳵ�е�����ӣ�ͼ�������+1
	@RequestMapping("/bookAddOne.action")
	public String bookAddOne(UserBook userBook) throws Exception{	
		this.userBook = userBook;
		shopcartService.addCountOfBook(userBook);	//�������+1
		return "redirect:/gotoShopCart.action";	//�ض��򵽹��ﳵ
	}
	
	//�ڹ��ﳵ�е��������һ��ͼ�������-1
	@RequestMapping("/bookSubOne.action")
	public String bookSubOne(UserBook userBook) throws Exception{
		this.userBook = userBook;
		//�Ȳ�ѯ���ﳵ�Ƿ��д��飬1��0�����л���
		int count = shopcartService.isInShopcart(userBook);
		
		
		if(count == 1){	//�����Ʒ���ڣ�����1
			//��ѯ��Ʒ����
			//select book_number from shopcart where book_id=#{book_id} and user_id=#{user_id}
			if(shopcartService.countOfBook(userBook) > 1){
					
				//��Ʒ��������һ
				//update shopcart set book_number=book_number-1 where book_id=#{book_id} and user_id=#{user_id}
				shopcartService.bookSubOne(userBook);
				
				return "redirect:/gotoShopCart.action";	//�ض��򵽹��ﳵ
			}else{	//book_number <= 1
				
				shopcartService.deleteBook(userBook);
				
				return "redirect:/gotoShopCart.action";	//�ض��򵽹��ﳵ
			}
		}
		//count == 0����Ʒ������
		return "redirect:/gotoShopCart.action";	//�ض��򵽹��ﳵ
	}
	
	//��յ�ǰ�û��Ĺ��ﳵ
	@RequestMapping("/clearShopCart.action")
	public ModelAndView clearShopCart(Integer userid) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		shopcartService.clearShopCart(userid);
		
		//��ת��ͼ���ѯ�б�
		modelAndView.setViewName("/getAllBook.action");
		return modelAndView;
	}
	
	//�ӹ��ﳵ��ɾ��ĳ���飨�����û�user_id��book_id��
	@RequestMapping("/deleteBook.action")
	public ModelAndView deleteBook(UserBook userBook) throws Exception{
		shopcartService.deleteBook(userBook);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/findShopCart.action?userid="+userBook.getUser_id());	//��ת�����ﳵ
		return modelAndView;
	}
	
	public ShopCartService getShopcartService() {
		return shopcartService;
	}

	public void setShopcartService(ShopCartService shopcartService) {
		this.shopcartService = shopcartService;
	}
	
	
}
