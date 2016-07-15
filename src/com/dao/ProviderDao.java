package com.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Page;
import com.entity.Provider;

public class ProviderDao extends BaseDao {
	private Page page = new Page();

	public List<Provider> searchByConditon(String c_providerName, String c_providerDesc, int rowNumber1,
			int rowNumber2) {
		String sql = null;
		sql = "select * from provider where providerDesc like '%" + c_providerDesc + "%' and providerName like '%"
				+ c_providerName + "%'";

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

		List<Provider> list = new ArrayList<Provider>();
		try {

			preparedStatement = connect.prepareStatement(c_sql);
			System.out.println("rowNumber1" + rowNumber1);
			System.out.println("rowNumber2" + rowNumber2);
			preparedStatement.setInt(1, rowNumber1);
			preparedStatement.setInt(2, rowNumber2);
			// System.out.println("sql " + sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				// System.out.println("herefffff");
				String providerId = rs.getString("providerId");
				String providerName = rs.getString("providerName");
				String providerDesc = rs.getString("providerDesc");
				String providerMobile = rs.getString("providerMobile");
				String providerAddress = rs.getString("providerAddress");
				list.add(new Provider(providerId, providerName, providerDesc, providerMobile, providerAddress));
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

	public int insert(String providerId, String providerName, String providerDesc, String providerMobile,
			String providerAddress) {
		int count = 0;
		String sql = "insert into provider values(?,?,?,?,?)";
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

			preparedStatement.setString(1, providerId);
			preparedStatement.setString(2, providerName);
			preparedStatement.setString(3, providerDesc);
			preparedStatement.setString(4, providerDesc);
			preparedStatement.setString(5, providerAddress);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return count;
	}

	public List<Provider> getAll() {
		String sql = "select * from provider";
		String username = "c##u61";
		String password = "u61";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<Provider> providerList = new ArrayList<Provider>();
		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
			preparedStatement = connect.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String providerId = rs.getString("providerId");
				String providerName = rs.getString("providerName");
				String providerDesc = rs.getString("providerDesc");
				String providerMobile = rs.getString("providerMobile");
				String providerAddress = rs.getString("providerAddress");
				providerList.add(new Provider(providerId, providerName, providerDesc, providerMobile, providerAddress));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return providerList;
	}

	public int delete(String providerId) {
		String sql = "delete from provider where providerid=?";
		int count = 0;
		String username = "c##u61";
		String password = "u61";
		System.out.println("providerId"+providerId);
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, providerId);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return count;
	}

	public int update(String providerId, String providerName, String providerDesc, String providerMobile,
			String providerAddress) {
		int count = 0;
		String sql = "update provider set providerName=?,providerDesc=?,providerMobile=?,providerAddress=? where providerid=?";
		String username = "c##u61";
		String password = "u61";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		System.out.println("provider dao mobile"+providerMobile);
		try {
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", username, password);
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, providerName);
			preparedStatement.setString(2, providerDesc);
			preparedStatement.setString(3, providerMobile);
			preparedStatement.setString(4, providerAddress);
			preparedStatement.setString(5, providerId);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return count;
	}
}
