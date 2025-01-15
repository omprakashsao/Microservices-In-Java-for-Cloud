package in.ops.om.main;

import in.ops.om.dao.TransferProductImpl;

public class MainApp {

	public static void main(String[] args) {
		
		TransferProductImpl obj = new TransferProductImpl();
		String status = obj.transferProductById(1);
		System.out.println(status);

	}

}
