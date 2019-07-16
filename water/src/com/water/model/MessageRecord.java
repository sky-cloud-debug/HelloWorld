package com.water.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 类名: MessageRecord<BR>
 * 描述: <BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年5月29日-上午4:49:39 <BR>
 * @version 1.0
 */
@Entity
@Table(name="irri_message_record")
public class MessageRecord {
	private Integer id;
	private String content;
	private Date createTime;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public MessageRecord(String content, Date createTime) {
		super();
		this.content = content;
		this.createTime = createTime;
	}
	public MessageRecord() {
		super();
	}
	
}
