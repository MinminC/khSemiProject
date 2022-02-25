package com.kh.vote.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.PageInfo;
import com.kh.vote.model.dao.VoteDao;
import com.kh.vote.model.vo.Vote;
import com.kh.vote.model.vo.VoteList;
import com.kh.vote.model.vo.VoteResult;

public class VoteService {

	public int selectListCount() {

		Connection conn = getConnection();

		int listCount = new VoteDao().selectListCount(conn);

		close(conn);

		return listCount;
	}

	public ArrayList<VoteList> selectList(PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<VoteList> list = new VoteDao().selectList(conn, pi);

		close(conn);

		return list;
	}

	public int voteInsert(Vote v, ArrayList<VoteResult> list) {

		Connection conn = getConnection();

		int result1 = new VoteDao().voteInsert(conn, v);
		
		if(result1 >0) {
			int result2 = new VoteDao().voteResultInsert(conn, list);
			if (result2 > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			close(conn);
			return result2;
		}else {
			return result1;
		}
	}

	public ArrayList<VoteList> pastVoteAll() {
		
		Connection conn = getConnection();

		ArrayList<VoteList> list = new VoteDao().pastVoteAll(conn);
		
		close(conn);
		
		return list;
		
	}

	public ArrayList<VoteList> voting() {
		
		Connection conn = getConnection();
		ArrayList<VoteList> list = new VoteDao().voting(conn);
		close(conn);
		
		return list;
	}

	public int countUpdate(int vreNo, int memberNo) {
		Connection conn = getConnection();
		
		int result1 = new VoteDao().countUpdate(conn, vreNo);
		int result2 = new VoteDao().userVote(conn, vreNo, memberNo);
		if(result1*result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result1*result2;
	}

	public int selectVotingMember(int memberNo) {
		
		Connection conn = getConnection();
		int vreNo = new VoteDao().selectVotingMember(conn, memberNo);
		
		close(conn);
		return vreNo;
	}

	public ArrayList<VoteList> selectVote(int voteNo) {
		Connection conn = getConnection();
		ArrayList<VoteList> list = new VoteDao().selectVote(conn, voteNo);
		close(conn);
		
		return list;
	}

	public ArrayList<VoteList> selectVoting() {
		Connection conn = getConnection();
		ArrayList<VoteList> list = new VoteDao().selectVoting(conn);
		close(conn);
		
		return list;
	}

	public int voteUpdate(Vote v, ArrayList<VoteResult> list) {
		Connection conn = getConnection();

		int result1 = new VoteDao().voteUpdate(conn, v);
		
		if(result1 >0) {
			int result2 = new VoteDao().voteResultUpdate(conn, list);
			if (result2 > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			close(conn);
			return result2;
		}else {
			return result1;
		}
	}


}
