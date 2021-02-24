package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Program2 {
	
	//DATA �Է�
	
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
		//Statementó�� �� ������� sql�� �ִ°��� �ƴ϶�,
		//Ʋ�� �غ��صΰ�(prepared) �������� ������ ���Ƽ� �ش�.
		
		//���� ���Ƴֱ�
		st.setString(1, title);
		st.setString(2, description);
		
		//st�� ������ �� �־��� ������ �����ص� �ȴ�.
		int result = st.executeUpdate();
		
		
		//SELECT(��ȸ)�� �ƴ� ���� ��������� ����. �׷��� ������ Query�� �ؼ� ��������� ���� �ʿ䰡 ����. ==> RESULTSET �ʿ� ����
		//ResultSet rs = st.executeQuery(sql);
		//select�� �ƴ� insert, update, delete���� ����� �� .executeUpdate�� ����ϴµ�,
		//.executeUpdate�� Int�� �����ϸ鼭 �� ���� Row�� ������ �޾Ҵ����� �˷��ִ� Int�� ��ȯ�Ѵ�.
		//�����Ҷ��� �ֿ��Լ� �� �� ����, ������Ʈ
		
		System.out.println(result);
		

		
		st.close();
		con.close();
	}

}
