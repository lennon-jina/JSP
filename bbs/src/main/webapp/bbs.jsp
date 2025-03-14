<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.1.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>
	
	    <!-- content 영역 -->
	<main class="container-fluid p-3">
		<div class="row d-flex align-items-center"  style="height: 600px;">
			<div class="col-lg-1"></div>
			<div class="col-lg-10">
				<table class="table table-striped" style="text-align:center;" >
					<thead>
						<tr>
						   <th style="background-color: #eeeeee; text-align:center">번호</th>
						   <th style="background-color: #eeeeee; text-align:center">제목</th>
						   <th style="background-color: #eeeeee; text-align:center">작성자</th>
						   <th style="background-color: #eeeeee; text-align:center">작성일</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>안녕하세요</td>
							<td>길동</td>
							<td>2023-08-28</td>
						</tr>
						<tr>
							<td>2</td>
							<td>안녕하세요</td>
							<td>동길</td>
							<td>2023-08-28</td>
						</tr>
							<tr>
							<td>3</td>
							<td>안녕하세요</td>
							<td>팽수</td>
							<td>2023-08-28</td>
						</tr>
					</tbody>
				</table>
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					<a href="write.jsp" class="btn btn-dark pull-right" role="button" >글쓰기</a>
				</div>
			</div>
			<div class="col-lg-1">
			</div>
		</div>
	</main>
    <!-- content 영역 끝 -->
	
	<jsp:include page="/WEB-INF/inc/footer.jsp"></jsp:include>
</body>
</html>