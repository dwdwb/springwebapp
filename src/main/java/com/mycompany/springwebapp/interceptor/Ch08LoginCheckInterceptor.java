package com.mycompany.springwebapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycompany.springwebapp.dto.Ch08Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch08LoginCheckInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("실행");
		
		//요청 처리 메소드가 @login가 붙어 있는지 확인
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Login login = handlerMethod.getMethodAnnotation(Login.class);
		if(login != null) {
			//@login 붙어 있을 경우
			HttpSession session = request.getSession();
			Ch08Member member = (Ch08Member) session.getAttribute("login");
			//로그인이 되었다면
			if(member != null) {
				return true;
			} else {
				//로그인이 안되어있다면
				response.sendRedirect(request.getContextPath() + "/ch08/content");
				return false;
			}
		} else {
			//@login 안 붙어 있을 경우
			return true;
		}
	}
}
