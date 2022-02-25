package com.kh.ticket.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class KakaopayController
 */
@WebServlet("/pay.ti")
public class KakaopayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KakaopayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식 -> 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 값 뽑기
		String mName = request.getParameter("title");
		int runNo = Integer.parseInt(request.getParameter("runNo"));
		int ticketNumber = Integer.parseInt(request.getParameter("ticketNumber"));
		String payment = request.getParameter("payMoney");
		
		
		String successUrl = "";
			URL address = new URL("https://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection connection = (HttpURLConnection)address.openConnection(); // 서버 연결
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Authorization", "KakaoAK f1ded0476926f8faf65e7d0247d1e439"); // admin키
			connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			connection.setDoOutput(true);
			connection.setDoInput(true);
		
			Map<String, String> params = new HashMap<String, String>();
			params.put("cid", String.valueOf("TC0ONETIME")); // 가맹점 코드
			params.put("partner_order_id", String.valueOf("partner_order_id")); // 가맹점 주문번호
			params.put("partner_user_id", String.valueOf("partner_user_id")); // 가맹점 회원 ID
			params.put("item_name",  String.valueOf(mName)); // 상품명
			params.put("item_code", String.valueOf(runNo)); // 상품 코드
			params.put("quantity", String.valueOf(ticketNumber)); // 상품 수량
			params.put("total_amount", String.valueOf(payment)); // 총 금액
			params.put("vat_amount", String.valueOf("0")); // 부가세
			params.put("tax_free_amount", "0");
			params.put("approval_url", "http://localhost:8222/cinemaHeaven/list.ti?currentPage=1"); // 결제 성공 시
			params.put("fail_url", "http://localhost:8222/cinemaHeaven/MoView.ti/"); //결제 실패 시 
			params.put("cancel_url", "http://localhost:8222/cinemaHeaven/MoView.ti/"); // 결제 취소 시
	
			String string_params = new String();
			for(Map.Entry<String, String> elem : params.entrySet()) {
				string_params += (elem.getKey() + "=" + elem.getValue() + "&");
			}
			
			// 연결된 url에 바꿔준 파라미터 전달
			// connection.getOutputStream().write(string_params.getBytes());
			OutputStream send = connection.getOutputStream();
			DataOutputStream dataSend = new DataOutputStream(send);
			dataSend.write(string_params.getBytes());
			dataSend.close();
			
			// 전송 번호 받기
			int result = connection.getResponseCode();
			InputStream receive;
			
			if(result == 200) {
				receive = connection.getInputStream();
			} else {
				receive = connection.getErrorStream();
			}
			
			// 응답받은 코드 in에 담기
			BufferedReader in = new BufferedReader(new InputStreamReader(receive));
			
			// json으로 응답할 수 있도록 객체 변환
			JSONParser parser = new JSONParser();
			JSONObject obj;

			try {
				obj = (JSONObject)parser.parse(in);
				successUrl = (String)obj.get("next_redirect_pc_url"); // Object
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		// 응답
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(successUrl);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
