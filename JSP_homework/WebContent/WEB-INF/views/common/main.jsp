

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>버거는 살안쪄요 내가 쪄요</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="icon" href="<%=request.getContextPath()%>/asset/i/favicon.png" type="image/x-icon" />
    <!-- Google Fonts -->
    <link
      href="https://fonts.googleapis.com/css2?family=Archivo+Black:wght@100;200;300;400;500;600;700;800;900&family=Merriweather:wght@100;200;300;400;500;600;700;800;900&display=swap"
      rel="stylesheet"
    />
    <!-- Bootstrap 4.5.2 CSS -->
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
      integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
      crossorigin="anonymous"
    />
    <!-- Slick 1.8.1 jQuery plugin CSS (Sliders) -->
    <link
      rel="stylesheet"
      type="text/css"
      href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"
    />
    <!-- Fancybox 3 jQuery plugin CSS (Open images and video in popup) -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.css"
    />
    <!-- AOS 2.3.4 jQuery plugin CSS (Animations) -->
    <link href="https://unpkg.com/aos@2.3.4/dist/aos.css" rel="stylesheet" />
    <!-- FontAwesome CSS -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
    />
    <!-- Startup CSS (Styles for all blocks) - Remove ".min" if you would edit a css code -->
    <link href="<%=request.getContextPath()%>/asset/css/style.min.css" rel="stylesheet" />
    <!-- jQuery 3.5.1 -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
   
 
  </head>
  <body>
    <!-- Navigation 2 -->
    <nav class="pt-30 pb-30 bg-light lh-40 navigation_2">
      <div class="container px-xl-0">
        <div class="row align-items-center justify-content-between">
          <div
            class="col-xl-2 col-lg-3 text-center text-lg-left"
            data-aos="fade-up"
            data-aos-delay="0"
          >
            <a href="<%=request.getContextPath()%>/index.jsp" class="link mr-20 color-main f-24 bold">
              Null Java
            </a>
          </div>
          <div
            class="col-xl-10 col-lg-9 d-flex flex-wrap align-items-center justify-content-center justify-content-md-between"
          >
            <div class="mb-10 mb-md-0" data-aos="fade-up" data-aos-delay="150">
              <div class="d-inline-block px-20 dropdown">
                <a
                  href="<%=request.getContextPath()%>/board.do"
                  class="link color-main dropdown-toggle"
                  id="navigation_2_dropdown_1"
                  data-toggle="dropdown"
                  aria-haspopup="true"
                  aria-expanded="false"
                >
                  게시판
                </a>
                <div
                  class="bg-light dropdown-menu"
                  aria-labelledby="navigation_2_dropdown_1"
                >
                  <div>
                    <a href="<%=request.getContextPath()%>/board.do?post_bor_num=1" class="link color-main"> 이벤트 </a>
                  </div>
                  <div>
                    <a href="<%=request.getContextPath()%>/board.do?post_bor_num=2" class="link color-main"> 공지사항 </a>
                  </div>
                  <div>
                    <a href="<%=request.getContextPath()%>/board.do?post_bor_num=3" class="link color-main"> QnA </a>
                  </div>
                </div>
              </div>
            </div>
            <div class="text-md-right" data-aos="fade-up" data-aos-delay="300">
            
              <a href="<%=request.getContextPath()%>/common/regist" class="link mx-15 color-main">
                회원가입
              </a>
             <c:if test="${empty session.loginUser }" >
				<a href="<%=request.getContextPath()%>/common/login" class="link mx-15 color-main"> 로그인 </a>
			</c:if> 
              
              <c:if test="${!empty session.loginUser }" >
				<a href="<%=request.getContextPath()%>/common/logout" class="link mx-15 color-main"> 로그아웃 </a>
				</c:if>      
       
              
              
            </div>
          </div>
        </div>
      </div>
    </nav>

    <!-- Header 2 -->
    <header class="pt-190 pb-120 bg-dark header_2"
    data-bg-src="<%=request.getContextPath()%>/asset/i/three_burger.png"
	data-bg-src-2x="<%=request.getContextPath()%>/asset/i/three_burger.png">
      <div class="container text-center">
        <h1
          class="big color-white text-center"
          data-aos="fade-up"
          data-aos-delay="0"
        >
          ${loginUser.name } 님 환영합니다
        </h1>

       
         
         <button type="button" onclick="list_go();" data-aos="fade-up"
         data-aos-delay="0" class="btn action-1 xl text-center bg-danger mt-20 w-600"">리스트보기 </button>

		<button type="button" onclick="logout_go();" data-aos="fade-up"
          data-aos-delay="0" class="btn action-1 xl text-center bg-danger mt-20 w-600">로그아웃 </button>
		
        
      </div>
    </header>

    <!-- Showcase 2 -->
    <section class="pt-105 pb-90 bg-light text-center showcase_2">
      <div class="container px-xl-0">
        <div class="row justify-content-center">
          <div class="col-xl-8 col-lg-10">
            <h2 class="small" data-aos="fade-up" data-aos-delay="0">
              햄버거 브랜드들
            </h2>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4 col-sm-6" data-aos="fade-up" data-aos-delay="0">
            <a href="<%=request.getContextPath() %>/page/map_search.do?brand=1" class="mt-50 link color-main">
              <img
                src="<%=request.getContextPath()%>/asset/i/macdonald.png"
                srcset="<%=request.getContextPath()%>/asset/i/macdonald.png"
                alt="" width="300px"
                class="img-fluid radius10 "
              />
              <div class="mt-20 mb-15 f-22 title">맥도날드</div>
              <div class="color-heading f-14 semibold text-uppercase sp-20">
                매그도나르도
              </div>
            </a>
           </div>
          
          
          <div
            class="col-md-4 col-sm-6"
            data-aos="fade-up"
            data-aos-delay="150"
          >
            <a href="<%=request.getContextPath() %>/page/map_search.do?brand=2" class="mt-50 link color-main">
              <img
                src="<%=request.getContextPath()%>/asset/i/lotteria.jpg"
                srcset="<%=request.getContextPath()%>/asset/i/lotteria.jpg"
                alt="" width="300px"
                class="img-fluid radius10"
              />
              <div class="mt-20 mb-15 f-22 title">롯데리아</div>
              <div class="color-heading f-14 semibold text-uppercase sp-20">
                로떼리아
              </div>
            </a>
          </div>
          
          
          
          
           <div
            class="col-md-4 col-sm-6"
            data-aos="fade-up"
            data-aos-delay="300"
          >
            <a href="<%=request.getContextPath() %>/page/map_search.do?brand=3" class="mt-50 link color-main">
              <img
                src="<%=request.getContextPath()%>/asset/i/burger_king.png"
                srcset="<%=request.getContextPath()%>/asset/i/burger_king.png"
                alt="" width="300px"
                class="img-fluid radius10"
              />
              <div class="mt-20 mb-15 f-22 title">버거킹</div>
              <div class="color-heading f-14 semibold text-uppercase sp-20">
                버거의 제왕
              </div>
            </a>
          </div>
          
          <div
            class="col-md-4 col-sm-6"
            data-aos="fade-up"
            data-aos-delay="300"
          >
            <a href="<%=request.getContextPath() %>/page/map_search.do?brand=4" class="mt-50 link color-main">
              <img
                src="<%=request.getContextPath()%>/asset/i/momstouch.jpg"
                srcset="<%=request.getContextPath()%>/asset/i/momstouch.jpg"
                alt="" width="300px"
                class="img-fluid radius10"
              />
              <div class="mt-20 mb-15 f-22 title">맘스터치</div>
              <div class="color-heading f-14 semibold text-uppercase sp-20">
                엄마의 손길
              </div>
            </a>
          </div>
          
          <div
            class="col-md-4 col-sm-6"
            data-aos="fade-up"
            data-aos-delay="300"
          >
            <a href="<%=request.getContextPath() %>/page/map_search.do?brand=5" class="mt-50 link color-main">
              <img
                src="<%=request.getContextPath()%>/asset/i/popeyes.jpg"
                srcset="<%=request.getContextPath()%>/asset/i/popeyes.jpg"
                alt="" width="300px"
                class="img-fluid radius10"
              />
              <div class="mt-20 mb-15 f-22 title">파파이스</div>
              <div class="color-heading f-14 semibold text-uppercase sp-20">
                아빠의 버거
              </div>
            </a>
          </div>
          
        </div>
      </div>
    </section>

<!-- Footer 1 -->
    <footer class="pt-75 pb-65 bg-light text-center footer_1">
      <div class="container px-xl-0">
        <div class="row justify-content-between align-items-center lh-40 links">
          <div
            class="col-lg-4 col-sm-6 text-sm-right text-lg-left order-1 order-lg-0"
            data-aos="fade-up"
            data-aos-delay="150"
          >
            <a href="#" class="link mr-15 color-main"> 널자바에대해 </a>
            <a href="#" class="link mx-15 color-main"> 정책 </a>
            <a href="#" class="link mx-15 color-main"> 규칙 </a>
          </div>
          <div
            class="mb-10 mb-lg-0 col-lg-auto order-0"
            data-aos="fade-up"
            data-aos-delay="0"
          >
            <a href="#" class="link logo color-main"> Null Java </a>
          </div>
          <div
            class="col-lg-4 col-sm-6 text-sm-left text-lg-right order-2 order-lg-0"
            data-aos="fade-up"
            data-aos-delay="150"
          >
            <a href="#" class="link mr-15 color-main"> 연락처 </a>
            <a href="#" class="mx-15 link color-main">
              <i class="fab fa-twitter"> </i>
            </a>
            <a href="#" class="mx-15 link color-main">
              <i class="fab fa-facebook-square"> </i>
            </a>
            <a href="#" class="ml-15 link color-main">
              <i class="fab fa-google-plus-g"> </i>
            </a>
          </div>
        </div>
        <div class="row justify-content-center">
          <div
            class="mt-10 col-xl-4 col-lg-5 col-md-6 col-sm-8"
            data-aos="fade-up"
            data-aos-delay="0"
          >
            <div class="color-heading text-adaptive">
              와 오늘 저녁은 치킨이닭
            </div>
          </div>
        </div>
      </div>
    </footer>
    <!-- forms alerts -->
    <div
      class="alert alert-success alert-dismissible fixed-top alert-form-success"
      role="alert"
    >
      <button
        type="button"
        class="close"
        data-dismiss="alert"
        aria-label="Close"
      >
        <span aria-hidden="true">&times;</span>
      </button>
      Thanks for your message!
    </div>
    <div
      class="alert alert-warning alert-dismissible fixed-top alert-form-check-fields"
      role="alert"
    >
      <button
        type="button"
        class="close"
        data-dismiss="alert"
        aria-label="Close"
      >
        <span aria-hidden="true">&times;</span>
      </button>
      Please, fill in required fields.
    </div>
    <div
      class="alert alert-danger alert-dismissible fixed-top alert-form-error"
      role="alert"
    >
      <button
        type="button"
        class="close"
        data-dismiss="alert"
        aria-label="Close"
      >
        <span aria-hidden="true">&times;</span>
      </button>
      <div class="message">
        데이터를 보내는데 에러가 발생하였씁니다.
        <a href="" target="_blank" class="link color-transparent-white"
          >안내링크</a
        >.
      </div>
    </div>

    <!-- gReCaptcha popup (uncomment if you need a recaptcha integration) -->
    <!--
		<div class="bg-dark op-8 grecaptcha-overlay"></div>
		<div class="bg-light radius10 w-350 h-120 px-20 pt-20 pb-20 grecaptcha-popup">
			<div class="w-full h-full d-flex justify-content-center align-items-center">
				<div id="g-recaptcha" data-sitekey="PUT_YOUR_SITE_KEY_HERE"></div>
			</div>
		</div>
		<script src="https://www.google.com/recaptcha/api.js?render=explicit" async defer></script>
		-->
    <!-- Bootstrap 4.5.2 JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
    <!-- Fancybox 3 jQuery plugin JS (Open images and video in popup) -->
    <script src="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.js"></script>
    <!-- 
			Google maps JS API 
			Don't forget to replace the key "AIzaSyDP6Ex5S03nvKZJZSvGXsEAi3X_tFkua4U" to your own! 
			Learn how to get a key: https://help.designmodo.com/article/startup-google-maps-api/ 
		-->
    <script
      type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?v=3&key=AIzaSyDP6Ex5S03nvKZJZSvGXsEAi3X_tFkua4U"
    ></script>
    <!-- Slick 1.8.1 jQuery plugin JS (Sliders) -->
    <script
      type="text/javascript"
      src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"
    ></script>
    <!-- AOS 2.3.4 jQuery plugin JS (Animations) -->
    <script src="https://unpkg.com/aos@2.3.4/dist/aos.js"></script>
    <!-- Maskedinput jQuery plugin JS (Masks for input fields) -->
    <script src="<%=request.getContextPath()%>/asset/js/jquery.maskedinput.min.js"></script>
    <!-- Startup JS (Custom js for all blocks) -->
    <script src="<%=request.getContextPath()%>/asset/js/script.js"></script>
    
    <script src="<%=request.getContextPath()%>/asset/js/pagechange.js"></script>

	

	<script>
	function logout_go(){
		if(confirm("로그아웃합니다.")){
			location.href="<%=request.getContextPath()%>/common/logout"
		}
	}
	
	function list_go(){
		
			location.href="<%=request.getContextPath()%>/member/list"
		
	}
</script>
	
  </body>
</html>

