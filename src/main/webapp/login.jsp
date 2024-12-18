<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_register.css">
    <title>Đăng nhập</title>
</head>
<body>
    <div class="main">

        <form action="" method="POST" class="form" id="form-2">
          <h3 class="heading">Đăng nhập</h3>
          
  
          <div class="spacer"></div>
  
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
  
          <button class="form-submit">Đăng nhập</button>
        </form>
  
    </div>
      
     
</body>
<script>
  
    document.addEventListener('DOMContentLoaded', function () {
     


      Validator({
        form: '#form-2',
        formGroupSelector: '.form-group',
        errorSelector: '.form-message',
        rules: [
          Validator.isEmail('#email'),
          Validator.minLength('#password', 6),
        ],
        onSubmit: function (data) {
          console.log(data);
        }
      });
    });

  </script>
<script src="${pageContext.request.contextPath}/js/regex.js"></script>
</html>