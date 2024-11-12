package com.hanseol.community.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 관리자 회원 서비스 객체
 * 201911695 한설
 */
@Service
public class AdminMemberService {
	
	final static public int ADMIN_ACCOUNT_ALREADY_EXIST = 0;
	final static public int ADMIN_ACCOUNT_CREATE_SUCCESS = 1;
	final static public int ADMIN_ACCOUNT_CREATE_FAIL = -1;
	
	@Autowired
	AdminMemberDAO adminMemberDAO;
	
	// 관리자계정 생성 승인 메소드
	public int createAccountConfirm(AdminMemberVO adminMemberVO) {
		System.out.println("[AdminMemberService] createAccountconfirm()");
		
		boolean isMember = adminMemberDAO.isAdminMember(adminMemberVO.getA_m_id());
		
		if(!isMember) {
			int result = adminMemberDAO.insertAdminMember(adminMemberVO);
			
			if (result > 0) return ADMIN_ACCOUNT_CREATE_SUCCESS;
			else return ADMIN_ACCOUNT_CREATE_FAIL;
		} else return ADMIN_ACCOUNT_ALREADY_EXIST;
	}
}
