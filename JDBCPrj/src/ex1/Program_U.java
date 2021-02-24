package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Program_U {
	
	//DATA ������
	
	public static void main(String[] args) throws Exception{
		
		String title = "Python";
		String description = "Python is...";
		int id = 2;
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "UPDATE topic	" + 	//topic�� " ���̿� ������ ���� ������, query���� topicSET���� �ν��ؼ� SET�� ������ ����. 
				"SET" + 
				"    title = ?," + 
				"    description = ?" + 
				"WHERE id = ?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "jws", "12345");
		//Statement st = con.createStatement();
		
		PreparedStatement st = con.prepareStatement(sql);
		//Statementó�� �� ������� sql�� �ִ°��� �ƴ϶�,
		//Ʋ�� �غ��صΰ�(prepared) �������� ������ ���Ƽ� �ش�.
		
		//���� ���Ƴֱ�
		st.setString(1, title);
		st.setString(2, description);
		st.setInt(3, id);
		
		//st�� ������ �� �־��� ������ �����ص� �ȴ�.
		int result = st.executeUpdate();

		System.out.println(result);
		
		st.close();
		con.close();
	}

}
