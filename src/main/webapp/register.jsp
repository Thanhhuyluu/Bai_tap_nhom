<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_register.css">
    <title>Đăng kí</title>
</head>
<body>
    <div class="main">

        <form action="" method="POST" class="form " id="form-1">
          <h3 class="heading">Đăng ký</h3>
  
          <div class="spacer"></div>
  
          <div class="form-group">
            <label for="fullname" class="form-label">Tên đầy đủ</label>
            <input id="fullname" name="fullname" type="text" placeholder="VD: Huy Luu" class="form-control">
            <span class="form-message"></span>
          </div>
  
          <div class="form-group">
            <label for="email" class="form-label">Email</label>
            <input id="email" name="email" type="text" placeholder="VD: email@domain.com" class="form-control">
            <span class="form-message"></span>
          </div>
  
          <div class="form-group">
            <label for="password" class="form-label">Mật khẩu</label>
            <input id="password" name="password" type="password" placeholder="Nhập mật khẩu" class="form-control">
            <span class="form-message"></span>
          </div>
  
          <div class="form-group">
            <label for="password_confirmation" class="form-label">Nhập lại mật khẩu</label>
            <input id="password_confirmation" name="password_confirmation" placeholder="Nhập lại mật khẩu" type="password" class="form-control">
            <span class="form-message"></span>
          </div>
  
          <button class="form-submit">Đăng ký</button>
        </form>
  
        
  
    </div>
      
     
</body>
<script>

		document.addEventListener('DOMContentLoaded', function () {
		  Validator({
		    form: '#form-1',
		    formGroupSelector: '.form-group',
		    errorSelector: '.form-message',
		    rules: [
		      Validator.isRequired('#fullname', 'Vui lòng nhập tên đầy đủ của bạn'),
		      Validator.isEmail('#email'),
		      Validator.minLength('#password', 6),
		      Validator.isRequired('#password_confirmation'),
		      Validator.isConfirmed('#password_confirmation', function () {
		        return document.querySelector('#form-1 #password').value;
		      }, 'Mật khẩu nhập lại không chính xác')
		    ],
		    onSubmit: function (data) {
		      console.log(data);
		    }
		  });
		
		
		});



</script>
<script src="${pageContext.request.contextPath}/js/regex.js"></script>
</html>