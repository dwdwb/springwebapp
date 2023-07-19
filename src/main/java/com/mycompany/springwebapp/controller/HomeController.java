package com.mycompany.springwebapp.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
   public HomeController() {
      log.info("실행");
   }
   
   @PostConstruct  //객체가 만들어지고 나서 바로 생성
   public void method1() {
      log.info("실행");
   }
   @PostConstruct //객체가 만들어지고 나서 바로 생성
   public void method2() {
      log.info("실행");
   }
   
   @PreDestroy //객체가 없어질때 (어플리케이션이 종료될때) 실행된다.
   public void method3() {
      log.info("실행");
   }
   // http://localhost:8080/springwebapp/ 요청을 하면 HomeController.index() 실행
   @RequestMapping("/")
   public String viewIndex() {
      log.info("실행");
      return "home";
   }
}