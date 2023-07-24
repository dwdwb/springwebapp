package com.mycompany.springwebapp.controller;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dto.Ch04Form1;
import com.mycompany.springwebapp.dto.Ch04Form2;
import com.mycompany.springwebapp.dto.Ch04JoinForm;
import com.mycompany.springwebapp.dto.Ch04LoginForm;
import com.mycompany.springwebapp.validator.Ch04Form1Validator;
import com.mycompany.springwebapp.validator.Ch04Form2Validator;
import com.mycompany.springwebapp.validator.Ch04JoinFormValidator;
import com.mycompany.springwebapp.validator.Ch04LoginFormValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch04")
public class Ch04Controller {
   @RequestMapping("/content")
   public String content() {
      return "ch04/content";
   }
   
   //어떤 녀석으로 유효성 검사를 할지 바인딩을 초기화함
   @InitBinder("ch04Form1")
   public void ch04Form1Validator(WebDataBinder binder) {
	   binder.setValidator(new Ch04Form1Validator());
   }
   @InitBinder("ch04Form2")
   public void ch04Form2Validator(WebDataBinder binder) {
	   binder.setValidator(new Ch04Form2Validator());
   }
   @InitBinder("ch04JoinForm")
   public void ch04JoinFormValidator(WebDataBinder binder) {
	   binder.setValidator(new Ch04JoinFormValidator());
   }
   @InitBinder("ch04LoginForm")
   public void ch04LoginFormValidator(WebDataBinder binder) {
	   binder.setValidator(new Ch04LoginFormValidator());
   }
   
   @PostMapping("/method1")
   //pom.xml에 validation-api 라이브러리 의존 설정 필요
   //request.setAttribute("ch04Form1", form1);로 자동 저장
   public String method1(@Valid Ch04Form1 form1, Errors errors) {
	   //errors.rejectValue(...)가 한번이라도 호출되었다면 hasErrors()는 true를 리턴
	   if(errors.hasErrors()) {
		   return "ch04/content";
	   }
	   
	   //요청 처리 코드
	   log.info("param1: " + form1.getParam1());
	   log.info("param2: " + form1.getParam2());
	   log.info("param3: " + form1.getParam3());
	   log.info("param4: " + form1.isParam4());
	   log.info("param5: " + form1.getParam5());
	   return "redirect:/";
   }
   @RequestMapping("/method2")
   public String method2(@Valid Ch04Form2 form2, Errors errors) {
	   if(errors.hasErrors()) {
		   return "ch04/content";
	   }
	   
	   log.info("param1: " + form2.getParam1());
	   log.info("param2: " + form2.getParam2());
	   log.info("param3: " + form2.getParam3());
	   log.info("param4: " + form2.isParam4());
	   log.info("param5: " + form2.getParam5());
	   return "redirect:/";
   }
   @RequestMapping("/join")
   public String join(@Valid Ch04JoinForm joinForm, Errors errors) {
	   if(errors.hasErrors()) {
		   return "ch04/content";
	   }
	   
	   log.info("mid: " + joinForm.getMid());
	   log.info("mpassword: " + joinForm.getMpassword());
	   log.info("memail: " + joinForm.getMemail());
	   log.info("mtel: " + joinForm.getMtel());
	   return "redirect:/";
   }
   @RequestMapping("/login")
   public String join(@Valid Ch04LoginForm loginForm, Errors errors) {
	   if(errors.hasErrors()) {
		   return "ch04/content";
	   }
	   
	   log.info("mid: " + loginForm.getMid());
	   log.info("mpassword: " + loginForm.getMpassword());
	   return "redirect:/";
   }
}