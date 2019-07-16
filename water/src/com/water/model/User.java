package com.water.model;

import java.io.Serializable;
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
 * 类名: User<BR>
 * 描述: 用户实体类<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月12日-下午7:05:39 <BR>
 * 
 * @version 1.0
 */
@Entity
@Table(name = "irri_user")
public class User implements Serializable{
	/** id */
	private Integer id;
	/** 用户名 */
	private String username;
	/** 密码 */
	private String password;
	/** 电话号码 */
	private String telephone;
	/** 邮箱 */
	private String email;
	/**角色*/
	private List<SysRole> roles;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "telephone", length = 50)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

	@ManyToMany(targetEntity=SysRole.class)
	@JoinTable(name="sys_user_role",joinColumns={@JoinColumn(name="user_id",referencedColumnName="id"),@JoinColumn(name="role_id",referencedColumnName="id")})
	public List<SysRole> getRoles() {
		return roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", telephone=" + telephone + ", email=" + email
				+ "]";
	}
}
