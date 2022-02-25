package com.kh.vote.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.model.vo.PageInfo;
import com.kh.vote.model.vo.Vote;
import com.kh.vote.model.vo.VoteList;
import com.kh.vote.model.vo.VoteResult;

public class VoteDao {

	private Properties prop = new Properties();

	public VoteDao() {

		String fileName = VoteDao.class.getResource("/sql/vote/vote-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// V.VOTE_NO, V.VOTE_TITLE, VR.VRE_FILEPATH, COUNT, V.S_DATE, V.E_DATE,
	// VR.VRE_TITLE, VR.VRE_GENRE, VR.VRE_SYNOPSIS
	public int selectListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt("COUNT"); // 13
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public ArrayList<VoteList> selectList(Connection conn, PageInfo pi) {
		ArrayList<VoteList> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectList");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {

				VoteList vl = new VoteList();
				vl.setVoteNo(rset.getInt("VOTE_NO"));
				vl.setVoteTitle(rset.getString("VOTE_TITLE"));
				vl.setVreFilePath(rset.getString("VRE_FILEPATH"));

				list.add(vl);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int voteInsert(Connection conn, Vote v) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("voteInsert");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, v.getVoteTitle());
			pstmt.setDate(2, v.getsDate());
			pstmt.setDate(3, v.geteDate());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int voteResultInsert(Connection conn, ArrayList<VoteResult> list) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("voteResultInsert");

		try {
			pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < 4; i++) {

				pstmt.setString(1, list.get(i).getVreTitle());
				pstmt.setString(2, list.get(i).getVreGenre());
				pstmt.setString(3, list.get(i).getVreSynopsis());
				pstmt.setString(4, list.get(i).getVreFilePath());

				result += pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<VoteList> pastVoteAll(Connection conn) {

		ArrayList<VoteList> list = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("pastVoteAll");
		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();
			// VOTE_NO, VOTE_TITLE, S_DATE
			while (rset.next()) {

				list.add(new VoteList(rset.getInt("VOTE_NO"), rset.getDate("S_DATE"), rset.getDate("E_DATE"), rset.getString("VOTE_TITLE")));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<VoteList> voting(Connection conn) {
		ArrayList<VoteList> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("voting");
		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();
			// V.VOTE_NO, V.VOTE_TITLE, VR.VRE_FILEPATH, COUNT, V.S_DATE, V.E_DATE,
			// VR.VRE_TITLE, VR.VRE_GENRE, VR.VRE_SYNOPSIS
			while (rset.next()) {

				VoteList vl = new VoteList();
				vl.setVoteNo(rset.getInt("VOTE_NO"));
				vl.setVreNo(rset.getInt("VRE_NO"));
				vl.setVoteTitle(rset.getString("VOTE_TITLE"));
				vl.setVreFilePath(rset.getString("VRE_FILEPATH"));
				vl.setCount(rset.getInt("COUNT"));
				vl.setsDate(rset.getDate("S_DATE"));
				vl.seteDate(rset.getDate("E_DATE"));
				vl.setVreTitle(rset.getString("VRE_TITLE"));
				vl.setVreGenre(rset.getString("VRE_GENRE"));
				vl.setVreSynopsis(rset.getString("VRE_SYNOPSIS"));

				list.add(vl);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int countUpdate(Connection conn, int vreNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("countUpdate");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vreNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int userVote(Connection conn, int vreNo, int memberNo) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("userVote");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vreNo);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int selectVotingMember(Connection conn, int memberNo) {

		int vreNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectVotingMember");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				vreNo = rset.getInt("VRE_NO");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vreNo;
	}

	public ArrayList<VoteList> selectVote(Connection conn, int voteNo) {
		ArrayList<VoteList> list = new ArrayList<VoteList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectVote");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, voteNo);
			rset = pstmt.executeQuery();
			// V.VOTE_NO, V.VOTE_TITLE, VR.VRE_FILEPATH, COUNT, V.S_DATE, V.E_DATE,
			// VR.VRE_TITLE, VR.VRE_GENRE, VR.VRE_SYNOPSIS
			while (rset.next()) {

				VoteList vl = new VoteList();
				vl.setVoteNo(rset.getInt("VOTE_NO"));
				vl.setVreNo(rset.getInt("VRE_NO"));
				vl.setVoteTitle(rset.getString("VOTE_TITLE"));
				vl.setVreFilePath(rset.getString("VRE_FILEPATH"));
				vl.setCount(rset.getInt("COUNT"));
				vl.setsDate(rset.getDate("S_DATE"));
				vl.seteDate(rset.getDate("E_DATE"));
				vl.setVreTitle(rset.getString("VRE_TITLE"));
				vl.setVreGenre(rset.getString("VRE_GENRE"));
				vl.setVreSynopsis(rset.getString("VRE_SYNOPSIS"));
				list.add(vl);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<VoteList> selectVoting(Connection conn) {
		ArrayList<VoteList> list = new ArrayList<VoteList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectVoting");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			// V.VOTE_NO, V.VOTE_TITLE, VR.VRE_FILEPATH, COUNT, V.S_DATE, V.E_DATE,
			// VR.VRE_TITLE, VR.VRE_GENRE, VR.VRE_SYNOPSIS
			while (rset.next()) {

				VoteList vl = new VoteList();
				vl.setVoteNo(rset.getInt("VOTE_NO"));
				vl.setVreNo(rset.getInt("VRE_NO"));
				vl.setVoteTitle(rset.getString("VOTE_TITLE"));
				vl.setVreFilePath(rset.getString("VRE_FILEPATH"));
				vl.setCount(rset.getInt("COUNT"));
				vl.setsDate(rset.getDate("S_DATE"));
				vl.seteDate(rset.getDate("E_DATE"));
				vl.setVreTitle(rset.getString("VRE_TITLE"));
				vl.setVreGenre(rset.getString("VRE_GENRE"));
				vl.setVreSynopsis(rset.getString("VRE_SYNOPSIS"));
				list.add(vl);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int voteUpdate(Connection conn, Vote v) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("voteUpdate");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, v.getVoteTitle());
			pstmt.setDate(2, v.getsDate());
			pstmt.setDate(3, v.geteDate());
			pstmt.setInt(4, v.getVoteNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int voteResultUpdate(Connection conn, ArrayList<VoteResult> list) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("voteResultUpdate");

		try {
			pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < 4; i++) {

				pstmt.setString(1, list.get(i).getVreTitle());
				pstmt.setString(2, list.get(i).getVreGenre());
				pstmt.setString(3, list.get(i).getVreSynopsis());
				pstmt.setString(4, list.get(i).getVreFilePath());
				pstmt.setInt(5, list.get(i).getVreNo());

				result += pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
