package cn.itcast.ssm.pojo;

//������
public class Item {
	private int userId;	//�û�id
	private int bookId;	//��id
	private String bookName;
	private int bookNum;	//�������
	private double bookPrice;	//��ļ�Ǯ
	private int status;	//������״̬��1������0��������
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getBookNum() {
		return bookNum;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
}
