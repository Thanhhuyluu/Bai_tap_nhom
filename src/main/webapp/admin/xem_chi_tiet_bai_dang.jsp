<%@page import="model.bean.ChuyenMuc"%>
<%@page import="model.bean.BaiDang"%>
<%@page import="model.bean.DiaDiem"%>
<%@page import="model.bean.KhuVuc"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.google.gson.Gson" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xem Bài Đăng</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/them_bai_dang_form.css">
</head>
<body>

	<%
	

	BaiDang baiDang = (BaiDang) request.getAttribute("baiDang");

	DiaDiem diaDiem = (DiaDiem) request.getAttribute("diaDiem");

	ArrayList<ChuyenMuc> chuyenMucList = (ArrayList<ChuyenMuc>) request.getAttribute("chuyenMucList");
	%>
    <div class="container">
        <h2>Xem Bài Đăng</h2>
        <form class="add-form" action="${pageContext.request.contextPath}/admin-xu-ly-sua-bai-dang" method="POST">
  			<input type="text"  name="maBaiDang" hidden value="<%=baiDang.getMaBaiDang()%>">
            <div class="form-group">
                <label for="post-title">Tên Bài Đăng</label>
                <input type="text" id="post-title" name="post-title" placeholder="Nhập tên bài đăng" required value="<%=baiDang.getTenBaiDang()%>">
            </div>


            <div class="form-group">
                <label for="region">Mã Khu Vực</label>
                <select id="region" name="region" required readonly>
                    
                   
                    
                    <option selected value="<%=diaDiem.getMaKhuVuc()%>"><%=diaDiem.getMaKhuVuc() %></option>
                 
                  
                    
                </select>
                
            </div>
            <div class="form-group">
                <label for="diaDiem">Chọn địa điểm</label>
                <select id="diaDiem" name="diaDiem" required>
				    <option value="" selected>Chọn địa điểm</option>
				    <%if(diaDiem!= null) {%>
				    <option value="<%=diaDiem.getMaDiaDiem() %>" selected><%=diaDiem.getTenDiaDiem() %></option>
				    <%} %>
				    
				</select>
                
            </div>
			<div class="form-group">
              		<label for="img">Hình Ảnh Bài Đăng</label>
                    <input type="text" id="img" name="img" value="<%=baiDang.getHinhAnh() %>" >
                    <img src="<%= baiDang.getHinhAnh() %>" alt="Existing Image" width="100" height="100">
            </div>          

            <div class="form-group">
                <label for="description">Mô Tả Địa Điểm</label>
                <textarea id="description" name="description" rows="4" placeholder="Nhập mô tả địa điểm"><%=baiDang.getMoTaBaiDang() %></textarea>
            </div>

            <div id="topic-container">
                <h3>Chuyên Mục</h3>
                
                <%
                for(ChuyenMuc c : chuyenMucList) {
                %>
                
                <div class="topic-item">
                    <div class="form-group">
                        <label for="topic-name-1">Tên Chuyên Mục</label>
                        <input type="text" id="topic-name-1" name="topic-name[]" placeholder="Nhập tên chuyên mục" value="<%= c.getTenChuyenMuc()%>">
                    </div>
                    <div class="form-group">
                        <label for="topic-description-1">Mô Tả Chuyên Mục</label>
                        <textarea id="topic-description-1" name="topic-description[]" rows="3" placeholder="Nhập mô tả chuyên mục"><%=c.getMoTa()%></textarea>
                    </div>
                    <div class="form-group">
                        <label for="topic-image-1">Hình Ảnh Chuyên Mục</label>
                        <input type="text" id="topic-image-1" name="topic-image[]" value="<%=c.getHinhAnh()%>">
                        <img src="<%= c.getHinhAnh() %>" alt="Existing Image" width="100" height="100">
                    </div>
                    
                     <input type="text" hidden name="maChuyenMucList[]"  value="<%= c.getMaChuyenMuc()%>">
                </div>
                
                <%} %>
            </div>

            
            <a href="${pageContext.request.contextPath}/admin-xem-bai-dang" id="cancel-btn" >Trở Về</a>
        </form>
    </div>

   
</body>
</html>
