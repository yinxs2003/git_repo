package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseDao {
	Connection connect = null;
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;
	Scanner input = new Scanner(System.in);
	int count = 0;// 执行update受影响的行数

	public BaseDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 程序退出时候调用
	 */
	public void closeResource() {
		try {
			if (rs != null) {
				preparedStatement.close();
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

	/**
	 * 
	 * @param date格式为yyyy-mm-dd
	 */
	private String checkDate() {
		String regex = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$";
		Pattern pattern = Pattern.compile(regex);

		boolean flag = true;
		while (flag) {
			String date = input.next();
			Matcher matcher = pattern.matcher(date);
			if (matcher.matches()) {
				flag = false;
				return date;
			} else {
				System.out.println("非法的日期格式，请重新输入(yyyy-mm-dd)");
			}
		}
		return null;
	}

	/**
	 * @param date
	 * @return
	 */
	public String getDate() {
		String dateString = checkDate();
		return dateString;
	}

	/**
	 * 循环输入int
	 * 
	 * @return
	 */
	public int whileScanInt() {
		// System.out.println("请输入数字：");
		boolean flag = true;
		while (flag) {
			try {
				int select = input.nextInt();
				flag = false;
				return select;
			} catch (Exception e) {
				System.out.println("你输入的不是数字，请重新输入：");
				input.next();
			}
		}
		return -1;
	}

}
