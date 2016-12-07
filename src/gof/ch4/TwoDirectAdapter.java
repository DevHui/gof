package gof.ch4;

import java.util.ArrayList;
import java.util.List;

public class TwoDirectAdapter implements LogDbOperateApi, LogFileOperateApi {

	private LogFileOperateApi fileLog;

	private LogDbOperateApi dbLog;

	public TwoDirectAdapter(LogFileOperateApi fileLog, LogDbOperateApi dbLog) {
		this.fileLog = fileLog;
		this.dbLog = dbLog;
	}

	@Override
	public List<LogModel> readLogFile() {
		return dbLog.getAllLog();
	}

	@Override
	public void writeLogFile(List<LogModel> list) {
		for (LogModel lm : list) {
			dbLog.createLog(lm);
		}
	}

	@Override
	public void createLog(LogModel lm) {

		List<LogModel> list = fileLog.readLogFile();

		if (null == list) {
			list = new ArrayList<LogModel>();
		}

		list.add(lm);

		fileLog.writeLogFile(list);
	}

	@Override
	public void removeLog(LogModel lm) {

		List<LogModel> list = fileLog.readLogFile();

		if (null != list) {
			list = new ArrayList<LogModel>();
		}

		list.remove(lm);

		fileLog.writeLogFile(list);

	}

	@Override
	public List<LogModel> getAllLog() {
		return fileLog.readLogFile();
	}

	@Override
	public void updateLog(LogModel lm) {

		List<LogModel> list = fileLog.readLogFile();

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

		fileLog.writeLogFile(list);
	}

}
