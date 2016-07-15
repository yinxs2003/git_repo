package com.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Bill;

public class BillDao extends BaseDao {
	/**
	 * 查询所有
	 */
	public ArrayList<Bill> getAll() {
		ArrayList<Bill> list = new ArrayList<Bill>();

		String str = "select * from u2adminBillList";
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
			System.out.println("billDao.java: if(rs.next)");
			while (rs.next()) {
				String billId = rs.getString("billId");
				String commodityName = rs.getString("commodityname");
				int commodityQuantity = rs.getInt("commodityquantity");
				String commodityUtil = rs.getString("commodityunit");
				double sumPrice = rs.getDouble("sumPrice");
				int havePay = rs.getInt("havepay");
				String providerName = rs.getString("providerName");
				String commodityDesc = rs.getString("commoditydesc");

				// private String billId;
				// private String commodityName;
				// private int commodityQuantity;
				// private String commodityUtil;
				// private double sumPrice;
				// private int havePay;
				// private String providerId;
				// private String commodityDesc;
				list.add(new Bill(billId, commodityName, commodityQuantity, commodityUtil, sumPrice, havePay,
						providerName, commodityDesc));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return list;

	}

	public List<Bill> getPages(int rowNumber1, int rowNumber2) {
		ArrayList<Bill> list = new ArrayList<Bill>();
		String str = "select * from (select rownum rn,u2adminbilllist.* from u2adminbilllist) where rn >? and rn<=?";
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
			preparedStatement.setInt(1, rowNumber1);
			preparedStatement.setInt(2, rowNumber2);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String billId = rs.getString("billId");
				String commodityName = rs.getString("commodityname");
				int commodityQuantity = rs.getInt("commodityquantity");
				String commodityUtil = rs.getString("commodityunit");
				double sumPrice = rs.getDouble("sumPrice");
				int havePay = rs.getInt("havepay");
				String supplierId = rs.getString("supplierId");
				String commodityDesc = rs.getString("commoditydesc");
				list.add(new Bill(billId, commodityName, commodityQuantity, commodityUtil, sumPrice, havePay,
						supplierId, commodityDesc));
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

	public int getCount() {
		String str = "select count(*) count from u2adminbilllist";
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
			preparedStatement = connect.prepareStatement(str);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
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
		// System.out.println("count"+count);
		return count;
	}

	/**
	 * 输入的sql语句得到一个结果，查询该结果总行数
	 * 
	 * @param str
	 *            sql语句
	 * @return
	 */
	public int getCount(String str) {
		String username = "c##u61";
		String password = "u61";
		int count = 0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "select count(*) from " + str;
		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
			preparedStatement = connect.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
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
		// System.out.println("count"+count);
		return count;
	}

	/**
	 * @param billId
	 * @param commodityName
	 * @param commodityQuantity
	 * @param commodityUnit
	 * @param sumPrice
	 * @param havePay
	 * @param supplierId
	 * @param commoditydesc
	 * @param buyDate
	 * @return
	 */
	public int insert(String billId, String commodityName, int commodityQuantity, String commodityUnit, double sumPrice,
			int havePay, int supplierId, String commoditydesc) {
		int count = 0;
		String sql = "insert into u2adminbilllist values(?,?,?,?,?,?,?,?)";
		String username = "c##u61";
		String password = "u61";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
			preparedStatement = connect.prepareStatement(sql);

			preparedStatement.setString(1, billId);
			preparedStatement.setString(2, commodityName);
			preparedStatement.setInt(3, commodityQuantity);
			preparedStatement.setString(4, commodityUnit);
			preparedStatement.setDouble(5, sumPrice);
			preparedStatement.setInt(6, havePay);
			preparedStatement.setInt(7, supplierId);
			preparedStatement.setString(8, commoditydesc);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return count;
	}

	private int c_count = 0;

	/**
	 * 只有调用完searchByConditon（）方法后，调用该方法才能获取正确的行数
	 */
	public int getConditionCount() {
		return c_count;
	}

	public void resetConditionCount() {
		c_count = 0;
	}

	public List<Bill> searchByConditon(String condition, String s_havePay, int rowNumber1, int rowNumber2) {
		String sql = null;
		if (s_havePay == null || s_havePay == "" || s_havePay.length() == 0) {
			// System.out.println("here");
			sql = "select * from u2adminbilllist where commodityname like '%" + condition + "%'";
		} else {
			sql = "select * from u2adminbilllist where commodityname like '%" + condition + "%' and havepay="
					+ s_havePay;
		}
		String username = "c##u61";
		String password = "u61";
		String countSql = "select count(*) count from  (" + sql + ")";
		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
		} catch (SQLException e3) {
			e3.printStackTrace();
		}

		System.out.println(countSql);
		try {
			preparedStatement = connect.prepareStatement(countSql);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				c_count = rs.getInt("count");
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		// conditionsql缩写为c_sql
		// String c_sql = "select rownum,t.* from ( " + sql + " ) t where
		// rownum>? and rownum<=?";
		String c_sql = "select * from (select rownum rn,t.* from ( " + sql + " ) t) where rn>? and rn<=?";
		// System.out.println(c_sql);

		List<Bill> list = new ArrayList<Bill>();
		try {

			preparedStatement = connect.prepareStatement(c_sql);
			System.out.println("rowNumber1" + rowNumber1);
			System.out.println("rowNumber2" + rowNumber2);
			preparedStatement.setInt(1, rowNumber1);
			preparedStatement.setInt(2, rowNumber2);
			// System.out.println("sql " + sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String billId = rs.getString("billId");
				String commodityName = rs.getString("commodityname");
				int commodityQuantity = rs.getInt("commodityquantity");
				String commodityUtil = rs.getString("commodityunit");
				double price = rs.getDouble("sumPrice");
				int havePay = rs.getInt("havepay");
				String supplierId = rs.getString("providerId");
				String commodityDesc = rs.getString("commoditydesc");
				list.add(new Bill(billId, commodityName, commodityQuantity, commodityUtil, price, havePay, supplierId,
						commodityDesc));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return list;
	}

	public int delete(String billId) {
		String sql = "delete from u2adminbilllist where billId=" + billId;
		String username = "c##u61";
		String password = "u61";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
			preparedStatement = connect.prepareStatement(sql);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return count;
	}

	public int update(String billId, String commodityName, int commodityQuantity, String commodityUnit, double sumPrice,
			int havePay, String providerId, String commodityDesc) {
		String sql = "update u2adminbilllist set commodityName=?, commodityQuantity=?, commodityUnit=?"
				+ ", sumPrice=?, havePay=?, providerId=?, commodityDesc=?" + " where billId=?";
		System.out.println("billDao update: " + sql);
		String username = "c##u61";
		String password = "u61";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
			preparedStatement = connect.prepareStatement(sql);

			preparedStatement.setString(1, commodityName);
			preparedStatement.setInt(2, commodityQuantity);
			preparedStatement.setString(3, commodityUnit);
			preparedStatement.setDouble(4, sumPrice);
			preparedStatement.setInt(5, havePay);
			preparedStatement.setString(6, providerId);
			preparedStatement.setString(7, commodityDesc);
			preparedStatement.setString(8, billId);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return count;
	}

}
