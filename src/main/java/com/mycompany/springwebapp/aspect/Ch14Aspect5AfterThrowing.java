package com.mycompany.springwebapp.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14Aspect5AfterThrowing {
	//after로 시작하는 모든 메소드
	@AfterThrowing(
		pointcut="execution(public * com.mycompany.springwebapp.controller.Ch14Controller.afterThrowing*(..))",
		throwing="e"
	)
	public void method(Throwable e) {
		log.info("실행");
		log.info("에러 메시지: " + e.getMessage());
	}
}
