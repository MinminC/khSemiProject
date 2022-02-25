package com.kh.ticket;


import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.kh.common.MailSend;

public class Crowling {
	
	public void crowling() {
		final String cgvUrl = "http://www.cgv.co.kr/movies/";
		Connection conn = Jsoup.connect(cgvUrl);
		
		try {
			Document doc = conn.get();
			/* Elements */
			Elements ranks = doc.select(".rank");
			Elements imgs = doc.select(".thumb-img > img");
			Elements movieAges = doc.select(".ico-grade");
			Elements title = doc.select(".box-contents strong.title");
			Elements movieRates = doc.select(".percent span");
			Elements movieOpenDates = doc.select(".txt-info strong");
			Elements likes = doc.select(".count strong>i");
			
			/* logger.info("counts" + likes); */
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
