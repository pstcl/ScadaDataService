package org.pstcl.sldc.scada.model;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;



@Data
@Entity
@Table(name = "scadadata4")
public class ScadaDataEntity {

	@JsonIgnore
	@EmbeddedId
	 ScadaEntityId entityId;
	
    LocalDate dateS;
	Time timeS;
	@Column(precision=20,scale=10)
	BigDecimal value;
	String flag;
	
	
	
	public ScadaDataEntity() {
		super();
		this.entityId=new ScadaEntityId();
	}
	public String getDdeItem() {
		return entityId.getDdeItem();
	}
	public void setDdeItem(String ddeItem) {
		entityId.setDdeItem(ddeItem);
	}
	public String getPointID() {
		return entityId.getPointID();
	}
	public void setPointID(String pointsID) {
		entityId.setPointID(pointsID);
	}
	public String getDateTimeLocal() {
		return entityId.getDateTimeLocal();
	}
	
	public LocalDate getDateS() {
		return dateS;
	}
	public void setDateS(LocalDate localDate) {
		this.dateS = localDate;
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
	public void setDateTimeLocal(String s) {
		// TODO Auto-generated method stub
		entityId.setDateTimeLocal(s);
	}

	
}
