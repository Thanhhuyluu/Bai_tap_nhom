<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.bean.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>World's Best Places to Visit</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/post_detail.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/fontawesome-free-6.6.0-web/css/all.min.css">

</head>
<body>
   
    <header class="custom-header">
        <div class="header-container">
            <!-- Logo -->
            <div class="logo">
               
                <img src="${pageContext.request.contextPath}/img/logo.png" alt="Tripadvisor Logo">
            </div>

            <!-- Header Search Section -->
            <div class="header-search">
                <input type="text" class="search-input" placeholder="Search">
                <select class="location-dropdown">
                    <option value="" disabled selected>Select Location</option>
                    <option value="paris">Paris</option>
                    <option value="newyork">New York</option>
                    <option value="tokyo">Tokyo</option>
                    <option value="sydney">Sydney</option>
                </select>
                <button class="search-button">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </div>

            <nav class="nav-links">
                <a class="nav-link active" href="trang-chu">Destinations</a>
                <a class="nav-link" href="#">Things to Do</a>
                <a class="nav-link" href="#">Forums</a>
            </nav>

			<%
			if(session.getAttribute("userId") == null) {
				
			
			
			%>

            <div class="header-actions">
                <a href="${pageContext.request.contextPath}/register.jsp"class="sign-in-btn">Sign in</a>
                <a href="${pageContext.request.contextPath}/login.jsp"class="sign-in-btn">Login</a>
            </div>
            
            <%} %>
        </div>
        
    </header>



    
    <main>
        <div class="app-container">
            <!-- <div class="post-over">
                <h1 class="destination-heading">Vịnh Hạ Long</h1>
                <p class="destination-description">Vịnh Hạ Long được Unesco nhiều lần công nhận là Di sản thiên nhiên của Thế giới với hàng nghìn hòn đảo được làm nên bởi tạo hoá kỳ vĩ và sống động. Vịnh Hạ Long có phong cảnh tuyệt đẹp nên nơi đây là một điểm du lịch rất hấp dẫn với du khách trong nước và quốc tế.

                    Mới đây nhất, ngày 16/9/2023, tại thủ đô Riyadh, Ả Rập Xê Út, UNESCO lại một lần nữa vinh danh và công nhận quần thể vịnh Hạ Long – quần đảo Cát Bà là Di sản thiên nhiên thế giới, bởi nơi đây chứa đựng các khu vực có vẻ đẹp thiên nhiên bao gồm các đảo đá vôi có thảm thực vật che phủ và các đỉnh nhọn núi đá vôi nhô lên trên mặt biển cùng với các đặc điểm karst liên quan như các mái vòm và hang động.</p>

            </div> -->
            <%
            BaiDang bd = (BaiDang) request.getAttribute("baiDang");
            List<ChuyenMuc> listChuyenMuc = (List<ChuyenMuc>) request.getAttribute("listChuyenMuc");
            
            %>
            <div class="post-over">
                <h1 class="destination-heading"><%= bd.getTenBaiDang()%></h1>
                <p class="destination-description"><%= bd.getTenBaiDang()%></p>

            </div>

            <div class="destination-detail">
            	
               
                <ul class="destination-detail-list">
                
                <%
                	if (listChuyenMuc != null){
                		for (ChuyenMuc cm : listChuyenMuc){
                %>
                	<li class="destination-detail-item">
                        <h3 class="destination-detail-item-heading"><%= cm.getTenChuyenMuc() %></h3>
                        <p class="destination-detail-item-description"><%= cm.getMoTa() %></p>
                        
                        <div class="destination-detail-item-img-wrapper">
                            <img src="<%=cm.getHinhAnh() %>" alt="hinhX" class="destination-detail-item-img">
                        </div>
                    </li>
                
                <%			
                		}
                	}
                %>
            		
            	</ul>



            </div>
                

        </div>
    
    </main>

    <footer>
        <p>&copy; 2024 Travel Rankings | Best Destinations Worldwide</p>
    </footer>
</body>
</html>
