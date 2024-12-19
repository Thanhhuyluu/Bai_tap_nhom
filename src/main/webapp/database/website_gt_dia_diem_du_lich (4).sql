-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 19, 2024 lúc 04:51 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `website_gt_dia_diem_du_lich`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bai_dang`
--

CREATE TABLE `bai_dang` (
  `ma_bai_dang` int(11) NOT NULL,
  `ten_bai_dang` varchar(255) NOT NULL,
  `ma_dia_diem` int(11) NOT NULL,
  `mo_ta_bai_dang` text NOT NULL,
  `ma_nguoi_dang` int(11) NOT NULL,
  `hinh_anh` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `bai_dang`
--

INSERT INTO `bai_dang` (`ma_bai_dang`, `ten_bai_dang`, `ma_dia_diem`, `mo_ta_bai_dang`, `ma_nguoi_dang`, `hinh_anh`) VALUES
(10, 'Du lịch Bảo Lạc', 2, 'Bảo Lạc là một trong những vùng địa đầu và điểm du lịch Cao Bằng, với địa hình đa dạng từ đồi núi, thung lũng đến sông suối. Điểm nổi bật của Bảo Lạc là khu du lịch sinh thái Hồ Thung Nai, với hồ nước xanh trong vắt bao quanh bởi các ngọn núi.', 1, 'https://ik.imagekit.io/tvlk/blog/2022/02/dia-diem-du-lich-cao-bang-3-819x1024.jpg?tr=q-70,w-625,dpr-2'),
(11, 'Top 8 địa điểm du lịch Cao Bằng bạn nhất định phải check-in một lần', 2, 'Nhắc đến Cao Bằng, các tín đồ xê dịch sẽ nghĩ ngay đến vùng đất phía Bắc với thiên nhiên hùng vỹ giữ trọn nét nguyên sơ cùng khí hậu mát mẻ suốt 4 mùa trong năm. Ngoài ra, Bao Bằng còn nổi tiếng với nhiều khu rừng nguyên sinh và hệ thống sông suối dày đặc. Điều này đã góp phần đưa nơi này trở thành điểm đến yêu thích của các tín đồ xê dịch thích khám phá thiên nhiên. Nếu bạn đang có kế hoạch vi vu tọa độ này, cùng Traveloka điểm danh ngay top 8 địa điểm du lịch Cao Bằng nhất định phải check-in.', 1, 'https://ik.imagekit.io/tvlk/blog/2022/02/dia-diem-du-lich-cao-bang-6-1024x1024.jpg?tr=q-70,w-625,dpr-2'),
(12, 'Giới thiệu về Bà Nà Hills', 3, 'Nếu bạn có dịp đi thăm quan Đà Nẵng thì Bà Nà Hills chắc chắn là điểm đến không thể bỏ qua. Bà Nà Hills thuộc huyện Hòa Vang, nằm cách trung tâm Đà Nẵng khoảng 25km về phía Tây Nam, nằm ở độ cao 1487m so với mực bước biển. Bà Nà được ví von như Đà Lạt của miền trung hay ‘’lá phổi xanh’’, ‘’hòn ngọc khí hậu’’ của Việt Nam.', 1, 'https://danangsensetravel.com/view-800/at_gioi-thieu-ve-ba-na-hills_af7f7fd4cd73c40b62e8a2977276d29b.jpg'),
(13, 'Ngoài phố cổ, bạn nên ghé những địa điểm tham quan Hội An đẹp xuất sắc này', 4, 'Hội An được xem là một trong những “thiên đường” du lịch nghỉ dưỡng dành cho những ai mê sự hoài cổ. Các điểm tham quan Hội An hút hồn du khách nhờ kiến trúc đậm màu lịch sử, cảnh sắc thiên nhiên hoang sơ, con người hồn hậu và ẩm thực đặc sắc.', 1, 'https://ik.imagekit.io/tvlk/blog/2023/12/di-lich-hoi-an-hinh-anh4.jpg?tr=q-70,w-625,dpr-2'),
(14, 'Mãn nhãn với kiến trúc Champa cổ của tháp Chiên Đàn Quảng Nam', 5, 'Tháp Chiên Đàn không chỉ là địa điểm du lịch nổi tiếng mà nơi đây còn thu hút nhiều nhà nghiên cứu đến tìm hiểu về kiến trúc, văn hóa độc đáo của người Champa xưa.', 1, 'https://statics.vinpearl.com/thap-chien-dan-1_1632733014.jpeg'),
(15, '10 địa điểm tham quan Huế mang đậm dấu ấn lịch sử', 6, 'Nhắc đến cố đô Huế là nhắc đến các lăng tẩm, di tích, đền chùa,…mang đậm dấu ấn lịch sử hào hùng của dân tộc. Bên cạnh những kiến trúc cổ xưa, các điểm tham quan Huế còn sở hữu cảnh sắc thiên nhiên hữu tình, nên thơ.Thành phố Huế nằm ở dải đất miền Trung đầy nắng gió. Nơi đây thu hút nhiều tín đồ xê dịch nhờ những công trình kiến trúc độc đáo. Mỗi kiến trúc ẩn sâu trong đó là những câu chuyện về văn hóa hào hùng, Mặt khác, ẩm thực đa dạng và đặc sắc tại đây cũng là điều không thể bỏ qua. Ngại ngần gì mà không cùng Săn vé máy bay giá rẻ khám phá 10 địa điểm tham quan Huế đẹp bậc nhất nào!', 1, 'https://sanvemaybay.vn/includes/uploads/2024/09/dai-noi-hue-1-e1726406140390.webp'),
(16, 'Vui quên lối về tại Núi thần tài Đà Nẵng ', 7, 'Đà Nẵng có rất nhiều điểm du lịch nổi tiếng và độc đáo. Một trong số đó chính là Núi Thần Tài. Núi thần tài Đà Nẵng có gì? Cách di chuyển ra sao? Giá vé như thế nào? Và bạn sẽ có những trải nghiệm đắt giá nào khi đến đây? Cùng theo chân “team Traveloka” để khám phá bạn nhé!', 1, 'https://ik.imagekit.io/tvlk/blog/2023/10/nui-than-tai-da-nang-19.jpg?tr=q-70,c-at_max,w-500,h-250,dpr-2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chuyen_muc`
--

CREATE TABLE `chuyen_muc` (
  `ma_chuyen_muc` int(11) NOT NULL,
  `ma_bai_dang` int(11) NOT NULL,
  `ten_chuyen_muc` varchar(255) NOT NULL,
  `mo_ta` text NOT NULL,
  `hinh_anh` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chuyen_muc`
--

INSERT INTO `chuyen_muc` (`ma_chuyen_muc`, `ma_bai_dang`, `ten_chuyen_muc`, `mo_ta`, `hinh_anh`) VALUES
(21, 11, ' Thác Bản Giốc', 'Thác Bản Giốc từng lọt vào danh sách những thác nước đẹp nhất khu vực Đông Nam Á và cũng top 4 dòng thác lớn nhất thế giới. Nằm tại vị trí giao thoa giữa biên giới Trung Quốc và Việt Nam, Bản Giốc đẹp tựa một dải lụa trắng tinh khôi giữa núi rừng Cao Bằng và đổ xuống dòng sông Quây Sơn màu ngọc bích.', 'https://ik.imagekit.io/tvlk/blog/2022/02/dia-diem-du-lich-cao-bang-3-819x1024.jpg?tr=q-70,w-625,dpr-2'),
(22, 11, 'Hồ Thang Hen', 'Cùng thuộc địa phận huyện Trà Lĩnh, hồ Thang Hen là một trong các địa điểm du lịch Cao Bằng nổi tiếng nhất. Hồ nằm trong quần thể 36 hồ nước tự nhiên nằm ở độ cao gần 1700m và kết nối thông qua hệ thống hang động dưới lòng đất. Trong đó, hồ Thang Hen có diện tích lớn nhất và cũng thu hút nhiều tín đồ xê dịch nhất.', 'https://ik.imagekit.io/tvlk/blog/2022/02/dia-diem-du-lich-cao-bang-9-819x1024.jpg?tr=q-70,w-625,dpr-2'),
(23, 10, 'Thác Bản Giốc', 'Thác Bản Giốc từng lọt vào danh sách những thác nước đẹp nhất khu vực Đông Nam Á và cũng top 4 dòng thác lớn nhất thế giới. Nằm tại vị trí giao thoa giữa biên giới Trung Quốc và Việt Nam, Bản Giốc đẹp tựa một dải lụa trắng tinh khôi giữa núi rừng Cao Bằng và đổ xuống dòng sông Quây Sơn màu ngọc bích.', 'https://ik.imagekit.io/tvlk/blog/2022/02/dia-diem-du-lich-cao-bang-2-819x1024.jpg?tr=q-70,w-625,dpr-2'),
(24, 10, 'Đèo Mã Phục', 'Mã Phục là con đèo đẹp nhất tỉnh Cao Bằng và là một địa điểm check in ở Cao Bằng khiến các tín đồ xê dịch ngỡ ngàng trước sự hùng vĩ của thiên nhiên. Đèo thuộc địa phận huyện Trà Lĩnh và có chiều dài Khoảng 3,5 km cùng độ cao 700m (so với mực nước biển). Đúng như tên gọi, đèo Mã Phục “vắt” ngang ngọn núi đá vôi và thung lũng tạo nên hình ảnh tương tự con ngựa.', 'https://ik.imagekit.io/tvlk/blog/2022/02/dia-diem-du-lich-cao-bang-6-1024x1024.jpg?tr=q-70,w-625,dpr-2'),
(25, 12, 'Cầu Vàng Bà Nà hills', 'Được giới thiệu từ tháng 06/2018, câu cầu Vàng đã trở thành một hiện tượng thu hút sự chú ý của đông đảo người đam mê xê dịch trong nước cũng như quốc tế. Và mới đây, tạp chí Times còn bình chọn cây cầu Vàng thuộc Top 10 điểm đến hấp dẫn nhất hành tinh năm 2018.', 'https://danangsensetravel.com/view/at_gioi-thieu-ve-ba-na-hills_33c83ee5467dfc9823eaf3b6503f504b.jpg'),
(26, 12, 'Vườn hoa Le Jardin d’Amour', 'Là một vườn hoa với diện tích khổng lồ 8.206m2 nằm tại phía Đông của núi Bà Nà. Vườn hoa thu hút khách thăm quan bởi khí hậu luôn mát mẻ dễ chịu và muôn vàn loài hoa đẹp. Đặc biệt, ở đây gồm có 9 khu vườn nhỏ với kiến trúc độc đáo khác nhau là vườn Suối Mơ, vườn Địa Đàng, vườn Bí Ẩn, vườn Uyên Ương, vườn Suy Tưởng, vườn Thần Thoại, vườn, Ký Ức, vườn Thiêng và vườn nho. Đến với vườn hoa phong cách Pháp ‘’Le Jardin d’Amour’’, Lữ khách còn được đắm say với nhiều loài hoa quý hiếm và đầy màu sắc như cẩm tú cầu, lavender,  Xác pháo Nữ Hoàng,  đào chuông,  cúc bách nhật…', 'https://danangsensetravel.com/view-800/at_gioi-thieu-ve-ba-na-hills_af7f7fd4cd73c40b62e8a2977276d29b.jpg'),
(27, 12, 'Chùa Linh Ứng', 'Được xây dựng trên đỉnh Bà Nà, chùa Linh Ứng có độ cao đạt 1500m đã trở thành trải nghiệm tâm linh nổi tiếng mà khách thăm quan không nên bỏ qua. Ngôi chùa này có phong cách kiến trúc giống với các loại chùa Việt Nam với mái ngói cong, diện tích khoảng sân rộng lót bằng đá và phía trước trồng cây thông có 3 loại lá khác nhau. Đặc biệt, Lữ khách đến đây sẽ vô cùng ấn tượng trước tượng Đức Bổn Sư Thích Ca Mâu cao 27m, thiền định trên một đài hoa sen và bên dưới có 8 bức phù điêu chạm khắc tinh tế, tất cả tái hiện lại cuộc đời của Đức Phật Thích ca. Ngoài ra, khách thăm quan khi đến đây còn được ngắm nhìn toàn cảnh thành phố Đà Nẵng, bán đảo Sơn Trà, bãi biển Mỹ Khê…', ''),
(28, 13, 'Các hội quán người Hoa', 'Các hội quán người Hoa', 'https://ik.imagekit.io/tvlk/blog/2023/12/Hoi-Quan-Phuc-Kien.webp?tr=q-70,w-625,dpr-2'),
(29, 13, 'Chùa Cầu', 'Tọa lạc tại đầu đường Nguyễn Thị Minh Khai trong thành phố Hội An, Chùa Cầu là điểm tham quan mà bạn không thể bỏ qua. Lối kiến trúc đặc trưng, bắc qua dòng sông Hoài thơ mộng đã ngày càng gắn bó, in sâu vào tâm trí người dân nơi đây.', 'https://ik.imagekit.io/tvlk/blog/2023/12/chua-cau-hoi-an-15-1024x682-1.webp?tr=q-70,w-625,dpr-2'),
(30, 14, 'Tháp Chăm Chiên Đàn ở đâu? ', 'Nhắc đến Quảng Nam, du khách thường nghĩ ngay đến điểm du lịch phố cổ Hội An. Tuy nhiên, địa phương này còn có rất nhiều nơi rất đáng để khám phá và trải nghiệm như: thánh địa Mỹ Sơn, Cù Lao Chàm hay tháp Chiên Đàn… ', 'https://statics.vinpearl.com/thap-chien-dan-21_1632747708.jpg'),
(31, 15, ' Các lăng tẩm Huế', 'Tìm hiểu về lịch sử bạn sẽ biết nhà Nguyễn có tổng 13 vị vua. Tuy vậy, lại chỉ có 7 lăng tẩm được tiến hàng xây dựng. Hệ thống lăng tẩm này luôn nằm trong danh sách những điểm tham quan nhất định phải check-in tại Huế.', 'https://sanvemaybay.vn/includes/uploads/2024/09/lang-tu-duc-7_1682349012-e1726406197465.jpg'),
(32, 15, 'Chùa Thiên Mụ', 'Nhắc đến các điểm tham quan Huế nhất định phải check-in mà bỏ qua Chùa Thiên Mụ thì thật là lãng phí. Chùa Thiên Mụ hay còn được gọi là chùa Linh Mụ, nằm cạnh dòng sông Hương thơ mộng.Khi đến đây, người người đều ấn tượng với tháp Phước Duyên được vua Thiệu Trị chỉ đạo khởi công. Tòa tháp bao gồm 7 tầng và mỗi tầng đều thờ một vị Phật khác nhau. Một điều bạn nhất định phải làm khi tới đây chính là ngắm hoàng hôn từ chùa Thiên Mụ và thưởng thức món đậu hũ đặc trưng ngay trước cổng chùa.', 'https://sanvemaybay.vn/includes/uploads/2024/09/chua-thien-mu-1-e1726406520560.webp'),
(33, 15, 'Ngôi trường trăm tuổi – Quốc Học Huế', 'Tại thời xưa, nơi đây chính là điểm huấn luyện binh lính đường thủy của nhà Nguyễn. Lúc đó, nơi đây chỉ vỏn vẹn có hai dãy nhà cấp 4. Mãi cho đến những năm đầu thế kỷ 19, nơi đây mới được xây dựng lại kiên cố theo kiến trúc Tây Âu.Muốn trải nghiệm khung cảnh tuyệt nhất, hãy đến trường Quốc Học Huế trong khoảng từ tháng 5 đến tháng 7. Thời gian này sấc hoa điệp và hoa anh đào bay ngập trời, rất thích hợp để bạn có những bức ảnh và trải nghiệm đáng nhớ.', 'https://sanvemaybay.vn/includes/uploads/2024/09/truong-quoc-hoc-hue-2-e1726406557609.webp'),
(34, 15, 'Bảo tàng Lê Bá Đảng', 'Nếu bạn yêu thích nghệ thuật, bảo tàng Lê Bá Đảng là điểm đến nhất định phải check-in tại Huế. Được bao bọc bởi những khu rừng cây và hoa cỏ, công trình này được chia thành nhiều khu trưng bày dành cho nghệ thuật đương đại.Trong đó, toà cao hơn 10m là nơi lưu giữ nhiều tác phẩm của hoạ sĩ Lê Bá Đảng dành tặng cho thành phố Huế. Không gian xinh xắn và cực “nghệ” tại đây sẽ là nơi sống ảo lý tưởng cho hội mê chụp hình.', 'https://sanvemaybay.vn/includes/uploads/2024/09/check-in-bao-tang-nghe-thuat-xin-nhat-co-do-lebadang-memory-space-ht.cica_-e1726406599172.jpg'),
(35, 16, 'Núi thần tài Đà Nẵng - Điểm du lịch hấp dẫn mọi du khách', 'Công viên suối khoáng nóng Núi Thần Tài tọa lạc tại khu bảo tồn thiên nhiên Bà Nà Núi Chúa. Nguồn suối khoáng nóng tại Núi Thần Tài khởi nguồn từ đỉnh núi Bà Nà. Bao bọc hai bên là núi Thanh Long và Bạch Hổ. Nguồn suối nóng âm ỉ tích khoáng trong lòng đất và và phát lộ tại long huyệt tại thôn Phú Túc, xã Hòa Phú, huyện Hòa Vang, TP Đà Nẵng.', 'https://ik.imagekit.io/tvlk/blog/2023/10/nui-than-tai-da-nang-19.jpg?tr=q-70,w-625,dpr-2'),
(36, 16, 'Cách di chuyển đến Núi Thần Tài Đà Nẵng', 'Muốn đến Núi Thần Tài trước hết du khách cần đến với thành phố xinh đẹp Đà Nẵng. Du khách đến từ các tỉnh miền Bắc và miền Nam có thể đến đây bằng tàu hỏa, xe khách, xe giường nằm, đi phượt bằng xe cá nhân… Nhưng thuận tiện và phổ biến nhất có lẽ là mua vé máy bay đi Đà Nẵng.', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dia_diem`
--

CREATE TABLE `dia_diem` (
  `ma_dia_diem` int(11) NOT NULL,
  `ma_khu_vuc` int(11) NOT NULL,
  `ten_dia_diem` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `dia_diem`
--

INSERT INTO `dia_diem` (`ma_dia_diem`, `ma_khu_vuc`, `ten_dia_diem`) VALUES
(1, 1, 'Vinh Hạ Long'),
(2, 2, 'Bảo Lạc'),
(3, 4, 'Bà Nà Hill'),
(4, 5, 'Hội An'),
(5, 5, 'Tam Kỳ'),
(6, 6, 'Cố đô Huế'),
(7, 4, 'Núi Thần Tài');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khu_vuc`
--

CREATE TABLE `khu_vuc` (
  `ma_khu_vuc` int(11) NOT NULL,
  `ten_khu_vuc` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khu_vuc`
--

INSERT INTO `khu_vuc` (`ma_khu_vuc`, `ten_khu_vuc`) VALUES
(1, 'Hà Giang'),
(2, 'Cao Bằng'),
(3, 'Lào Cai'),
(4, 'Đà Nẵng'),
(5, 'Quảng Nam'),
(6, 'Thừa Thiên Huế');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoi_dung`
--

CREATE TABLE `nguoi_dung` (
  `ma_nguoi_dung` int(11) NOT NULL,
  `ten_nguoi_dung` varchar(100) NOT NULL,
  `vai_tro` int(20) NOT NULL DEFAULT 0,
  `mat_khau` int(20) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nguoi_dung`
--

INSERT INTO `nguoi_dung` (`ma_nguoi_dung`, `ten_nguoi_dung`, `vai_tro`, `mat_khau`, `email`) VALUES
(1, 'huy', 1, 123123, 'thanhhuyluu@gmail.com'),
(2, 'huy', 0, 123121, 'thanhhuyluu1@gmail.com'),
(3, 'Huy Hùng', 0, 121212, 'thanhhuykd1701104@gmail.com'),
(4, 'Huy Hùng', 0, 131313, 'thanhhuykd1710104@gmail.com');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bai_dang`
--
ALTER TABLE `bai_dang`
  ADD PRIMARY KEY (`ma_bai_dang`),
  ADD KEY `id_nguoi_dang` (`ma_nguoi_dang`),
  ADD KEY `id_dia_diem` (`ma_dia_diem`);

--
-- Chỉ mục cho bảng `chuyen_muc`
--
ALTER TABLE `chuyen_muc`
  ADD PRIMARY KEY (`ma_chuyen_muc`),
  ADD KEY `id_chuyen_muc` (`ma_bai_dang`);

--
-- Chỉ mục cho bảng `dia_diem`
--
ALTER TABLE `dia_diem`
  ADD PRIMARY KEY (`ma_dia_diem`),
  ADD KEY `ma_khu_vuc` (`ma_khu_vuc`);

--
-- Chỉ mục cho bảng `khu_vuc`
--
ALTER TABLE `khu_vuc`
  ADD PRIMARY KEY (`ma_khu_vuc`);

--
-- Chỉ mục cho bảng `nguoi_dung`
--
ALTER TABLE `nguoi_dung`
  ADD PRIMARY KEY (`ma_nguoi_dung`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `bai_dang`
--
ALTER TABLE `bai_dang`
  MODIFY `ma_bai_dang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `chuyen_muc`
--
ALTER TABLE `chuyen_muc`
  MODIFY `ma_chuyen_muc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT cho bảng `dia_diem`
--
ALTER TABLE `dia_diem`
  MODIFY `ma_dia_diem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `nguoi_dung`
--
ALTER TABLE `nguoi_dung`
  MODIFY `ma_nguoi_dung` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bai_dang`
--
ALTER TABLE `bai_dang`
  ADD CONSTRAINT `id_dia_diem` FOREIGN KEY (`ma_dia_diem`) REFERENCES `dia_diem` (`ma_dia_diem`),
  ADD CONSTRAINT `id_nguoi_dang` FOREIGN KEY (`ma_nguoi_dang`) REFERENCES `nguoi_dung` (`ma_nguoi_dung`);

--
-- Các ràng buộc cho bảng `chuyen_muc`
--
ALTER TABLE `chuyen_muc`
  ADD CONSTRAINT `id_chuyen_muc` FOREIGN KEY (`ma_bai_dang`) REFERENCES `bai_dang` (`ma_bai_dang`);

--
-- Các ràng buộc cho bảng `dia_diem`
--
ALTER TABLE `dia_diem`
  ADD CONSTRAINT `ma_khu_vuc` FOREIGN KEY (`ma_khu_vuc`) REFERENCES `khu_vuc` (`ma_khu_vuc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
