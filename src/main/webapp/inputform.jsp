<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz01_240522</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js"
        integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</head>
<body>
    <form action="/input.movies" method="get">
        <table border=1 align="center">
            <tr>
                <td colspan="4">
                    영화 이름 <input type="text" name="title">
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    영화 장르 <input type="text" name="genre">
                </td>
            </tr>
            <tr>
                <td colspan="4" align="end">
                    <button type="submit">전송</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>