package org.pstcl.sldc.scada.model;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Deprecated
//@Data
//@Entity
//@Table(name="ScadaData1")
public class ScadaEntity {

	@Override
	public String toString() {
		return "ScadaEntity [id=" + id + ", ddeItem=" + ddeItem + ", pointsID=" + pointsID + ", dateTimeLocal="
				+ dateTimeLocal + ", dateS=" + dateS + ", timeS=" + timeS + ", value=" + value + ", flag=" + flag + "]";
	}
	@Id @GeneratedValue
	private  long id;
	private String ddeItem;
	private String pointsID;
	private Date dateTimeLocal;
	private Date dateS;
	private Time timeS;
	@Column(precision=20,scale=10)
	private BigDecimal value;
	private String flag;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDdeItem() {
		return ddeItem;
	}
	public void setDdeItem(String ddeItem) {
		this.ddeItem = ddeItem;
	}
	public String getPointsID() {
		return pointsID;
	}
	public void setPointsID(String pointsID) {
		this.pointsID = pointsID;
	}
	public Date getDateTimeLocal() {
		return dateTimeLocal;
	}
	public void setDateTimeLocal(Date dateTimeLocal) {
		this.dateTimeLocal = dateTimeLocal;
	}
	public Date getDateS() {
		return dateS;
	}
	public void setDateS(Date dateS) {
		this.dateS = dateS;
	}
	public Time getTimeS() {
		return timeS;
	}
	public void setTimeS(Time timeS) {
		this.timeS = timeS;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	
}
