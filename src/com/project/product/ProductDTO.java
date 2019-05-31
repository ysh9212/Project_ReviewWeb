package com.project.product;

public class ProductDTO {
	private int pnum;
	private int pcategory_num;
	private String pname;
	private String pcontents;
	private int price;
	private String preg_date;
	private int pcount;
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getPcategory_num() {
		return pcategory_num;
	}
	public void setPcategory_num(int pcategory_num) {
		this.pcategory_num = pcategory_num;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcontents() {
		return pcontents;
	}
	public void setPcontents(String pcontents) {
		this.pcontents = pcontents;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPreg_date() {
		return preg_date;
	}
	public void setPreg_date(String preg_date) {
		this.preg_date = preg_date;
	}
	public int getPcount() {
		return pcount;
	}
	public void setPcount(int pcount) {
		this.pcount = pcount;
	}
	
	
}
