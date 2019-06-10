package com.project.community.page;

public class SearchPager {
	private Search search;
	private int curPage;
	// 시작 번호
	private int startNum;
	// 끝 번호
	private int lastNum;
	// 페이지당 block?
	private int curBlock;
	// 전체 block
	private int totalBlock;
	
	public Search getSearch() {
		return search;
	}
	public void setSearch(Search search) {
		this.search = search;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getLastNum() {
		return lastNum;
	}
	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

}
