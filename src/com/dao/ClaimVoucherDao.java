package com.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.beans.ClaimVoucher;
import com.beans.Pager;

public interface ClaimVoucherDao {
	/**
	 * 查询所有
	 * 
	 * @return ClaimVoucher集合
	 */
	List<ClaimVoucher> getAll();

	List<ClaimVoucher> getByDetachedCriteria(DetachedCriteria dcCriteria, int beginIndex, int pageSize);

	long getTotalPages(Map<String, Object> map);

	Long getTotalCountByDetachCriteria(DetachedCriteria dcCriteria);
}
