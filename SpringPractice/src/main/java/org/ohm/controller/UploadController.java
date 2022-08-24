package org.ohm.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.ohm.model.AttachFileVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {
	@RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
	public void uploadForm() {
		
	}
	
	@RequestMapping(value = "/uploadFormAction", method = RequestMethod.POST)
	public void uploadFormPost(MultipartFile[] uploadFile) {
		
		// 폴더 경로 
		String uploadFolder="D:\\01-STUDY\\upload";
		
		// for(배열명:변수명)
		for(MultipartFile multipartFile : uploadFile) {
			System.out.println(multipartFile.getOriginalFilename());
			System.out.println(multipartFile.getSize());
			
			// 파일 저장
			//     어느폴더에(D:\\01-STUDY\\upload),어떤 파일 이름으로(image)
			File saveFile = new File(uploadFolder,multipartFile.getOriginalFilename());
			
			try{ // D:\\01-STUDY\\upload\\image에 파일을 전송(transferTo)
				multipartFile.transferTo(saveFile);
			}catch(Exception e) {// 예외르 처리하라.
				System.out.println(e.getMessage());
			}
		}	
	}
	
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.GET)
	public void uploadAjax() {
		
	}
	// 년/월/일 폴더 생성하는 메서드 선언
	private String getFolder() {
		
		// 현재날짜 추출(Thu Aug 24 09:23:12 KST 2022)
		Date date = new Date();
		System.out.println("No Format 현재날짜: " +date);
		// Thu Aug 24 09:23:12 KST 2022 -> 2022-08-24
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 현재날짜와 날짜형식을 연결
		String str = sdf.format(date); // 2022-08-24
		System.out.println("Format 적용 현재날짜:"+str);
		// 2022-08-24 -> 2022\08\24로 변경
		return str.replace("-", "\\");		
	}
	
	// 내가 올리고자 하는 파일이 이미지 파일인지 아닌지 구분하는 메서드 선언
	//	     반환타입   메소드명                 타입 변수명
	private boolean checkImageType(File file) {
		// probeContentType(파일경로) : 파일경로에 있는 파일타입을 알아내는 메서드
		String contentType;
		try {
			contentType = Files.probeContentType(file.toPath());
			System.out.println("contentType="+contentType);
			// 파일타입이 image 이면 true, 그 이외에는 false
			return contentType.startsWith("image");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}	
		
	
	
	@RequestMapping(value = "/uploadAjaxAction", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<AttachFileVO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		
		// AttachFileVO클래스 포함
		ArrayList<AttachFileVO> list = new ArrayList<>();
		
		// 폴더 경로 
		String uploadFolder="D:\\01-STUDY\\upload";
		
		// 서버 업로드 경로와 getFolder메서드의 날짜문자열을 이어서 하나의 폴더 생성
		File uploadPath = new File(uploadFolder,getFolder());
		
		// 폴더 생성
		if(uploadPath.exists()==false) { //uploadPath가 존재하지 않으면,
			uploadPath.mkdirs();
		}
		
		// for(배열명:변수명)
		for(MultipartFile multipartFile : uploadFile) {
			
			// AttachFileVO클래스의 새로운 주소를 반복적으로 생성하여
			// ArrayList에 저장
			AttachFileVO attachvo = new AttachFileVO();
			
			System.out.println(multipartFile.getOriginalFilename());
			System.out.println(multipartFile.getSize());
			
			// 파일 저장
			// 실제파일명(multiparFile.getOriginalFilename())
			// UUID 적용(UUID_multiparFile.getOriginalFilename())
			UUID uuid = UUID.randomUUID();
			
			System.out.println("UUID="+uuid.toString());	
			
			// AttachFileVO의 uploadPath 변수에 저장()
			attachvo.setUploadPath(getFolder());
			// AttachFileVO의 fileName 변수에 저장()
			attachvo.setFileName(multipartFile.getOriginalFilename());
			// AttachFileVO의 uuid 변수에 저장()
			attachvo.setUuid(uuid.toString());
			
			
						
			//     어느폴더에(D:\\01-STUDY\\upload),어떤 파일 이름으로(UUID_image)
			File saveFile = new File(uploadPath,uuid.toString()+"_"+multipartFile.getOriginalFilename());
			
			try{ // D:\\01-STUDY\\upload\\image에 파일을 전송(transferTo)
				multipartFile.transferTo(saveFile); // 서버로 원본파일 전송
				// 내가 서버에 올리고자 하는 파일이 이미지이면,
				if(checkImageType(saveFile)) {
					
					// AttachFileVO의 image 변수에 저장()
					attachvo.setImage(true);
					// 파일 생성
					FileOutputStream thumnail = new FileOutputStream(new File(uploadPath,uuid.toString()+"_s_"+multipartFile.getOriginalFilename()));
					// 썸네일형식의 파일생성
					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumnail,100,100);
					
					thumnail.close();
				} // checkImageType 메서드 끝
		
				// AttachFileVO에 저장된 데이터를 배열의 추가(add 메소드)
				list.add(attachvo);
				
				
			}catch(Exception e) {// 예외르 처리하라.
				System.out.println(e.getMessage());
			}
		} // for문 끝
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	

	
}
