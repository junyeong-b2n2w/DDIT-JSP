<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
    

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="float-right d-none d-sm-inline">
      Anything you want
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2014-2019 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
  </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>
<!-- handlebars -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.6/handlebars.min.js"></script>

<script type="text/x-handlebars-template"  id="subMenu-list-template" >
{{#each .}}
	<li class="nav-item subMenu" >
      	<a href="javascript:goPage('{{murl }}','{{mcode}}');" class="nav-link">
          <i class="{{micon }}"></i>
             <p>{{mname }}</p>
        </a>
	</li>
{{/each}}
</script>

<script>
	var printData = function(subMenuArr, target, templateObject){
		var template = Handlebars.compile(templateObject.html());
		var html = template(subMenuArr);
		$('.subMenu').remove();
		target.append(html);
	}

	
	
	

	function subMenu(mCode){
		if(mCode != "M000000"){
			$.getJSON("<%=request.getContextPath()%>/common/subMenu.do?mCode="+mCode, function(data){
				printData(data, $('.subMenuList'), $('#subMenu-list-template'));
			});	
		}else{
			$('.subMenuList').html("");
		}
		
		
	}
	
	function goPage(url, mCode){
		//HTML5 브라우저에서 사용가능
		if(typeof(history.pushState) == 'function'){
			//현재주소를 가져온다
			var renewURL = location.href;
			//현재주소중 .do 뒷부분이 있다면 날려버린다
			renewURL = renewURL.substring(0, renewURL.indexOf(".do")+3);
			
			if( mCode != 'M000000'){
				renewURL += "?mCode=" + mCode;
			}
			
			//페이지를 리로드 하지 않고 페이지 주소만 변경할때 사용
			history.pushState(mCode, null, renewURL);
			
		}else{
			location.hash = "#" + mCode;
		}
		
		$('#if_list').attr("src", "<%=request.getContextPath()%>"+url);
	}
	
	goPage('${menu.murl}', '${menu.mcode}');
	subMenu('${menu.mcode}'.substring(0,3)+"0000");
	
</script>

</body>
</html>
