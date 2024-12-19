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
    <title>Thêm Bài Đăng</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/them_bai_dang_form.css">
</head>
<body>

	<%
	
	ArrayList<KhuVuc> khuVucList = (ArrayList<KhuVuc>) request.getAttribute("khuVucList");
	ArrayList<DiaDiem> diaDiemList = (ArrayList<DiaDiem>) request.getAttribute("diaDiemList");
	ArrayList<ChuyenMuc> chuyenMucList = (ArrayList<ChuyenMuc>) request.getAttribute("chuyenMucList");
	BaiDang baiDang = (BaiDang) request.getAttribute("baiDang");
	DiaDiem diaDiem = (DiaDiem) request.getAttribute("diaDiem");
	
	%>
    <div class="container">
        <h2>Sửa Bài Đăng</h2>
        <form class="add-form" action="${pageContext.request.contextPath}/admin-xu-ly-sua-bai-dang" method="POST">
  			<input type="text"  name="maBaiDang" hidden value="<%=baiDang.getMaBaiDang()%>">
            <div class="form-group">
                <label for="post-title">Tên Bài Đăng</label>
                <input type="text" id="post-title" name="post-title" placeholder="Nhập tên bài đăng" required value="<%=baiDang.getTenBaiDang()%>">
            </div>


            <div class="form-group">
                <label for="region">Chọn Khu Vực</label>
                <select id="region" name="region" required>
                    <option value="" selected>Chọn khu vực</option>
                    <%
                    for(KhuVuc k : khuVucList){
                    	if(k.getMaKhuVuc() == diaDiem.getMaKhuVuc()){
                    %>
                    
                    <option selected value="<%=k.getMaKhuVuc()%>"><%=k.getTenKhuVuc() %></option>
                    <%}else { %>
                    
                    
                    <option value="<%=k.getMaKhuVuc()%>"><%=k.getTenKhuVuc() %></option>
                    <%} %>
                    
                    <%} %>
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

            <button type="button" id="add-topic-btn">Thêm Chuyên Mục</button>

            <div class="form-group">
                <button type="submit" class="submit-btn">Lưu Bài Đăng</button>
            </div>
            <a href="${pageContext.request.contextPath}/admin-xem-bai-dang" id="cancel-btn" >Hủy</a>
        </form>
    </div>

    <script>
   		 const diaDiemData = <%= new Gson().toJson(diaDiemList) %>;
   		 
   		 document.addEventListener("DOMContentLoaded", function () {
   	        const regionSelect = document.getElementById("region");
   	        const diaDiemSelect = document.getElementById("diaDiem");

   	        regionSelect.addEventListener("change", function () {
   	            const selectedRegion = parseInt(this.value);

   	            // Xóa các tùy chọn hiện tại trong dropdown Địa điểm
   	            diaDiemSelect.innerHTML = '<option value="-1" selected>Chọn địa điểm</option>';

   	            // Lọc danh sách địa điểm theo khu vực được chọn
   	            diaDiemData.forEach(diaDiem => {
   	                if (diaDiem.maKhuVuc === selectedRegion) {
   	                    const option = document.createElement("option");
   	                    option.value = diaDiem.maDiaDiem;
   	                    option.textContent = diaDiem.tenDiaDiem;
   	                    diaDiemSelect.appendChild(option);
   	                }
   	            });
   	        });
   	    });
   		 
   		 
   		 
   		 
        const addTopicBtn = document.getElementById("add-topic-btn");
        const topicContainer = document.getElementById("topic-container");
        let topicCount = 1;

        addTopicBtn.addEventListener("click", () => {
            topicCount++;
            const topicItem = document.createElement("div");
            topicItem.classList.add("topic-item");
            topicItem.innerHTML = `
                <div class="form-group">
                    <label for="topic-name-${topicCount}">Tên Chuyên Mục</label>
                    <input type="text" id="topic-name-${topicCount}" name="topic-name[]" placeholder="Nhập tên chuyên mục">
                </div>
                <div class="form-group">
                    <label for="topic-description-${topicCount}">Mô Tả Chuyên Mục</label>
                    <textarea id="topic-description-${topicCount}" name="topic-description[]" rows="3" placeholder="Nhập mô tả chuyên mục"></textarea>
                </div>
                <div class="form-group">
                    <label for="topic-image-${topicCount}">Hình Ảnh Chuyên Mục</label>
                    <input type="text" id="topic-image-${topicCount}" name="topic-image[]">
                </div>
            `;
            topicContainer.appendChild(topicItem);
        });
    </script>
</body>
</html>
