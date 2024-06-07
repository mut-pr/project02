<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
 <style>
        *{box-sizing: border-box;}
        div{border: 1px solid black;}

        .container{
            width: 400px;
            height: 100px;
            margin: auto;
        }

        .header{
            width:100%; height: 30%;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .content{
            display: flex;
            width:100%; height: 70%;
        }

        .col{
            flex:1;
            height:100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .col button{
            width:80%;
            height:60%;
            font-size: 18px;
        }
    </style>
</head>
<body>
	
	<div class="container">
        <div class="header">선호 영화 관리 시스템</div>
        <div class="content">
            <div class="col">
                <button id="inputBtn">영화 등록하기</button>
            </div>
            <div class="col">
                <button id="outputBtn">영화 조회하기</button>
            </div>
        </div>
    </div>
    
    <script>
        $("#inputBtn").on("click", function(){
            location.href = "inputform.jsp";
        });

        $("#outputBtn").on("click", function(){
            location.href = "output.jsp";
        });

    </script>
	
	
</body>
</html>