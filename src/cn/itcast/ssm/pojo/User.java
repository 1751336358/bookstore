package cn.itcast.ssm.pojo;

import java.util.List;

public class User {
	private Integer id;	//�û�id
	private String username;	//�û���
	private String password;	//�û�����
	private List<Book> bookList;	//��ѯ���ﳵ��1��n
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
}
