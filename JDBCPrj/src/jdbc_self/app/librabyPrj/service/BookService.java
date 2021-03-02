package jdbc_self.app.librabyPrj.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc_self.app.librabyPrj.model.Book;

public class BookService {
	
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String uid = "jws";
	private String pwd = "12345";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	//조회
	public List<Book> getList(int page, String field, String query) throws ClassNotFoundException, SQLException{
		
		int start = 1 + (page-1)*10;
		int end = page * 10;
		
		String sql = "SELECT * FROM "
				+ "(SELECT ROWNUM AS RNUM, BOOK.* FROM BOOK WHERE " + field + " LIKE ? )"
				+ "WHERE RNUM BETWEEN ? AND ?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		st.setInt(2, start);
		st.setInt(3, end);

		ResultSet rs = st.executeQuery();
		
		List<Book> list = new ArrayList<Book>();
		
		while (rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writer = rs.getString("WRITER");
			String rent = rs.getString("RENT");
			
			Book book = new Book(id, title, writer, rent);
			list.add(book);
		}
		return list;
	}

	//
	public Book find(int bookNumber) throws ClassNotFoundException, SQLException{
		
		String sql = "SELECT * FROM BOOK WHERE ID LIKE ?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, bookNumber);
		
		ResultSet rs = st.executeQuery();
		rs.next();
		int id = rs.getInt("ID");
		String title = rs.getString("TITLE");
		String writer = rs.getString("WRITER");
		String rent = rs.getString("RENT");
		Book book = new Book(id, title, writer, rent);
		return book;
	}
	
	//UpdateToRent
	public void updateToRent(int bookId, int rent, int member_id, String date) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE book	" + 
				"SET" + 
				"	rent = ?," +
				"	rentid = ?," +
				"	expire = ?"+	
				"	WHERE id = ?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, rent);
		if (rent == 0) {
			st.setInt(2, member_id);
			st.setString(3, date);
		}else {
			st.setInt(2, 0);
			st.setString(3, date);
		}
		st.setInt(4, bookId);
		
		st.executeUpdate();
	}
//	
//	//회원의 도서목록
//	public void rentedBook() {
//		String sql = "SELECT * FROM BOOK WHERE RENTID = ?"
//		Class.forName(driver);
//		Connection con = DriverManager.getConnection(url, uid, pwd);
//		PreparedStatement st = con.prepareStatement(sql);
//	}
	
	//Scalar
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException{
		String sql = "SELECT COUNT(*) FROM BOOK WHERE " + field +
				" LIKE ?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		ResultSet rs = st.executeQuery();
		
		rs.next();
		int count = rs.getInt(1);
		
		return count;
	}
}
