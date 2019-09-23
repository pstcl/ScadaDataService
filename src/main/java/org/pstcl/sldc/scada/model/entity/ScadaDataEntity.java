package org.pstcl.sldc.scada.model.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;



@Data
@Entity
@Table(name="scada_data_repo")
public class ScadaDataEntity {

	public ScadaEntityId getEntityId() {
		return entityId;
	}
	public void setEntityId(ScadaEntityId entityId) {
		this.entityId = entityId;
	}
	@JsonIgnore
	@EmbeddedId
	private ScadaEntityId entityId;
	

	@DateTimeFormat(pattern="yyyy-dd-MM HH:mm:ss")
	private Date dateTimeWrongFormat;
	
	public LocalDateTime getChartDate()
	{
		LocalDateTime chartdate=null;
		if(getDateS()!=null&& getTimeS()!=null)
		{
			chartdate=LocalDateTime.of(getDateS(), getTimeS());
		}
		return chartdate;
	}
	
	@Column(precision=20,scale=2)
	private BigDecimal value;
	
	private String flag;
	
	
	
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
	
	
	public LocalDate getDateS() {
		return this.entityId.getDateS();
	}
	public void setDateS(LocalDate dateS) {
		this.entityId.setDateS(dateS);
	}
	public LocalTime getTimeS() {
		return this.entityId.getTimeS();
	}
	public void setTimeS(LocalTime timeS) {
		this.entityId.setTimeS(timeS);
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
	public Date getDateTimeWrongFormat() {
		return dateTimeWrongFormat;
	}
	public void setDateTimeWrongFormat(Date dateTimeWrongFormat) {
		this.dateTimeWrongFormat = dateTimeWrongFormat;
	}

	
}
