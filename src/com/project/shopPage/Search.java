package com.project.shopPage;

public class Search {
	private String kind;
	private String search;
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		if(kind == null) {
			this.kind = "pc";
		} else if(kind.equals("mobile")) {
			this.kind = "mobile";
		} else if(kind.equals("etc")) {
			this.kind = "etc";
		} else {
			this.kind = "pc";
		}
		
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		if(search == null) {
			this.search="";
		}else {
			this.search = search;
		}
	}
}
