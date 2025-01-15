package in.ops.om.customize;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class CustomizeWriter extends PrintWriter {

	private   PrintWriter out;
	public CustomizeWriter(PrintWriter out) {
		super(out);
		this.out =out;
		// TODO Auto-generated constructor stub
	}
  
	
	@Override
	public void println(String data) {
		
		if(!data.startsWith("<")) {
			StringBuffer sb = new StringBuffer(data);
			out.println(sb.reverse());
		}
		else {
			out.println(data);
		}
		
	}

}
