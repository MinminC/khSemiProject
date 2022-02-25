package com.kh.theater.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.theater.model.service.TheaterService;
import com.kh.theater.model.vo.TheaterAuditorium;

/**
 * Servlet implementation class AMovieTheaterUpdateController
 */
@WebServlet("/atUpdate.th")
public class AMovieTheaterUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AMovieTheaterUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int theaterNo = Integer.parseInt(request.getParameter("theaterNo"));
		int auditoriumNo = Integer.parseInt(request.getParameter("auditoriumNo"));
		String theaterName = request.getParameter("theaterName");
		String address = request.getParameter("address");
		int auditoriumNum = Integer.parseInt(request.getParameter("auditoriumNum"));
		String phone = request.getParameter("phone");
		int seatNum = Integer.parseInt(request.getParameter("seatNum"));
		int theaterImg = Integer.parseInt(request.getParameter("theaterImg"));
		String[] auditoriumNameArr = request.getParameterValues(("auditoriumName"));
		String[] auditoriumSeatNumArr = request.getParameterValues("auditoriumSeatNum");
		String location = request.getParameter("location");
		String traffic = request.getParameter("traffic");
		String parking = request.getParameter("parking");
		
		String auditoriumName = "";
		String auditoriumSeatNum = "";
		
		if(auditoriumNameArr != null) {
			auditoriumName = String.join(",", auditoriumNameArr);
		}
		
		if(auditoriumSeatNumArr != null) {
			auditoriumSeatNum = String.join(",", auditoriumSeatNumArr);
		}

		TheaterAuditorium ta = new TheaterAuditorium();
		
		ta.setTheaterNo(theaterNo);
		ta.setAuditoriumNo(auditoriumNo);
		ta.setTheaterName(theaterName);
		ta.setAddress(address);
		ta.setAuditoriumNum(auditoriumNum);
		ta.setPhone(phone);
		ta.setSeatNum(seatNum);
		ta.setTheaterImg(theaterImg);
		ta.setAuditoriumName(auditoriumName);
		ta.setAuditoriumSeatNum(auditoriumSeatNum);
		ta.setLocation(location);
		ta.setTraffic(traffic);
		ta.setParking(parking);
		
		System.out.println("auditoriumName :" + auditoriumName);
		int result = 0;
		
		result = new TheaterService().updateTheater(ta);
		
		/*
		if(auditoriumNameArr != null) { // 상영관정보에 데이터가 있을 경우 -> 유지 또는 변경
			result = new TheaterService().updateTheater(ta);
		} else { // 상영관 정보에 데이터가 없을 경우 -> 제거
			result = new TheaterService().deleteAuditorium(theaterNo);
			System.out.println("theaterNo : " + theaterNo);
		}
		*/
		
		System.out.println("controller : " + result);
		
		if(result > 0) {
			System.out.println(ta);
			//request.getSession().setAttribute("ta", ta);
			request.getSession().setAttribute("alertMsg", "수정되었습니다.");
			
			response.sendRedirect(request.getContextPath()+"/atDetail.th?tno="+ta.getTheaterNo());
			
			//request.getRequestDispatcher(request.getContextPath()+"/atDetail.th?tno="+ta.getTheaterNo()).forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
