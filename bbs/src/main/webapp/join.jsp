<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
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
          <form action="joinAction.jsp" method="post" class="needs-valiadition" novalidate>
            <h3	style="text-align: center; padding-bottom: 5%; padding-top: 15%;">회원가입 화면</h3>
            <div class="form-group">
              <input type="text" class="form-control" placeholder="아이디" name="userId" maxlength="20" required>
              <div class="valid-feedback">
                  완벽!
              </div>
              <div class="invalid-feedback">
                  아이디 필수!!!
              </div>
            </div>
            <div class="form-group pt-1">
              <input type="password" class="form-control" placeholder="비밀번호" name="userPw" maxlength="20" required>
                <div class="invalid-feedback">
                  비번 필수!!!
                </div>
            </div>
            <div class="form-group pt-1"  style="padding-bottom: 5%;">
              <input type="text" class="form-control" placeholder="이름" name="userNm" required>
                 <div class="invalid-feedback">
                  이름 필수!!!
                </div>
            </div>
            <input type="submit" class="btn btn-primary form-control" value="회원가입">
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