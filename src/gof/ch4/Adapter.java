package gof.ch4;

import java.util.ArrayList;
import java.util.List;

public class Adapter implements LogDbOperateApi {

	private LogFileOperateApi adaptee;

	public Adapter(LogFileOperateApi adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void createLog(LogModel lm) {

		List<LogModel> list = adaptee.readLogFile();
		if (null == list) {
			list = new ArrayList<LogModel>();
		}

		list.add(lm);

		adaptee.writeLogFile(list);
	}

	@Override
	public void removeLog(LogModel lm) {

		List<LogModel> list = adaptee.readLogFile();

		if (null == list) {
			list = new ArrayList<LogModel>();
		}

		list.remove(lm);
		
		adaptee.writeLogFile(list);
	}

	@Override
	public List<LogModel> getAllLog() {

		return adaptee.readLogFile();
	}

	@Override
	public void updateLog(LogModel lm) {

		List<LogModel> list = adaptee.readLogFile();

		if (null != list) {
			boolean isNew = true;

			int size = list.size();
			for (int i = 0; i < size; i++) {
				if (list.get(i).getLogId().equals(lm.getLogId())) {
					list.set(i, lm);
					isNew = false;
					break;
				}
			}

			if (isNew) {
				list.add(lm);
			}
		} else {
			list = new ArrayList<LogModel>();
			list.add(lm);
		}

		adaptee.writeLogFile(list);

	}

}
