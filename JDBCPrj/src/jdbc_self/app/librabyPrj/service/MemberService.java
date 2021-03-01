package jdbc_self.app.librabyPrj.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc_self.app.librabyPrj.model.Member;

public class MemberService {

	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String uid = "jws";
	private String pwd = "12345";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	//등록
	public void createId(String name, String id, String pw) throws ClassNotFoundException, SQLException{
		String sql = "INSERT INTO MEMBER (MEMBER_ID, NAME, USER_ID, PW) VALUES (MEMBER_SEQ.NEXTVAL, ?, ?, ?)";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, name);
		st.setString(2, id);
		st.setString(3, pw);
		
		st.executeUpdate();
		System.out.println("> 회원가입 완료");
	}
	
	//조회
	public Member searchMember(String id, String pw) throws ClassNotFoundException, SQLException{
		
		Member member = new Member();
		String sql = "SELECT * FROM MEMBER WHERE USER_ID = ? AND PW = ?";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, id);
		st.setString(2, pw);
		
		ResultSet rs = st.executeQuery();
		if (rs.next()) {		
			member.setName(rs.getString("NAME"));
			member.setId(rs.getString("USER_ID"));
			member.setPw(rs.getString("PW"));
			return member;
		}else {
			System.out.println("아이디가 없거나 잘못 입력되었습니다.");
			return null;
		}
	}
}
