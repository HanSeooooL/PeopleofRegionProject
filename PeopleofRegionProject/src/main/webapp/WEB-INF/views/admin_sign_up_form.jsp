<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 회원가입</title>

	<link href="${pageContext.request.contextPath}/resources/css/admin/admin_sign_up_form.css" rel="stylesheet" type="text/css">
	<jsp:include page="include/admin_sign_up_form_js.jsp" />
</head>
<body>
	<section>
		<div id="section_wrap">
			<div id="form_title">
				<h3>관리자 회원가입</h3>
			</div>
			
			<div id="admin_signup_form">
			
				<form action="<c:url value='/admin/member/adminsignupconfirm'/>" name="create_admin_member_form" method="post" >
					
					<input type="text" name="a_m_id" placeholder="아이디를 입력해주세요" class="input"> <br/>
					<input type="password" name="a_m_pw" placeholder="비밀번호를 입력해주세요" class="input"> <br/>
					<input type="password" name="a_m_pw_again" placeholder="비밀번호 확인" class="input"> <br/>
					<input type="text" name="a_m_name" placeholder="이름을 입력해주세요" class="input"> <br/>
					
					<input type="button" value="SIGN UP" onclick="adminSignUpForm();">
					<input type="reset" value="CANCEL">
					
				</form>
			</div>
			
		</div>
	</section>
</body>
</html>