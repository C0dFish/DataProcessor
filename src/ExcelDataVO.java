/**
 * 
 */


import java.util.Date;

/**
 * @creat time 2020�?7�?12�? 上午8:08:25
 * @author hao zhang
 * @version 1.0
 * @comment
 */
public class ExcelDataVO {

	/**
	 * 记录编号
	 */
	private String recordId;

	/**
	 * 时间
	 */
	private Date time;

	/**
	 * 设备名称
	 */
	private String deviceId;

	/**
	 * 事件�?
	 */
	private String place;

	/**
	 * 事件描述
	 */
	private String action;

	/**
	 * 人员编号
	 */
	private String userId;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 卡号
	 */
	private String cardId;

	/**
	 * 部门名称
	 */
	private String department;

	/**
	 * 读头名称
	 */
	private String readHeadName;

	/**
	 * 验证方式
	 */
	private String verifyType;

	/**
	 * 区域名称
	 */
	private String area;

	/**
	 * 备注
	 */
	private String comment;

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getReadHeadName() {
		return readHeadName;
	}

	public void setReadHeadName(String readHeadName) {
		this.readHeadName = readHeadName;
	}

	public String getVerifyType() {
		return verifyType;
	}

	public void setVerifyType(String verifyType) {
		this.verifyType = verifyType;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
