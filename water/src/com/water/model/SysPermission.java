package com.water.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 类名: SysPermission<BR>
 * 描述: 系统权限<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月21日-下午4:51:34 <BR>
 * @version 1.0
 */
@Entity
@Table(name="sys_permission")
public class SysPermission {

	private Integer id;
	private String permissionName;
	private String url;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="permission_name",length=50)
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	@Column(name="url",length=100)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
