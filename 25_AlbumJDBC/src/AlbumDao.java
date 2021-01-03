import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlbumDao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "jspid";
	private String pw = "jsppw";

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// 생성자
	AlbumDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 발견되지 않습니다(jar 파일 누락)");
			e.printStackTrace();
		}

	} // AlbumDao 생성자

	public void getConn() {
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			System.out.println("커넥션 생성 오류");
		}

	} // getConn

	public ArrayList<AlbumBean> getAllAlbums() {
		getConn();

		ArrayList<AlbumBean> list = new ArrayList<AlbumBean>();

		String sql = "select * from albums order by num";
		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				AlbumBean bean = new AlbumBean();
				bean.setNum(rs.getInt("num"));
				bean.setSong(rs.getString("song"));
				bean.setSinger(rs.getString("singer"));
				bean.setCompany(rs.getString("company"));
				bean.setPrice(rs.getInt("price"));
				bean.setPub_day(String.valueOf(rs.getDate("pub_day")));

				list.add(bean);

			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	} // getAllAlbums

	public int insertData(AlbumBean bean) {
		getConn();

		int count = -1;

		String sql = "insert into albums(num,song,singer,company,price,pub_day)" + "values(albumseq.nextval,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, bean.getSong());
			ps.setString(2, bean.getSinger());
			ps.setString(3, bean.getCompany());
			ps.setInt(4, bean.getPrice());
			ps.setString(5, bean.getPub_day());

			count = ps.executeUpdate();
			System.out.println("count: " + count);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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

		return count;
	}

	public int updateData(AlbumBean bean) {
		getConn();

		int count = -1;

		String sql = "update albums set song=?, singer=?, company=?, price=?, pub_day=? where num=? ";
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);

			ps.setString(1, bean.getSong());
			ps.setString(2, bean.getSinger());
			ps.setString(3, bean.getCompany());
			ps.setInt(4, bean.getPrice());
			ps.setString(5, bean.getPub_day());
			ps.setInt(6, bean.getNum());

			count = ps.executeUpdate();
			conn.commit();
			System.out.println("count: " + count);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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

		return count;
	}

	public int deleteData(int num) {
		getConn();
		int count = -1;

		String sql = "delete from albums where num=? ";
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);

			count = ps.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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

		return count;

	} // deleteData

	public ArrayList<AlbumBean> getAlbumBySearch(String column, String search_word) {
		getConn();

		ArrayList<AlbumBean> list = new ArrayList<AlbumBean>();

		String sql = "select * from albums where upper(" + column + ") like ? order by num";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + search_word.toUpperCase() + "%"); // 양쪽 모두 대문자로 바꿔서 출력

			rs = ps.executeQuery();
			while (rs.next()) {
				AlbumBean bean = new AlbumBean();
				bean.setNum(rs.getInt("num"));
				bean.setSong(rs.getString("song"));
				bean.setSinger(rs.getString("singer"));
				bean.setCompany(rs.getString("company"));
				bean.setPrice(rs.getInt("price"));
				bean.setPub_day(String.valueOf(rs.getDate("pub_day")));

				list.add(bean);

			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	} // getAlbumBySearch

	public ArrayList<AlbumBean> getAlbumByRange(int from, int to) {
		getConn();

		ArrayList<AlbumBean> list = new ArrayList<AlbumBean>();

//		SQL> select rank,num,song,singer,company,price,pub_day
//		from (select rownum as rank,num,song,singer,company,price,pub_day
//		from(select rownum,num,song,singer,company,price,pub_day from albums order by price desc,singer asc))
//		where rank between 5 and 6;

//		[방법①] - rownum 사용
//		String sql = "select rank,num,song,singer,company,price,pub_day"
//				+ " from (select rownum as rank,num,song,singer,company,price,pub_day"
//				+ " from(select rownum,num,song,singer,company,price,pub_day from albums order by price desc,singer asc))"
//				+ " where rank between ? and ?";
//		[방법②]-rank 사용
		String sql = "select rownum,num,song,singer,company,price,pub_day,rank"
				+ " from(select rownum,num,song,singer,company,price,pub_day,rank() over(order by price desc, singer asc)"
				+ " as rank from albums)" + " where rank between ? and ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, from);
			ps.setInt(2, to);

			rs = ps.executeQuery();
			while (rs.next()) {
				AlbumBean bean = new AlbumBean();
				bean.setNum(rs.getInt("num"));
				bean.setSong(rs.getString("song"));
				bean.setSinger(rs.getString("singer"));
				bean.setCompany(rs.getString("company"));
				bean.setPrice(rs.getInt("price"));
				bean.setPub_day(String.valueOf(rs.getDate("pub_day")));

				list.add(bean);

			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	} // getAlbumByRange

	public ArrayList<AlbumBean> align(String column, String way) {
		getConn();

		ArrayList<AlbumBean> list = new ArrayList<AlbumBean>();

		String sql = "select * from albums order by " + column + " " + way;
		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				AlbumBean bean = new AlbumBean();
				bean.setNum(rs.getInt("num"));
				bean.setSong(rs.getString("song"));
				bean.setSinger(rs.getString("singer"));
				bean.setCompany(rs.getString("company"));
				bean.setPrice(rs.getInt("price"));
				bean.setPub_day(String.valueOf(rs.getDate("pub_day")));

				list.add(bean);

			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

} // AlbumDao
//