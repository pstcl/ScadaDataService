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
	private Environment environment;

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

	@Value("${parameter.htp1}")
	private String htp1ParameterName;
	@Value("${parameter.htp2}")
	private String htp2ParameterName;
	@Value("${parameter.htp3}")
	private String htp3ParameterName;
	@Value("${parameter.htp4}")
	private String htp4ParameterName;
	@Value("${paramter.haryana_sch}")
	private String haryana_schParameterName;
	@Value("${paramter.haryana_drwl}")
	private String haryana_drwlParameterName;
	@Value("${parameter.haryana_odud}")
	private String haryana_odudParameterName;
	@Value("${parameter.haryana_load}")
	private String haryana_loadParameterName;
	@Value("${parameter.gvk1}")
	private String gvk1ParameterName;
	@Value("${parameter.gvk2}")
	private String gvk2ParameterName;
	@Value("${parameter.raj_sch")
	private String raj_schParameterName;
	@Value("${parameter.raj_drwl")
	private String raj_drwlParameterName;
	@Value("${parameter.raj_odud")
	private String raj_odudParameterName;
	@Value("${parameter.raj_load")
	private String raj_loadParameterName;
	@Value("${parameter.delhi_sch")
	private String delhi_schParameterName;
	@Value("${parameter.delhi_drwl")
	private String delhi_drwlParameterName;
	@Value("${parameter.delhi_odud")
	private String delhi_odudParameterName;
	@Value("${parameter.delhi_load")
	private String delhi_loadParameterName;
	@Value("${parameter.up_sch")
	private String up_schParameterName;
	@Value("${parameter.up_drwl")
	private String up_drwlParameterName;
	@Value("${parameter.up_odud")
	private String up_odudParameterName;
	@Value("${parameter.up_load")
	private String up_loadParameterName;
	@Value("${parameter.uk_sch")
	private String uk_schParameterName;
	@Value("${parameter.uk_drwl")
	private String uk_drwlParameterName;
	@Value("${parameter.uk_odud")
	private String uk_odudParameterName;
	@Value("${parameter.uk_load")
	private String uk_loadParameterName;
	@Value("${parameter.chd_sch")
	private String chd_schParameterName;
	@Value("${parameter.chd_drwl")
	private String chd_drwlParameterName;
	@Value("${parameter.chd_odud")
	private String chd_odudParameterName;
	@Value("${parameter.hp_sch")
	private String hp_schParameterName;
	@Value("${parameter.hp_drwl")
	private String hp_drwlParameterName;
	@Value("${parameter.hp_odud")
	private String hp_odudParameterName;
	@Value("${parameter.hp_load")
	private String hp_loadParameterName;
	@Value("${parameter.jk_sch")
	private String jk_schParameterName;
	@Value("${parameter.jk_drwl")
	private String jk_drwlParameterName;
	@Value("${parameter.jk_odud")
	private String jk_odudParameterName;
	@Value("${parameter.jk_load")
	private String jk_loadParameterName;
	@Value("${parameter.npl1")
	private String npl1ParameterName;
	@Value("${parameter.npl2")
	private String npl2ParameterName;
	@Value("${parameter.tldtp1")
	private String tldtp1ParameterName;
	@Value("${parameter.tldtp2")
	private String tldtp2ParameterName;
	@Value("${parameter.tldtp3")
	private String tldtp3ParameterName;

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

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public String getHtp1ParameterName() {
		return htp1ParameterName;
	}

	public void setHtp1ParameterName(String htp1ParameterName) {
		this.htp1ParameterName = htp1ParameterName;
	}

	public String getHtp2ParameterName() {
		return htp2ParameterName;
	}

	public void setHtp2ParameterName(String htp2ParameterName) {
		this.htp2ParameterName = htp2ParameterName;
	}

	public String getHtp3ParameterName() {
		return htp3ParameterName;
	}

	public void setHtp3ParameterName(String htp3ParameterName) {
		this.htp3ParameterName = htp3ParameterName;
	}

	public String getHtp4ParameterName() {
		return htp4ParameterName;
	}

	public void setHtp4ParameterName(String htp4ParameterName) {
		this.htp4ParameterName = htp4ParameterName;
	}

	public String getHaryana_schParameterName() {
		return haryana_schParameterName;
	}

	public void setHaryana_schParameterName(String haryana_schParameterName) {
		this.haryana_schParameterName = haryana_schParameterName;
	}

	public String getHaryana_drwlParameterName() {
		return haryana_drwlParameterName;
	}

	public void setHaryana_drwlParameterName(String haryana_drwlParameterName) {
		this.haryana_drwlParameterName = haryana_drwlParameterName;
	}

	public String getHaryana_odudParameterName() {
		return haryana_odudParameterName;
	}

	public void setHaryana_odudParameterName(String haryana_odudParameterName) {
		this.haryana_odudParameterName = haryana_odudParameterName;
	}

	public String getHaryana_loadParameterName() {
		return haryana_loadParameterName;
	}

	public void setHaryana_loadParameterName(String haryana_loadParameterName) {
		this.haryana_loadParameterName = haryana_loadParameterName;
	}

	public String getGvk1ParameterName() {
		return gvk1ParameterName;
	}

	public void setGvk1ParameterName(String gvk1ParameterName) {
		this.gvk1ParameterName = gvk1ParameterName;
	}

	public String getGvk2ParameterName() {
		return gvk2ParameterName;
	}

	public void setGvk2ParameterName(String gvk2ParameterName) {
		this.gvk2ParameterName = gvk2ParameterName;
	}

	public String getRaj_schParameterName() {
		return raj_schParameterName;
	}

	public void setRaj_schParameterName(String raj_schParameterName) {
		this.raj_schParameterName = raj_schParameterName;
	}

	public String getRaj_drwlParameterName() {
		return raj_drwlParameterName;
	}

	public void setRaj_drwlParameterName(String raj_drwlParameterName) {
		this.raj_drwlParameterName = raj_drwlParameterName;
	}

	public String getRaj_odudParameterName() {
		return raj_odudParameterName;
	}

	public void setRaj_odudParameterName(String raj_odudParameterName) {
		this.raj_odudParameterName = raj_odudParameterName;
	}

	public String getRaj_loadParameterName() {
		return raj_loadParameterName;
	}

	public void setRaj_loadParameterName(String raj_loadParameterName) {
		this.raj_loadParameterName = raj_loadParameterName;
	}

	public String getDelhi_schParameterName() {
		return delhi_schParameterName;
	}

	public void setDelhi_schParameterName(String delhi_schParameterName) {
		this.delhi_schParameterName = delhi_schParameterName;
	}

	public String getDelhi_drwlParameterName() {
		return delhi_drwlParameterName;
	}

	public void setDelhi_drwlParameterName(String delhi_drwlParameterName) {
		this.delhi_drwlParameterName = delhi_drwlParameterName;
	}

	public String getDelhi_odudParameterName() {
		return delhi_odudParameterName;
	}

	public void setDelhi_odudParameterName(String delhi_odudParameterName) {
		this.delhi_odudParameterName = delhi_odudParameterName;
	}

	public String getDelhi_loadParameterName() {
		return delhi_loadParameterName;
	}

	public void setDelhi_loadParameterName(String delhi_loadParameterName) {
		this.delhi_loadParameterName = delhi_loadParameterName;
	}

	public String getUp_schParameterName() {
		return up_schParameterName;
	}

	public void setUp_schParameterName(String up_schParameterName) {
		this.up_schParameterName = up_schParameterName;
	}

	public String getUp_drwlParameterName() {
		return up_drwlParameterName;
	}

	public void setUp_drwlParameterName(String up_drwlParameterName) {
		this.up_drwlParameterName = up_drwlParameterName;
	}

	public String getUp_odudParameterName() {
		return up_odudParameterName;
	}

	public void setUp_odudParameterName(String up_odudParameterName) {
		this.up_odudParameterName = up_odudParameterName;
	}

	public String getUp_loadParameterName() {
		return up_loadParameterName;
	}

	public void setUp_loadParameterName(String up_loadParameterName) {
		this.up_loadParameterName = up_loadParameterName;
	}

	public String getUk_schParameterName() {
		return uk_schParameterName;
	}

	public void setUk_schParameterName(String uk_schParameterName) {
		this.uk_schParameterName = uk_schParameterName;
	}

	public String getUk_drwlParameterName() {
		return uk_drwlParameterName;
	}

	public void setUk_drwlParameterName(String uk_drwlParameterName) {
		this.uk_drwlParameterName = uk_drwlParameterName;
	}

	public String getUk_odudParameterName() {
		return uk_odudParameterName;
	}

	public void setUk_odudParameterName(String uk_odudParameterName) {
		this.uk_odudParameterName = uk_odudParameterName;
	}

	public String getUk_loadParameterName() {
		return uk_loadParameterName;
	}

	public void setUk_loadParameterName(String uk_loadParameterName) {
		this.uk_loadParameterName = uk_loadParameterName;
	}

	public String getChd_schParameterName() {
		return chd_schParameterName;
	}

	public void setChd_schParameterName(String chd_schParameterName) {
		this.chd_schParameterName = chd_schParameterName;
	}

	public String getChd_drwlParameterName() {
		return chd_drwlParameterName;
	}

	public void setChd_drwlParameterName(String chd_drwlParameterName) {
		this.chd_drwlParameterName = chd_drwlParameterName;
	}

	public String getChd_odudParameterName() {
		return chd_odudParameterName;
	}

	public void setChd_odudParameterName(String chd_odudParameterName) {
		this.chd_odudParameterName = chd_odudParameterName;
	}

	public String getHp_schParameterName() {
		return hp_schParameterName;
	}

	public void setHp_schParameterName(String hp_schParameterName) {
		this.hp_schParameterName = hp_schParameterName;
	}

	public String getHp_drwlParameterName() {
		return hp_drwlParameterName;
	}

	public void setHp_drwlParameterName(String hp_drwlParameterName) {
		this.hp_drwlParameterName = hp_drwlParameterName;
	}

	public String getHp_odudParameterName() {
		return hp_odudParameterName;
	}

	public void setHp_odudParameterName(String hp_odudParameterName) {
		this.hp_odudParameterName = hp_odudParameterName;
	}

	public String getHp_loadParameterName() {
		return hp_loadParameterName;
	}

	public void setHp_loadParameterName(String hp_loadParameterName) {
		this.hp_loadParameterName = hp_loadParameterName;
	}

	public String getJk_schParameterName() {
		return jk_schParameterName;
	}

	public void setJk_schParameterName(String jk_schParameterName) {
		this.jk_schParameterName = jk_schParameterName;
	}

	public String getJk_drwlParameterName() {
		return jk_drwlParameterName;
	}

	public void setJk_drwlParameterName(String jk_drwlParameterName) {
		this.jk_drwlParameterName = jk_drwlParameterName;
	}

	public String getJk_odudParameterName() {
		return jk_odudParameterName;
	}

	public void setJk_odudParameterName(String jk_odudParameterName) {
		this.jk_odudParameterName = jk_odudParameterName;
	}

	public String getJk_loadParameterName() {
		return jk_loadParameterName;
	}

	public void setJk_loadParameterName(String jk_loadParameterName) {
		this.jk_loadParameterName = jk_loadParameterName;
	}

	public String getNpl1ParameterName() {
		return npl1ParameterName;
	}

	public void setNpl1ParameterName(String npl1ParameterName) {
		this.npl1ParameterName = npl1ParameterName;
	}

	public String getNpl2ParameterName() {
		return npl2ParameterName;
	}

	public void setNpl2ParameterName(String npl2ParameterName) {
		this.npl2ParameterName = npl2ParameterName;
	}

	public String getTldtp1ParameterName() {
		return tldtp1ParameterName;
	}

	public void setTldtp1ParameterName(String tldtp1ParameterName) {
		this.tldtp1ParameterName = tldtp1ParameterName;
	}

	public String getTldtp2ParameterName() {
		return tldtp2ParameterName;
	}

	public void setTldtp2ParameterName(String tldtp2ParameterName) {
		this.tldtp2ParameterName = tldtp2ParameterName;
	}

	public String getTldtp3ParameterName() {
		return tldtp3ParameterName;
	}

	public void setTldtp3ParameterName(String tldtp3ParameterName) {
		this.tldtp3ParameterName = tldtp3ParameterName;
	}

}
