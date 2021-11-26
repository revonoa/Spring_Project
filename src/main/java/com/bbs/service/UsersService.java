package com.bbs.service;

import com.bbs.dao.Authmail;

//service를 구성할 interface 표준 설계 작성
public interface UsersService {
	
	public int idCheck(String user_id) throws Exception;
	public int setAuthnum(String user_mail) throws Exception;
	public int checkAuthnum(Authmail authmail) throws Exception;
	
	

}
