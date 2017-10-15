package cn.itcast.ssm.controller;


//ʹ��ע�⿪����������Ҫ����İ�
import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.service.BookService;

@Controller
public class BookController01{
	private BookService bookService;
	
	//����id����ͼ��
	@RequestMapping("/findBookByName.action")
	public ModelAndView findBookByName(String bookName) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		if(bookName == null || bookName.equals("")){//���û����������
			
			modelAndView.setViewName("/WEB-INF/jsp/booklistempty.jsp");
			return modelAndView;
		}	
			
		List<Book> bookList = bookService.findBookByName(bookName);
		
		if(bookList.size() > 0){	//����鵽��ͼ��
			modelAndView.addObject("bookList",bookList);
			modelAndView.setViewName("/WEB-INF/jsp/bookdescripse.jsp");
		}else{	//���û�в鵽ͼ��
			modelAndView.addObject("bookName",bookName);
			modelAndView.setViewName("/WEB-INF/jsp/booklistempty.jsp");
		}
		
		return modelAndView;
	}
	
	//�������е�ͼ��
	@RequestMapping("/getAllBook.action")
	public ModelAndView getAllBook() throws Exception{
		List<Book> bookList = bookService.getAllBook();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("bookList", bookList);
		modelAndView.setViewName("/WEB-INF/jsp/booklist.jsp");
			
		return modelAndView;
	}

	public BookService getBookService() {
		return bookService;
	}


	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	
}
