package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.pojo.Item;

public interface ManagerMapper {
	//��̨����Ա�鿴���еĶ������ƶ����ķ���״̬
	public List<Item> getAllItem()throws Exception;
	
	//�ı䷢����״̬
	public void chstatus(Item item) throws Exception;
}
