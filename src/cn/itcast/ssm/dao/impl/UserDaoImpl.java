package cn.itcast.ssm.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.ssm.dao.BookDao;
import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.mapper.BookMapper;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.Book;
import cn.itcast.ssm.pojo.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	//�û�ע��ʱ����û����Ƿ����
	@Override
	public List<User> findUserByUsername(User u) throws Exception {
		
		return this.getSqlSession().getMapper(UserMapper.class).findUserByUsername(u);
	}
	
	//�û���¼ʱ�ж��û����û�������������ȷ
	@Override
	public User findUsernameAndPassword(User u) throws Exception {
		
		return this.getSqlSession().getMapper(UserMapper.class).findUsernameAndPassword(u);
	}
	
	//����ע����û�����ӵ����ݿ�
	@Override
	public void insertUser(User u) throws Exception {
		this.getSqlSession().getMapper(UserMapper.class).insertUser(u);
		
	}

	
	
}
