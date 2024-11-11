package com.hanseol.community.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
 * 관리자 회원 컨트롤러
 * 201911695 한설
 * */
@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
	
	@Autowired
	AdminMemberService adminMemberService;
	
	//관리자 회원가입 창 생성
	@RequestMapping(value = "/adminsignup", method = RequestMethod.GET)
	public String adminSignUp() {
		System.out.println("[AdminMemberController] adminSignUp()");
		String nextPage = "admin_sign_up_form";
		
		return nextPage;
	}
	
	//관리자 회원가입 승인
	@PostMapping("/adminsignupconfirm")
	public String adminSignUpConfirm(AdminMemberVO adminMemberVO) {
		System.out.println("[AdminMembercontroller] adminSignUpConfirm()");
		String nextPage = "admin_sign_up_ok";
		
		int result = adminMemberService.createAccountConfirm(adminMemberVO);
		
		if (result <= 0) nextPage = "admin_sign_up_ng";
		
		return nextPage;
	}
	
	
}
