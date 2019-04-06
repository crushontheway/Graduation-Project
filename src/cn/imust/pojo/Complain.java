package cn.imust.pojo;

import java.sql.Timestamp;


public class Complain {
	private int id;
	private String m_id;
	private String content;
	private Timestamp commitDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public Timestamp getCommitDate() {
		return commitDate;
	}
	public void setCommitDate(Timestamp commitDate) {
		this.commitDate = commitDate;
	}
	
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public Complain(int id, String m_id, String content, Timestamp commitDate) {
		super();
		this.id = id;
		this.m_id = m_id;
		this.content = content;
		this.commitDate = commitDate;
	}
	public Complain() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
