<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>사원 등록</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/signin.css" rel="stylesheet">
  </head>
	
	<script>
		window.addEventListener('load', function(){
			document.querySelector('#signupBtn').onclick = function(){
				var idObj = document.querySelector('#id');
				var pwdObj = document.querySelector('#pwd');
				if(idObj.value.trim().length<4){
					alert('ID는 4글자 이상입니다.');
					return;
				}
				if(pwdObj.value.trim().length<6){
					alert('Password는 6글자 이상입니다.');
					return;
				}
				var xhr = new XMLHttpRequest();
				xhr.open('POST', '/emp/login');
				xhr.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
				xhr.onreadystatechange = function(){
					if(xhr.readyState==4){
						var obj = JSON.parse(xhr.response);
						if(obj.result=='false'){
							alert('아이디나 비밀번호가 잘못되었습니다.');
							idOBj.value='';
							pwdObj.value='';
							idObj.focus();
						} else {
							location.href="/uri/index";
						}
					}
				}
				var param = 'id=' + idObj.value + '&pwd=' + pwdObj.value;
				xhr.send(param);
			}
		});		
	</script>

  <body class="text-center">
    <form class="form-signin" action="/emp/insert" method="post">
      <img class="mb-4" src="/resources/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign up</h1>
      <label for="text" class="sr-only">Your Name</label>
      <input type="text" id="name" class="form-control" placeholder="Your Name" required autofocus name="name">
       <label for="inputEmail" class="sr-only">Email address</label>
      <input type="text" id="id" class="form-control" placeholder="ID" required autofocus name="id">
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="pwd" class="form-control" placeholder="Password" required name="pwd">      
      <select name="deptNo" id="deptNo" onchange="changeDept(this)" class="form-control">
      		<option value="" disabled selected>Select Dept</option>
      	<c:forEach items="${deptList}" var="dept">
      		<option value="${dept.DEPTNO}">${dept.DNAME}</option>
      	</c:forEach>      	
      </select>
    
      <button class="btn btn-lg btn-primary btn-block" type="button" id="signupBtn">Sign up</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
  </body>
</html>
