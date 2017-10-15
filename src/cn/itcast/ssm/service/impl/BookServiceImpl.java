package cn.itcast.ssm.service.impl;


import java.util.List;

import cn.itcast.ssm.dao.BookDao;
import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao bookdao;//ע��

	//����bookName����ͼ�����Ϣ
	@Override
	public List<Book> findBookByName(String bookName) throws Exception {
		
		return bookdao.findBookByName(bookName);
	}
	
	//�������е�ͼ��
	@Override
	public List<Book> getAllBook() throws Exception {
		// TODO Auto-generated method stub
		return bookdao.getAllBook();
	}
	
	public BookDao getBookdao() {
		return bookdao;
	}

	public void setBookdao(BookDao bookdao) {
		this.bookdao = bookdao;
	}

	

}
