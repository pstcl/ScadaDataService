package org.pstcl.sldc.scada.model;

import java.time.LocalDateTime;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;



@Data
@Entity
@Table(name="scada_map")
public class ScadaMap {


	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;


	private LocalDateTime excelAccessTime;
	
	public ScadaMap()
	{
		
	}
	
	
	public LocalDateTime getExcelAccessTime() {
		return excelAccessTime;
	}


	public void setExcelAccessTime(LocalDateTime excelAccessTime) {
		this.excelAccessTime = excelAccessTime;
	}


	@CreatedDate
	private LocalDateTime createdDateTime;
	
	@LastModifiedDate
	private LocalDateTime updatedDateTime;
	

	private HashMap<String, ScadaDataEntity> scadaMap;


	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}


	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}


	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}


	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}


	public HashMap<String, ScadaDataEntity> getScadaMap() {
		return scadaMap;
	}


	public void setScadaMap(HashMap<String, ScadaDataEntity> scadaMap) {
		this.scadaMap = scadaMap;
	}

}
