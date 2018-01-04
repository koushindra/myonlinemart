package com.info.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.model.CustModel;
import com.info.service.CustService;
import com.otherID.OtherID;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		
		String email=request.getParameter("Email");
		String location=request.getParameter("location");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		

		OtherID objid=new OtherID();
		String id=objid.genratedID();
		
		CustModel model=new CustModel(name, mobile, email, location, username, password, id);
		CustService obj=new CustService();
		
		obj.insertUser(model);
		response.sendRedirect("costumerLogin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
