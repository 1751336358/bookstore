package cn.itcast.ssm.service.impl;


import java.util.List;

import cn.itcast.ssm.dao.BookDao;
import cn.itcast.ssm.dao.ShopCartDao;
import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.pojo.UserBook;
import cn.itcast.ssm.service.BookService;
import cn.itcast.ssm.service.ShopCartService;
import cn.itcast.ssm.service.UserService;

public class ShopCartServiceImpl implements ShopCartService {
	private ShopCartDao shopcartdao;//ע��
	
	
	//�����������ڹ��ﳵ�����ڣ������������빺�ﳵ
	@Override
	public void addToShopcart(UserBook userBook) throws Exception {
		shopcartdao.addToShopcart(userBook);
		
	}
	
	//�����������ڹ��ﳵ�д��ڣ�������1
	@Override
	public void addCountOfBook(UserBook userBook) throws Exception {
		
		shopcartdao.addCountOfBook(userBook);
	}
	
	//��Ʒ����-1
	@Override
	public void bookSubOne(UserBook userBook) throws Exception{
		shopcartdao.bookSubOne(userBook);
	}
	
	//�鿴���ﳵ
	public User findShopCart(Integer userid) throws Exception{
		return shopcartdao.findShopCart(userid);
	}
	
	//�鿴���ﳵ�Ƿ��д���Ʒ�����ش���Ʒ������
	@Override
	public int isInShopcart(UserBook userBook) throws Exception {
		
		return shopcartdao.isInShopcart(userBook);
	}
	
	//�鿴ĳ���������
	@Override
	public int countOfBook(UserBook userBook) throws Exception{
		
		return shopcartdao.countOfBook(userBook);
	}
	
	//��յ�ǰ�û��Ĺ��ﳵ
	public void clearShopCart(int userid) throws Exception{
		shopcartdao.clearShopCart(userid);
	}
	
	//�ӹ��ﳵ��ɾ����Ʒ������user_id��book_id)
	public void deleteBook(UserBook userBook) throws Exception{
		shopcartdao.deleteBook(userBook);
	}
	
	public ShopCartDao getShopcartdao() {
		return shopcartdao;
	}

	public void setShopcartdao(ShopCartDao shopcartdao) {
		this.shopcartdao = shopcartdao;
	}
	
	

	
}
