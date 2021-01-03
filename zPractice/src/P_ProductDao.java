import java.sql.Connection;
import java.sql.PreparedStatement;

public class P_ProductDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	
	
	
	//기본 생성자
	P_ProductDao () {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	} // P_ProductDao 생성자
	
	
	
	
	
	

} // P_ProductDao
