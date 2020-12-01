package com.jsp.action.pds;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;
import com.jsp.utils.ExceptionLoggerHelper;
import com.jsp.utils.GetUploadPath;
import com.jsp.utils.MakeFileName;
import com.jsp.utils.ServletFileUploadBuilder;

public class PdsRegistAction implements Action{

	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="/pds/regist_success";
		
		
		try {
			PdsVO pds = fileUpload(request);
			pdsService.regist(pds);
		}catch (Exception e) {
			e.printStackTrace();
			ExceptionLoggerHelper.write(request, e, pdsService);
			url="/pds/regist_fail";
		}
	
		return url;
	}
	
	
	//업로드 파일 환경설정
	
	private static final int MEMORY_THRESHOLD = 1024 * 500 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 *  40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 200; // 200MB
	
	private PdsVO fileUpload(HttpServletRequest request) throws Exception{
		
		PdsVO pds = new PdsVO();
		List<AttachVO> attachList = new ArrayList<AttachVO>();
		
		ServletFileUpload upload = ServletFileUploadBuilder.build(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
		
		//실제 저장 경로를 설정
		String uploadPath = GetUploadPath.getUploadDatePath("pds.upload");
		File file = new File(uploadPath);
		if(!file.mkdirs()) {
			System.out.println(uploadPath + "가 이미 존재하거나 생성을 실패했습니다.");
		}
				
		List<FileItem> formItems = upload.parseRequest(request);
		
		for(FileItem item : formItems) {
			//1.1 필드
			if(item.isFormField()) {
				//파라미터 구분(파라미터 이름)
				switch(item.getFieldName()) {
				case "title":
					pds.setTitle( HTMLInputFilter.htmlSpecialChars( item.getString("utf-8")  ));
					break;
				case "writer":
					pds.setWriter(item.getString("utf-8"));
					break;
				case "content":
					pds.setContent(item.getString("utf-8"));
					break;
				}
			}else {
			// file
				//summernote files 를 제외함
				if(!item.getFieldName().equals("uploadFile")) continue;
				
				String fileName = new File(item.getName()).getName();
				fileName = MakeFileName.toUUIDFileName(fileName, "$$");
				String filePath = uploadPath + File.separator + fileName;
				File storeFile = new File(filePath);
				
				//localHdd 에 저장
				try {
					item.write(storeFile);
					
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				
				
				//db에 저장할 attach 에 파일내용 추가
				AttachVO attach = new AttachVO();
				attach.setFileName(fileName);
				attach.setUploadPath(uploadPath);
				attach.setFileType(fileName.substring(fileName.lastIndexOf(".") + 1));
				
				attachList.add(attach);
				
				System.out.println("uploadFile :" + attach);
				
				
			}
		}
		
		pds.setAttachList(attachList);
		
		return pds;
	}
	
}
