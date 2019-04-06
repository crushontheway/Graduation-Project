package cn.imust.pojo;

public class Coupon {
	private int id;
	private int s_id;
	private double reducePrice;
	private double limitPrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public double getReducePrice() {
		return reducePrice;
	}
	public void setReducePrice(double reducePrice) {
		this.reducePrice = reducePrice;
	}
	public double getLimitPrice() {
		return limitPrice;
	}
	public void setLimitPrice(double limitPrice) {
		this.limitPrice = limitPrice;
	}
	public Coupon(int id, int s_id, double reducePrice, double limitPrice) {
		super();
		this.id = id;
		this.s_id = s_id;
		this.reducePrice = reducePrice;
		this.limitPrice = limitPrice;
	}
	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
