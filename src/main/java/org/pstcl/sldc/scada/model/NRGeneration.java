package org.pstcl.sldc.scada.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NRGeneration {
	private LocalDate dateLoad;
	private LocalTime timeLoad;

	@JsonFormat(pattern="HH:mm:ss")
	private LocalDateTime  updateDate;
	private BigDecimal 		chd_drwl	;
	private BigDecimal 		chd_load	;
	private BigDecimal 		chd_odud	;
	private BigDecimal 		chd_sch	;
	private BigDecimal 		delhi_drwl	;
	private BigDecimal 		delhi_load	;
	private BigDecimal 		delhi_odud	;
	private BigDecimal 		delhi_sch	;
	private BigDecimal 		haryana_drwl	;
	private BigDecimal 		haryana_load	;
	private BigDecimal 		haryana_odud	;
	private BigDecimal 		haryana_sch	;
	private BigDecimal 		hp_drwl	;
	private BigDecimal 	 	hp_load	;
	private BigDecimal 	 	hp_odud	;
	private BigDecimal 	 	hp_sch	;
	private BigDecimal 	 	jk_drwl	;
	private BigDecimal 	 	jk_load	;
	private BigDecimal 	 	jk_odud	;
	private BigDecimal 	 	jk_sch	;
	private BigDecimal 	 	pun_drwl	;
	private BigDecimal 	 	pun_load	;
	private BigDecimal 	 	pun_odud	;
	private BigDecimal 	 	pun_sch	;
	private BigDecimal 	 	raj_drwl	;
	private BigDecimal 	 	raj_load	;
	private BigDecimal 	 	raj_odud	;
	private BigDecimal 	 	raj_sch	;
	private BigDecimal 	 	uk_drwl	;
	private BigDecimal 	 	uk_load	;
	private BigDecimal 	 	uk_odud	;
	private BigDecimal 	 	uk_sch	;
	private BigDecimal 	 	up_drwl	;
	private BigDecimal 	 	up_load	;
	private BigDecimal 	 	up_odud	;
	private BigDecimal 	 	up_sch	;
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
	public BigDecimal getChd_drwl() {
		return chd_drwl;
	}
	public void setChd_drwl(BigDecimal chd_drwl) {
		this.chd_drwl = chd_drwl;
	}
	public BigDecimal getChd_load() {
		return chd_load;
	}
	public void setChd_load(BigDecimal chd_load) {
		this.chd_load = chd_load;
	}
	public BigDecimal getChd_odud() {
		return chd_odud;
	}
	public void setChd_odud(BigDecimal chd_odud) {
		this.chd_odud = chd_odud;
	}
	public BigDecimal getChd_sch() {
		return chd_sch;
	}
	public void setChd_sch(BigDecimal chd_sch) {
		this.chd_sch = chd_sch;
	}
	public BigDecimal getDelhi_drwl() {
		return delhi_drwl;
	}
	public void setDelhi_drwl(BigDecimal delhi_drwl) {
		this.delhi_drwl = delhi_drwl;
	}
	public BigDecimal getDelhi_load() {
		return delhi_load;
	}
	public void setDelhi_load(BigDecimal delhi_load) {
		this.delhi_load = delhi_load;
	}
	public BigDecimal getDelhi_odud() {
		return delhi_odud;
	}
	public void setDelhi_odud(BigDecimal delhi_odud) {
		this.delhi_odud = delhi_odud;
	}
	public BigDecimal getDelhi_sch() {
		return delhi_sch;
	}
	public void setDelhi_sch(BigDecimal delhi_sch) {
		this.delhi_sch = delhi_sch;
	}
	public BigDecimal getHaryana_drwl() {
		return haryana_drwl;
	}
	public void setHaryana_drwl(BigDecimal haryana_drwl) {
		this.haryana_drwl = haryana_drwl;
	}
	public BigDecimal getHaryana_load() {
		return haryana_load;
	}
	public void setHaryana_load(BigDecimal haryana_load) {
		this.haryana_load = haryana_load;
	}
	public BigDecimal getHaryana_odud() {
		return haryana_odud;
	}
	public void setHaryana_odud(BigDecimal haryana_odud) {
		this.haryana_odud = haryana_odud;
	}
	public BigDecimal getHaryana_sch() {
		return haryana_sch;
	}
	public void setHaryana_sch(BigDecimal haryana_sch) {
		this.haryana_sch = haryana_sch;
	}
	public BigDecimal getHp_drwl() {
		return hp_drwl;
	}
	public void setHp_drwl(BigDecimal hp_drwl) {
		this.hp_drwl = hp_drwl;
	}
	public BigDecimal getHp_load() {
		return hp_load;
	}
	public void setHp_load(BigDecimal hp_load) {
		this.hp_load = hp_load;
	}
	public BigDecimal getHp_odud() {
		return hp_odud;
	}
	public void setHp_odud(BigDecimal hp_odud) {
		this.hp_odud = hp_odud;
	}
	public BigDecimal getHp_sch() {
		return hp_sch;
	}
	public void setHp_sch(BigDecimal hp_sch) {
		this.hp_sch = hp_sch;
	}
	public BigDecimal getJk_drwl() {
		return jk_drwl;
	}
	public void setJk_drwl(BigDecimal jk_drwl) {
		this.jk_drwl = jk_drwl;
	}
	public BigDecimal getJk_load() {
		return jk_load;
	}
	public void setJk_load(BigDecimal jk_load) {
		this.jk_load = jk_load;
	}
	public BigDecimal getJk_odud() {
		return jk_odud;
	}
	public void setJk_odud(BigDecimal jk_odud) {
		this.jk_odud = jk_odud;
	}
	public BigDecimal getJk_sch() {
		return jk_sch;
	}
	public void setJk_sch(BigDecimal jk_sch) {
		this.jk_sch = jk_sch;
	}
	public BigDecimal getPun_drwl() {
		return pun_drwl;
	}
	public void setPun_drwl(BigDecimal pun_drwl) {
		this.pun_drwl = pun_drwl;
	}
	public BigDecimal getPun_load() {
		return pun_load;
	}
	public void setPun_load(BigDecimal pun_load) {
		this.pun_load = pun_load;
	}
	public BigDecimal getPun_odud() {
		return pun_odud;
	}
	public void setPun_odud(BigDecimal pun_odud) {
		this.pun_odud = pun_odud;
	}
	public BigDecimal getPun_sch() {
		return pun_sch;
	}
	public void setPun_sch(BigDecimal pun_sch) {
		this.pun_sch = pun_sch;
	}
	public BigDecimal getRaj_drwl() {
		return raj_drwl;
	}
	public void setRaj_drwl(BigDecimal raj_drwl) {
		this.raj_drwl = raj_drwl;
	}
	public BigDecimal getRaj_load() {
		return raj_load;
	}
	public void setRaj_load(BigDecimal raj_load) {
		this.raj_load = raj_load;
	}
	public BigDecimal getRaj_odud() {
		return raj_odud;
	}
	public void setRaj_odud(BigDecimal raj_odud) {
		this.raj_odud = raj_odud;
	}
	public BigDecimal getRaj_sch() {
		return raj_sch;
	}
	public void setRaj_sch(BigDecimal raj_sch) {
		this.raj_sch = raj_sch;
	}
	public BigDecimal getUk_drwl() {
		return uk_drwl;
	}
	public void setUk_drwl(BigDecimal uk_drwl) {
		this.uk_drwl = uk_drwl;
	}
	public BigDecimal getUk_load() {
		return uk_load;
	}
	public void setUk_load(BigDecimal uk_load) {
		this.uk_load = uk_load;
	}
	public BigDecimal getUk_odud() {
		return uk_odud;
	}
	public void setUk_odud(BigDecimal uk_odud) {
		this.uk_odud = uk_odud;
	}
	public BigDecimal getUk_sch() {
		return uk_sch;
	}
	public void setUk_sch(BigDecimal uk_sch) {
		this.uk_sch = uk_sch;
	}
	public BigDecimal getUp_drwl() {
		return up_drwl;
	}
	public void setUp_drwl(BigDecimal up_drwl) {
		this.up_drwl = up_drwl;
	}
	public BigDecimal getUp_load() {
		return up_load;
	}
	public void setUp_load(BigDecimal up_load) {
		this.up_load = up_load;
	}
	public BigDecimal getUp_odud() {
		return up_odud;
	}
	public void setUp_odud(BigDecimal up_odud) {
		this.up_odud = up_odud;
	}
	public BigDecimal getUp_sch() {
		return up_sch;
	}
	public void setUp_sch(BigDecimal up_sch) {
		this.up_sch = up_sch;
	}
				

}
