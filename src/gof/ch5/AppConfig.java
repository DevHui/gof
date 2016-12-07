package gof.ch5;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
	
	private final static String pro_file = "AppConfig.properties";
	private final static String paramA = "paramA";
	private final static String paramB = "paramB";
	
	private String parameterA;
	private String parameterB;
	
	private static class AppConfigHolder{
		private static AppConfig instance = new AppConfig();
	}
	
	public static AppConfig getInstance(){
		return AppConfigHolder.instance;
	}
	
	private AppConfig(){
		readConfig();
	}

	public String getParameterA() {
		return parameterA;
	}

	public String getParameterB() {
		return parameterB;
	}
	
	private void readConfig() {
		
		Properties pro = new Properties();
		
		InputStream in = null;
		
		try {
			in = AppConfig.class.getResourceAsStream(pro_file);
			pro.load(in);
			
			this.parameterA = pro.getProperty(paramA);
			this.parameterB = pro.getProperty(paramB);
			
		} catch (IOException e) {
			System.out.println("配置文件装载错误，请核查信息！");
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
