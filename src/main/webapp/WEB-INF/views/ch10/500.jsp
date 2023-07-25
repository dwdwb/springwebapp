<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/header.jsp"%>


<div class="card m-2">
	<div class="card-header bg-dark text-white">
		예외 처리 내용(500)
		<a href="content" class="btn btn-outline-warning btn-sm">돌아가기</a>
	</div>
	<div class="card-body bg-dark text-white">
		[경고] 알 수 없는 예외 발생.
		즉시 관리자에게 문의 바랍니다.
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>