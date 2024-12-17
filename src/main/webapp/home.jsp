<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>World's Best Places to Visit</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
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
                <a class="nav-link active" href="#">Destinations</a>
                <a class="nav-link" href="#">Things to Do</a>
                <a class="nav-link" href="#">Forums</a>
            </nav>


            <div class="header-actions">
                <a href="#">Review</a>
                <button class="sign-in-btn">Sign in</button>
            </div>
        </div>
        
    </header>



    
    <main>
        <div class="result-not-found-container hide">
            <img class="no-result-img" src="/img/no-result.webp" alt="">
            <h2 class="result-not-found">Sorry. Result not found!</h2>
        </div>
                
        <section class="intro-section">
            <div class="intro-container">
			    <h2>Điểm Đến Hàng Đầu - Việt Nam</h2>
			    <p>
			        Bạn có thể đã từng nghe hoặc muốn khám phá một vài địa điểm nổi tiếng trên khắp Việt Nam.
			        Những địa danh này không chỉ tuyệt đẹp mà còn mang đến những trải nghiệm khó quên cho du khách.
			    </p>
			    <p>
			        Danh hiệu "Điểm Đến Yêu Thích Nhất" vinh danh những địa điểm du lịch nổi bật với chất lượng dịch vụ
			        xuất sắc. Danh hiệu này được trao cho các địa điểm nhận được nhiều đánh giá tích cực và phản hồi
			        nổi bật từ cộng đồng du khách trong vòng 12 tháng qua. Trong hàng ngàn điểm đến trên khắp Việt Nam,
			        chỉ một số ít địa điểm xuất sắc mới đạt được cột mốc này.
			    </p>
			</div>

        </section>
        
       
        <section class="place-list">
           
            <h2 class="place-list-heading">Địa điểm được tìm thấy</h2>
            <!-- Place Item -->
            <div class="place-item">
                <img src="${pageContext.request.contextPath}/img/img1.jpg" alt="Place 1">
                <div class="place-details">
                    <h2>
                        <a href="#" class="place-item-link">Bali</a>
                    </h2>
                    <p>Bali is a living postcard, an Indonesian paradise that feels like a fantasy. Soak up the sun on a stretch of fine white sand, or commune with the tropical creatures as you dive along coral ridges or the colorful wreck of a WWII war ship. On shore, the lush jungle shelters stone temples and mischievous monkeys. The “artistic capital” of Ubud is the perfect place to see a cultural dance performance, take a batik or silver-smithing workshop, or invigorate your mind and body in a yoga class.</p>
                </div>
            </div>

            <div class="place-item">
                <img src="${pageContext.request.contextPath}/img/img1.jpg" alt="Place 1">
                <div class="place-details">
                    <h2>
                        <a href="#" class="place-item-link">Bali</a>
                    </h2>
                    <p>Bali is a living postcard, an Indonesian paradise that feels like a fantasy. Soak up the sun on a stretch of fine white sand, or commune with the tropical creatures as you dive along coral ridges or the colorful wreck of a WWII war ship. On shore, the lush jungle shelters stone temples and mischievous monkeys. The “artistic capital” of Ubud is the perfect place to see a cultural dance performance, take a batik or silver-smithing workshop, or invigorate your mind and body in a yoga class.</p>
                </div>
            </div>

            <div class="place-item">
                <img src="${pageContext.request.contextPath}/img/img1.jpg" alt="Place 1">
                <div class="place-details">
                    <h2>
                        <a href="#" class="place-item-link">Bali</a>
                    </h2>
                    <p>Bali is a living postcard, an Indonesian paradise that feels like a fantasy. Soak up the sun on a stretch of fine white sand, or commune with the tropical creatures as you dive along coral ridges or the colorful wreck of a WWII war ship. On shore, the lush jungle shelters stone temples and mischievous monkeys. The “artistic capital” of Ubud is the perfect place to see a cultural dance performance, take a batik or silver-smithing workshop, or invigorate your mind and body in a yoga class.</p>
                </div>
            </div>

           

        </section>
    </main>

    <footer>
        <p>&copy; 2024 Travel Rankings | Best Destinations Worldwide</p>
    </footer>
</body>
</html>