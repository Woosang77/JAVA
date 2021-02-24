package jdbc_newlec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc_newlec.entity.Topic;

public class TopicService {
	
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String uid = "jws";
	private String pwd = "12345";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	public List<Topic> getList() throws ClassNotFoundException, SQLException{
		
		String sql = "SELECT * FROM TOPIC WHERE ID > 2";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Topic> list = new ArrayList<Topic>();
		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String description = rs.getString("DESCRIPTION");
			Date created = rs.getDate("CREATED");
			int author_id = rs.getInt("AUTHOR_ID");
			
			Topic topic = new Topic(
					id,
					title,
					description,
					created,
					author_id
			);
			
			list.add(topic);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	public int insert(Topic topic) throws ClassNotFoundException, SQLException{
		
		String title = topic.getTitle();
		String description = topic.getDescription();
		String sql = "INSERT INTO topic (" + 
				"    title," + 
				"    description" + 
				") VALUES (?,?)";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, title);
		st.setString(2, description);

		int result = st.executeUpdate();

		st.close();
		con.close();
		
		return result;
	}
	
	public int update(Topic topic) throws ClassNotFoundException, SQLException{
		
		String title = topic.getTitle();
		String description = topic.getDescription();
		int id = topic.getId();

		String sql = "UPDATE topic	" + 
				"SET" + 
				"    title = ?," + 
				"    description = ?" + 
				"WHERE id = ?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);	
		PreparedStatement st = con.prepareStatement(sql);
	
		st.setString(1, title);
		st.setString(2, description);
		st.setInt(3, id);

		int result = st.executeUpdate();

		st.close();
		con.close();
		
		return result;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException{
		
		String sql = "DELETE TOPIC WHERE id = ?";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);

		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, id);

		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
}
