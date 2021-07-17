package com.opolo.hsbctest.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityGeoData {
	
	private String cod;
	private BigDecimal calctime;
	private BigDecimal cnt;
	private List<CityModel> list;
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public BigDecimal getCalctime() {
		return calctime;
	}
	public void setCalctime(BigDecimal calctime) {
		this.calctime = calctime;
	}
	public BigDecimal getCnt() {
		return cnt;
	}
	public void setCnt(BigDecimal cnt) {
		this.cnt = cnt;
	}
	public List<CityModel> getList() {
		return list;
	}
	public void setList(List<CityModel> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "CityGeoData [cod=" + cod + ", calctime=" + calctime + ", cnt=" + cnt + ", list=" + list + "]";
	}
	
	
}
