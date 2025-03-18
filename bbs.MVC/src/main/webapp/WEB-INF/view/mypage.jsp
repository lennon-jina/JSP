<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserService" %>
<%@ page import="model.UserVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>mypage</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
	<jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>	
    <script>  // 이 부분이 안 쓰면 빨갛게 되는 거
       $(document).ready(function() {
           const forms = document.querySelectorAll('.needs-validation')
           Array.from(forms).forEach(form => {
               form.addEventListener('submit', event => {
                   if (!form.checkValidity()) {
                       event.preventDefault()
                       event.stopPropagation()
                   }
                   form.classList.add('was-validated')
               }, false)
           });
       });
   </script>
    <!-- content 영역 -->
	<div class="container-fluid">
      <div class="row align-items-center" style="height:700px">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
          <form action="mypage.do" method="post" class="needs-valiadition" novalidate>
            <h3	style="text-align: center; padding-bottom: 5%; padding-top: 15%;">마이페이지</h3>
            <div class="form-group">
              <input type="text" class="form-control" disabled value="${user.userId}" maxlength="20">
              <input type="hidden" name="userId" value="${user.userId}">
            </div>
            <div class="form-group pt-1">
              <input type="text" class="form-control" disabled value="${user.userPw}" maxlength="20">
            </div>
            <div class="form-group pt-1" style="padding-bottom: 5%;">
              <input type="text" class="form-control" value="${user.userNm}" name="userNm" required>
            </div>
            <input type="submit" class="btn btn-success form-control" value="수정">
          </form>
        </div>
        <div class="col-lg-4">
        </div>
      </div>
    </div>
    <!-- content 영역 끝 -->
	<jsp:include page="/WEB-INF/inc/footer.jsp"></jsp:include>
</body>
</html>