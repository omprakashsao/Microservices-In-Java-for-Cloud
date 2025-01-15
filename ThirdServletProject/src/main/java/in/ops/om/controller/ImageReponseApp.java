package in.ops.om.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageReponseApp
 */
@WebServlet(description = "working with image as a response", urlPatterns = { "/image" })
public class ImageReponseApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageReponseApp() {
        System.out.println("Servlet Instatiation.....");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	     response.setContentType("image/png");
         
	       ServletOutputStream outputStream  =response.getOutputStream();
	       String path = getServletContext().getRealPath("image.png");
	         File file = new File(path);
	         FileInputStream fis = new FileInputStream(file);
	         byte[] b = new byte[(int)file.length()];
	         fis.read(b);
	         outputStream.write(b);
	         
	         fis.close();
	         outputStream.flush();
	         outputStream.close();
	}

}
