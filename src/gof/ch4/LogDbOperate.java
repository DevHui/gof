package gof.ch4;

import java.util.List;

public class LogDbOperate implements LogDbOperateApi {

	@Override
	public void createLog(LogModel lm) {
		
		System.out.println(LogDbOperate.class.getName() + " createLog ");

	}

	@Override
	public void removeLog(LogModel lm) {
		System.out.println(LogDbOperate.class.getName() + " removeLog ");
	}

	@Override
	public List<LogModel> getAllLog() {
		System.out.println(LogDbOperate.class.getName() + " getAllLog ");
		return null;
	}

	@Override
	public void updateLog(LogModel lm) {
		System.out.println(LogDbOperate.class.getName() + " updateLog ");
	}

}
