package com.water.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/**
 * 
 * 类名: SysRole<BR>
 * 描述:系统角色 <BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月21日-下午4:51:47 <BR>
 * @version 1.0
 */
@Entity
@Table(name="sys_role")
public class SysRole {
	private Integer id;
	private String roleName;
	
	private List<SysPermission> permissions;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="role_name",length=50)
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@ManyToMany
	@JoinTable(name="sys_role_permission",joinColumns={@JoinColumn(name="role_id",referencedColumnName="id"),@JoinColumn(name="permission_id",referencedColumnName="id")})
	public List<SysPermission> getPermissions() {
		return permissions;
	}
	
	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}
}
