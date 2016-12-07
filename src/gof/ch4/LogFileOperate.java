package gof.ch4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class LogFileOperate implements LogFileOperateApi {

	private String logFilePathName = "AdapterLog.log";

	public LogFileOperate(String logFilePathName) {
		if (null != logFilePathName && logFilePathName.trim().length() > 0) {
			this.logFilePathName = logFilePathName;
		}
	}

	@Override
	public List<LogModel> readLogFile() {

		List<LogModel> list = null;

		ObjectInputStream oin = null;

		try {
			File f = new File(logFilePathName);
			if (f.exists()) {
				oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
				
				list = (List<LogModel>) oin.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != oin) {
					oin.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void writeLogFile(List<LogModel> list) {
		
		System.out.println("writeLogFile start>>>" + logFilePathName);
		
		File f = new File(logFilePathName);
		
		ObjectOutputStream oout = null;
		
		try {
			oout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			oout.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	
		

	}

}
