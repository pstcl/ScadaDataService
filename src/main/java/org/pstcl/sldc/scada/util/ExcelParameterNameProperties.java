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

	@Value("${parameter.frequency}")	private String frequencyParameterName;
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
	@Value("${parameter.raj_sch}")
	private String raj_schParameterName;
	@Value("${parameter.raj_drwl}")
	private String raj_drwlParameterName;
	@Value("${parameter.raj_odud}")
	private String raj_odudParameterName;
	@Value("${parameter.raj_load}")
	private String raj_loadParameterName;
	@Value("${parameter.delhi_sch}")
	private String delhi_schParameterName;
	@Value("${parameter.delhi_drwl}")
	private String delhi_drwlParameterName;
	@Value("${parameter.delhi_odud}")
	private String delhi_odudParameterName;
	@Value("${parameter.delhi_load}")
	private String delhi_loadParameterName;
	@Value("${parameter.up_sch}")
	private String up_schParameterName;
	@Value("${parameter.up_drwl}")
	private String up_drwlParameterName;
	@Value("${parameter.up_odud}")
	private String up_odudParameterName;
	@Value("${parameter.up_load}")
	private String up_loadParameterName;
	@Value("${parameter.uk_sch}")
	private String uk_schParameterName;
	@Value("${parameter.uk_drwl}")
	private String uk_drwlParameterName;
	@Value("${parameter.uk_odud}")
	private String uk_odudParameterName;
	@Value("${parameter.uk_load}")
	private String uk_loadParameterName;
	@Value("${parameter.chd_sch}")
	private String chd_schParameterName;
	@Value("${parameter.chd_drwl}")
	private String chd_drwlParameterName;
	@Value("${parameter.chd_odud}")
	private String chd_odudParameterName;
	@Value("${parameter.hp_sch}")
	private String hp_schParameterName;
	@Value("${parameter.hp_drwl}")
	private String hp_drwlParameterName;
	@Value("${parameter.hp_odud}")
	private String hp_odudParameterName;
	@Value("${parameter.hp_load}")
	private String hp_loadParameterName;
	@Value("${parameter.jk_sch}")
	private String jk_schParameterName;
	@Value("${parameter.jk_drwl}")
	private String jk_drwlParameterName;
	@Value("${parameter.jk_odud}")
	private String jk_odudParameterName;
	@Value("${parameter.jk_load}")
	private String jk_loadParameterName;

	@Value("${parameter.ashp1}")	private String 		ashp1ParameterName	;
	@Value("${parameter.ashp2}")	private String 		ashp2ParameterName	;
	@Value("${parameter.ggsstp1}")	private String 		ggsstp1ParameterName	;
	@Value("${parameter.ggsstp2}")	private String 		ggsstp2ParameterName	;
	@Value("${parameter.ggsstp3}")	private String 		ggsstp3ParameterName	;
	@Value("${parameter.ggsstp4}")	private String 		ggsstp4ParameterName	;
	@Value("${parameter.ggsstp5}")	private String 		ggsstp5ParameterName	;
	@Value("${parameter.ggsstp6}")	private String 		ggsstp6ParameterName	;
	@Value("${parameter.ghtp1}")	private String 		ghtp1ParameterName	;
	@Value("${parameter.ghtp2}")	private String 		ghtp2ParameterName	;
	@Value("${parameter.ghtp3}")	private String 		ghtp3ParameterName	;
	@Value("${parameter.ghtp4}")	private String 		ghtp4ParameterName	;
	@Value("${parameter.gndtp1}")	private String 		gndtp1ParameterName	;
	@Value("${parameter.gndtp2}")	private String 		gndtp2ParameterName	;
	@Value("${parameter.gndtp3}")	private String 		gndtp3ParameterName	;
	@Value("${parameter.gndtp4}")	private String 		gndtp4ParameterName	;
	@Value("${parameter.mph}")	private String 		mphParameterName	;
	@Value("${parameter.npl1}")	private String 		npl1ParameterName	;
	@Value("${parameter.npl2}")	private String 		npl2ParameterName	;
	@Value("${parameter.rsd1}")	private String 		rsd1ParameterName	;
	@Value("${parameter.rsd2}")	private String 		rsd2ParameterName	;
	@Value("${parameter.rsd3}")	private String 		rsd3ParameterName	;
	@Value("${parameter.rsd4}")	private String 		rsd4ParameterName	;
	//	@Value("${parameter.joginder1}")	private String 		joginder1ParameterName	;
	//	@Value("${parameter.joginder2}")	private String 		joginder2ParameterName	;
	//	@Value("${parameter.joginder3}")	private String 		joginder3ParameterName	;
	//	@Value("${parameter.joginder4}")	private String 		joginder4ParameterName	;
	//	@Value("${parameter.joginder5}")	private String 		joginder5ParameterName	;
	//	@Value("${parameter.joginder6}")	private String 		joginder6ParameterName	;
	@Value("${parameter.tldtp1}")	private String 		tldtp1ParameterName	;
	@Value("${parameter.tldtp2}")	private String 		tldtp2ParameterName	;
	@Value("${parameter.tldtp3}")	private String 		tldtp3ParameterName	;
	@Value("${parameter.ubdc}")	private String 		ubdcParameterName	;


	@Value("${parameter.shanan}")	private String 		shananParameterName	;


	@Value("${parameter.RES.Generation}")	private String 		totalResGenParameter;
	@Value("${parameter.Solar.Generation}")	private String 		totalSOLARGenerationParameter;
	@Value("${parameter.Non.Solar.Generation}")	private String 		totalNonSOLARGenerationParameter;




	public String getShananParameterName() {
		return shananParameterName;
	}

	public void setShananParameterName(String shananParameterName) {
		this.shananParameterName = shananParameterName;
	}

	public String getAshp1ParameterName() {
		return ashp1ParameterName;
	}

	public void setAshp1ParameterName(String ashp1ParameterName) {
		this.ashp1ParameterName = ashp1ParameterName;
	}

	public String getAshp2ParameterName() {
		return ashp2ParameterName;
	}

	public void setAshp2ParameterName(String ashp2ParameterName) {
		this.ashp2ParameterName = ashp2ParameterName;
	}

	public String getGgsstp1ParameterName() {
		return ggsstp1ParameterName;
	}

	public void setGgsstp1ParameterName(String ggsstp1ParameterName) {
		this.ggsstp1ParameterName = ggsstp1ParameterName;
	}

	public String getGgsstp2ParameterName() {
		return ggsstp2ParameterName;
	}

	public void setGgsstp2ParameterName(String ggsstp2ParameterName) {
		this.ggsstp2ParameterName = ggsstp2ParameterName;
	}

	public String getGgsstp3ParameterName() {
		return ggsstp3ParameterName;
	}

	public void setGgsstp3ParameterName(String ggsstp3ParameterName) {
		this.ggsstp3ParameterName = ggsstp3ParameterName;
	}

	public String getGgsstp4ParameterName() {
		return ggsstp4ParameterName;
	}

	public void setGgsstp4ParameterName(String ggsstp4ParameterName) {
		this.ggsstp4ParameterName = ggsstp4ParameterName;
	}

	public String getGgsstp5ParameterName() {
		return ggsstp5ParameterName;
	}

	public void setGgsstp5ParameterName(String ggsstp5ParameterName) {
		this.ggsstp5ParameterName = ggsstp5ParameterName;
	}

	public String getGgsstp6ParameterName() {
		return ggsstp6ParameterName;
	}

	public void setGgsstp6ParameterName(String ggsstp6ParameterName) {
		this.ggsstp6ParameterName = ggsstp6ParameterName;
	}

	public String getGhtp1ParameterName() {
		return ghtp1ParameterName;
	}

	public void setGhtp1ParameterName(String ghtp1ParameterName) {
		this.ghtp1ParameterName = ghtp1ParameterName;
	}

	public String getGhtp2ParameterName() {
		return ghtp2ParameterName;
	}

	public void setGhtp2ParameterName(String ghtp2ParameterName) {
		this.ghtp2ParameterName = ghtp2ParameterName;
	}

	public String getGhtp3ParameterName() {
		return ghtp3ParameterName;
	}

	public void setGhtp3ParameterName(String ghtp3ParameterName) {
		this.ghtp3ParameterName = ghtp3ParameterName;
	}

	public String getGhtp4ParameterName() {
		return ghtp4ParameterName;
	}

	public void setGhtp4ParameterName(String ghtp4ParameterName) {
		this.ghtp4ParameterName = ghtp4ParameterName;
	}

	public String getGndtp1ParameterName() {
		return gndtp1ParameterName;
	}

	public void setGndtp1ParameterName(String gndtp1ParameterName) {
		this.gndtp1ParameterName = gndtp1ParameterName;
	}

	public String getGndtp2ParameterName() {
		return gndtp2ParameterName;
	}

	public String getTotalResGenParameter() {
		return totalResGenParameter;
	}

	public void setTotalResGenParameter(String totalResGenParameter) {
		this.totalResGenParameter = totalResGenParameter;
	}

	public String getTotalSOLARGenerationParameter() {
		return totalSOLARGenerationParameter;
	}

	public void setTotalSOLARGenerationParameter(String totalSOLARGenerationParameter) {
		this.totalSOLARGenerationParameter = totalSOLARGenerationParameter;
	}

	public String getTotalNonSOLARGenerationParameter() {
		return totalNonSOLARGenerationParameter;
	}

	public void setTotalNonSOLARGenerationParameter(String totalNonSOLARGenerationParameter) {
		this.totalNonSOLARGenerationParameter = totalNonSOLARGenerationParameter;
	}

	public void setGndtp2ParameterName(String gndtp2ParameterName) {
		this.gndtp2ParameterName = gndtp2ParameterName;
	}

	public String getGndtp3ParameterName() {
		return gndtp3ParameterName;
	}

	public void setGndtp3ParameterName(String gndtp3ParameterName) {
		this.gndtp3ParameterName = gndtp3ParameterName;
	}

	public String getGndtp4ParameterName() {
		return gndtp4ParameterName;
	}

	public void setGndtp4ParameterName(String gndtp4ParameterName) {
		this.gndtp4ParameterName = gndtp4ParameterName;
	}

	public String getMphParameterName() {
		return mphParameterName;
	}

	public void setMphParameterName(String mphParameterName) {
		this.mphParameterName = mphParameterName;
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

	public String getRsd1ParameterName() {
		return rsd1ParameterName;
	}

	public void setRsd1ParameterName(String rsd1ParameterName) {
		this.rsd1ParameterName = rsd1ParameterName;
	}

	public String getRsd2ParameterName() {
		return rsd2ParameterName;
	}

	public void setRsd2ParameterName(String rsd2ParameterName) {
		this.rsd2ParameterName = rsd2ParameterName;
	}

	public String getRsd3ParameterName() {
		return rsd3ParameterName;
	}

	public void setRsd3ParameterName(String rsd3ParameterName) {
		this.rsd3ParameterName = rsd3ParameterName;
	}

	public String getRsd4ParameterName() {
		return rsd4ParameterName;
	}

	public void setRsd4ParameterName(String rsd4ParameterName) {
		this.rsd4ParameterName = rsd4ParameterName;
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

	public String getUbdcParameterName() {
		return ubdcParameterName;
	}

	public void setUbdcParameterName(String ubdcParameterName) {
		this.ubdcParameterName = ubdcParameterName;
	}

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


}
