package cn.imust.pojo;

public class OrderItem {
	private int id;
	private String o_id;
	private int p_id;
	private String m_id;
	private int itemnumber;
	private int s_id;
	
	private Product product;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public String getO_id() {
		return o_id;
	}
	public void setO_id(String o_id) {
		this.o_id = o_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getItemnumber() {
		return itemnumber;
	}
	public void setItemnumber(int itemnumber) {
		this.itemnumber = itemnumber;
	}
	
	
	
	public OrderItem(int id, String o_id, int p_id, String m_id, int itemnumber, int s_id, Product product) {
		super();
		this.id = id;
		this.o_id = o_id;
		this.p_id = p_id;
		this.m_id = m_id;
		this.itemnumber = itemnumber;
		this.s_id = s_id;
		this.product = product;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
