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
 * Servlet implementation class AMovieTheaterInsertContorller
 */
@WebServlet("/atInsert.th")
public class AMovieTheaterInsertContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AMovieTheaterInsertContorller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		System.out.println("INSERTFORM");
		
		String theaterName = request.getParameter("theaterName");
		String address = request.getParameter("address");
		int auditoriumNum = Integer.parseInt(request.getParameter("auditoriumNum"));
		String phone = request.getParameter("phone");
		int seatNum = Integer.parseInt(request.getParameter("seatNum"));
		int auditoriumNo = Integer.parseInt(request.getParameter("auditoriumNo")); // 추가될 첫 상영관번호
		auditoriumNo++;
		System.out.println(auditoriumNo);
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
//		System.out.println(auditoriumName); // 1관, 2관
		
		if(auditoriumSeatNumArr != null) {
			auditoriumSeatNum = String.join(",", auditoriumSeatNumArr);
		}
//		System.out.println(auditoriumSeatNum); // 100, 120
		
		TheaterAuditorium ta = new TheaterAuditorium();
		
		ta.setTheaterName(theaterName);
		ta.setAddress(address);
		ta.setAuditoriumNum(auditoriumNum);
		ta.setPhone(phone);
		ta.setSeatNum(seatNum);
		ta.setAuditoriumNo(auditoriumNo);
		ta.setTheaterImg(theaterImg);
		ta.setAuditoriumName(auditoriumName);
		ta.setAuditoriumSeatNum(auditoriumSeatNum);
		ta.setLocation(location);
		ta.setTraffic(traffic);
		ta.setParking(parking);
		
		
		int result = new TheaterService().insertTheater(ta);
		
		if((result) > 0) {
			
			request.getSession().setAttribute("alertMsg", "등록되었습니다.");
			response.sendRedirect(request.getContextPath() + "/atList.th?currentPage=1");
			
		}else {
			request.getSession().setAttribute("alertMsg", "등록에 실패하였습니다.");
			response.sendRedirect(request.getContextPath() + "/atList.th?currentPage=1");
			
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
