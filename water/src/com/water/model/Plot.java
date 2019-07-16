package com.water.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * 类名: Plot<BR>
 * 描述: 站点实体类<BR>
 * 创建人:毕燕东 <BR>
 * 时间：2017年8月12日 <BR>
 * @version 1.0
 */
@Entity
@Table(name="irri_plot")
public class Plot {
/**id*/
private Integer id;
/**站点名称*/
private String plotName;
/** 区域 */
private County county;
private String plotId;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

@Column(name = "plot_name", length = 50)
public String getPlotName() {
	return plotName;
}
public void setPlotName(String plotName) {
	this.plotName = plotName;
}

@JoinColumn(name = "county_id")
@ManyToOne
public County getCounty() {
	return county;
}
public void setCounty(County county) {
	this.county = county;
}

@Override
public String toString() {
	return "Plot [id=" + id + ", countyName=" + plotName + ", county="
			+ county + "]";
}
public void setPlotId(String plotId) {
	this.plotId = plotId;
}

@Column(name = "plot_id", length = 50)
public String getPlotId() {
	return plotId;
}







}
