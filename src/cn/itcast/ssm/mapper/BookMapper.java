package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.pojo.Book;

public interface BookMapper {
	//����ͼ���id��ѯͼ�����Ϣ
	public List<Book> findBookByName(String bookName) throws Exception;
	
	//�õ����е�ͼ��
	public List<Book> getAllBook() throws Exception;
}
