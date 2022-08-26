/**
 * 첨부파일 관련 js
 */
$(document).ready(function(){
	// detail.jsp가 시작되자마자(ready이벤트) bno값 가져오기
	var bno=$("input[name='bno']").val();

	$.getJSON("/attachlist",{bno:bno},function(attachlist){
		console.log(attachlist);
		
		var str="";
		
		$(attachlist).each(function(i,attach){
			// 만약 image결과가 true면
			if(attach.image){
				// 아래에 있는거 실행
				var filePath = encodeURIComponent(attach.uploadPath+"/"+attach.uuid+"_s_"+attach.fileName);
				str+="<li><img src='\display?fileName="+filePath+"'>"+attach.fileName+"</li>"
			}else{ // 그렇지 않으면
				// 다운로드 할 수 있도록 실행
				var filePath = encodeURIComponent(attach.uploadPath+"/"+attach.uuid+"_"+attach.fileName);
				str+="<li><a href='\download?fileName="+filePath+"'>"+attach.fileName+"</a></li>"
			}
		})
		$("#uploadResult ul").html(str);
	})
})