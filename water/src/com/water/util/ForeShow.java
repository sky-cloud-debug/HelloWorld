package com.water.util;

import java.util.Date;

import javax.persistence.Entity;

public class ForeShow {
private double eT0pre;
private double kCpre;
private double ipre;
private double soilHumipre;
private Date date;

public double geteT0pre() {
	return eT0pre;
}
public void seteT0pre(double eT0pre) {
	this.eT0pre = eT0pre;
}
public double getkCpre() {
	return kCpre;
}
public void setkCpre(double kCpre) {
	this.kCpre = kCpre;
}
public double getIpre() {
	return ipre;
}
public void setIpre(double ipre) {
	this.ipre = ipre;
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
