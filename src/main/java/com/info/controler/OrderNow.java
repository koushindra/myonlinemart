package com.info.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.info.model.CartModel;
import com.info.model.OrderModel;
import com.info.service.CartService;
import com.info.service.OrderService;
import com.otherID.OtherID;

/**
 * Servlet implementation class OrderNow
 */
@WebServlet("/SaveOrderNow")
public class OrderNow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderNow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		String userId=(String)session.getAttribute("CuserId");
		String name=(String)session.getAttribute("cname");
		String mobile=(String)session.getAttribute("mobile");
		String email=(String)session.getAttribute("email");
		String address=(String)session.getAttribute("address");
		
		int total=0;
		
		 OtherID objid=new OtherID();
		
		 String id=objid.genratedID();
		 
		 ArrayList<CartModel> itemDb=CartService.getDises();
     	if(itemDb!=null)
     	{
     		for(CartModel show: itemDb)
     		{
     			String ida=show.getUserid();
     			
     			System.out.println("user id : "+userId+" id : "+id);
     			
     			if(userId.equals(ida))
     			{
     				total=total+Integer.parseInt(show.getPrice());
     			}
     		}
     	}
     	System.out.println("FlagA-1-!!!!");
		 
		 
		 String amount=Integer.toString(total);
		 
		 System.out.println("FlagA-2-!!!!");
		 OrderModel model=new OrderModel(userId, name, mobile, email, address, amount, id);
		 OrderService obj=new OrderService();
		 System.out.println("FlagA-3-!!!!");
	boolean flag=OrderService.insertOrder(model);
	System.out.println("FlagA-4-!!!!");
	if (flag) {
		System.out.println("FlagA!!!!");
		CartService.removeItem(userId);
		
		RequestDispatcher rd=request.getRequestDispatcher("successOrder.jsp");
		rd.forward(request, response);
	}
	else 
	{
		System.out.println("FlagB!!!!");
		RequestDispatcher rd=request.getRequestDispatcher("successOrder.jsp");
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
