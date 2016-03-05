package com.beans;

import java.util.List;

public class Pager {
	private int currentPage = 1;// 当前页
	private int pageSize;// 每页条数
	private long totalPage;
	private List<ClaimVoucher> claimVoucherList;
	private List<Long> pageList;// 存放页数的数字的数组

	public Pager() {
	}

	/**
	 * 
	 * @param currentPage
	 *            当前页码
	 * @param pageSize
	 *            页面条数
	 * @param totalPage
	 *            总页数
	 * @param claimVoucherList
	 *            存放来自数据库表结果集
	 * @param pageList
	 *            存放页数的数字的数组
	 */
	public Pager(int currentPage, int pageSize, long totalPage, List<ClaimVoucher> claimVoucherList,
			List<Long> pageList) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.claimVoucherList = claimVoucherList;
		this.pageList = pageList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public List<ClaimVoucher> getClaimVoucherList() {
		return claimVoucherList;
	}

	public void setClaimVoucherList(List<ClaimVoucher> claimVoucherList) {
		this.claimVoucherList = claimVoucherList;
	}

	@Override
	public String toString() {
		return "Pager [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", claimVoucherList=" + claimVoucherList + ", pageList=" + pageList + "]";
	}

	public List<Long> getPageList() {
		return pageList;
	}

	public void setPageList(List<Long> pageList) {
		this.pageList = pageList;
	}
}
