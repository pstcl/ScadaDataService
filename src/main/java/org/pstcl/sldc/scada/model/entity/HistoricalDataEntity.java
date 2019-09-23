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
@Table(name="scada_historical_data")
public class HistoricalDataEntity {

	@DateTimeFormat(pattern="yyyy-dd-MM HH:mm:ss")
	private Date dateTimeWrongFormat;
	@JsonIgnore
	@EmbeddedId
	private ScadaEntityId entityId;
	private String flag;


	@Column(precision=20,scale=2)
	private BigDecimal value;

	public HistoricalDataEntity()
	{

	}

	public HistoricalDataEntity(ScadaDataEntity scadaDataEntity) {
		super();
		this.entityId=scadaDataEntity.getEntityId();
		this.value=scadaDataEntity.getValue();
		this.dateTimeWrongFormat=scadaDataEntity.getDateTimeWrongFormat();
		this.flag=scadaDataEntity.getFlag();
	}

	public LocalDateTime getChartDate()
	{
		LocalDateTime chartdate=null;
		if(getDateS()!=null&& getTimeS()!=null)
		{
			chartdate=LocalDateTime.of(getDateS(), getTimeS());
		}
		return chartdate;
	}


	public LocalDate getDateS() {
		return this.entityId.getDateS();
	}
	public Date getDateTimeWrongFormat() {
		return dateTimeWrongFormat;
	}
	public String getDdeItem() {
		return entityId.getDdeItem();
	}
	public ScadaEntityId getEntityId() {
		return entityId;
	}
	public String getFlag() {
		return flag;
	}
	public String getPointID() {
		return entityId.getPointID();
	}


	public LocalTime getTimeS() {
		return this.entityId.getTimeS();
	}
	public BigDecimal getValue() {
		return value.setScale(2,RoundingMode.HALF_UP);

	}
	public void setDateS(LocalDate dateS) {
		this.entityId.setDateS(dateS);
	}
	public void setDateTimeWrongFormat(Date dateTimeWrongFormat) {
		this.dateTimeWrongFormat = dateTimeWrongFormat;
	}

	public void setDdeItem(String ddeItem) {
		entityId.setDdeItem(ddeItem);
	}
	public void setEntityId(ScadaEntityId entityId) {
		this.entityId = entityId;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public void setPointID(String pointsID) {
		entityId.setPointID(pointsID);
	}
	public void setTimeS(LocalTime timeS) {
		this.entityId.setTimeS(timeS);
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}


}
