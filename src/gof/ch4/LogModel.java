package gof.ch4;

public class LogModel implements java.io.Serializable{
	

	/** 
	 * @Fields serialVersionUID : TODO〈一句话功能简述〉
	 */
	private static final long serialVersionUID = 2464756468701719753L;

	private String logId;
	
	private String operateUser;
	
	private String operateTime;
	
	private String logContent;
	
	
	

	@Override
	public String toString() {
		return "LogModel [logId=" + logId + ", operateUser=" + operateUser + ", operateTime=" + operateTime
				+ ", logContent=" + logContent + "]";
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getOperateUser() {
		return operateUser;
	}

	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	
	
	

}
