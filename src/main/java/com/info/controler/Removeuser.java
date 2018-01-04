package com.info.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.info.service.ItemService;
import com.info.service.UserService;

/**
 * Servlet implementation class Removeuser
 */
@WebServlet("/Removeuser")
public class Removeuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Removeuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String typeId=request.getParameter("typeID");		
		UserService obj = new UserService();
				boolean flag= obj.removePlace(typeId);
				
				if(flag)
				{
					RequestDispatcher rd=request.getRequestDispatcher("WelAdmin");
					rd.forward(request, response);
				} 
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("WelAdmin");
					rd.forward(request, response);
				}
			}

			/**
			 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
			 */
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				doGet(request, response);
			}

}
