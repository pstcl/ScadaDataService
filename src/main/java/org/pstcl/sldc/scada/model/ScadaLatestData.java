package org.pstcl.sldc.scada.model;

public class ScadaLatestData {
	private ScadaDataEntity frequency;
	private ScadaDataEntity drawal;
	private ScadaDataEntity schedule;
	private ScadaDataEntity odud;
	private ScadaDataEntity load;
	private ScadaDataEntity currentTime;
	public ScadaDataEntity getFrequency() {
		return frequency;
	}
	public void setFrequency(ScadaDataEntity frequency) {
		this.frequency = frequency;
	}
	public ScadaDataEntity getDrawal() {
		return drawal;
	}
	public void setDrawal(ScadaDataEntity drawal) {
		this.drawal = drawal;
	}
	public ScadaDataEntity getSchedule() {
		return schedule;
	}
	public void setSchedule(ScadaDataEntity schedule) {
		this.schedule = schedule;
	}
	public ScadaDataEntity getOdud() {
		return odud;
	}
	public void setOdud(ScadaDataEntity odud) {
		this.odud = odud;
	}
	public ScadaDataEntity getLoad() {
		return load;
	}
	public void setLoad(ScadaDataEntity load) {
		this.load = load;
	}
	public ScadaDataEntity getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(ScadaDataEntity currentTime) {
		this.currentTime = currentTime;
	}
	
}
