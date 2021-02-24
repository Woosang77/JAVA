package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Program_R {
	
	//데이터 읽기
	
	public static void main(String[] args) throws Exception{
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM TOPIC WHERE ID > 2";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "jws", "12345");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String description = rs.getString("DESCRIPTION");
			Date created = rs.getDate("CREATED");
			int author_id = rs.getInt("AUTHOR_ID");
			
			System.out.printf("id : %d, title : %s, desciption : %s, created : %s, author_id : %d", 
					id, title, description, created, author_id);
			System.out.println();
		}
		
		rs.close();
		st.close();
		con.close();
	}

}
