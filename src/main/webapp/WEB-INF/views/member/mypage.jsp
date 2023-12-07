<%@page import="com.edu.blooming.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<style>
	table, th, td {
		board-style : solid;
		board-width : 1px;
		text-align : center;
	}


	.form_instructor {display: none;}

</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%@ include file="/WEB-INF/views/component/navigation.jsp"%> 
	<ul class="nav justify-content-center underline">
  		<li class="nav-item">
   			<a class="nav-link" href="/blooming/member/mypage">내 활동</a>
 		</li>
		<li class="nav-item">
			<a class="nav-link" href="/blooming/member/mypage-identify">내 정보 수정</a>
		</li>
	</ul>
	<hr>
	<br>
	<br>
		
	<h5>작성한 글</h5>
	<hr>
	<table class="table">
		<thead>
			<tr>
				<th scope="col" style="width : 60px">번호</th>
				<th scope="col" style="width : 500px">제목</th>
				<th scope="col" style="width : 120px">작성자</th>
				<th scope="col" style="width : 60px">조회수</th>
				<th scope="col" style="width : 60px">댓글수</th>
				<th scope="col" style="width : 60px">좋아요</th>
				<th scope="col" style="width : 300px">작성일</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="vo" items="${listByMemberId }">
				<tr>
					<td>${vo.boardId }</td>
					<td><a href="/blooming/board/detail?boardId=${vo.boardId }">${vo.boardTitle }</a></td>
					<td>${vo.authorNickname }</td>
					<td>${vo.boardViewCount }</td>
					<td>${vo.boardReplyCount }</td>
					<td>${vo.boardLikeCount }</td>
					<fmt:formatDate value="${vo.boardDateCreated }"
					pattern="yyyy-MM-dd HH:mm:ss" var="boardDateCreated"/>
					<td>${boardDateCreated }</td>
				</tr>			
			</c:forEach>
		</tbody> 
	</table>
	
	<h5>좋아요 누른 글</h5>
	<hr>
	<table class="table">
		<thead>
			<tr>
				<th scope="col" style="width : 60px">번호</th>
				<th scope="col" style="width : 500px">제목</th>
				<th scope="col" style="width : 120px">작성자</th>
				<th scope="col" style="width : 60px">조회수</th>
				<th scope="col" style="width : 60px">댓글수</th>
				<th scope="col" style="width : 60px">좋아요</th>
				<th scope="col" style="width : 300px">작성일</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="vo" items="${listByLike }">
				<tr>
					<td>${vo.boardId }</td>
					<td><a href="/blooming/board/detail?boardId=${vo.boardId }">${vo.boardTitle }</a></td>
					<td>${vo.authorNickname }</td>
					<td>${vo.boardViewCount }</td>
					<td>${vo.boardReplyCount }</td>
					<td>${vo.boardLikeCount }</td>
					<fmt:formatDate value="${vo.boardDateCreated }"
					pattern="yyyy-MM-dd HH:mm:ss" var="boardDateCreated"/>
					<td>${boardDateCreated }</td>
				</tr>			
			</c:forEach>
		</tbody> 
	</table>	
	
	<h5>작성한 댓글</h5>
	<hr>
	<table class="table">
		<thead>
			<tr>
				<th scope="col" style="width : 60px">번호</th>
				<th scope="col" style="width : 700px">댓글내용</th>
				<th scope="col" style="width : 300px">작성일</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="vo" items="${replyListByMemberId }">
				<tr>
					<td>${vo.boardReplyId }</td>
					<td><a href="/blooming/board/detail?boardId=${vo.boardId }">${vo.boardReplyContent }</a></td>
					<fmt:formatDate value="${vo.boardReplyDateCreated }"
					pattern="yyyy-MM-dd HH:mm:ss" var="boardReplyDateCreated"/>
					<td>${boardReplyDateCreated }</td>
				</tr>			
			</c:forEach>
		</tbody> 
	</table>
		
	<br>
	<hr>

	<%@ include file="/WEB-INF/views/component/footer.jsp"%>	
	

</body>
</html>