package cn.itcast.ssm.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.ssm.dao.BookDao;
import cn.itcast.ssm.dao.ShopCartDao;
import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.mapper.BookMapper;
import cn.itcast.ssm.mapper.ShopCartMapper;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.pojo.UserBook;

public class ShopCartDaoImpl extends SqlSessionDaoSupport implements ShopCartDao{
	
	
	//�����������ڹ��ﳵ�����ڣ������������빺�ﳵ
	@Override
	public void addToShopcart(UserBook userBook) throws Exception {
		this.getSqlSession().getMapper(ShopCartMapper.class).addToShopcart(userBook);
		
	}
	
	//�����������ڹ��ﳵ�д��ڣ�������1
	@Override
	public void addCountOfBook(UserBook userBook) throws Exception{
		this.getSqlSession().getMapper(ShopCartMapper.class).addCountOfBook(userBook);
	}
	
	//��Ʒ����-1
	public void bookSubOne(UserBook userBook) throws Exception{
		this.getSqlSession().getMapper(ShopCartMapper.class).bookSubOne(userBook);
	}
	
	//�鿴���ﳵ
	@Override
	public User findShopCart(Integer userid) throws Exception {
		return this.getSqlSession().getMapper(ShopCartMapper.class).findShopCart(userid);
	}

	//�鿴���ﳵ�Ƿ��д���Ʒ���еĻ�����������û�з���0
	@Override
	public int isInShopcart(UserBook userBook) throws Exception{
		return this.getSqlSession().getMapper(ShopCartMapper.class).isInShopcart(userBook);
	}
	
	//�鿴ĳ���������
	@Override
	public int countOfBook(UserBook userBook) throws Exception{
		return this.getSqlSession().getMapper(ShopCartMapper.class).countOfBook(userBook);
	}
	//��յ�ǰ�û��Ĺ��ﳵ
	@Override
	public void clearShopCart(int userid) throws Exception{
		this.getSqlSession().getMapper(ShopCartMapper.class).clearShopCart(userid);
	}
	
	//�ӹ��ﳵ��ɾ����Ʒ������user_id��book_id)
	@Override
	public void deleteBook(UserBook userBook) throws Exception{
		this.getSqlSession().getMapper(ShopCartMapper.class).deleteBook(userBook);
	}
}
