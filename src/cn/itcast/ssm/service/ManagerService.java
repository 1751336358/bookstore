package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.pojo.Item;

public interface ManagerService {
	//��̨����Ա�鿴���еĶ������ƶ����ķ���״̬
	public List<Item> getAllItem()throws Exception;
	
	//�ı䷢����״̬
	public void chstatus(Item item) throws Exception;
}
