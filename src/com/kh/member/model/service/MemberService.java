package com.kh.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

import static com.kh.common.JDBCTemplate.*;

public class MemberService {

	public int idCheck(String memberId) {

		Connection conn = getConnection();

		int result = new MemberDao().idCheck(conn, memberId);

		close(conn);

		return result;
	}

	public int emailCheck(String email) {
		Connection conn = getConnection();

		int result = new MemberDao().emailCheck(conn, email);

		close(conn);

		return result;
	}

	public int memberInsert(Member m) {
		Connection conn = getConnection();

		int result = new MemberDao().memberInsert(conn, m);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

	public ArrayList<Member> memberList(String keyword, PageInfo pi) {
		Connection conn = getConnection();

		ArrayList<Member> list = new MemberDao().memberList(conn, keyword, pi);

		close(conn);

		return list;
	}

	public Member adminDetail(int memberNo) {

		Connection conn = getConnection();
		Member m = new MemberDao().adminDetail(conn, memberNo);

		close(conn);

		return m;
	}

	public int memberListCount(String keyword) {
		Connection conn = getConnection();
		int result = new MemberDao().memberListCount(conn, keyword);

		close(conn);
		return result;
	}

	public int adminMemberUpdate(Member m) {

		Connection conn = getConnection();

		int result = new MemberDao().adminMemberUpdate(conn, m);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int memberDelete(int memberNo) {

		Connection conn = getConnection();
		int result = new MemberDao().memberDelete(conn, memberNo);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int MemberRemove(int memberNo) {
		Connection conn = getConnection();
		int result = new MemberDao().MemberRemove(conn, memberNo);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public Member memberDetail(int memberNo) {
		Connection conn = getConnection();
		
		Member m = new MemberDao().memberDetail(conn, memberNo);
		
		close(conn);
		
		return m;
	}

	public int memberUpdate(Member m) {
		
		Connection conn = getConnection();
		int result = new MemberDao().memberUpdate(conn, m);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
		
	}
	public int deleteMember(int memberNo, String pwdSHA) {
		Connection conn = getConnection();
		int result = new MemberDao().deleteMember(conn, memberNo, pwdSHA);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
		
	}

}
