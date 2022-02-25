package com.kh.loginLogout.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.loginLogout.model.dao.LoginDao;
import com.kh.member.model.vo.Member;

public class LoginService {

	public Member selectMember(String memberId, String changedPwd) {
		
		Connection conn = getConnection();
		
		Member m = new LoginDao().selectMember(conn, memberId, changedPwd);
		
		close(conn);
		
		return m;
	}

	public Member searchId(Member m) {
		
		Connection conn = getConnection();
		
		Member searchMem = new LoginDao().searchId(conn, m);
		
		close(conn);
		
		return searchMem;
	}

	public Member searchPwd(String memberId) {

		Connection conn = getConnection();
		
		Member searchMem = new LoginDao().searchPwd(conn, memberId);
		
		close(conn);
		
		return searchMem;
	}

	public Member pwdCertify(String memberId, String email) {

		Connection conn = getConnection();
		
		Member searchMem = new LoginDao().pwdCertify(conn, memberId, email);
		
		close(conn);
		
		return searchMem;
	}

	public int updateImsyPwd(String memberId, String changedPwd) { 
		
		Connection conn = getConnection();
		
		int result = new LoginDao().updateImsyPwd(conn, memberId, changedPwd);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
