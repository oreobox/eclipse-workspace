import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "jspid";
	private String pw = "jsppw";

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// 기본 생성자
	BookDao() {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 발견되지 않습니다(jar 파일 누락)");
			e.printStackTrace();
		}

	} // BookDao 생성자
	// 2단계
	public void getConn() { // 메서드
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			System.out.println("커넥션 생성 오류");
		}

	} // getConn

	public ArrayList<BookBean> getAllBook() {
		getConn();

		ArrayList<BookBean> list = new ArrayList<BookBean>();

		String sql = "select * from book order by no asc";

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
//				int no = rs.getInt("no");
//				String title = rs.getString("title");
//				String author = rs.getString("author");
//				String publisher = rs.getString("publisher");
//				int price = rs.getInt("price");
//				String pub_day = String.valueOf(rs.getDate("pub_day"));
//				//+
////			BookBean bean = new BookBean(no, title, author, publisher, price, pub_day);
				BookBean bean = new BookBean();
//				bean.setNo(no);
//				bean.setTitle(title);
//				bean.setAuthor(author);
//				bean.setPublisher(publisher);
//				bean.setPrice(price);
//				bean.setPub_day(pub_day);
				// ↓
				bean.setNo(rs.getInt("no"));
				bean.setTitle(rs.getString("title"));
				bean.setAuthor(rs.getString("author"));
				bean.setPublisher(rs.getString("publisher"));
				bean.setPrice(rs.getInt("price"));
				bean.setPub_day(String.valueOf(rs.getDate("pub_day")));

				list.add(bean);

			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 접속 종료
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} // finally
		return list;
	}

//	public ArrayList<BookBean> getBookSelect(int no) {
//		getConn();
//		
//		ArrayList<BookBean> list = new ArrayList<BookBean>();
//		
////		String sql = "select * from book where no=?";
//		String sql = "select * from book where " + title + " like ? order by no";
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1,no);
//			
//			rs = ps.executeQuery();
//			
//			while (rs.next()) {
//				int no2 = rs.getInt("no");
//				String title = rs.getString("title");
//				String author = rs.getString("author");
//				String publisher = rs.getString("publisher");
//				int price = rs.getInt("price");
//				String pub_day = String.valueOf(rs.getString("pub_day"));
//				
//				BookBean bean = new BookBean(no2,title,author,publisher,price,pub_day);
//				list.add(bean);
//				
//			} // while
//				
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			} // if rs
//			if (ps != null) {
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			} // if ps
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			} // if conn
//
//		} // finally
//		
//		return list;
//		
//	} // getBookSelect

	public int insertData(BookBean bean) {
//		System.out.println(bean.getTitle());
//		System.out.println(bean.getAuthor());
		getConn();

		int count = -1;

		String sql = "insert into book(no,title,author,publisher,price,pub_day)" +
				"values(bseq.nextval,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, bean.getTitle());
			ps.setString(2, bean.getAuthor());
			ps.setString(3, bean.getPublisher());
			ps.setInt(4, bean.getPrice());
			ps.setString(5, bean.getPub_day());

			count = ps.executeUpdate(); // 성공적으로 실행(삽입)된 갯수가 리턴됨
			System.out.println("insert count: " + count);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if (conn != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

		} // finally

		return count;

	} // insertData

	public int updateData(BookBean bean) {
//		System.out.println(bean.getNo());
//		System.out.println(bean.getTitle());
//		System.out.println(bean.getAuthor());
		getConn();

		int count = -1;

		String sql = "update book set title=?, author=?, publisher=?, price=?, pub_day=? where no=?";
		// 조건을 쓰지 않으면 6개 항목 다 수정됨
		
		try {
			
			conn.setAutoCommit(false); // 자동 커밋되는 설정X (true면 자동 커밋 설정됨) - 모두 수정된 후에 commit되도록 하기
			ps = conn.prepareStatement(sql);

			ps.setString(1, bean.getTitle());
			ps.setString(2, bean.getAuthor());
			ps.setString(3, bean.getPublisher());
			ps.setInt(4, bean.getPrice());
			ps.setString(5, bean.getPub_day());
			ps.setInt(6, bean.getNo());

			count = ps.executeUpdate();
			
			conn.commit(); // conn.setAutoCommit(false);과 쌍으로 사용해야함
			
			System.out.println("update count: " + count);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if (conn != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

		} // finally

		return count;

	} // updateData

	public int deleteData(int no) {
		getConn();

		int count = -1;

		String sql = "delete from book where no=?";

		try {
			conn.setAutoCommit(false); // 자동으로 commit 되지않도록
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);

			count = ps.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			if (conn != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} // finally

		return count;
	}

	public ArrayList<BookBean> getBookBySearch(String column, String search_word) {
		getConn();

		ArrayList<BookBean> list = new ArrayList<BookBean>();

		// select * from book where author like '%정%';
		// where과 like 사이 띄어쓰기 주의
		String sql = "select * from book where " + column + " like ? order by no";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + search_word + "%"); // %정%

			rs = ps.executeQuery();
			while (rs.next()) {
				BookBean bean = new BookBean();

				bean.setNo(rs.getInt("no"));
				bean.setTitle(rs.getString("title"));
				bean.setAuthor(rs.getString("author"));
				bean.setPublisher(rs.getString("publisher"));
				bean.setPrice(rs.getInt("price"));
				bean.setPub_day(String.valueOf(rs.getDate("pub_day")));

				list.add(bean);

			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 접속 종료
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} // finally
		
		// 리턴 위에다 출력해야함. 리턴하기 전에 표시
		System.out.println("검색한 항목은" + list.size() +"권 입니다.");
		return list;
	} // getBookBySearch

} // BookDao
