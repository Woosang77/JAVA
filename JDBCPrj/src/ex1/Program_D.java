package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Program_D {
	
	//DATA 삭제
	
	public static void main(String[] args) throws Exception{
		
		int id = 2;
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "DELETE TOPIC WHERE id = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "jws", "12345");
		//Statement st = con.createStatement();
		
		PreparedStatement st = con.prepareStatement(sql);
		//Statement처럼 다 만들어진 sql을 넣는것이 아니라,
		//틀을 준비해두고(prepared) 마지막에 정보를 몰아서 준다.
		
		//정보 몰아넣기
		st.setInt(1, id);
		
		//st에 정보를 다 넣었기 때문에 실행해도 된다.
		int result = st.executeUpdate();

		System.out.println(result);
		
		st.close();
		con.close();
	}

}
