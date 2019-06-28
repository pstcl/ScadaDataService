package org.pstcl.sldc.scada.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NRGeneration {
	private LocalDate dateLoad;
	private LocalTime timeLoad;

	@JsonFormat(pattern="HH:mm:ss")
	private LocalDateTime  updateDate;
	private ScadaDataEntity 		chd_drwl	;
	private ScadaDataEntity 		chd_load	;
	private ScadaDataEntity 		chd_odud	;
	private ScadaDataEntity 		chd_sch	;
	private ScadaDataEntity 		delhi_drwl	;
	private ScadaDataEntity 		delhi_load	;
	private ScadaDataEntity 		delhi_odud	;
	private ScadaDataEntity 		delhi_sch	;
	private ScadaDataEntity 		haryana_drwl	;
	private ScadaDataEntity 		haryana_load	;
	private ScadaDataEntity 		haryana_odud	;
	private ScadaDataEntity 		haryana_sch	;
	private ScadaDataEntity 		hp_drwl	;
	private ScadaDataEntity 	 	hp_load	;
	private ScadaDataEntity 	 	hp_odud	;
	private ScadaDataEntity 	 	hp_sch	;
	private ScadaDataEntity 	 	jk_drwl	;
	private ScadaDataEntity 	 	jk_load	;
	private ScadaDataEntity 	 	jk_odud	;
	private ScadaDataEntity 	 	jk_sch	;
	private ScadaDataEntity 	 	pun_drwl	;
	private ScadaDataEntity 	 	pun_load	;
	private ScadaDataEntity 	 	pun_odud	;
	private ScadaDataEntity 	 	pun_sch	;
	private ScadaDataEntity 	 	raj_drwl	;
	private ScadaDataEntity 	 	raj_load	;
	private ScadaDataEntity 	 	raj_odud	;
	private ScadaDataEntity 	 	raj_sch	;
	private ScadaDataEntity 	 	uk_drwl	;
	private ScadaDataEntity 	 	uk_load	;
	private ScadaDataEntity 	 	uk_odud	;
	private ScadaDataEntity 	 	uk_sch	;
	private ScadaDataEntity 	 	up_drwl	;
	private ScadaDataEntity 	 	up_load	;
	private ScadaDataEntity 	 	up_odud	;
	private ScadaDataEntity 	 	up_sch	;
	public LocalDate getDateLoad() {
		return dateLoad;
	}
	public void setDateLoad(LocalDate dateLoad) {
		this.dateLoad = dateLoad;
	}
	public LocalTime getTimeLoad() {
		return timeLoad;
	}
	public void setTimeLoad(LocalTime timeLoad) {
		this.timeLoad = timeLoad;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public ScadaDataEntity getChd_drwl() {
		return chd_drwl;
	}
	public void setChd_drwl(ScadaDataEntity chd_drwl) {
		this.chd_drwl = chd_drwl;
	}
	public ScadaDataEntity getChd_load() {
		return chd_load;
	}
	public void setChd_load(ScadaDataEntity chd_load) {
		this.chd_load = chd_load;
	}
	public ScadaDataEntity getChd_odud() {
		return chd_odud;
	}
	public void setChd_odud(ScadaDataEntity chd_odud) {
		this.chd_odud = chd_odud;
	}
	public ScadaDataEntity getChd_sch() {
		return chd_sch;
	}
	public void setChd_sch(ScadaDataEntity chd_sch) {
		this.chd_sch = chd_sch;
	}
	public ScadaDataEntity getDelhi_drwl() {
		return delhi_drwl;
	}
	public void setDelhi_drwl(ScadaDataEntity delhi_drwl) {
		this.delhi_drwl = delhi_drwl;
	}
	public ScadaDataEntity getDelhi_load() {
		return delhi_load;
	}
	public void setDelhi_load(ScadaDataEntity delhi_load) {
		this.delhi_load = delhi_load;
	}
	public ScadaDataEntity getDelhi_odud() {
		return delhi_odud;
	}
	public void setDelhi_odud(ScadaDataEntity delhi_odud) {
		this.delhi_odud = delhi_odud;
	}
	public ScadaDataEntity getDelhi_sch() {
		return delhi_sch;
	}
	public void setDelhi_sch(ScadaDataEntity delhi_sch) {
		this.delhi_sch = delhi_sch;
	}
	public ScadaDataEntity getHaryana_drwl() {
		return haryana_drwl;
	}
	public void setHaryana_drwl(ScadaDataEntity haryana_drwl) {
		this.haryana_drwl = haryana_drwl;
	}
	public ScadaDataEntity getHaryana_load() {
		return haryana_load;
	}
	public void setHaryana_load(ScadaDataEntity haryana_load) {
		this.haryana_load = haryana_load;
	}
	public ScadaDataEntity getHaryana_odud() {
		return haryana_odud;
	}
	public void setHaryana_odud(ScadaDataEntity haryana_odud) {
		this.haryana_odud = haryana_odud;
	}
	public ScadaDataEntity getHaryana_sch() {
		return haryana_sch;
	}
	public void setHaryana_sch(ScadaDataEntity haryana_sch) {
		this.haryana_sch = haryana_sch;
	}
	public ScadaDataEntity getHp_drwl() {
		return hp_drwl;
	}
	public void setHp_drwl(ScadaDataEntity hp_drwl) {
		this.hp_drwl = hp_drwl;
	}
	public ScadaDataEntity getHp_load() {
		return hp_load;
	}
	public void setHp_load(ScadaDataEntity hp_load) {
		this.hp_load = hp_load;
	}
	public ScadaDataEntity getHp_odud() {
		return hp_odud;
	}
	public void setHp_odud(ScadaDataEntity hp_odud) {
		this.hp_odud = hp_odud;
	}
	public ScadaDataEntity getHp_sch() {
		return hp_sch;
	}
	public void setHp_sch(ScadaDataEntity hp_sch) {
		this.hp_sch = hp_sch;
	}
	public ScadaDataEntity getJk_drwl() {
		return jk_drwl;
	}
	public void setJk_drwl(ScadaDataEntity jk_drwl) {
		this.jk_drwl = jk_drwl;
	}
	public ScadaDataEntity getJk_load() {
		return jk_load;
	}
	public void setJk_load(ScadaDataEntity jk_load) {
		this.jk_load = jk_load;
	}
	public ScadaDataEntity getJk_odud() {
		return jk_odud;
	}
	public void setJk_odud(ScadaDataEntity jk_odud) {
		this.jk_odud = jk_odud;
	}
	public ScadaDataEntity getJk_sch() {
		return jk_sch;
	}
	public void setJk_sch(ScadaDataEntity jk_sch) {
		this.jk_sch = jk_sch;
	}
	public ScadaDataEntity getPun_drwl() {
		return pun_drwl;
	}
	public void setPun_drwl(ScadaDataEntity pun_drwl) {
		this.pun_drwl = pun_drwl;
	}
	public ScadaDataEntity getPun_load() {
		return pun_load;
	}
	public void setPun_load(ScadaDataEntity pun_load) {
		this.pun_load = pun_load;
	}
	public ScadaDataEntity getPun_odud() {
		return pun_odud;
	}
	public void setPun_odud(ScadaDataEntity pun_odud) {
		this.pun_odud = pun_odud;
	}
	public ScadaDataEntity getPun_sch() {
		return pun_sch;
	}
	public void setPun_sch(ScadaDataEntity pun_sch) {
		this.pun_sch = pun_sch;
	}
	public ScadaDataEntity getRaj_drwl() {
		return raj_drwl;
	}
	public void setRaj_drwl(ScadaDataEntity raj_drwl) {
		this.raj_drwl = raj_drwl;
	}
	public ScadaDataEntity getRaj_load() {
		return raj_load;
	}
	public void setRaj_load(ScadaDataEntity raj_load) {
		this.raj_load = raj_load;
	}
	public ScadaDataEntity getRaj_odud() {
		return raj_odud;
	}
	public void setRaj_odud(ScadaDataEntity raj_odud) {
		this.raj_odud = raj_odud;
	}
	public ScadaDataEntity getRaj_sch() {
		return raj_sch;
	}
	public void setRaj_sch(ScadaDataEntity raj_sch) {
		this.raj_sch = raj_sch;
	}
	public ScadaDataEntity getUk_drwl() {
		return uk_drwl;
	}
	public void setUk_drwl(ScadaDataEntity uk_drwl) {
		this.uk_drwl = uk_drwl;
	}
	public ScadaDataEntity getUk_load() {
		return uk_load;
	}
	public void setUk_load(ScadaDataEntity uk_load) {
		this.uk_load = uk_load;
	}
	public ScadaDataEntity getUk_odud() {
		return uk_odud;
	}
	public void setUk_odud(ScadaDataEntity uk_odud) {
		this.uk_odud = uk_odud;
	}
	public ScadaDataEntity getUk_sch() {
		return uk_sch;
	}
	public void setUk_sch(ScadaDataEntity uk_sch) {
		this.uk_sch = uk_sch;
	}
	public ScadaDataEntity getUp_drwl() {
		return up_drwl;
	}
	public void setUp_drwl(ScadaDataEntity up_drwl) {
		this.up_drwl = up_drwl;
	}
	public ScadaDataEntity getUp_load() {
		return up_load;
	}
	public void setUp_load(ScadaDataEntity up_load) {
		this.up_load = up_load;
	}
	public ScadaDataEntity getUp_odud() {
		return up_odud;
	}
	public void setUp_odud(ScadaDataEntity up_odud) {
		this.up_odud = up_odud;
	}
	public ScadaDataEntity getUp_sch() {
		return up_sch;
	}
	public void setUp_sch(ScadaDataEntity up_sch) {
		this.up_sch = up_sch;
	}
				

}
