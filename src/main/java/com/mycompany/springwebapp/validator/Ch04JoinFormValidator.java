package com.mycompany.springwebapp.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.springwebapp.dto.Ch04JoinForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04JoinFormValidator implements Validator {
	//form1로 넘어온 데이터만 유효성 검사
	@Override
	public boolean supports(Class<?> clazz) {
		log.info("실행");
		boolean check = Ch04JoinForm.class.isAssignableFrom(clazz);
		return check;
	}
	
	//supports가 true를 리턴할 때만 실행됨
	@Override
	public void validate(Object target, Errors errors) {
		log.info("실행");
		Ch04JoinForm ch04JoinForm = (Ch04JoinForm) target;
		
		//mid 검사
		String mid = ch04JoinForm.getMid();
		if(mid == null || mid.equals("")) {
			errors.rejectValue("mid", "errors.form.required", "필수 입력(D)");
		} else if(mid.length() < 4) {
			errors.rejectValue("mid", "errors.form.minlength", new Object[] {4}, "최소 4자 입력(D)");
		} else if(mid.length() > 8) {
			errors.rejectValue("mid", "errors.form.maxlength",  new Object[] {8}, "최대 8자 입력(D)");
		}

		//mpassword 검사
		String mpassword = ch04JoinForm.getMpassword();
		if(mpassword == null || mpassword.equals("")) {
			errors.rejectValue("mpassword", "errors.form.required", "필수 입력(D)");
		} else if(mpassword.length() < 8) {
			errors.rejectValue("mpassword", "errors.form.minlength", new Object[] {8}, "최소 8자 입력(D)");
		} else if(mid.length() > 15) {
			errors.rejectValue("mpassword", "errors.form.maxlength",  new Object[] {15}, "최대 15자 입력(D)");
		}
		
		//meamil 검사
		String memail = ch04JoinForm.getMemail();
		if(memail == null || memail.equals("")) {
			errors.rejectValue("memail", "errors.form.required", "필수 입력(D)");
		} else {
			String regExp = "([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)";
			boolean result = Pattern.matches(regExp, memail);
			if(result == false) {
				errors.rejectValue("memail", "errors.form.format", "이메일 형식에 맞지 않음(D)");
			}
		}
		
		//mtel 검사
		String mtel = ch04JoinForm.getMtel();
		if(mtel == null || mtel.equals("")) {
			errors.rejectValue("mtel", "errors.form.required", "필수 입력(D)");
		} else {
			String regExp = "(010|011)-[0-9]{3,4}-[0-9]{4}";
			boolean result = Pattern.matches(regExp, mtel);
			if(result == false) {
				errors.rejectValue("mtel", "errors.form.format", "전화번호 형식에 맞지 않음(D)");
			}
		}
		
	}
}
