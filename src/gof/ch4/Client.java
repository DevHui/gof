package gof.ch4;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {

		LogModel lml = new LogModel();

		lml.setLogId("001");
		lml.setOperateUser("admin");
		lml.setOperateTime("2016-12-06 22:14:56");
		lml.setLogContent("this is a test");

		LogModel lml2 = new LogModel();

		lml2.setLogId("002");
		lml2.setOperateUser("admin");
		lml2.setOperateTime("2016-12-07 22:14:56");
		lml2.setLogContent("this is a test2");

		List<LogModel> list = new ArrayList<>();

		list.add(lml);
		list.add(lml2);

		LogFileOperateApi api = new LogFileOperate("");
		api.writeLogFile(list);

		List<LogModel> readLog = api.readLogFile();

		System.out.println("readLog=" + readLog);
	}

}
