package com.Biz;

import java.util.List;

import com.dao.ProviderDao;
import com.entity.Provider;

public class ProviderBiz {
	private ProviderDao providerDao = new ProviderDao();

	private int pageSize = 4;

	public List<Provider> searchByCondition(String c_commodityName, String c_providerName, int pageNow) {
		int rowNumber1 = (pageNow - 1) * pageSize;
		int rowNumber2 = pageNow * pageSize;
		System.out.println(pageNow);
		System.out.println(rowNumber1);
		System.out.println(rowNumber2);
		return providerDao.searchByConditon(c_commodityName, c_providerName, rowNumber1, rowNumber2);
	}

	public int getPageCount() {
		// 总的条目数
		int count = providerDao.getPageCount();
		// 网页上显示的链接总数
		int pageCount = 0;
		if (count % pageSize == 0) {
			pageCount = count / pageSize;
		} else {
			pageCount = count / pageSize + 1;
		}
		return pageCount;
	}

	public int insert(String providerId, String providerName, String providerDesc, String providerMobile,
			String providerAddress) {
		int count = providerDao.insert(providerId, providerName, providerDesc, providerMobile, providerAddress);
		return count;
	}

	public List<Provider> getAll() {
		return providerDao.getAll();
	}

	public int delete(String providerId) {
		return providerDao.delete(providerId);
	}

	public int update(String providerId, String providerName, String providerDesc, String providerMobile,
			String providerAddress) {
		return providerDao.update(providerId, providerName, providerDesc, providerMobile, providerAddress);
	}

}
