package com.jsp.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.jsp.dto.AttachVO;

public class MakeFileName {
	
	private static String delimiter ="$$";
	
	public static String toUUIDFileName(String fileName, String delimiter) {
		String uuid = UUID.randomUUID().toString().replace("-","");
		if(delimiter!=null && !delimiter.isEmpty()) MakeFileName.delimiter = delimiter;
		
		return uuid+ MakeFileName.delimiter+fileName;
	}
	
	
	public static String parseFileNameFromUUID(String fileName, String delimiter) {
		if(delimiter!=null && !delimiter.isEmpty()) MakeFileName.delimiter = delimiter;
		String[] uuidFileName = fileName.split(MakeFileName.delimiter);
		return uuidFileName[uuidFileName.length -1 ];
	}
	
	public static List<AttachVO> parseFileNameFromAttaches(List<AttachVO> attachList, String delimiter){
		List<AttachVO> renamedAttachList = new ArrayList<AttachVO>();
		
		if(attachList != null) {
			for(AttachVO attach : attachList) {
				String fileName = attach.getFileName(); //db상의 파일이름 
				fileName = parseFileNameFromUUID(fileName, delimiter);  //uuid가 제거된파일이름
				
				attach.setFileName(fileName);
				
				renamedAttachList.add(attach);
			}
		}
		return renamedAttachList;
	}
	
	
}
