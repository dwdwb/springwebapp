<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/header.jsp"%>


<div class="card m-2">
	<div class="card-header">
		재고 없음 처리(Ch10SoldoutException 처리)
		<a href="content" class="btn btn-outline-secondary btn-sm">돌아가기</a>
	</div>
	<div class="card-body text-danger">
		사유: [${message}] 의 이유로 주문할 수 없습니다.
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>