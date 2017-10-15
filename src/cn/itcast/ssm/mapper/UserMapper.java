package cn.itcast.ssm.mapper;

import java.util.List;
import cn.itcast.ssm.pojo.User;

public interface UserMapper {
	//�û�ע��ʱ����û����Ƿ����
	public List<User> findUserByUsername(User u) throws Exception;
	
	//����ע����û�����ӵ����ݿ�
	public void insertUser(User u) throws Exception;
	
	//�û���¼ʱ�ж��û����û�������������ȷ
	public User findUsernameAndPassword(User u) throws Exception;
}
