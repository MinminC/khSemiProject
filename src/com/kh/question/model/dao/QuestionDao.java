package com.kh.question.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.kh.common.model.vo.PageInfo;
import com.kh.question.model.vo.Q_Attachment;
import com.kh.question.model.vo.Question;

public class QuestionDao {

	private Properties prop = new Properties();
	
	public QuestionDao() {
		String fileName = QuestionDao.class.getResource("/sql/question/question-mapper.xml").getPath();
	
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Question> selectQuestionList(Connection conn, int memberNo) {
		ArrayList<Question> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectQ-list");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Question q = new Question(rset.getInt("ASK_NO"),
										  rset.getString("ASK_DATE"),
										  rset.getInt("ASK_TYPE"),
										  rset.getString("ASK_TITLE"),
										  rset.getString("COMMENT_DATE"),
										  rset.getInt("MEMBER_NO")
										 );
				list.add(q);		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public Question selectQuestionDetail(Connection conn, int questionNo) {
		Question q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectQ");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, questionNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				q = new Question(questionNo,
								 rset.getString("ASK_DATE"),
						  		 rset.getInt("ASK_TYPE"),
						  		 rset.getString("ASK_TITLE"),
						  		 rset.getString("ASK_CONTENT"),
						  		 rset.getString("COMMENT_DATE"),
						  		 rset.getString("ASK_COMMENT"),
						  		 rset.getInt("MEMBER_NO")
						 );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return q;
	}

	public int insertQuestion(Connection conn, Question q) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertQuestion");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, q.getAskTypeNo());
			pstmt.setString(2, q.getAskTitle());
			pstmt.setString(3, q.getAskContent());
			pstmt.setInt(4, q.getMemberNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertQAttachment(Connection conn, Q_Attachment at) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertQAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Q_Attachment selectQAttachment(Connection conn, int questionNo) {
		Q_Attachment Qat = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectQAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, questionNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				Qat = new Q_Attachment(rset.getInt("FILE_NO"),
									   rset.getString("ORIGIN_NAME"),
									   rset.getString("CHANGE_NAME"),
									   rset.getString("FILE_PATH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return Qat;
	}

	public ArrayList<Question> questionListAll(Connection conn, PageInfo pi) {
		ArrayList<Question> qlist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("questionListAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();
			while(rset.next()) {
				Question q = new Question(rset.getInt("ASK_NO"),
										  rset.getString("ASK_DATE"),
										  rset.getString("ASK_TITLE"),
										  rset.getString("ASK_COMMENT"),
										  rset.getString("MEMBER_ID"));
				qlist.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return qlist;
	}

	public int selectListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	public int addComment(Connection conn, int qno, String comment) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("addComment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment);
			pstmt.setInt(2, qno);
			System.out.println(qno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
