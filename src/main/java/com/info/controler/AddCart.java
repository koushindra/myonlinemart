package com.info.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.info.model.ItemModel;
import com.info.service.CartService;
import com.info.service.ConnectionProvider;
import com.info.service.ItemService;
import com.otherID.OtherID;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/AddInCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		OtherID idObj=new OtherID();
		
		HttpSession session = request.getSession();
		
		String userid=(String)session.getAttribute("CuserId");
		
		
		
		
		
		String id=request.getParameter("id");
		String itemName=null;
		String itemPrice=null;
		
		ArrayList<ItemModel> itemDb = ItemService.getPalace();
		if(itemDb!=null)
		{
			for(ItemModel show : itemDb)
        	{
				String getId=show.getId();
				if(id.equals(getId))
				{
    			itemName=show.getName();
    			itemPrice=show.getPrice();
				}
        	}
		}
		
		boolean flag=false;
		try
		{
			
			Connection con=ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into cartoption values(?, ?, ?)");
			ps.setString(1, itemName);
			ps.setString(2, itemPrice);
			ps.setString(3, userid);	
			int num = ps.executeUpdate();
			if(num>0)
			{
				flag = true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error inserting cart item type"+e);
		}
		request.setAttribute("succes", "your order added in cart");
		RequestDispatcher rd=request.getRequestDispatcher("ItemMenuList");
		rd.forward(request, response);
	
		
	}
			
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
