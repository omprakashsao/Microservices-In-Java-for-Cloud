package in.ops.om.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.hibernate.HibernateException;

import in.ops.om.entity.InsurancePolicyDTO;
import in.ops.om.service.InsurancePolicyMgmtServiceImpl;

/**
 * Servlet implementation class MainControllerServlet
 */
@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private InsurancePolicyMgmtServiceImpl service;
	
	
    @Override
    	public void init() throws ServletException {
    		service = new InsurancePolicyMgmtServiceImpl();
    	}
    

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pageNo = 0;
		int pageSize = 3;
		HttpSession session = null;
		long pageCount = 0;
		List<InsurancePolicyDTO> listdto = null;
		RequestDispatcher rd = null;
		String targetPage = null;
		
		session = request.getSession();
		
		String buttonClicked = request.getParameter("s1");
		
		if (buttonClicked.equalsIgnoreCase("generatedReport")) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			
			//default page no. is 1
			 pageNo = 1;
			
			// keeping page size in session scope
			if(session != null) {
				session.setAttribute("pageSize", pageSize);
			} 
		
		} else {
			//user clicked hyperlink
			
			
		}
		
		try {
			// No of pages need to display the records in pagination style
			pageCount = service.fetchPageCount(pageSize);
			
			// Get the records in each page to print on the ui
			listdto = service.fetchPageData(pageSize, pageNo);
					
		    request.setAttribute("policyList", listdto);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNo", pageNo);
			targetPage = "/target.jsp";
			
		} catch (HibernateException e) {
			e.printStackTrace();
			targetPage = "/error.jsp";
		} catch (Exception e ) {
			e.printStackTrace();
			targetPage = "/error.jsp";
		}
		rd = request.getRequestDispatcher(targetPage);
		rd.forward(request, response);
		
		
	}

}
