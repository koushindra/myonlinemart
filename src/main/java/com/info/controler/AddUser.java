package com.info.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.model.UserModel;
import com.info.service.UserService;
import com.otherID.OtherID;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
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
		
		String shopno=request.getParameter("shopno");
		String location=request.getParameter("location");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		

		OtherID objid=new OtherID();
		String id=objid.genratedID();
		
		UserModel model=new UserModel(name, mobile, shopno, location, username, password, id);
		UserService obj=new UserService();
		
		obj.insertUser(model);
		
		response.sendRedirect("WelAdmin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
