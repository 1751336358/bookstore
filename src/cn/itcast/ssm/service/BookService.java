package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.pojo.Book;

public interface BookService {
	//����bookname����ͼ�飬����ͼ�����Ϣ
	public List<Book> findBookByName(String bookName) throws Exception;
	
	//�õ����е�ͼ��
	public List<Book> getAllBook() throws Exception;
}
