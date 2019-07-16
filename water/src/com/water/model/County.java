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
 * 类名: County<BR>
 * 描述: 乡实体类<BR>
 * 创建人:毕燕东 <BR>
 * 时间：2017年8月12日 <BR>
 * @version 1.0
 */
@Entity
@Table(name="irri_county")
public class County {
/**id*/
private Integer id;
/**县级名字*/
private String countyName;
/** 区域 */
private Region region;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

@Column(name = "county_name", length = 50)
public String getCountyName() {
	return countyName;
}
public void setCountyName(String countyName) {
	this.countyName = countyName;
}

@JoinColumn(name = "region_id")
@ManyToOne
public Region getRegion() {
	return region;
}
public void setRegion(Region region) {
	this.region = region;
}

@Override
public String toString() {
	return "County [id=" + id + ", countyName=" + countyName + ", region="
			+ region + "]";
}





}
