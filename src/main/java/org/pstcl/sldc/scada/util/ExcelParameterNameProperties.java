package org.pstcl.sldc.scada.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:file.properties")
public class ExcelParameterNameProperties {

	@Autowired
	private  Environment environment;


	@Value("${parameter.frequency}")
	private String frequencyParameterName;
	@Value("${parameter.drawal}")
	private String drawalParameterName;
	@Value("${parameter.schedule}")
	private String scheduleParameterName;
	@Value("${parameter.odud}")
	private String odudParameterName;
	@Value("${parameter.load}")
	private String loadParameterName;
	@Value("${parameter.currentTime}")
	private String currentTimeParameterName;
	public String getFrequencyParameterName() {
		return frequencyParameterName;
	}
	public void setFrequencyParameterName(String frequencyParameterName) {
		this.frequencyParameterName = frequencyParameterName;
	}
	public String getDrawalParameterName() {
		return drawalParameterName;
	}
	public void setDrawalParameterName(String drawalParameterName) {
		this.drawalParameterName = drawalParameterName;
	}
	public String getScheduleParameterName() {
		return scheduleParameterName;
	}
	public void setScheduleParameterName(String scheduleParameterName) {
		this.scheduleParameterName = scheduleParameterName;
	}
	public String getOdudParameterName() {
		return odudParameterName;
	}
	public void setOdudParameterName(String odudParameterName) {
		this.odudParameterName = odudParameterName;
	}
	public String getLoadParameterName() {
		return loadParameterName;
	}
	public void setLoadParameterName(String loadParameterName) {
		this.loadParameterName = loadParameterName;
	}
	public String getCurrentTimeParameterName() {
		return currentTimeParameterName;
	}
	public void setCurrentTimeParameterName(String currentTimeParameterName) {
		this.currentTimeParameterName = currentTimeParameterName;
	}



}
