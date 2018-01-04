package com.info.controler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.info.model.ItemModel;
import com.info.model.UserModel;
import com.info.service.ItemService;
import com.info.service.UserService;


/**
 * Servlet implementation class FetchFruitImage
 */
@WebServlet("/FetchImage")
public class FetchFruitImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchFruitImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session1 = request.getSession();
		
		
	/*	System.out.println("Flag A: You are going to fetch the Photo!!!");*/
		HttpSession session = request.getSession();				
		String id = request.getParameter("id");		
	
		
		ByteArrayInputStream photoIn = null;
		
	
		
	ArrayList<ItemModel> itemDb=ItemService.getPalace();
		
		session.setAttribute("itemDb", itemDb);
		
		
		for(ItemModel s : itemDb)
		{
			if(s.getId().equals(id))
			{
				photoIn = (ByteArrayInputStream) s.getImage();
				break;
			}
		}	

		try
		{
			byte[] pack = new byte[4096];
			int c = 0;
			response.reset();  /*
			System.out.println("Flag C: response CheckA!");*/
	        response.setContentType("image/jpeg"); 
			response.addHeader("Content-Disposition","filename=photo.jpg");
/*			System.out.println("Flag D: response CheckB!");*/
			ServletOutputStream sos = response.getOutputStream();
			
			while((c=photoIn.read(pack))!= -1 )  
			{ 
				/*System.out.println("Flag E: Inside loop while copying");*/
				sos.write(pack, 0, c);  
			}  
	        response.flushBuffer(); 
	        photoIn.close();  						
		}
		catch(Exception e)
		{
			System.out.println("Error while fetching the father photo: "+e);
		}		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
