package com.water.model;

import java.util.Date;

import javax.persistence.Entity;
public class ForeShow {
private double ET0pre;
private double KCpre;
private double Ipre;
private double soilHumipre;
private Date date;
public double getET0pre() {
	return ET0pre;
}
public void setET0pre(double eT0pre) {
	ET0pre = eT0pre;
}
public double getKCpre() {
	return KCpre;
}
public void setKCpre(double kCpre) {
	KCpre = kCpre;
}
public double getIpre() {
	return Ipre;
}
public void setIpre(double ipre) {
	Ipre = ipre;
}
public double getSoilHumipre() {
	return soilHumipre;
}
public void setSoilHumipre(double soilHumipre) {
	this.soilHumipre = soilHumipre;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
}
