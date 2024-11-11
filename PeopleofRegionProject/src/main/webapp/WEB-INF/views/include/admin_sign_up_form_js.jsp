<%--
  Created by IntelliJ IDEA.
  User: hanseol
  Date: 24. 11. 11.
  Time: 오후 6:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<script type="text/javascript">

    function adminSignUpForm() {
        console.log('createAccountForm() CALLED!!');

        let form = document.create_admin_member_form;

        if (form.a_m_id.value == '') {
            alert('아이디를 입력해주세요.');
            form.a_m_id.focus();

        } else if (form.a_m_pw.value == '') {
            alert('비밀번호를 입력해주세요.');
            form.a_m_pw.focus();

        } else if (form.a_m_pw_again.value == '') {
            alert('비밀번호 확인을 입력해주세요.');
            form.a_m_pw_again.focus();

        } else if (form.a_m_pw.value != form.a_m_pw_again.value) {
            alert('입력된 비밀번호가 서로 다릅니다.');
            form.a_m_pw.focus();

        } else if (form.a_m_name.value == '') {
            alert('이름을 입력해주세요');
            form.a_m_name.focus();

        } else {
            form.submit();
        }

    }

</script>
