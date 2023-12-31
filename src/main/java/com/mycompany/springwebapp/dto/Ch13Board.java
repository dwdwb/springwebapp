package com.mycompany.springwebapp.dto;

import java.sql.Blob;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Ch13Board {
	private int bno;
	private String btitle;
	private String bcontent;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bdate;
	private String mid;
	private int bhitcount;
	//Client -> Controller
	private MultipartFile battach;
	//Controller -> Service
	private String battachoname;
	private String battachtype;
	//방법1: 서버 파일 시스템에 파일로 저장 (대용량 파일)
	private String battachsname;
	//방법2: DB에 BLOB으로 저장
	//MyBatis에서 Byte[] <- MyBatis -> BLOB 자동변환
	private byte[] battachdata;
}
