package com.mycompany.springwebapp.controller;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springwebapp.dto.Ch02Dto;
import com.mycompany.springwebapp.dto.Ch02FileInfo;
import com.mycompany.springwebapp.interceptor.Auth;
import com.mycompany.springwebapp.interceptor.Auth.Role;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch02")
public class Ch02Controller {
   @RequestMapping("/content")
   public String content() {
      return "ch02/content";
   }
   
   //ModelAndView는 잘 안씀
   /*@RequestMapping("/content")
   public ModelAndView content() {
	   ModelAndView mav = new ModelAndView();
	   mav.setViewName("ch02/content");
	   return mav;
   }*/
   
   //@GetMapping("/method")
   @RequestMapping(value="/method", method=RequestMethod.GET)
   public String method1(String bkind, int bno) {
      log.info("bkind: "+ bkind);
      log.info("bno: "+ bno);
      return "ch02/content";
   }
   //@PostMapping("/method")
   @RequestMapping(value="/method", method=RequestMethod.POST)
   public String method2(String bkind, int bno) {
      log.info("bkind: "+ bkind);
      log.info("bno: "+ bno);
      return "ch02/content";
   }
   //@PutMapping("/method")
   /*@RequestMapping(value="/method", method=RequestMethod.PUT)
   public void method3(@RequestBody String json, HttpServletResponse response) throws Exception {
	   JSONObject jsonObject = new JSONObject(json);
	   String bkind = jsonObject.getString("bkind");
	   int bno = jsonObject.getInt("bno");
	   log.info("bkind: "+ bkind);
	   log.info("bno: "+ bno);
	   
	   JSONObject root = new JSONObject();
	   root.put("result", "success");
	   String responseJson = root.toString();  //{"result":"success"}
	   
	   response.setContentType("application/json; charset=UTF-8");
	   PrintWriter pw = response.getWriter();
	   pw.print(responseJson);
	   pw.flush();
	   pw.close();
   }*/
   @RequestMapping(value="/method", method=RequestMethod.PUT)
   public void method3(@RequestBody Ch02Dto dto, HttpServletResponse response) throws Exception {
	   log.info("bkind: "+ dto.getBkind());
	   log.info("bno: "+ dto.getBno());
	   
	   JSONObject root = new JSONObject();
	   root.put("result", "success");
	   String responseJson = root.toString();  //{"result":"success"}
	   
	   response.setContentType("application/json; charset=UTF-8");
	   PrintWriter pw = response.getWriter();
	   pw.print(responseJson);
	   pw.flush();
	   pw.close();
   }
   //@DeleteMapping("/method")
   @RequestMapping(value="/method", method=RequestMethod.DELETE)
   public void method4(@RequestBody String json, HttpServletResponse response) throws Exception {
	   JSONObject jsonObject = new JSONObject(json);
	   int bno = jsonObject.getInt("bno");
	   log.info("bno: "+ bno);
	   
	   JSONObject root = new JSONObject();
	   root.put("result", "success");
	   String responseJson = root.toString();  //{"result":"success"}
	   
	   response.setContentType("application/json; charset=UTF-8");
	   PrintWriter pw = response.getWriter();
	   pw.print(responseJson);
	   pw.flush();
	   pw.close();
   }
   
   @GetMapping("/ajax1")
   public String ajax1() {
	   return "ch02/fragmentHtml";
   }
   //JSON 리턴
   @GetMapping("/ajax2")
   public void ajax2(HttpServletResponse response) throws Exception {
	   JSONObject root = new JSONObject();
	   root.put("fileName", "photo5.jpg");
	   String responseJson = root.toString();  //{"result":"success"}
	   
	   //직접 JSON 응답을 생성
	   response.setContentType("application/json; charset=UTF-8");
	   PrintWriter pw = response.getWriter();
	   pw.print(responseJson);
	   pw.flush();
	   pw.close();
   }
   //JSON 응답 바디에 바로 넣기
   @GetMapping(value="/ajax3", produces="application/json; charset=UTF-8")
   @ResponseBody  //리턴값을 응답 본문에 바로 싣기
   public String ajax3() {
	   JSONObject root = new JSONObject();
	   root.put("fileName", "photo6.jpg");
	   String responseJson = root.toString();  //{"fileName":"photo6.jpg"}
	   return responseJson;
   }
   //객체 -> JSON 응답 바디에 바로 넣기
   @GetMapping(value="/ajax4", produces="application/json; charset=UTF-8")
   @ResponseBody  //리턴값을 JSON으로 변환(jackson-databind 라이브러리가 필요함)해서 응답 본문에 바로 싣기
   public Ch02FileInfo ajax4() {
	   Ch02FileInfo fileInfo = new Ch02FileInfo();
	   fileInfo.setFileName("photo7.jpg");
	   return fileInfo;
   }
   
   @GetMapping("/fileDownLoad")
   public void fileDownLoad(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   String fileName = "photo1.jpg";
		String filePath = "/resources/images/photo/"+ fileName;
		filePath = request.getServletContext().getRealPath(filePath);  //절대경로 써야 함
		log.info("filePath: " + filePath);
		
		//응답 헤드에 Content-Type 추가
		String mimeType = request.getServletContext().getMimeType(filePath);
		response.setContentType(mimeType);  //image/jpeg, image/png
		
		//응답 헤드에 한글 이름의 파일명을 ISO-8859-1 문자셋으로 인코딩해서 추가
		String userAgent = request.getHeader("User-Agent");
		if(userAgent.contains("Trident") || userAgent.contains("MSIE")) {
			//IE
			fileName =	 URLEncoder.encode(fileName, "UTF-8");
			log.info("IE: " + fileName);
		} else {
			//Chrome, Edge, FireFox, Safari
			fileName =	new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			log.info("Chrome: " + fileName);
		}
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");  //이게 다운로드하도록 함 없으면 브라우저에서 보여줄 수 있는 타입이면 바로 해당 페이지에 열림!
		
		//응답 본문에 파일 데이터 싣기
		OutputStream os = response.getOutputStream();
		Path path = Paths.get(filePath);
		Files.copy(path, os);
		os.flush();
		os.close();
   }
   
   @RequestMapping("/filterAndInterceptor")
   @Auth(Role.ADMIN)
   public String filterAndInterceptor() {
	   log.info("실행");
	   return "ch02/adminPage";
   }
}