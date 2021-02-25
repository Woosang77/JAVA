package jdbc_newlec.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc_newlec.app.entity.Topic;

public class TopicService {
	
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String uid = "jws";
	private String pwd = "12345";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	public List<Topic> getList(int page, String field, String query ,int count) throws ClassNotFoundException, SQLException{
		//검색범위
		int start = 1 + (page - 1)*10;
		int end = 10 * page;
		
		//String sql = "SELECT * FROM TOPIC_VIEW WHERE " + field + " LIKE ? AND NUM BETWEEN ? AND ?";
		String sql = "SELECT * FROM "
				+ "(SELECT ROWNUM AS RNUM, TOPIC_VIEW.* FROM TOPIC_VIEW WHERE " + field + " LIKE ? )"
							+ "WHERE RNUM BETWEEN ? AND ?";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, "%"+query+"%");
		st.setInt(2, start);
		st.setInt(3, end);
		ResultSet rs = st.executeQuery();
		
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

	public int insert(String title_, String description_) throws ClassNotFoundException, SQLException{
		
		String title = title_;
		String description = description_;
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

	//Scalar
	public int getCount(String field, String query) throws SQLException, ClassNotFoundException{
		
		int count = 0;
		String sql = "SELECT COUNT(*) FROM TOPIC WHERE " +field+ " LIKE ?";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, "%"+query+"%");
		ResultSet rs = st.executeQuery();
		if (rs.next())
			count = rs.getInt("COUNT(*)");						
		
		rs.close();
		st.close();
		con.close();
		
		return count;
	}
}

