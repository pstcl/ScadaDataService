package org.pstcl.sldc.scada.model.entity;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
//COMPOSITE KEY FOR ENTITY


public class ScadaEntityId implements Serializable{


	private LocalDate dateS;
	private String ddeItem;

	private String pointID;
	private LocalTime timeS;
	
	public LocalDate getDateS() {
		return dateS;
	}
	public String getDdeItem() {
		return ddeItem;
	}
	public String getPointID() {
		return pointID;
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
	public LocalTime getTimeS() {
		return timeS;
	}
	public void setTimeS(LocalTime timeS) {
		this.timeS = timeS;
	}
	



}
