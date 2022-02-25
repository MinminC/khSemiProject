package com.kh.ticket.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.PageInfo;
import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;
import com.kh.movie.model.vo.Picture;
import com.kh.ticket.model.service.TicketService;
import com.kh.ticket.model.vo.Ticket;

/**
 * Servlet implementation class reserveTicketController
 */
@WebServlet("/list.ti")
public class reserveViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reserveViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원번호 받아오기
		// int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int memberNo = 2;
		
		// --- 페이징 처리 ---
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		// * listCount : 총 게시글 갯수
		listCount = new TicketService().selectListCount(memberNo);
				
		// * currentPage : 현재페이지(== 사용자가 요청한 페이지)
		currentPage = Integer.parseInt(request.getParameter("currentPage")); // : String
				
		// * pageLimit : 페이징바의 최대 갯수
		pageLimit = 10;
				
		// * boardLimit : 한 페이지에 보여질 게시글의 최대 갯수
		boardLimit = 2;
		
		PageInfo pi = new PageInfo().calcPageInfo(listCount, currentPage, pageLimit, boardLimit);

		ArrayList<Ticket> rList = new TicketService().selectTicketList(pi, memberNo);
		ArrayList<Ticket> cList = new TicketService().selectCancleList(memberNo);
		
		// 해당 영화 번호 추출
		ArrayList<Integer> currentNoList = new ArrayList<>();
		for(Ticket t : rList)
			currentNoList.add(t.getmNo());
		//추출된 번호로 포스터 조회해오기
		ArrayList<Picture> currentPicList = new MovieService().selectPosterList(currentNoList);
		
		// date 포맷 변경
		SimpleDateFormat inputFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		SimpleDateFormat inputFormat2 = new SimpleDateFormat("yyyy/MM/dd");		
		SimpleDateFormat outputFormat1 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
		SimpleDateFormat outputFormat2 = new SimpleDateFormat("yyyy/MM/dd");
		// 예매 리스트
		for(Ticket t : rList) {
			// 상영시간 포맷 바꾸기
			String runSch = null;
			Date runDate = null;
			try {
				runDate = inputFormat1.parse(t.getRunSch());
				runSch = outputFormat1.format(runDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			t.setRunSch(runSch);
			
			// 결제 취소일 계산하기
			Calendar cal = Calendar.getInstance();
			String cancleDate = null;
			Date payDate = null;
			try {
				payDate = inputFormat2.parse(t.getPayDate());
				cal.setTime(payDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cal.add(Calendar.DATE, 7);
			// 상영일이 7일 전이라면 상영일 전날까지 취소 가능
			if(cal.getTime().after(runDate)) {
				cal.setTime(runDate);
				cal.add(Calendar.DATE, -1);
				cancleDate = outputFormat2.format(cal.getTime());
			}
			cancleDate = outputFormat2.format(cal.getTime());
			t.setCancleDate(cancleDate);
			
			// 상세페이지 상영시간 자르기
			SimpleDateFormat format3 = new SimpleDateFormat("MM월 dd일 (E)");
			SimpleDateFormat format4 = new SimpleDateFormat("HH:mm");
			String runDay = format3.format(runDate);
			t.setRunDay(runDay);
			String runTime = format4.format(runDate);
			t.setRunTime(runTime);
			// 디데이 구하기
			cal.setTime(runDate); // 상영일
			Calendar today = Calendar.getInstance();
			today.setTime(new Date()); // 오늘
			long iRunDate = cal.getTimeInMillis() / (24*60*60*1000);
			long iToday = today.getTimeInMillis() / (24*60*60*1000);
			long Dday = iRunDate - iToday;
			if(Dday >= 0) {
				t.setDday("D - " + Dday);
			} else {
				t.setDday("D + " + Math.abs(Dday));
			}
			// 종료시간 구하기
			String endTime = null;
			cal.setTime(runDate); // 상영일
			cal.add(Calendar.MINUTE, t.getrTime());
			endTime = format4.format(cal.getTime());
			t.setEndTime(endTime);
		}
		
		for(Ticket t : cList) {
			// 결제금액 ,찍기
			DecimalFormat decFormat = new DecimalFormat("###,###");
			String price = decFormat.format(Double.valueOf(t.getPayment()));
			t.setPayment(price);
		}
		
		request.setAttribute("rList", rList);
		request.setAttribute("cList", cList);
		request.setAttribute("pi", pi);
		request.setAttribute("currentPicList", currentPicList);
		request.getRequestDispatcher("/views/user/mypage/reserveTicketListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
