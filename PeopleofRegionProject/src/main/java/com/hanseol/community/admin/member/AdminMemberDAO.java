package com.hanseol.community.admin.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 관리자 회원 데이터베이스 어댑터 오브젝트
 * 201911695 한설
 * */
@Component
public class AdminMemberDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	// 이미 존재하는 계정인지 확인
	public boolean isAdminMember(String a_m_id) {
		System.out.println("[AdminMemberDao] isAdminMember()");
		
		String sql = "select COUNT(*) from admin_user where a_m_id = ?";
		
		int result = jdbcTemplate.queryForObject(sql, Integer.class, a_m_id);
		
		if (result > 0) return true;
		else return false;
	}
	
	// 데이터베이스에 관리자 멤버 삽입
	public int insertAdminMember(AdminMemberVO adminMemberVO) {
		System.out.println("[AdmionMemberDAO] insertAdminMember()");
		
		List<String> args = new ArrayList<String>();
	
		String sql = "insert into admin_user(";
		
		if (adminMemberVO.getA_m_id().equals("super admin")) {
			sql += "a_m_approval, ";
			args.add("1");
		}
		
		sql += "a_m_id, ";
		args.add(adminMemberVO.getA_m_id());
		
		sql += "a_m_pw, ";
		args.add(passwordEncoder.encode(adminMemberVO.getA_m_pw()));
		
		sql += "a_m_name, ";
		args.add(adminMemberVO.getA_m_name());
		
		sql += "a_m_reg_date, a_m_mod_date) ";
		
		if(adminMemberVO.getA_m_id().equals("super admin"))
			sql += "VALUES(?, ?, ?, ?, NOW(), NOW())";
		
		else
			sql += "VALUES(?, ?, ?, NOW(), NOW())";
		
		int result = -1;
		
		try {
			result = jdbcTemplate.update(sql, args.toArray());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public List<AdminMemberVO> selectAdmins() {
		System.out.println("[AdminMemberDAO] selectAdmins()");
		String sql = "select * from admin_user";
		List<AdminMemberVO> result = new ArrayList<>();
		try {
			result = jdbcTemplate.query(sql, new RowMapper<AdminMemberVO>() {
				@Override
				public AdminMemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
					AdminMemberVO adminMemberVO = new AdminMemberVO();
					adminMemberVO.setA_m_id(rs.getString("a_m_id"));
					adminMemberVO.setA_m_pw(rs.getString("a_m_pw"));
					adminMemberVO.setA_m_name(rs.getString("a_m_name"));
					adminMemberVO.setA_m_reg_date(rs.getString("a_m_reg_date"));
					adminMemberVO.setA_m_mod_date(rs.getString("a_m_mod_date"));

					return adminMemberVO;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
