<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/header.jsp"%>


<div class="card m-2">
	<div class="card-header">
		예외 처리(404)
		<a href="content" class="btn btn-danger btn-sm">돌아가기</a>
	</div>
	<div class="card-body">
		사유: 잘못된 경로로 요청하셨습니다.
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>