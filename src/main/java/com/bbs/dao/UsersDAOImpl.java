package com.bbs.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDAOImpl implements UsersDAO {
	
	@Inject
	SqlSession sqlSession;
	
	final String SESSION = "com.bbs.mappers.bbs";

	@Override
	public String idCheck(String user_id) throws Exception {
		// TODO Auto-generated method stub
	
		return sqlSession.selectOne(SESSION+".idCheck",user_id);
	}

	
	@Override
	public Integer getAuthnum(String user_mail) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(SESSION+".getAuthnum", user_mail);
	}



	@Override
	public void setAuthnum(Authmail authmail) throws Exception {
		sqlSession.insert(SESSION + ".setAuthnum", authmail);
	}
	
	
	@Override
	public void resetAuthnum(Authmail authmail) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(SESSION+".resetAuthnum", authmail);
		
	}


}
