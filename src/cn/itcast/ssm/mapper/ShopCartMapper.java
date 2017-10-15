package cn.itcast.ssm.mapper;

import java.util.List;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.pojo.UserBook;

public interface ShopCartMapper {
	
	//�����������ڹ��ﳵ�����ڣ������������빺�ﳵ
	public void addToShopcart(UserBook userBook) throws Exception;
	
	//�����������ڹ��ﳵ�д��ڣ�������1
	public void addCountOfBook(UserBook userBook) throws Exception;
	//�鿴���ﳵ
	public User findShopCart(Integer userid) throws Exception;
	
	//��Ʒ����-1
	public void bookSubOne(UserBook userBook) throws Exception;
	
	//��ѯ���ﳵ�Ƿ��д���,���ش���ĸ���
	public int isInShopcart(UserBook userBook) throws Exception;
	
	//�鿴ĳ���������
	public int countOfBook(UserBook userBook) throws Exception;
	
	//��յ�ǰ�û��Ĺ��ﳵ
	public void clearShopCart(int userid) throws Exception;
	
	//�ӹ��ﳵ��ɾ����Ʒ������user_id��book_id)
	public void deleteBook(UserBook userBook) throws Exception;
}
