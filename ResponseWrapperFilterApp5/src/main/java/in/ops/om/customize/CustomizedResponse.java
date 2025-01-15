package in.ops.om.customize;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CustomizedResponse extends HttpServletResponseWrapper {

	private HttpServletResponse response;
	public CustomizedResponse(HttpServletResponse response) {
		super(response);
		this.response = response;
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
	 PrintWriter out = response.getWriter();
	CustomizeWriter myWriter = new CustomizeWriter(out);
	return myWriter;
	}

}
