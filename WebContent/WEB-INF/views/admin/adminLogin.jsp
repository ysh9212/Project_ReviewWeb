<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지입니다</title>
<style type="text/css">
.container{
	width: 100%;
	text-align: center;
}
.btn{
	text-align: center;
	margin-top: 40px;
	text-decoration: none;
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
}
.btn:hover{
  background:#fff;
  color:#007294;
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
.class{
	width: 100px;
}
.wrapper{
	text-align: center;
	
	margin-top: 10em;
	height: 15em;
	width: 50%;
	vertical-align: middle;
	margin-left: auto;
    margin-right: auto;
    border: 1px solid black;
}

</style>
</head>
<body>
<div class="container">
	<div class="wrapper">
		<h2>UDK 관리자 페이지 LOGIN</h2>
		<form action="./adminLogin" method="post">
			<div class="form-group">
				<div class="login">ID </div> 
				<input type="text" class="form-control"	name="id" placeholder="Put In ID">
			</div>
			<div class="form-group">
				<div class="login">PassWord </div> 
				<input type="password"
					class="form-control" name="pw" placeholder="Put In PassWord">
			</div>
			<input type="submit" class="btn" value="Login">
		</form>
		</div>
	</div>
</body>
</html>