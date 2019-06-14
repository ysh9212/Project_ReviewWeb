<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
.header{
	width: 100%;
	border: 0;
	height: 60px;
	border-bottom: 3px solid silver;
	vertical-align: middle;
	text-align: center;
	background-color: #007294;
	margin-top: 0;

}
.left{
	padding:10px 0px 10px 10px;
	border-right: solid 3px silver;
	text-decoration: none;
	width: 15%;
	float: left;
}
ul.leftmenu{
	list-style: none;
	margin: 0;
	padding: 0;
}
li{
display: list-item;
}
.tit{
	font-weight: bold;
	padding-left: 18px;
	margin-bottom: 5px;
	text-align: left;
}
ul.leftmenu ol{
	padding-left: 25px;
}
li.menu{
	padding: 0;
	margin: 2px 0px 2px 0px;
	text-align: left;
}
li.menu a{
	color: gray;
}
.leftmenu a:link{
	text-decoration: none;
}
.main{
	float : left;
	width: 80%;
}
table {
	border-collapse: collapse;
	border-spacing: 0;
}
/* TABLE */
.table{
	width: inherit;
	margin-bottom: 20px;
}
thead{
	display: table-header-group;
	vertical-align: middle;
	border-color: inherit;
}
tr{
	display: table-row;
	vertical-align: inherit;
	border-color: inherit;
	
	
}
.table > thead > tr> th {
	vertical-align: bottom;
	border-bottom: 2px solid #ddd;
}
th {
	text-align: left;
	color: #333;
	font-weight: bold;
	padding: 8px;
}
tbody{
	display: table-row-group;
	vertical-align: middle;
	border-color: inherit;
}
td{
	padding: 8px;
	line-height: 1.4;
	vertical-align: top;
	border-top : 1px solid #ddd;
	
}
td a{
	text-decoration: none;
}
a{
	color: gray;
}
.table-striped {
  > tbody > tr:nth-of-type(odd) {
    background-color: @table-bg-accent;
  }
}



.table-hover > tbody > tr:hover {
    background-color: #ddd;
  }
}
/* 페이지 css */
.center{
	text-align: center;
	align-items: center;
}
.pager{
	padding-left: 0;
	margin: 20px 0;
	text-align: center;
	list-style: none;
}
.pagination {
  display: inline-block;
  list-style: none;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  border: 1px solid #ddd;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}

.pagination a:first-child {
  border-top-left-radius: 5px;
  border-bottom-left-radius: 5px;
}

.pagination a:last-child {
  border-top-right-radius: 5px;
  border-bottom-right-radius: 5px;
}
</style>