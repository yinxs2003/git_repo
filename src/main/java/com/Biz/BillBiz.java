package com.Biz;

import java.util.ArrayList;
import java.util.List;

import com.dao.BillDao;
import com.entity.Bill;

public class BillBiz {
	private BillDao billDao = new BillDao();
	private int pageSize = 4;
	// private int pageNow = 1;// 默认显示第一页
	// private int rowCount = 0;// 该值从数据库中查询
	private int pageCount = 0;// 该值是通过pageSize和rowCount

	public ArrayList<Bill> getAll() {
		return billDao.getAll();
	}

	public List<Bill> getPages(int firstPage, int pageSize) {
		// firstPage来自于jsp页面的值
		int rowNumber1 = (firstPage - 1) * pageSize;
		int rowNumber2 = firstPage * pageSize;
		return billDao.getPages(rowNumber1, rowNumber2);
	}

	public int getPageCount() {
		int rowCount = getConditionCount();
		if (rowCount % pageSize == 0) {
			pageCount = rowCount / pageSize;
		} else {
			pageCount = rowCount / pageSize + 1;
		}
		System.out.println("数据总行数：" + rowCount);
		System.out.println("应该有的页数：" + pageCount);
		return pageCount;
	}

	public int getConditionCount() {
		return billDao.getConditionCount();
	}

	public void resettConditionCount() {
		billDao.resetConditionCount();
	}

	/**
	 * 
	 * @param condition
	 *            输入查询条件
	 * @param havePay
	 *            是否已经支付条件
	 * @param pageNow
	 *            当前页
	 * @return 账单集合
	 */
	public List<Bill> searchByCondition(String condition, String havePay, int pageNow) {
		int rowNumber1 = (pageNow - 1) * pageSize;
		int rowNumber2 = pageNow * pageSize;
		// System.out.println(pageNow);
		// System.out.println(rowNumber1);
		// System.out.println(rowNumber2);
		return billDao.searchByConditon(condition, havePay, rowNumber1, rowNumber2);
	}

	/**
	 * 插入逻辑
	 * 
	 * @param billId
	 * @param commodityName
	 * @param commodityQuantity
	 * @param commodityUnit
	 * @param sumPrice
	 * @param havePay
	 * @param supplierId
	 * @param commoditydesc
	 * @return 受影响行数
	 */
	public int insert(String billId, String commodityName, int commodityQuantity, String commodityUnit, double sumPrice,
			int havePay, int supplierId, String commoditydesc) {

		return billDao.insert(billId, commodityName, commodityQuantity, commodityUnit, sumPrice, havePay, supplierId,
				commoditydesc);
	}

	public int delete(String billId) {
		return billDao.delete(billId);
	}

	public int update(String billId, String commodityName, int commodityQuantity, String commodityUnit, double sumPrice,
			int havePay, String providerId, String commodityDesc) {
		return billDao.update(billId, commodityName, commodityQuantity, commodityUnit, sumPrice, havePay, providerId,
				commodityDesc);
	}
}
