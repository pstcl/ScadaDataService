package org.pstcl.sldc.scada.model;

import java.util.HashMap;
import java.util.List;
public class ScadaDataHolder {
	
	private List<ScadaDataEntity> dataEntities;
	private HashMap<String, ScadaDataEntity> scadaMap;
	
	public List<ScadaDataEntity> getDataEntities() {
		return dataEntities;
	}
	public void setDataEntities(List<ScadaDataEntity> dataEntities) {
		this.dataEntities = dataEntities;
	}
	public HashMap<String, ScadaDataEntity> getScadaMap() {
		return scadaMap;
	}
	public void setScadaMap(HashMap<String, ScadaDataEntity> scadaMap) {
		this.scadaMap = scadaMap;
	}

	

}
