package gof.ch5;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig2 {
	
	private final static String pro_file = "AppConfig.properties";
	private final static String paramA = "paramA";
	private final static String paramB = "paramB";
	/**
	 * volatile 关键字 会屏蔽掉虚拟机中的一些必要的代码优化，运行效率不是很高
	 * 没有特殊必要，不要使用，"双重检查加锁"实现线程安全的单例，不建议大量采用
	 */
	private volatile static AppConfig2 instance = null;
	private String parameterA;
	private String parameterB;
	
	public static AppConfig2 getInstance(){
		//先检查实例是否存在，如果不存在才进入下面同步模块
		if(null == instance){
			//同步块，线程安全地创建实例
			synchronized (AppConfig2.class) {
				//再检查实例是否存在,如果不存在才真正地创建实例
				if(null == instance){
					instance = new AppConfig2();
				}
			}
		}
		return instance;
	}
	
	private AppConfig2(){
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
			in = AppConfig2.class.getResourceAsStream(pro_file);
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
