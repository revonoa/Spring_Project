package com.bbs.service;

import com.bbs.dao.Authmail;

//service�� ������ interface ǥ�� ���� �ۼ�
public interface UsersService {
	
	public int idCheck(String user_id) throws Exception;
	public int setAuthnum(String user_mail) throws Exception;
	public int checkAuthnum(Authmail authmail) throws Exception;
	
	

}
