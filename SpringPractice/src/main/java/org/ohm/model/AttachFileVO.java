package org.ohm.model;

public class AttachFileVO {
	// 1. 파일이 저장되어 있는 경로
	private String uploadPath; // 2022\\08\\24
	// 2. 업로드된 파일명
	private String fileName; // image.png
	// 3. uuid 정보
	private String uuid; // afdlwejisf ...
	// 4. 업로드된 파일이 이미지파일인지 아닌지 구분
	private boolean image;
	// bno
	private int bno;
	
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public boolean isImage() {
		return image;
	}
	public void setImage(boolean image) {
		this.image = image;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	@Override
	public String toString() {
		return "AttachFileVO [uploadPath=" + uploadPath + ", fileName=" + fileName + ", uuid=" + uuid + ", image="
				+ image + ", bno=" + bno + "]";
	}
	
}
