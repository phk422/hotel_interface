package com.school.hotel.pojo.vo;


import java.util.Date;

/**
 * 入住界面视图
 */
public class CheckinVo {
	private Long id;//入住id
	private String roomSn; // 房间编号
	private String roomType;//房型
	private Float checkinPrice;//入住价格
	private String name;//入住者姓名
	private String idCard;//身份证号码
	private String mobile;//手机号
	private int status;//状态：0：入住中，1：已结算离店
	private String arriveDate;//入住日期
	private String leaveDate;//离店日期
	private Date createTime;//创建时间
	private Long bookOrderId;//预定订单id，可为空
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomSn() {
		return roomSn;
	}

	public void setRoomSn(String roomSn) {
		this.roomSn = roomSn;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Float getCheckinPrice() {
		return checkinPrice;
	}

	public void setCheckinPrice(Float checkinPrice) {
		this.checkinPrice = checkinPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}

	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getBookOrderId() {
		return bookOrderId;
	}

	public void setBookOrderId(Long bookOrderId) {
		this.bookOrderId = bookOrderId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
