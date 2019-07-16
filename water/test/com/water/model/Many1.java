package com.water.model;

import java.util.List;

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

@Table(name = "test_many1")
@Entity
public class Many1 {
	private Integer id;
	private String many1Name;
	private List<Many2> many2s;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "many1_name", length = 50)
	public String getMany1Name() {
		return many1Name;
	}

	public void setMany1Name(String many1Name) {
		this.many1Name = many1Name;
	}

	@ManyToMany(mappedBy="many1s")
	public List<Many2> getMany2s() {
		return many2s;
	}

	public void setMany2s(List<Many2> many2s) {
		this.many2s = many2s;
	}

}
