package org.pstcl.sldc.scada.model;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;



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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateS == null) ? 0 : dateS.hashCode());
		result = prime * result + ((ddeItem == null) ? 0 : ddeItem.hashCode());
		result = prime * result + ((pointID == null) ? 0 : pointID.hashCode());
		result = prime * result + ((timeS == null) ? 0 : timeS.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScadaEntityId other = (ScadaEntityId) obj;
		if (dateS == null) {
			if (other.dateS != null)
				return false;
		} else if (!dateS.equals(other.dateS))
			return false;
		if (ddeItem == null) {
			if (other.ddeItem != null)
				return false;
		} else if (!ddeItem.equals(other.ddeItem))
			return false;
		if (pointID == null) {
			if (other.pointID != null)
				return false;
		} else if (!pointID.equals(other.pointID))
			return false;
		if (timeS == null) {
			if (other.timeS != null)
				return false;
		} else if (!timeS.equals(other.timeS))
			return false;
		return true;
	}
	



}
