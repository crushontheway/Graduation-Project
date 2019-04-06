package cn.imust.pojo;

import java.sql.Timestamp;

public class OrderList {
	private String id;
	private String m_id;
	private String message;
	private Timestamp createDate;
	private Timestamp payDate;
	private Timestamp deliveryDate;
	private Timestamp comfirmDate;
	private int orderstatus;
	
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getPayDate() {
		return payDate;
	}
	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}
	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Timestamp getComfirmDate() {
		return comfirmDate;
	}
	public void setComfirmDate(Timestamp comfirmDate) {
		this.comfirmDate = comfirmDate;
	}
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public OrderList(String id, String m_id, String message, Timestamp createDate, Timestamp payDate,
			Timestamp deliveryDate, Timestamp comfirmDate, int orderstatus) {
		super();
		this.id = id;
		this.m_id = m_id;
		this.message = message;
		this.createDate = createDate;
		this.payDate = payDate;
		this.deliveryDate = deliveryDate;
		this.comfirmDate = comfirmDate;
		this.orderstatus = orderstatus;
	}
	public OrderList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
