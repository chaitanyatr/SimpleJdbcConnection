package com.jdbc.test;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step-1
		Names name=new Names();
		DAO dao=new DAO();
		name.setFirstName(request.getParameter("firstname"));
		name.setMiddleName(request.getParameter("middlename"));
		name.setLastName(request.getParameter("lastname"));
		
//		request.getSession().setAttribute("first_name", request.getParameter("firstname"));
//		request.getSession().setAttribute("middle_name", request.getParameter("middlename"));
//		request.getSession().setAttribute("last_name", request.getParameter("lastname"));
		
		//step-3
		HttpSession ses=request.getSession();
		ses.setAttribute("Name", name);
		try {
			dao.addNames(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		ses.setAttribute("first_name", fName);
//		ses.setAttribute("middle_name", mName);
//		ses.setAttribute("last_name", lName);
		response.sendRedirect("jsp/out.jsp");
		
	}

}
