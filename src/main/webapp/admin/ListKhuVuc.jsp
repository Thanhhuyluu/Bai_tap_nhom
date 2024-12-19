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

ArrayList<KhuVuc> khuVucList = (ArrayList<KhuVuc>) request.getAttribute("khuVucList");
%>

    <div class="sidebar">
        <div class="logo">
            <h2 class="main-heading">TraReSys</h2>
        </div>
        <ul class="menu">
            <li><a href="#" class="active">Bài đăng</a></li>
            <li><a href="#">Khu Vực</a></li>
            <li><a href="#">Người dùng</a></li>
            <li><a href="#">Đăng xuất</a></li>
        </ul>
    </div>
    <div class="container">
        <h2 >Tất cả bài đăng</h2>
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
                    <th>Mã bài đăng</th>
                    <th>Tên bài đăng</th>
                    <th>Địa điểm</th>
                    <th>Người đăng</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <%
                if(list == null) list = new ArrayList();
                for(BaiDang b : list) {
                %>
                
                <tr> 
                	<td><%=b.getMaBaiDang() %></td>
                    <td><a href="#"><%=b.getTenBaiDang() %></a></td>
                     <td><%=b.getMaDiaDiem()%></td>
                    <td><%=b.getMaNguoiDang() %></td>
                    <td>
                        <span class="action-icons">
                            <a href="${pageContext.request.contextPath}/admin-xem-chi-tiet-bai-dang?maBaiDang=<%=b.getMaBaiDang() %>" class="action-icon-link"><i class="fa-solid fa-circle-info"></i></a>
                            <a href="${pageContext.request.contextPath}/admin-sua-bai-dang?maBaiDang=<%=b.getMaBaiDang() %>" class="action-icon-link"><i class="fa-solid fa-pen-to-square"></i></a>
                        	<a onclick="return confirm('Bạn có chắc chắn muốn xóa bài đăng này không?');" 
							   href="${pageContext.request.contextPath}/admin-xoa-bai-dang?maBaiDang=<%=b.getMaBaiDang() %>" 
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
