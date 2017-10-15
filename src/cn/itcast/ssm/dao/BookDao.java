package cn.itcast.ssm.dao;

import java.util.List;

import cn.itcast.ssm.pojo.Book;

public interface BookDao {
	//����ͼ���id��ѯͼ�����Ϣ
	public List<Book> findBookByName(String bookName) throws Exception;
	
	//�õ����е�ͼ��
	public List<Book> getAllBook() throws Exception;
}
