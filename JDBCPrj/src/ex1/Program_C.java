package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Program2 {
	
	//DATA 입력
	
	public static void main(String[] args) throws Exception{
		
		String title = "C++";
		String description = "C++ is...";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "INSERT INTO topic (" + 
				"    title," + 
				"    description" + 
				") VALUES (?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "jws", "12345");
		//Statement st = con.createStatement();
		
		PreparedStatement st = con.prepareStatement(sql);
		//Statement처럼 다 만들어진 sql을 넣는것이 아니라,
		//틀을 준비해두고(prepared) 마지막에 정보를 몰아서 준다.
		
		//정보 몰아넣기
		st.setString(1, title);
		st.setString(2, description);
		
		//st에 정보를 다 넣었기 때문에 실행해도 된다.
		int result = st.executeUpdate();
		
		
		//SELECT(조회)가 아닐 때는 결과집합이 없다. 그렇기 때문에 Query로 해서 결과집합을 받을 필요가 없다. ==> RESULTSET 필요 없음
		//ResultSet rs = st.executeQuery(sql);
		//select가 아닌 insert, update, delete등을 사용할 땐 .executeUpdate를 사용하는데,
		//.executeUpdate는 Int를 리턴하면서 몇 개의 Row가 영향을 받았는지를 알려주는 Int를 반환한다.
		//실행할때는 주요함수 두 개 쿼리, 업데이트
		
		System.out.println(result);
		

		
		st.close();
		con.close();
	}

}
