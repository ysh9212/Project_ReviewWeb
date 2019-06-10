package com.project.community.page;

public class SearchMakePage {
	private int perPage;
	private int curPage;
	private Search search;
	
	public SearchMakePage(int curPage, String kind, String search) {
		this(curPage, 10, kind, search);
	}
	public SearchMakePage(int curPage, int perPage, String kind, String search) {
		this.perPage=perPage;
		this.curPage=curPage;
		this.search = new Search();
		// 검색하려는 종류;
		this.search.setKind(kind);
		// 검색하려는 단어;
		this.search.setSerch(search);
	}
	// row
	public SearchRow makeRow() {
		int startRow=(curPage-1)*perPage+1;
		int lastRow=curPage*perPage;
		SearchRow searchRow = new SearchRow();
		searchRow.setStartRow(startRow);
		searchRow.setLastRow(lastRow);
		searchRow.setSearch(search);
		return searchRow;
	}
	// page
	public SearchPager makePage(int totalCount) {
		int totalPage = totalCount/perPage;
		if(totalCount%perPage != 0) {
			totalPage++;
		}
		int perBlock=10;
		int totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		int curBlock = curPage/perBlock;
		if(curPage%perBlock != 0) {
			curBlock++;
		}
		int startNum=(curBlock-1)*perBlock+1;
		int lastNum=curBlock*perBlock;
		if(curBlock == totalBlock) {
			lastNum=totalPage;
		}
		SearchPager searchPager = new SearchPager();
		searchPager.setCurPage(curPage);
		searchPager.setCurBlock(curBlock);
		searchPager.setLastNum(lastNum);
		searchPager.setStartNum(startNum);
		searchPager.setTotalBlock(totalBlock);
		searchPager.setSearch(search);
		return searchPager;
	}
}
