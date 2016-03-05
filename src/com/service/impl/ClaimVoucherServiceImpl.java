package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.beans.ClaimVoucher;
import com.beans.Pager;
import com.dao.impl.ClaimVoucherDaoImpl;
import com.service.ClaimVoucherService;

@Service("claimVoucherService")
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ClaimVoucherServiceImpl implements ClaimVoucherService {

	private final int PAGE_SIZE = 4;

	@Autowired
	@Qualifier("claimVoucherDao")
	ClaimVoucherDaoImpl claimVoucherDao;

	@Override

	public List<ClaimVoucher> getAll() {
		return claimVoucherDao.getAll();
	}

	private List<Long> calcuPageList(long totalPage, int pageSize) {
		List<Long> pageList = new ArrayList<Long>();
		for (long i = 1; i <= totalPage; i++) {
			pageList.add(i);
		}
		return pageList;
	}

	private void getParamFromMap(DetachedCriteria dc, Map<String, Object> map) {
		if (map != null) {
			if (map.get("status") != null && map.get("status").toString().length() != 0) {
				dc.add(Restrictions.eq("status", map.get("status").toString()));
			}

			if (map.get("startDate") != null) {
				dc.add(Restrictions.gt("createTime", map.get("startDate")));
			}

			if (map.get("endDate") != null) {
				dc.add(Restrictions.lt("createTime", map.get("endDate")));
			}
		}
	}

	@Override
	public Pager getByDetachedCriteria(Map<String, Object> map, int currentPage) {
		DetachedCriteria dc = DetachedCriteria.forClass(ClaimVoucher.class);
		getParamFromMap(dc, map);
		int pageSize = PAGE_SIZE;
		int beginIndex = (currentPage - 1) * pageSize;
		List<ClaimVoucher> claimVoucherList = claimVoucherDao.getByDetachedCriteria(dc, beginIndex, pageSize);

		long totalPage = getTotalPages(map);

		return new Pager(currentPage, pageSize, totalPage, claimVoucherList, calcuPageList(totalPage, pageSize));
	}

	@Override
	public long getTotalPages(Map<String, Object> map) {
		System.out.println(this.getClass() + " get total pages ");
		DetachedCriteria dc = DetachedCriteria.forClass(ClaimVoucher.class);
		getParamFromMap(dc, map);
		int pageSize = PAGE_SIZE;
		long rowCount = claimVoucherDao.getTotalCountByDetachCriteria(dc);
		long temp = rowCount % pageSize;
		long totalPage = 0;
		if (temp != 0) {
			totalPage = rowCount / pageSize + 1;
		} else if (temp == 0) {
			totalPage = rowCount / pageSize;
		}
		return totalPage;
	}

	@Override
	public Pager searchByPaging(Map<String, Object> map, int currentPage) {
		System.err.println(this.getClass() + " searchByPaging " + currentPage);

		DetachedCriteria dc = DetachedCriteria.forClass(ClaimVoucher.class);
		getParamFromMap(dc, map);
		int pageSize = PAGE_SIZE;
		int beginIndex = (currentPage - 1) * pageSize;
		List<ClaimVoucher> claimVoucherList = claimVoucherDao.getByDetachedCriteria(dc, beginIndex, pageSize);

		long totalPage = getTotalPages(map);

		return new Pager(currentPage, pageSize, totalPage, claimVoucherList, calcuPageList(totalPage, pageSize));
	}

	@Override
	public void insert(ClaimVoucher newClaimVoucher) {
		claimVoucherDao.insert(newClaimVoucher);
	}
}
