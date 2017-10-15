package cn.itcast.ssm.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.ssm.dao.ItemDao;
import cn.itcast.ssm.mapper.ItemMapper;
import cn.itcast.ssm.pojo.Item;

public class ItemDaoImpl extends SqlSessionDaoSupport implements ItemDao{
	
	//����userId��bookIdɾ���ӹ��ﳵ���ύ��������
	@Override
	public void deleteShop(Item item) throws Exception {
		this.getSqlSession().getMapper(ItemMapper.class).deleteShop(item);
		
	}

	//���ӹ��ﳵ�ύ����Ʒд��Item��
	@Override
	public void addItem(Item item) throws Exception {
		
		this.getSqlSession().getMapper(ItemMapper.class).addItem(item);
	}
	
	//����userid��ѯ�ҵĶ���
	@Override
	public List<Item> getMyItemsById(int userid) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSession().getMapper(ItemMapper.class).getMyItemsById(userid);
	}
}
