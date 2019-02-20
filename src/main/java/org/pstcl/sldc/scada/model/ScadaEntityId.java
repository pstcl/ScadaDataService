package org.pstcl.sldc.scada.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;


public class ScadaEntityId implements Serializable{

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTimeLocal == null) ? 0 : dateTimeLocal.hashCode());
		result = prime * result + ((ddeItem == null) ? 0 : ddeItem.hashCode());
		result = prime * result + ((pointID == null) ? 0 : pointID.hashCode());
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
		if (dateTimeLocal == null) {
			if (other.dateTimeLocal != null)
				return false;
		} else if (!dateTimeLocal.equals(other.dateTimeLocal))
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
		return true;
	}
	private String ddeItem;
	private String pointID;
	
	private Date dateTimeLocal;
	public String getDdeItem() {
		return ddeItem;
	}
	public void setDdeItem(String ddeItem) {
		this.ddeItem = ddeItem;
	}
	public String getPointID() {
		return pointID;
	}
	public void setPointID(String pointsID) {
		this.pointID = pointsID;
	}
	public Date getDateTimeLocal() {
		return dateTimeLocal;
	}
	public void setDateTimeLocal(Date dateTimeLocal) {
		this.dateTimeLocal = dateTimeLocal;
	}
	
	
		
}
