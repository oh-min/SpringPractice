/**
 * 
 */

$(document).ready(function(){
	// 검색버튼을 클릭하면
	// $("input[type='button']").on("click",function(){
	$("#searchBtn").on("click",function(){
		// alert("aaa");
		// PageNum에 1을 초기화
		$("input[name='pageNum']").val("1");
		// form 태그르 submit
		$("#searchForm").submit();
	})
	
	
	
	
	
})