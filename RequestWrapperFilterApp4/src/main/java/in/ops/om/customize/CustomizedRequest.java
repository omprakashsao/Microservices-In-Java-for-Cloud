package in.ops.om.customize;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomizedRequest extends HttpServletRequestWrapper {

	public CustomizedRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getParameter(String name) {
		
		 String data = super.getParameter(name);
		 System.out.println("User entered data is :: "+data);
		 
		 if(data.equals("om") || data.equalsIgnoreCase("ops"))
			 data="Om Prakash Sao";
		
		 
		 return data;
	}

}
