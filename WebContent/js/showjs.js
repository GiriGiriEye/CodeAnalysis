//页面被加载时调用
$(document).ready(function(){
	$.ajax({
		  type: "GET",
		  url:"http://localhost:8080/CodeAnalysis/show",
		  dataType:"json",
		  success:function(result){
			  test(result);
		  }
	});
});
