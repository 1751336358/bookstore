package cn.itcast.ssm.pojo;

// ���ﳵ��
public class Shopcart {
	private Integer userId;	//�û�id
	private Integer bookId;	//��id
	private Integer bookNumber;	//�������
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(Integer bookNumber) {
		this.bookNumber = bookNumber;
	}	
	
}
