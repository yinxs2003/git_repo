package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beans.ClaimVoucher;
import com.dao.ClaimVoucherDao;

@Repository("claimVoucherDao")
public class ClaimVoucherDaoImpl implements ClaimVoucherDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClaimVoucher> getAll() {
		String hql = "from ClaimVoucher";
		List<ClaimVoucher> claimVoucherList = getSession().createQuery(hql).list();
		System.out.println(this.getClass() + " claimVoucherList： " + claimVoucherList);
		return claimVoucherList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClaimVoucher> getByDetachedCriteria(DetachedCriteria dcCriteria, int beginIndex, int pageSize) {
		// System.err.println(this.getClass() + " getByDetachedCriteria ");
		Session session = getSession();
		Criteria criteria = dcCriteria.getExecutableCriteria(session);
		return criteria.setFirstResult(beginIndex).setMaxResults(pageSize).list();
	}

	@Override
	public Long getTotalCountByDetachCriteria(DetachedCriteria dcCriteria) {

		Session session = getSession();
		Criteria criteria = dcCriteria.getExecutableCriteria(session);

		long rowCount = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		criteria.setProjection(null);// 必须设置为null才能继续数据查询

		System.err.println(this.getClass() + " rowCount " + rowCount);
		return rowCount;
	}

	/**
	 * 根据条件查询总页数,获取分页查询的总页数
	 */
	@Override
	public long getTotalPages(Map<String, Object> map) {

		String hql = "select count(*) from ClaimVoucher";
		return (long) getSession().createQuery(hql).uniqueResult();
	}

	public void insert(ClaimVoucher newClaimVoucher) {
		getSession().save(newClaimVoucher);
	}

}
