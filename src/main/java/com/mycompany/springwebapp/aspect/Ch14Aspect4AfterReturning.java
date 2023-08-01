package com.mycompany.springwebapp.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14Aspect4AfterReturning {
	//after로 시작하는 모든 메소드
	@AfterReturning(
		pointcut="execution(public * com.mycompany.springwebapp.controller.Ch14Controller.afterReturning*(..))",
		returning="returnValue"
	)
	public void method(String returnValue) {
		log.info("실행");
		log.info("리턴값: " + returnValue);
	}
}
