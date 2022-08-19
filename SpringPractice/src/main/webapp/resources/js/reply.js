/**
 *  댓글 관련 javascript 처리
 */

$(document).ready(function(){ // jquery 준비
	// 함수 호출
	// detail.jsp가 시작되자마자 bno값을 가져올려면 $(document).ready 아래에 선언
	var bnoValue=$("input[name='bno']").val();
	
	// detail.jsp가 시작되자마자 댓글목록리스트 함수를 호출
	list(bnoValue)
	
	// 댓글쓰기를 하기 위한 함수 호출
	$("#add").on("click",function(){
		// 댓글쓰기 버튼을 클릭했을 당시에 댓글내용을 가져오려면 $("#add").on("click",function(){ 아래에 선언
		var replyValue = $("#reply").val();
		var idValue="qq11"
		
		add({bno:bnoValue, reply:replyValue, id:idValue}); // 댓글쓰기를 하기 위한 함수 호출
		
	})
	
})

// 함수 선언

function list(bno){ // list 함수 선언 시작
	// alert(bno);
	$.getJSON("/replies/"+bno+".json",function(data){
		
		var str="";
		
		for(var i=0; i<data.length; i++){
			str+="<li>"+data[i].id+"</li>"
			str+="<li>"+data[i].reply+"</li>"
			str+="<li><a href='"+data[i].rno+"'>수정"+"</a></li>"
		}
		
		$("#replyUL").html(str);
	});
} // list 함수 선언 끝


// 댓글쓰기를 하기 위한 함수 선언
function add(reply){ // add함수 선언 시작
	$.ajax({	// ajax 준비(비동기식으로 처리) 
		type:"post",	// method 방식(get, post, put, delete)
		url:"/replies/new" ,	
		data: JSON.stringify(reply),
		// contentType : ajax -> controller로 데이터 전송 시 타입
		// (contentType을 생략하면 web Browser한테 타입선택 위임)
		contentType:"application/json; charset=utf-8",
		success:function(result){
			if(result=="success"){
				alert("댓글쓰기 성공")
			}
		}
	})
		
} // add함수 선언 끝





	
	




