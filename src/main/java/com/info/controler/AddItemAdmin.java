package com.info.controler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.info.model.ItemModel;
import com.info.service.ItemService;
import com.otherID.OtherID;
/**
 * Servlet implementation class AddItemAdmin
 */
@WebServlet("/AddItemAdmin")
public class AddItemAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

    private ServletFileUpload uploader = null;

    public void init() throws ServletException
	{		
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");	
		
		ItemModel set=new ItemModel();
		try 
		{
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			
			while(fileItemsIterator.hasNext())
			{
				FileItem fileItem = fileItemsIterator.next();	
				if(fileItem.isFormField())
                {
                    
                    if(fileItem.getFieldName().equals("name"))
                    {
                    	String name=(fileItem.getString());
                    	set.setName(name);
                    }
                    
                    
                    if(fileItem.getFieldName().equals("cat"))
                    {
                    	String cat=(fileItem.getString());
                    	set.setCat(cat);
                    }
                    
                    if(fileItem.getFieldName().equals("price"))
                    {
                    	String price=(fileItem.getString());
                    	set.setPrice(price);
                    }
                    
                    if(fileItem.getFieldName().equals("Pcat"))
                    {
                    	String pCat=(fileItem.getString());
                    	set.setpCat(pCat);
                    }
                    
                    
                    if(fileItem.getFieldName().equals("qwt"))
                    {
                    	String qyt=(fileItem.getString());
                    	set.setQyt(qyt);
                    }
                    
                    if(fileItem.getFieldName().equals("shopno"))
                    {
                    	String shopno=(fileItem.getString());
                    	set.setShopno(shopno);
                    }
                   
                    
                    if(fileItem.getFieldName().equals("location"))
                    {
                    	String location=(fileItem.getString());
                    	set.setLocation(location);
                    }
                    
                    if(fileItem.getFieldName().equals("desc"))
                    {
                    	String desc=(fileItem.getString());
                    	set.setDesc(desc);
                    }
                   
                }	
				else
				{
				 
					if(fileItem.getFieldName().equals("image"))
                    {
						InputStream image = fileItem.getInputStream();
						set.setImage(image); 
                    }  
				}	
				
			}
		} 
		
		
		
		catch (Exception e) 
		{
			out.write("Exception in uploading form feild file."+e);
		}
		
		OtherID idobj=new OtherID();
		
		String id=idobj.genratedID();
	set.setId(id);
	
	ItemService obj=new ItemService();
	boolean flag=obj.insertPalace(set);
	
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
