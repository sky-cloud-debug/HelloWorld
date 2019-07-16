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
 * 类名: City<BR>
 * 描述: 城市类<BR>
 * 创建人:毕燕东 <BR>
 * 时间：2017年8月12日 <BR>
 * @version 1.0
 */
@Entity
@Table(name="irri_city")
public class City {
/**id*/
private Integer id;
/**市级名字*/
private String cityName;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

@Column(name = "city_name", length = 50)
public String getCityName() {
	return cityName;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
}


@Override
public String toString() {
	return "City [id=" + id + ", cityName=" + cityName  + "]";
}





}
