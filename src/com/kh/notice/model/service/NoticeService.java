package com.kh.notice.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Category;
import com.kh.notice.model.vo.Notice;

public class NoticeService {

	public int countNotice(String tableType) {
		Connection conn = getConnection();

		int count = new NoticeDao().countNotice(conn, tableType);

		close(conn);

		return count;
	}

	public int countCategory(int category) {
		Connection conn = getConnection();

		int count = new NoticeDao().countCategory(conn, category);

		close(conn);

		return count;
	}

	public ArrayList<Notice> selectNoticeList(int startRow, int endRow) {
		Connection conn = getConnection();

		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn, startRow, endRow);

		close(conn);

		return list;
	}

	public int countKeywordNotice(String type, String keyword) {
		Connection conn = getConnection();

		int count = new NoticeDao().countKeywordNotice(conn, type, keyword);

		close(conn);

		return count;
	}

	public ArrayList<Notice> searchNoticeList(String pageType, String keyword, int startRow, int endRow) {
		Connection conn = getConnection();

		ArrayList<Notice> list = new NoticeDao().searchNoticeList(conn, pageType, keyword, startRow, endRow);

		close(conn);

		return list;
	}

	public int increaseNoticeViews(int noticeNo) {
		Connection conn = getConnection();

		int views = new NoticeDao().increaseNoticeViews(conn, noticeNo);

		if (views > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return views;
	}

	public Notice selectNotice(int noticeNo, String tableType) {
		Connection conn = getConnection();

		Notice n = new NoticeDao().selectNotice(conn, noticeNo, tableType);

		close(conn);

		return n;
	}

	public ArrayList<Notice> selectFAQList(int category, int startRow, int endRow) {
		Connection conn = getConnection();

		ArrayList<Notice> list = new NoticeDao().searchFAQList(conn, category, startRow, endRow);

		close(conn);

		return list;
	}

	public ArrayList<Notice> selectNoticeAdminList(String tableType, int startRow, int endRow) {
		Connection conn = getConnection();

		ArrayList<Notice> list = new NoticeDao().selectNoticeAdminList(conn, tableType, startRow, endRow);

		close(conn);

		return list;
	}

	public ArrayList<Category> selectCategory(String tableType) {
		Connection conn = getConnection();

		ArrayList<Category> list = new ArrayList<>();
		if (tableType.equals("notice")) {
			list = new NoticeDao().selectNoticeCategory(conn);
		} else {
			list = new NoticeDao().selectFAQCategory(conn);
		}

		close(conn);

		return list;
	}

	public ArrayList<Notice> searchNoticeAdminList(String pageType, String keyword, int startRow, int endRow) {
		Connection conn = getConnection();

		ArrayList<Notice> list = new NoticeDao().searchNoticeAdminList(conn, pageType, keyword, startRow, endRow);

		close(conn);

		return list;
	}

	public int deleteNotice(String[] deleteList) {
		Connection conn = getConnection();
		int result = 0;
		int rows = new NoticeDao().deleteNotice(conn, deleteList);

		if (rows == deleteList.length) {
			commit(conn);
			result = 1;
		} else
			rollback(conn);

		return result;
	}

	public int insertNotice(Notice n) {
		Connection conn = getConnection();

		int result = new NoticeDao().insertNotice(conn, n);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;
	}

	public int updateNotice(Notice n) {
		Connection conn = getConnection();

		int result = new NoticeDao().updateNotice(conn, n);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;
	}

	/**
	 * Main Page에 들어가는 한줄 선택 구문
	 * @param noticeMain
	 * @return
	 */
	public Notice MainNotice(String noticeMain) {
		
		Connection conn = getConnection();
		
		Notice mainList = new NoticeDao().MainNotice(conn, noticeMain);
		
		close(conn);
		
		return mainList;
		
	}
}
