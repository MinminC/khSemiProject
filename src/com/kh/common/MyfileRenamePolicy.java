package com.kh.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyfileRenamePolicy implements FileRenamePolicy	{

	@Override
	public File rename(File originFile) {
		// 원본 파일명 뽑기
		String originName = originFile.getName();
		
		// 수정 파일명 규칙 : 파일업로드 시간(년월일시분초) + 5자리 랜덤값(10000 ~ 99999) + 확장자
		// 현재 시간
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		// 5자리 랜덤값
		int ranNum = (int)(Math.random() * 50000) + 10000;
		// 확장자 뽑기
		String ext = originName.substring(originName.lastIndexOf("."));
		
		// 수정파일명
		String changeName = currentTime + ranNum + ext;
		
		// 기존파일을 수정된 파일명으로 적용시켜서 리턴
		return new File(originFile.getParent(), changeName);
	
	}
	
}
