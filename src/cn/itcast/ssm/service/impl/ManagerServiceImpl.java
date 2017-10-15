package cn.itcast.ssm.service.impl;


import java.util.List;

import cn.itcast.ssm.dao.ManagerDao;
import cn.itcast.ssm.pojo.Item;
import cn.itcast.ssm.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerdao;//ע��
	
	//��̨����Ա�鿴���еĶ������ƶ����ķ���״̬
	@Override
	public List<Item> getAllItem() throws Exception {
		// TODO Auto-generated method stub
		return managerdao.getAllItem();
	}

	//�ı䷢����״̬
	@Override
	public void chstatus(Item item) throws Exception {
		managerdao.chstatus(item);
		
	}
	
	public ManagerDao getManagerdao() {
		return managerdao;
	}

	public void setManagerdao(ManagerDao managerdao) {
		this.managerdao = managerdao;
	}
	
}
