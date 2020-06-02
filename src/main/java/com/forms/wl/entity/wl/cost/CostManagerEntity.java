package com.forms.wl.entity.wl.cost;

import com.forms.wl.entity.PageBean;

public class CostManagerEntity extends PageBean{
	
	private String costId = null;
	private String costType = null;
	private String costTypeContent = null;
	private String costNum = null;
	private String costContent = null;
	private String costDate = null;
	private String costUser = null;
	private String addUser = null;
	private String addDate = null;
	private String addTime = null;
	private String smallType = null;
	private String smallTypeContent = null;
	
	public String getCostId() {
		return costId;
	}
	public void setCostId(String costId) {
		this.costId = costId;
	}
	public String getCostType() {
		return costType;
	}
	public void setCostType(String costType) {
		this.costType = costType;
	}
	public String getCostNum() {
		return costNum;
	}
	public void setCostNum(String costNum) {
		this.costNum = costNum;
	}
	public String getCostContent() {
		return costContent;
	}
	public void setCostContent(String costContent) {
		this.costContent = costContent;
	}
	public String getCostDate() {
		return costDate;
	}
	public void setCostDate(String costDate) {
		this.costDate = costDate;
	}
	public String getCostUser() {
		return costUser;
	}
	public void setCostUser(String costUser) {
		this.costUser = costUser;
	}
	public String getAddUser() {
		return addUser;
	}
	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getSmallType() {
		return smallType;
	}
	public void setSmallType(String smallType) {
		this.smallType = smallType;
	}
	public String getCostTypeContent() {
		return costTypeContent;
	}
	public void setCostTypeContent(String costTypeContent) {
		this.costTypeContent = costTypeContent;
	}
	public String getSmallTypeContent() {
		return smallTypeContent;
	}
	public void setSmallTypeContent(String smallTypeContent) {
		this.smallTypeContent = smallTypeContent;
	}
	
	@Override
	public String toString() {
		return "CostManagerEntity [costId=" + costId + ", costType=" + costType + ", costNum=" + costNum
				+ ", costContent=" + costContent + ", costDate=" + costDate + ", costUser=" + costUser + ", addUser="
				+ addUser + ", addDate=" + addDate + ", addTime=" + addTime + "]";
	}
	
}
