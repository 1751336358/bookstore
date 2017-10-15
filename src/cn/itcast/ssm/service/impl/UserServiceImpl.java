package cn.itcast.ssm.service.impl;


import java.util.List;

import cn.itcast.ssm.dao.BookDao;
import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.service.BookService;
import cn.itcast.ssm.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userdao;//ע��
	
	//�û�ע��ʱ����û����Ƿ����
	@Override
	public List<User> findUserByUsername(User u) throws Exception {
		
		return userdao.findUserByUsername(u);
	}
	
	//�û���¼ʱ�ж��û����û�������������ȷ
	@Override
	public User findUsernameAndPassword(User u) throws Exception {
		
		return userdao.findUsernameAndPassword(u);
	}
	
	//����ע����û�����ӵ����ݿ�
	@Override
	public void insertUser(User u) throws Exception {
		userdao.insertUser(u);
		
	}

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	

	

}
