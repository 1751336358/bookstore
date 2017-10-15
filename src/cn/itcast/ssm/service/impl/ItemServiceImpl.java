package cn.itcast.ssm.service.impl;


import java.util.List;

import cn.itcast.ssm.dao.BookDao;
import cn.itcast.ssm.dao.ItemDao;
import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.pojo.Item;
import cn.itcast.ssm.service.BookService;
import cn.itcast.ssm.service.ItemService;

public class ItemServiceImpl implements ItemService {
	private ItemDao itemdao;//ע��
	
	// ����userId��bookIdɾ���ӹ��ﳵ���ύ��������
	@Override
	public void deleteShop(Item item) throws Exception {
		itemdao.deleteShop(item);
		
	}
	//���ӹ��ﳵ�ύ����Ʒд��Item��
	@Override
	public void addItem(Item item) throws Exception {
		itemdao.addItem(item);
		
	}

	//����userid��ѯ�ҵĶ���
	@Override
	public List<Item> getMyItemsById(int userid) throws Exception {
		// TODO Auto-generated method stub
		return itemdao.getMyItemsById(userid);
	}
	
	
	public ItemDao getItemdao() {
		return itemdao;
	}

	public void setItemdao(ItemDao itemdao) {
		this.itemdao = itemdao;
	}
}
