<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<body>
  <!-- Content Wrapper. Contains page content -->
  <div style="min-height:812px;">
   <jsp:include page="/WEB-INF/views/content_header.jsp">
      <jsp:param value="공지사항" name="subject"/>
      <jsp:param value="list.do" name="url"/>
      <jsp:param value="등록" name="item"/>
   </jsp:include>

    <!-- Main content -->
    <section class="content container-fluid">
      <div class="row justify-content-center">
         <div class="col-md-9" style="max-width:960px;">
            <div class="card card-outline card-info">
               <div class="card-header">
                  <h3 class="card-title p-1">공지등록</h3>
                  <div class ="card-tools">
                     <button type="button" class="btn btn-primary" id="registBtn">등 록</button>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <button type="button" class="btn btn-warning" id="cancelBtn" onclick="CloseWindow();" >취 소</button>
                  </div>
               </div><!--end card-header  -->
               <div class="card-body pad">
                  <form role="form" method="post" action="regist.do" name="registForm">
                     <div class="form-group">
                        <label for="title">제 목</label> 
                        <input type="text" id="title"
                           name='title' class="form-control" placeholder="제목을 쓰세요">
                     </div>                     
                     <div class="form-group">
                        <label for="writer">작성자</label> 
                        <input type="text" id="writer" readonly
                           name="writer" class="form-control" value="${loginUser.id }">
                     </div>
                     <div class="form-group">
                        <label for="content">내 용</label>
                        <textarea class="textarea" name="content" id="content" rows="20"
                           placeholder="1000자 내외로 작성하세요." ></textarea>
                     </div>
                  </form>
               </div><!--end card-body  -->
               <div class="card-footer" style="display:none">
               
               </div><!--end card-footer  -->
            </div><!-- end card -->            
         </div><!-- end col-md-12 -->
      </div><!-- end row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <script>
  window.onload=function(){
  	$('#registBtn').on('click', function(e){
  		var form=document.registForm;
  		if(form.title.value==""){
  			alert("제목은 필수입니다.");
  			return;
  		}
  		
  		form.submit();
  		
  	});
  	
  	$('#content').summernote({
  		placeholder:'여기다 적어요 ',
  		height : 250,
  		disableResizeEditor:true,
  		callbacks:{
  			onImageUpload:function(files, editor, welEditable){
  				//file size validation
  				for ( var i = files.length -1 ; i>= 0 ; i--){
  					if(files[i].size > 1024 * 1024 * 5){
  						alert("이미지는 5MB 미만입니다.");
  						return;
  					}
  				}
  				//file sending
  				for ( var i = files.length -1 ; i >= 0 ; i--){
  					sendFile(files[i], this);
  				}
  			},
  			onMediaDelete: function(target){
  				var answer = confirm("정말 이미지를 삭제하시겠습니까? ");
  				if(answer){
					deleteFile(target[0].src);
				}
  			}
  		}
  		
  	
  	})
  }
  
 	function sendFile(file , el){
 		var form_data = new FormData();
 		form_data.append("file", file);
 		$.ajax({
 			data : form_data,
 			type : 'POST',
 			url : '<%=request.getContextPath()%>/uploadImg.do',
 			contentType : false,
 			processData : false,
 			success : function(img_url){
 				$(el).summernote('editor.insertImage', img_url);
 			}
 		});
 	}
 	
 	function deleteFile(src){
 		var splitSrc = src.split("=");
 		var fileName= splitSrc[splitSrc.length-1];
 		
 		//alert(fileName);
 		var fileData = {
 				fileName : fileName
 		}
 		$.ajax({
 			url:"<%=request.getContextPath()%>/deleteImg.do",
 			data : JSON.stringify(fileData),
 			type:"post",
 			success:function(res){
 				console.log(res);
 			}
 		})
 	}
  </script>
  </body>