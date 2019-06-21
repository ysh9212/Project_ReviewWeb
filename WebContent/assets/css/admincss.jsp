<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
/*header  */
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
	color: #5d93a2;
}
.tit a{
	color: black;
	text-decoration: none;
}
.table-striped {
  > tbody > tr:nth-of-type(odd) {
    background-color: @table-bg-accent;
  }
}



.table-hover > tbody > tr:hover {
    background-color: #ddd;
  }
/* 버튼 */
.btn{
  background:#007294;
  color:#fff;
  border:none;
  position:relative;
  height:40px;
  font-size:1.3em;
  padding:0 0.7em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
  border-radius: 10px;
  float: right;
  text-decoration: none;
}
.btn:before,.button:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #007294;
  transition:400ms ease all;
}
.btn:hover{
  background:#fff;
  color:#007294;
}
.btn:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
.btn:hover:before,.btn:hover:after{
  width:100%;
  transition:800ms ease all;
}
.rounded {
  border-radius: 10px;
}
.btn1.blue {box-shadow: 0px 4px #74a3b0;}
.btn1.blue:active {box-shadow: 0 0 #74a3b0; background-color: #709CA8;}
.btn1.blue, .btn-two.blue     {background-color: #7fb1bf;}

.btn1 {
	position: relative;
	border: 0;
	padding: 10px 20px;
	display: inline-block;
	text-align: center;
	color: white;
	cursor: pointer;
}
/* 페이지 css */
.adminhome{
	float: right;
	text-decoration: none;
	color: black;
	font-weight: bold;
}
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
.pager li{
	display: inline;
}
.pager li>a, .pager li>span {
    display: inline-block;
    padding: 5px 14px;
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 15px;
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
.pagination>li:first-child>a, .pagination>li:first-child>span {
    margin-left: 0;
    border-top-left-radius: 4px;
    border-bottom-left-radius: 4px;
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