<%@page import="model.bean.KhuVuc"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.BaiDang"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/fontawesome-free-6.6.0-web/css/all.min.css">

</head>
<body>

<%

	List<KhuVuc> list = (List<KhuVuc>) request.getAttribute("listKhuVuc");
%>

    <div class="sidebar">
        <div class="logo">
            <h2 class="main-heading">TraReSys</h2>
        </div>
        <ul class="menu">
            <li><a href="${pageContext.request.contextPath}/admin-xem-bai-dang" >Bài đăng</a></li>
            <li><a href="${pageContext.request.contextPath}/admin-xem-khu-vuc" class="active">Khu Vực</a></li>
            <li><a href="${pageContext.request.contextPath}/admin-xem-nguoi-dung">Người dùng</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
        </ul>
    </div>
    <div class="container">
        <h2 >Tất cả Khu Vực</h2>
        <form action="${pageContext.request.contextPath}/admin-tim-kiem" class="search-container">
		    <input type="text" placeholder="Search" class="search-input">
		   
		    <button class="search-button">
		        <i class="fa-solid fa-magnifying-glass"></i>
		    </button>
		</form>
		<div class="add-button-wrapper">
			<a href="${pageContext.request.contextPath}/admin-them-bai-dang" class="add-button">Thêm</a>
		</div>
        <table>
            <thead>
                <tr>
                    <th>Mã khu vực</th>
                    <th>Tên khu vực</th>                   
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <%
                if(list == null) list = new ArrayList();
                for(KhuVuc kv : list) {
                %>
                
                <tr> 
                	<td><%=kv.getMaKhuVuc() %></td>
                    <td><a href="#"><%=kv.getTenKhuVuc() %></a></td>
                    <td>
                        <span class="action-icons">
                            
                            <a href="${pageContext.request.contextPath}/admin-sua-khu-vuc?maKhuVuc=<%= kv.getMaKhuVuc() %>" class="action-icon-link"><i class="fa-solid fa-pen-to-square"></i></a>
                        	<a onclick="return confirm('Bạn có chắc chắn muốn xóa khu vực này không?');" 
							   href="${pageContext.request.contextPath}/admin-xoa-khu-vuc?maKhuVuc=<%= kv.getMaKhuVuc() %>" 
							   class="action-icon-link">
							   <i class="fa-solid fa-trash"></i>
							</a>
							                        	    
                        </span>
                    </td>
                </tr>
            	<%} %>
            </tbody>
        </table>
    </div>
</body>
</html>
