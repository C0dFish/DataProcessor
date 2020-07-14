/**
 * 
 */


import java.util.Date;

/**
 * @creat time 2020�?7�?12�? 上午9:12:20
 * @author hao zhang
 * @version 1.0
 * @comment
 */
public class ResultDataVO {
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
	 * 上午到岗时间
	 */
	private Date amOnTime;

	/**
	 * 上路离岗时间
	 */
	private Date amOffTime;

	/**
	 * 下午到岗时间
	 */
	private Date pmOnTime;

	/**
	 * 下午离岗时间
	 */
	private Date pmOffTime;

	/**
	 * 全天在岗时间
	 */
	private String onDutyTime;
	
	/**
	 * 备注
	 */
	private String comment;

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

	public Date getAmOnTime() {
		return amOnTime;
	}

	public void setAmOnTime(Date amOnTime) {
		this.amOnTime = amOnTime;
	}

	public Date getAmOffTime() {
		return amOffTime;
	}

	public void setAmOffTime(Date amOffTime) {
		this.amOffTime = amOffTime;
	}

	public Date getPmOnTime() {
		return pmOnTime;
	}

	public void setPmOnTime(Date pmOnTime) {
		this.pmOnTime = pmOnTime;
	}

	public Date getPmOffTime() {
		return pmOffTime;
	}

	public void setPmOffTime(Date pmOffTime) {
		this.pmOffTime = pmOffTime;
	}

	public String getOnDutyTime() {
		return onDutyTime;
	}

	public void setOnDutyTime(String onDutyTime) {
		this.onDutyTime = onDutyTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
