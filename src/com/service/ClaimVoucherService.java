package com.service;

import java.util.List;
import java.util.Map;

import com.beans.ClaimVoucher;
import com.beans.Pager;

public interface ClaimVoucherService {
	List<ClaimVoucher> getAll();

	Pager getByDetachedCriteria(Map<String, Object> map, int currentPage);

	long getTotalPages(Map<String, Object> map);

	Pager searchByPaging(Map<String, Object> map, int currentPage);

	void insert(ClaimVoucher newClaimVoucher);}
