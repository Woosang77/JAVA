package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Program_U {
	
	//DATA 수정ㄹ
	
	public static void main(String[] args) throws Exception{
		
		String title = "Python";
		String description = "Python is...";
		int id = 2;
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "UPDATE topic	" + 	//topic과 " 사이에 공백을 넣지 않으면, query언어에서 topicSET으로 인식해서 SET이 오류가 난다. 
				"SET" + 
				"    title = ?," + 
				"    description = ?" + 
				"WHERE id = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "jws", "12345");
		//Statement st = con.createStatement();
		
		PreparedStatement st = con.prepareStatement(sql);
		//Statement처럼 다 만들어진 sql을 넣는것이 아니라,
		//틀을 준비해두고(prepared) 마지막에 정보를 몰아서 준다.
		
		//정보 몰아넣기
		st.setString(1, title);
		st.setString(2, description);
		st.setInt(3, id);
		
		//st에 정보를 다 넣었기 때문에 실행해도 된다.
		int result = st.executeUpdate();

		System.out.println(result);
		
		st.close();
		con.close();
	}

}
