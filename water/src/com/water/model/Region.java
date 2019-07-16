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
 * 类名: Region<BR>
 * 描述: 区域实体类<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月12日-下午7:14:40 <BR>
 * @version 1.0
 */
@Entity
@Table(name="irri_region")
public class Region {
	/**id*/
	private Integer id;
	/**区域名字*/
	private String regionName;
	/**城市*/
	private String city;
	/**村镇*/
	private String town;
	/**创建时间*/
	private Date createTime;
	/**经度*/
	private String latitude;
	/**纬度*/
	private String longitude;
	/**高程*/
	private String altitude;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="city",length=30)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="town",length=30)
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name="latitude",length=10)
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	@Column(name="longitude",length=10)
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	@Column(name="altitude",length=10)
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	@Column(name="region_name")
	public String getRegionName() {
		return regionName;
	}
}
