<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyTube</title>
<link rel="stylesheet" href="/resources/css/default.css" />
<link rel="stylesheet" href="/resources/css/style.css" />
<link rel="shortcut icon" href="/resources/images/youtube.ico" type="image/x-icon">
</head>
<body>
	<nav class="nav">
		<div class="nav_left">
			<a>
				<img alt="mytube" src="/resources/images/youtube.ico">
				MyTube
			</a>
		</div>

		<div class="nav_center">
			<input type="text">
			<button type="button" class="nav_search">Search</button>
		</div>

		<div class="nav_right">
			<a>acount</a>
		</div>
	</nav>
	
	<div class="contents">
		
	</div>
	<script
	  src="https://code.jquery.com/jquery-3.5.1.js"
	  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	  crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(".nav_search").on("click",function(){
			const word = $(".nav_center input[type='text']").val();
			$.ajax({
				url : "/youtube",
				type : "get",
				dataType : "json",
				data : {"search" : word},
				success : function(data){
					alert(JSON.stringify(data));
					$("div.contents").html(JSON.stringify(data));
					}
				})
		})
	</script>
</body>
</html>

