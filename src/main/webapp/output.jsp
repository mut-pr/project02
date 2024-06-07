<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" ></script> 
</head>
<body>
	<div class="container">
		<header class="header">
			<div class="h_id"></div>
			<div class="h_title"></div>
			<div class="h_genre"></div>
		</header>
		<section>
			<c:forEach var="dto" items="${list }">
				<div class="row">
					<div class="id">${dto.id }</div>
					<div class="title">${dto.title }</div>
					<div class="genre">${dto.genre }</div>
					<form action="/delete.movies">
						<div class="button"><button class="btndelete">X</button></div>
					</form>	
				</div>
			</c:forEach>
		</section>
		<div class="boxupdate">
			<form action="/update.movies">
				<div class="boxinput"><input type="text" name="id" placeholder="수정할 영화 아이디를 입력하세요."></div>
				<div class="boxupdate"><input type="text" name="title" placeholder="영화제목입력"></div>
				<div class="boxupdate"><input type="text" name="genre" placeholder="영화장르입력"></div>
				<div class="button"><button class="btnupdate">완료</button></div>
			</form>
		</div>
	</div>
</body>
</html>