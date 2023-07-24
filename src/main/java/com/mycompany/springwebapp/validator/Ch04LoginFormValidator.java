package com.mycompany.springwebapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.springwebapp.dto.Ch04LoginForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04LoginFormValidator implements Validator {
	//form1로 넘어온 데이터만 유효성 검사
	@Override
	public boolean supports(Class<?> clazz) {
		log.info("실행");
		boolean check = Ch04LoginForm.class.isAssignableFrom(clazz);
		return check;
	}
	
	//supports가 true를 리턴할 때만 실행됨
	@Override
	public void validate(Object target, Errors errors) {
		log.info("실행");
		Ch04LoginForm ch04LoginForm = (Ch04LoginForm) target;
		
		//mid 검사
		String mid = ch04LoginForm.getMid();
		if(mid == null || mid.equals("")) {
			errors.rejectValue("mid", "errors.form.required", "필수 입력(D)");
		} else if(mid.length() < 4) {
			errors.rejectValue("mid", "errors.form.minlength", new Object[] {4}, "최소 4자 입력(D)");
		} else if(mid.length() > 8) {
			errors.rejectValue("mid", "errors.form.maxlength",  new Object[] {8}, "최대 8자 입력(D)");
		}

		//mpassword 검사
		String mpassword = ch04LoginForm.getMpassword();
		if(mpassword == null || mpassword.equals("")) {
			errors.rejectValue("mpassword", "errors.form.required", "필수 입력(D)");
		} else if(mpassword.length() < 8) {
			errors.rejectValue("mpassword", "errors.form.minlength", new Object[] {8}, "최소 8자 입력(D)");
		} else if(mid.length() > 15) {
			errors.rejectValue("mpassword", "errors.form.maxlength",  new Object[] {15}, "최대 15자 입력(D)");
		}
	}
}
