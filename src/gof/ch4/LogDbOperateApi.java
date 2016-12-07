package gof.ch4;

import java.util.List;

public interface LogDbOperateApi {
	
	public void createLog(LogModel lm);
	
	public void removeLog(LogModel lm);
	
	public List<LogModel> getAllLog();
	
	public void updateLog(LogModel lm);

}
