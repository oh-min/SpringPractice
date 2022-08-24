package org.ohm.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
		for(MultipartFile multiparFile : uploadFile) {
			System.out.println(multiparFile.getOriginalFilename());
			System.out.println(multiparFile.getSize());
			
			// 파일 저장
			//     어느폴더에(D:\\01-STUDY\\upload),어떤 파일 이름으로(image)
			File saveFile = new File(uploadFolder,multiparFile.getOriginalFilename());
			
			try{ // D:\\01-STUDY\\upload\\image에 파일을 전송(transferTo)
				multiparFile.transferTo(saveFile);
			}catch(Exception e) {// 예외르 처리하라.
				System.out.println(e.getMessage());
			}
		}	
	}
	
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.GET)
	public void uploadAjax() {
		
	}
	@RequestMapping(value = "/uploadAjaxAction", method = RequestMethod.POST)
	public void uploadAjaxPost(MultipartFile[] uploadFile) {
		
		// 폴더 경로 
		String uploadFolder="D:\\01-STUDY\\upload";
		
		// for(배열명:변수명)
		for(MultipartFile multiparFile : uploadFile) {
			System.out.println(multiparFile.getOriginalFilename());
			System.out.println(multiparFile.getSize());
			
			// 파일 저장
			//     어느폴더에(D:\\01-STUDY\\upload),어떤 파일 이름으로(image)
			File saveFile = new File(uploadFolder,multiparFile.getOriginalFilename());
			
			try{ // D:\\01-STUDY\\upload\\image에 파일을 전송(transferTo)
				multiparFile.transferTo(saveFile);
			}catch(Exception e) {// 예외르 처리하라.
				System.out.println(e.getMessage());
			}
		}	
	}
	

	
}
