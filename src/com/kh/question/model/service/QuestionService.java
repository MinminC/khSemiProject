package com.kh.question.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.PageInfo;
import com.kh.question.model.dao.QuestionDao;
import com.kh.question.model.vo.Q_Attachment;
import com.kh.question.model.vo.Question;

public class QuestionService {

	public ArrayList<Question> selectQuestionList(int memberNo) {
		Connection conn = getConnection();

		ArrayList<Question> list = new QuestionDao().selectQuestionList(conn, memberNo);
		
		close(conn);
		
		return list;
	}

	public Question selectQuestionDetail(int questionNo) {
		Connection conn = getConnection();
		
		Question Qdetail = new QuestionDao().selectQuestionDetail(conn, questionNo);
		
		close(conn);
		
		return Qdetail;
	}

	public int insertQuestion(Question q, Q_Attachment at) {
		Connection conn = getConnection();
		
		int result1 = new QuestionDao().insertQuestion(conn, q);
		int result2 = 1;
		
		if(at != null) {
			result2 = new QuestionDao().insertQAttachment(conn, at);
		}
		
		if((result1 * result2) > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return (result1 * result2);
	}

	public Q_Attachment selectQAttachment(int questionNo) {
		Connection conn = getConnection();
		
		Q_Attachment Qat = new QuestionDao().selectQAttachment(conn, questionNo);
		
		close(conn);
		
		return Qat;
	}

	public ArrayList<Question> questionlistAll(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Question> qlist = new QuestionDao().questionListAll(conn, pi);
		
		close(conn);
		
		return qlist;
	}

	public int selectListCount() {
		Connection conn = getConnection();
		
		int listCount = new QuestionDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public int addComment(int qno, String comment) {
		Connection conn = getConnection();
		
		int result = new QuestionDao().addComment(conn, qno, comment);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

}
