package com.mycompany.springwebapp.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.springwebapp.dao.Ch12DaoByAnnotation1;
import com.mycompany.springwebapp.dao.Ch12DaoByAnnotation2;
import com.mycompany.springwebapp.dao.Ch12DaoByAnnotation3;
import com.mycompany.springwebapp.dao.Ch12DaoI;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch12ServiceDiByAnnotation {
	//필드
	@Autowired  //@Resource
	private Ch12DaoByAnnotation1 daoAnnotation1;
	
	private Ch12DaoByAnnotation2 daoAnnotation2;
	private Ch12DaoByAnnotation3 daoAnnotation3;
	
	//필드
	@Resource(name="ch12DaoImpl1")
	private Ch12DaoI ch12Dao1;
	@Autowired @Qualifier("ch12DaoImpl2")
	private Ch12DaoI ch12Dao2;
	
	//생성자
	public Ch12ServiceDiByAnnotation() {
		log.info("실행1");
	}
	//생성자
	//@Autowired  //생성자 주입(잘 안씀)
	public Ch12ServiceDiByAnnotation(Ch12DaoByAnnotation1 daoAnnotation1) {
		log.info("실행2");
		this.daoAnnotation1 = daoAnnotation1;
	}
	
	//Setter
	public void setCh12DaoByXml1(Ch12DaoByAnnotation1 daoAnnotation1) {
		log.info("실행");
		this.daoAnnotation1 = daoAnnotation1;
	}
	
	@Autowired  //@Resource
	public void setCh12DaoByXml2(Ch12DaoByAnnotation2 daoAnnotation2) {
		log.info("실행");
		this.daoAnnotation2 = daoAnnotation2;
	}
	@Autowired  //@Resource
	public void setCh12DaoByXml3(Ch12DaoByAnnotation3 daoAnnotation3) {
		log.info("실행");
		this.daoAnnotation3 = daoAnnotation3;
	}
	
	//인스턴스 메소드
	public void method() {
		daoAnnotation1.method();
		daoAnnotation2.method();
		daoAnnotation3.method();
		ch12Dao1.method();
		ch12Dao2.method();
	}
}