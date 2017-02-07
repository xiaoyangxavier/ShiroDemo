package savy.myhome.vo.outlay;

import java.io.File;
import java.util.Date;

public class Outlay {

	private Integer id;
	private Integer typeId;
	private String typeName;
	private Double amount;
	private String pictureUrl;
	private Integer userId;
	private String userRealName;
	private Date outlayDate;
	private String description;
	private Date operationDate;
	private String operator;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	 
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public Date getOutlayDate() {
		return outlayDate;
	}
	public void setOutlayDate(Date outlayDate) {
		this.outlayDate = outlayDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	@Override
	public String toString() {
		return "Outlay [id=" + id + ", typeId=" + typeId + ", typeName=" + typeName + ", amount=" + amount
				+ ", pictureUrl=" + pictureUrl + ", userId=" + userId + ", userRealName="
				+ userRealName + ", outlayDate=" + outlayDate + ", description=" + description + ", operationDate="
				+ operationDate + ", operator=" + operator + "]";
	}
	
	 
	
	
}
