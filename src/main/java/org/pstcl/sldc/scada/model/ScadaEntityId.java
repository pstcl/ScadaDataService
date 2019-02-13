package org.pstcl.sldc.scada.model;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;



public class ScadaEntityId implements Serializable{


	private LocalDate dateS;
	private String ddeItem;

	private String pointID;
	private Time timeS;
	
	public LocalDate getDateS() {
		return dateS;
	}
	public String getDdeItem() {
		return ddeItem;
	}
	public String getPointID() {
		return pointID;
	}
	public Time getTimeS() {
		return timeS;
	}
	

	public void setDateS(LocalDate dateS) {
		this.dateS = dateS;
	}
	public void setDdeItem(String ddeItem) {
		this.ddeItem = ddeItem;
	}
	public void setPointID(String pointsID) {
		this.pointID = pointsID;
	}
	public void setTimeS(Time timeS) {
		this.timeS = timeS;
	}
	



}
