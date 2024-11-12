package com.hanseol.community.admin.member;

/**
 * 관리자 회원 정보 객체
 */
public class AdminMemberVO {
	int a_m_no; 	// 식별번호
	int a_m_approval; // 승인 여부
	String a_m_id;		// 아이디
	String a_m_pw;		// 비밀번호
	String a_m_name;	// 이름
	String a_m_reg_date;	// 관리자 등록일
	String a_m_mod_date;	// 관리자 수정일
	
	public int getA_m_no() {
		return a_m_no;
	}
	public void setA_m_no(int a_m_no) {
		this.a_m_no = a_m_no;
	}
	public int getA_m_approval() {
		return a_m_approval;
	}
	public void setA_m_approval(int a_m_approval) {
		this.a_m_approval = a_m_approval;
	}
	public String getA_m_id() {
		return a_m_id;
	}
	public void setA_m_id(String a_m_id) {
		this.a_m_id = a_m_id;
	}
	public String getA_m_pw() {
		return a_m_pw;
	}
	public void setA_m_pw(String a_m_pw) {
		this.a_m_pw = a_m_pw;
	}
	public String getA_m_name() {
		return a_m_name;
	}
	public void setA_m_name(String a_m_name) {
		this.a_m_name = a_m_name;
	}
	public String getA_m_reg_date() {
		return a_m_reg_date;
	}
	public void setA_m_reg_date(String a_m_reg_date) {
		this.a_m_reg_date = a_m_reg_date;
	}
	public String getA_m_mod_date() {
		return a_m_mod_date;
	}
	public void setA_m_mod_date(String a_m_mod_date) {
		this.a_m_mod_date = a_m_mod_date;
	}
	
	
	
}
