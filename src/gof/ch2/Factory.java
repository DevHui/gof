package gof.ch2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Factory {

	private final static String pro_file = "factory.properties";
	
	private final static String pro_key = "ImpleClass";

	public static Api createApi(int condition) {

		Api api = null;

		switch (condition) {
		case 1:
			api = new ImplA();
			break;

		case 2:
			api = new ImplB();
			break;

		default:
			break;
		}
		return api;
	}

	public static Api createApi() {

		Properties pfile = new Properties();

		InputStream in = null;

		try {
			in = Factory.class.getResourceAsStream(pro_file);
			
			pfile.load(in);

		} catch (IOException e) {

			System.out.println("装配文件出错！");

			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Api api = null;
		
		try {
			api = (Api) Class.forName(pfile.getProperty(pro_key)).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return api;
	}
}
