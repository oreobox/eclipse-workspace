import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MusicalDao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "jspid";
	private String pw = "jsppw";

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// 생성자
	MusicalDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("jar 파일이 누락되었습니다.");
			e.printStackTrace();
		}
	} // MusicalDao

	public void getConn() {
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			System.out.println("계정에 접속을 할 수 없습니다.");
			e.printStackTrace();
		}

	} // getConn

	public ArrayList<MusicalBean> getAllCasting() {
		getConn();

		ArrayList<MusicalBean> list = new ArrayList<MusicalBean>();

		String sql = "select * from musical order by no";
		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				MusicalBean bean = new MusicalBean();
				bean.setNo(rs.getInt("no"));
				bean.setActor(rs.getString("actor"));
				bean.setMus_date(String.valueOf(rs.getDate("mus_date")));
				bean.setMus_day(rs.getString("mus_day"));
				bean.setTime(rs.getInt("time"));
				bean.setPrice(rs.getInt("price"));

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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // finally

		return list;

	} // getAllCasting

	public int insertData(MusicalBean bean) {
		getConn();

		int count = -1;

		ArrayList<MusicalBean> list = new ArrayList<MusicalBean>();

		String sql = "insert into musical values(mus_seq.nextval,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, bean.getActor());
			ps.setString(2, bean.getMus_date());
			ps.setString(3, bean.getMus_day());
			ps.setInt(4, bean.getTime());
			ps.setInt(5, bean.getPrice());

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

	} // insertData

	public int updateData(MusicalBean bean) {
		getConn();

		int count = -1;

		ArrayList<MusicalBean> list = new ArrayList();

		String sql = "update musical set actor=?, mus_date=?, mus_day=?, time=?, price=? where no=? ";
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);

			ps.setString(1, bean.getActor());
			ps.setString(2, bean.getMus_date());
			ps.setString(3, bean.getMus_day());
			ps.setInt(4, bean.getTime());
			ps.setInt(5, bean.getPrice());
			ps.setInt(6, bean.getNo());

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

	public int deleteData(int no) {
		getConn();

		int count = -1;

		String sql = "delete from musical where no=?";
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);

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
	}

	public ArrayList<MusicalBean> getSearchByDay(String search_day) {
		getConn();

		ArrayList<MusicalBean> list = new ArrayList<MusicalBean>();

		String sql = "select * from musical where mus_day=? order by mus_date, time asc";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, search_day);

			rs = ps.executeQuery();
			while (rs.next()) {
				MusicalBean bean = new MusicalBean();
				bean.setNo(rs.getInt("no"));
				bean.setActor(rs.getString("actor"));
				bean.setMus_date(String.valueOf(rs.getDate("mus_date")));
				bean.setMus_day(rs.getString("mus_day"));
				bean.setTime(rs.getInt("time"));
				bean.setPrice(rs.getInt("price"));

				list.add(bean);

			} // while

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		} // finally

		return list;
	}

	public ArrayList<MusicalBean> getMusicalBySearch(String search) {
		getConn();

		ArrayList<MusicalBean> list = new ArrayList<MusicalBean>();

		String sql = "select * from musical where actor like ? order by mus_date";
		try {
			ps = conn.prepareStatement(sql);
			ps.setNString(1, "%" + search + "%");

			rs = ps.executeQuery();
			while (rs.next()) {
				MusicalBean bean = new MusicalBean();
				bean.setNo(rs.getInt("no"));
				bean.setActor(rs.getString("actor"));
				bean.setMus_date(String.valueOf(rs.getDate("mus_date")));
				bean.setMus_day(rs.getString("mus_day"));
				bean.setTime(rs.getInt("time"));
				bean.setPrice(rs.getInt("price"));

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

} // MusicalDao
