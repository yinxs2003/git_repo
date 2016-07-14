package com.Biz;

import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.entity.User;

public class UserBiz {
	private UserDao userDao = new UserDao();
	private int pageSize = 4;

	public ArrayList<User> getAll() {
		ArrayList<User> list = userDao.getAll();
		return list;
	}

	public List<User> searchByCondition(String userName, int pageNow) {
		int rowNumber1 = (pageNow - 1) * pageSize;
		int rowNumber2 = pageNow * pageSize;
		System.out.println(pageNow);
		System.out.println(rowNumber1);
		System.out.println(rowNumber2);
		return userDao.searchByConditon(userName, rowNumber1, rowNumber2);
	}

	public int getPageCount() {
		// 总的条目数
		int count = userDao.getPageCount();
		// 网页上显示的链接总数
		int pageCount = 0;
		if (count % pageSize == 0) {
			pageCount = count / pageSize;
		} else {
			pageCount = count / pageSize + 1;
		}
		return pageCount;
	}

	public int insert(String userId, String userName, String password, String sex, int age, String phoneNumber,
			String address, int power) {
		return userDao.insert(userId, userName, password, sex, age, phoneNumber, address, power);
	}

	public int delete(String userId) {
		return userDao.delete(userId);

	}

	public int update(String userId, String userName, String passWord, String sex, int age, String phoneNumber,
			String address, String power) {
		return userDao.update(userId, userName, passWord, sex, age, phoneNumber, address, power);
	}

	public int update(String userId, String userName, String sex, int age, String phoneNumber, String address) {
		return userDao.update(userId, userName, sex, age, phoneNumber, address);
	}

}
