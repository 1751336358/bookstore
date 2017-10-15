package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.pojo.Item;

public interface ItemMapper {
	//����userId��bookIdɾ���ӹ��ﳵ���ύ�������� 
	public void deleteShop(Item item) throws Exception;
	
	//���ӹ��ﳵ�ύ����Ʒд��Item��
	public void addItem(Item item) throws Exception;
	
	// ����userid��ѯ�ҵĶ���
	public List<Item> getMyItemsById(int userid) throws Exception;
}
