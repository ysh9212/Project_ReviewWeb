package com.project.community.page;

public class Search {
	private String kind;
	private String search;
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		if(kind==null) {
			// kind - �� �˻��Ҷ� �� ��ü��;
			this.kind="title";
		}else if(kind.equals("writer")) {
			this.kind="writer";
		}else if(kind.equals("contents")) {
			this.kind="contents";
		}else {
			this.kind="title";
		}
	}
	public String getSearch() {
		return search;
	}
	public void setSerch(String search) {
		if(search==null) {
			this.search="";
		}else {
			this.search=search;
		}
	}
}
