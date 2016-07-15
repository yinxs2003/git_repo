package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Page;
import com.entity.User;

public class UserDao extends BaseDao {
	private Page page = new Page();

	/**
	 * 查询所有
	 */
	public ArrayList<User> getAll() {
		ArrayList<User> list = new ArrayList<User>();

		String str = "select u.*,r.powername from u2user u,u2userrelation r where u.power=r.power";
		String username = "c##u61";
		String password = "u61";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
			preparedStatement = connect.prepareStatement(str);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String u2UserId = rs.getString("userid");
				String u2UserName = rs.getString("username");
				String u2PassWord = rs.getString("password");
				String sex = rs.getString("sex");
				int age = rs.getInt("age");
				String phoneNumber = rs.getString("phoneNumber");
				String address = rs.getString("address");
				int u2power = rs.getInt("power");
				String u2PowerName = rs.getString("powername");
				System.out.println(u2UserName + " " + u2PassWord);
				list.add(new User(u2UserId, u2UserName, u2PassWord, sex, age, phoneNumber, address, u2power,
						u2PowerName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			try {
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/* 这里到后面都没写 */
	/**
	 * 删除
	 */
	public int delById(int id) {
		String sql_del = "delete from test where deptno =" + id;
		String username = "c##scott";
		String password = "tiger";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
			st = conn.createStatement();
			count = st.executeUpdate(sql_del);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	/**
	 * 
	 * @param id
	 * @param dname
	 * @param loc
	 * @return 是否修改成功
	 */
	public int updateById(String u2UserName, String u2PassWord, int u2Power) {
		String updateSql = "update u2user set password=?,power=? where username=?";
		String username = "c##u61";
		String password = "u61";
		int count = 0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
			preparedStatement = connect.prepareStatement(updateSql);
			preparedStatement.setString(1, u2PassWord);
			preparedStatement.setInt(1, u2Power);
			preparedStatement.setString(3, u2UserName);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			try {
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	/**
	 * 
	 * @param id
	 * @param dname
	 * @param loc
	 * @return
	 */
	public int insert(String userName, String passWord, int power) {
		String updateSql = "insert into u2user values(?,?,?)";
		String username = "c##u61";
		String password = "u61";
		int count = 0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
			preparedStatement = connect.prepareStatement(updateSql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, passWord);
			preparedStatement.setInt(3, power);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return count;
	}

	public List<User> searchByConditon(String userName, int rowNumber1, int rowNumber2) {
		// String sql = null;
		// sql = "select * from u2user where providerDesc like '%" + userName +
		// "%'";

		String sql = "select * from (select u.*,r.powername from u2user u,u2userrelation r where u.power=r.power ) where  username like '%"
				+ userName + "%'";
		System.out.println("sql: " + sql);
		String username = "c##u61";
		String password = "u61";
		String countSql = "select count(*) count from  (" + sql + ")";
		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
		} catch (SQLException e3) {
			e3.printStackTrace();
		}

		System.out.println("countSql" + countSql);
		try {
			preparedStatement = connect.prepareStatement(countSql);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				// c_count = rs.getInt("count");
				// 设置条目数
				page.setCount(rs.getInt("count"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		// conditionsql缩写为c_sql
		// String c_sql = "select rownum,t.* from ( " + sql + " ) t where
		// rownum>? and rownum<=?";
		String c_sql = "select * from (select rownum rn,t.* from ( " + sql + " ) t) where rn>? and rn<=?";

		System.out.println("c_sql : " + c_sql);
		// select u.*,r.powername from u2user u,u2userrelation r where
		// u.power=r.power;
		List<User> list = new ArrayList<User>();
		try {
			preparedStatement = connect.prepareStatement(c_sql);
			System.out.println("rowNumber1" + rowNumber1);
			System.out.println("rowNumber2" + rowNumber2);
			preparedStatement.setInt(1, rowNumber1);
			preparedStatement.setInt(2, rowNumber2);
			// System.out.println("sql " + sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String userId = rs.getString("userid");
				String userName1 = rs.getString("username");
				String passWord = rs.getString("password");
				String sex = rs.getString("sex");
				int age = rs.getInt("age");
				String phoneNumber = rs.getString("phonenumber");
				String address = rs.getString("address");
				int power = rs.getInt("power");
				String powerName = rs.getString("powername");
				list.add(new User(userId, userName1, passWord, sex, age, phoneNumber, address, power, powerName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		System.out.println(list);
		return list;
	}

	public int getPageCount() {
		return page.getCount();
	}

	public int insert(String userId, String userName, String passWord, String sex, int age, String phoneNumber,
			String address, int power) {
		String updateSql = "insert into u2user values(?,?,?,?,?,?,?,?)";
		String username = "c##u61";
		String password = "u61";
		int count = 0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
			preparedStatement = connect.prepareStatement(updateSql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userName);
			preparedStatement.setString(3, passWord);
			preparedStatement.setString(4, sex);
			preparedStatement.setInt(5, age);
			preparedStatement.setString(6, phoneNumber);
			preparedStatement.setString(7, address);
			preparedStatement.setInt(8, power);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return count;
	}

	public int delete(String userId) {
		String updateSql = "delete from u2user where userid=?";
		String username = "c##u61";
		String password = "u61";
		int count = 0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
			preparedStatement = connect.prepareStatement(updateSql);
			preparedStatement.setString(1, userId);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return count;
	}

	public int update(String userId, String userName, String passWord, String sex, int age, String phoneNumber,
			String address, String power) {
		int count = 0;
		String updateSql = "update u2user set userName=?,password=?,sex=?,age=?,phoneNumber=?,address=?,power=? where userId=?";
		String username = "c##u61";
		String password = "u61";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
			preparedStatement = connect.prepareStatement(updateSql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, sex);
			preparedStatement.setInt(4, age);
			preparedStatement.setString(5, phoneNumber);
			preparedStatement.setString(6, address);
			preparedStatement.setString(7, power);
			preparedStatement.setString(8, userId);

			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return count;
	}

	public int update(String userId, String userName, String sex, int age, String phoneNumber, String address) {
		int count = 0;
		String updateSql = "update u2user set userName=?,sex=?,age=?,phoneNumber=?,address=? where userId=?";
		String username = "c##u61";
		String password = "u61";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
			preparedStatement = connect.prepareStatement(updateSql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, sex);
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4, phoneNumber);
			preparedStatement.setString(5, address);
			preparedStatement.setString(6, userId);

			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return count;

	}
}
