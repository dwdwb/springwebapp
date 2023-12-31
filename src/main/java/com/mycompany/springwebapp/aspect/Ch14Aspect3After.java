package com.mycompany.springwebapp.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14Aspect3After {
	//after로 시작하는 모든 메소드
	@After("execution(public * com.mycompany.springwebapp.controller.Ch14Controller.after*(..))")
	public void method() {
		log.info("실행");
	}
}
