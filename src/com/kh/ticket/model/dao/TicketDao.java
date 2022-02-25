package com.kh.ticket.model.dao;

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
import com.kh.movie.model.vo.Movie;
import com.kh.theater.model.vo.Theater;
import com.kh.ticket.model.vo.Ticket;

public class TicketDao {
	
	private Properties prop = new Properties();
	
	public TicketDao() {
		String fileName = TicketDao.class.getResource("/sql/ticket/ticket-mapper.xml").getPath();
	
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

	public int selectListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCount;
	}
	
	public int selectListCount(Connection conn, int memberNo) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
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
	
	public ArrayList<Movie> selectMovieName(Connection conn) {
		ArrayList<Movie> mList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMovieName");
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				Movie m = new Movie();
				m.setMovieNo(rset.getInt("MNO"));
				m.setMovieName(rset.getString("MNAME"));
				m.setRate(rset.getString("RATE"));

				mList.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return mList;
	}

	public ArrayList<Theater> selectTheaterAll(Connection conn) {
		ArrayList<Theater> tlist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTheaterAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Theater t = new Theater();
				t.setAddress(rset.getString("LOCATION"));
				t.setTheaterNum(rset.getInt("COUNT"));
				
				tlist.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return tlist;
	}

	public ArrayList<Theater> selectLocation(Connection conn, String mName) {
		ArrayList<Theater> tlist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectLocation");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mName);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Theater t = new Theater();
				t.setTheaterName(rset.getString("LOCATION"));
				t.setTheaterNum(rset.getInt("COUNT"));
				
				tlist.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return tlist;
	}

	public ArrayList<String> selectTheater(Connection conn, String tAddr, String mName) {
		ArrayList<String> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTheater");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mName);
			pstmt.setString(2, tAddr + "%");
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String place = rset.getString("THEATER_NAME");
				
				list.add(place);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Ticket> selectTicketList(Connection conn, PageInfo pi, int memberNo) {
		ArrayList<Ticket> rlist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTicketList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			// 페이징
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Ticket t = new Ticket(rset.getInt("PAY_NO"),
									  rset.getString("PAY_DATE"),
									  rset.getInt("TICKET_NO"),
									  rset.getString("TICKET_TYPE"),
									  rset.getInt("SEAT_PK"),
									  rset.getString("SEAT_NO"),
									  rset.getString("AUDITORIUM_NAME"),
									  rset.getString("THEATER_NAME"),
									  rset.getString("RESERVE_DATE"),
									  rset.getInt("MNO"),
									  rset.getString("MNAME"),
									  rset.getString("RATE"),
									  rset.getInt("RTIME")
									  );
				rlist.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return rlist;
	}

	public ArrayList<Ticket> selectCancleList(Connection conn, int memberNo) {
		ArrayList<Ticket> clist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCancleList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Ticket t = new Ticket(rset.getString("PAYMENT"),		
									  rset.getString("THEATER_NAME"),
									  rset.getString("RUN_SCH"),
									  rset.getString("MNAME"),
									  rset.getString("PAY_DATE"));
				clist.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return clist;
	}

	public int countTicket(Connection conn, int payNo) {
		int tCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countTicket");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, payNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				tCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return tCount;
	}

	public int cancelTicket(Connection conn, int memberNo, int payNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("cancelTicket");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, payNo);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Ticket> ticketListAll(Connection conn, PageInfo pi) {
		ArrayList<Ticket> tlist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("ticketListAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Ticket t = new Ticket(
									  rset.getInt("PAY_NO"),
									  rset.getString("PAY_STATUS"),
									  rset.getString("PAY_DATE"),
									  rset.getString("PAYMENT"),
									  rset.getString("MEMBER_ID"),
									  rset.getString("TICKET_TYPE"),
									  rset.getInt("RUN_NO"),
									  rset.getString("MNAME"),
									  rset.getInt("COUNT")
						);
				tlist.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return tlist;
	}

	public ArrayList<Ticket> selectTime(Connection conn, String mName, String theater, String date) {
		ArrayList<Ticket> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTime");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mName);
			pstmt.setString(2, theater);
			pstmt.setString(3, "%" + date);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
					Ticket t = new Ticket();
					t.setRunNo(rset.getInt("RUN_NO"));
					t.setRunSch(rset.getString("RUN_SCH"));
					t.setSeatNum(rset.getInt("A_SEAT"));
					t.setRemain(rset.getInt("REMAIN"));
					t.setAuditoriumName(rset.getString("AUDITORIUM_NAME"));
					list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<String> selectedSeat(Connection conn, int runNo) {
		ArrayList<String> selectedSeatList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectedSeat");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, runNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				selectedSeatList.add(rset.getString("SEAT_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return selectedSeatList;
	}

	public ArrayList<Integer> selectSeatPK(Connection conn, int runNo, String[] sArr) {
		ArrayList<Integer> seatPKList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSeatPK");
		
			try {
				for(int i = 0; i < sArr.length; i++) {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, runNo);
					pstmt.setString(2, sArr[i]);
					
					rset = pstmt.executeQuery();
					if(rset.next()) {
						seatPKList.add(rset.getInt("SEAT_PK"));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
		
		return seatPKList;
	}

	public int insertPayment(Connection conn, ArrayList<Ticket> ticketList) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPayment");
		
		try {
			for(Ticket t : ticketList) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, t.getPayment());
				pstmt.setInt(2, t.getMemberNo());
				
				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertTicket(Connection conn, ArrayList<Ticket> ticketList) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertTicket");
		
		try {
			for(Ticket t : ticketList) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, t.getTicketType());
				pstmt.setInt(2, t.getSeatPk());
				pstmt.setInt(3, t.getRunNo());
				
				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
