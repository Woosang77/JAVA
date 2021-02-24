package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Program_D {
	
	//DATA ����
	
	public static void main(String[] args) throws Exception{
		
		int id = 2;
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "DELETE TOPIC WHERE id = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "jws", "12345");
		//Statement st = con.createStatement();
		
		PreparedStatement st = con.prepareStatement(sql);
		//Statementó�� �� ������� sql�� �ִ°��� �ƴ϶�,
		//Ʋ�� �غ��صΰ�(prepared) �������� ������ ���Ƽ� �ش�.
		
		//���� ���Ƴֱ�
		st.setInt(1, id);
		
		//st�� ������ �� �־��� ������ �����ص� �ȴ�.
		int result = st.executeUpdate();

		System.out.println(result);
		
		st.close();
		con.close();
	}

}
