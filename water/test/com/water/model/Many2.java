package com.water.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "test_many2")
@Entity
public class Many2 {
	private Integer id;
	private String many2Name;
	private List<Many1> many1s;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "many2_name", length = 50)
	public String getMany2Name() {
		return many2Name;
	}

	public void setMany2Name(String many2Name) {
		this.many2Name = many2Name;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "test_many1_many2", joinColumns = { @JoinColumn(name = "many2_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "many1_id") })
	public List<Many1> getMany1s() {
		return many1s;
	}

	public void setMany1s(List<Many1> many1s) {
		this.many1s = many1s;
	}

}
