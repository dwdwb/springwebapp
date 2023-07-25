<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/header.jsp"%>


<div class="card m-2">
	<div class="card-header bg-dark text-white">
		예외 처리 내용(NullPointerException 처리)
	</div>
	<div class="card-body bg-dark text-white">
		서버가 점검 중입니다. 잠시 후에 다시 시도해 주십시오.
		<a href="content" class="btn btn-outline-danger btn-sm">돌아가기</a>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>