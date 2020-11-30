package com.jsp.action.pds;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.request.SearchCriteria;
import com.jsp.service.PdsService;
import com.jsp.utils.ExceptionLoggerHelper;

public class PdsListAction implements Action {

	private PdsService pdsService;
	
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/pds/list";
		

		String page = request.getParameter("page");
		String perPageNum = request.getParameter("perPageNum");
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		SearchCriteria cri = new SearchCriteria(page, perPageNum, searchType, keyword);
		
		try {
			Map<String, Object> dataMap = pdsService.getList(cri);
			request.setAttribute("dataMap", dataMap);
		}catch (SQLException e) {
			e.printStackTrace();
			ExceptionLoggerHelper.write(request, e, pdsService);
		}
		
		return url;
	}
}
