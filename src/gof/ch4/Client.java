package gof.ch4;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {

		// testVersion1();

		testVersion2();

	}

	private static void testVersion2() {

		LogFileOperateApi adaptee = new LogFileOperate("");

		LogDbOperateApi api = new Adapter(adaptee);

		LogModel lml = new LogModel();
		lml.setLogId("001");
		lml.setOperateUser("admin");
		lml.setOperateTime("2016-12-06 22:14:56");
		lml.setLogContent("this is a test222");

		api.updateLog(lml);

		List<LogModel> readLog = api.getAllLog();

		for (LogModel item : readLog) {
			System.out.println("item=" + item);
		}

		lml.setLogContent("this is a testdddd");
		api.updateLog(lml);

		readLog = api.getAllLog();
		System.out.println("readLog=" + readLog);

	}

	private static void testVersion1() {

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
