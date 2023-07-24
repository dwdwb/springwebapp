<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">모델(데이터) 전달</div>
	<div class="card-body">
		<div class="m-2">
			<a href="useRequest1" class="btn btn-outline-success btn-sm">request 이용1</a>
			<a href="useRequest2" class="btn btn-outline-success btn-sm">request 이용2</a>
			<a href="useRequest3" class="btn btn-outline-success btn-sm">request 이용3</a>
			<a href="useRequest4?bno=4&btitle=제목4&bcontent=내용4&bwriter=글쓴이4&bdate=2023-07-24" class="btn btn-outline-success btn-sm">request 이용4</a>
			<a href="useRequest5?bno=5&btitle=제목5&bcontent=내용5&bwriter=글쓴이5&bdate=2023-07-24" class="btn btn-outline-success btn-sm">request 이용5</a>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>