package cn.itcast.ssm.dao;

import java.util.List;

import cn.itcast.ssm.pojo.Item;

public interface ManagerDao {
	//��̨����Ա�鿴���еĶ������ƶ����ķ���״̬
	public List<Item> getAllItem()throws Exception;
	
	//�ı䷢����״̬
	public void chstatus(Item item) throws Exception;
}
