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
 * 类名: Device<BR>
 * 描述: 设备类<BR>
 * 创建人:毕燕东 <BR>
 * 时间：2017年8月12日 <BR>
 * @version 1.0
 */
@Entity
@Table(name="irri_device")
public class Device {
/**id*/
private Integer id;
/**设备名字*/
private String deviceName;
private Plot plot;
private Integer type;//0:代表土壤；1：代表空气
private String unit;
private String decrip;
private String dataId;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

@Column(name = "device_name", length = 50)
public String getDeviceName() {
	return deviceName;
}
public void setDeviceName(String deviceName) {
	this.deviceName = deviceName;
}


@Column(name = "type", length = 50)
public Integer getType() {
	return type;
}
public void setType(Integer type) {
	this.type = type;
}


@Column(name = "unit", length = 50)
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
@Column(name = "data_id", length = 50)
public String getDataId() {
	return dataId;
}
public void setDataId(String dataId) {
	this.dataId = dataId;
}
@Column(name = "descrip", length = 50)
public String getDecrip() {
	return decrip;
}
public void setDecrip(String decrip) {
	this.decrip = decrip;
}
@JoinColumn(name = "plot_id")
@ManyToOne
public Plot getPlot() {
	return plot;
}
public void setPlot(Plot plot) {
	this.plot = plot;
}


@Override
public String toString() {
	return "Device [id=" + id + ", deviceName=" + deviceName + ", plot=" + plot
			+ ", type=" + type + ", unit=" + unit + ", decrip=" + decrip
			+ ", dataId=" + dataId + "]";
}




}
