<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%--
1) header.jsp의 소스코드를 복사해서 붙여넣기
2) 절대 경로/ 는 웹애플리케이션의 로컬 루트(WebContent 폴더)
 --%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%-- index.jsp 의 중앙내용 --%>
<div class="card m-2">
   <div class="card-header">
      Home
   </div>
   <div class="card-body">
   </div>
</div>

<%--
1) footer.jsp의 소스코드를 복사해서 붙여넣기 
2) 절대 경로/는 웹애플리케이션의 로컬 루트(WebContent 폴더)
--%>
<%@ include file="/WEB-INF/views/common/footer.jsp"  %>