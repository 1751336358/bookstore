package cn.itcast.ssm.pojo;

import java.io.Serializable;



public class Book implements Serializable{	//�����л�����������
	private Integer id;	//��id
	private String bookName;	//����
	private String author;	//����
	private double price;	//�۸�
	private String descripse;	//����
	private Shopcart shopCart;	//���������
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescripse() {
		return descripse;
	}
	public void setDescripse(String descripse) {
		this.descripse = descripse;
	}
	public Shopcart getShopCart() {
		return shopCart;
	}
	public void setShopCart(Shopcart shopCart) {
		this.shopCart = shopCart;
	}
	
}
