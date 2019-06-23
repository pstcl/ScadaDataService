package org.pstcl.sldc.scada.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LatestDynamicData {

	//	Updated at: 09:40:17
	//	Frequency (Hz): 	49.98
	//	Drawal (MW): 	5492
	//	Schedule (MW): 	5585
	//	OD(+)/UD(-) (MW): 	-93
	//	Load (MW): 	10004

	private LocalDate dateLoad;
	private LocalTime timeLoad;

	@JsonFormat(pattern="HH:mm:ss")
	private LocalDateTime  updateDate;
	private BigDecimal frequencyHz;
	private BigDecimal drawalMW;
	private BigDecimal scheduleMW;

	private BigDecimal odUD;
	private BigDecimal loadMW;


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
	public BigDecimal getFrequencyHz() {
		return frequencyHz;
	}
	public void setFrequencyHz(BigDecimal frequencyHz) {
		this.frequencyHz = frequencyHz.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	public BigDecimal getDrawalMW() {
		return drawalMW;
	}
	public void setDrawalMW(BigDecimal drawalMW) {
		this.drawalMW = drawalMW.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	public BigDecimal getScheduleMW() {
		return scheduleMW;
	}
	public void setScheduleMW(BigDecimal scheduleMW) {
		this.scheduleMW = scheduleMW.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	public BigDecimal getOdUD() {
		return odUD;
	}
	public void setOdUD(BigDecimal odUD) {
		this.odUD = odUD.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	public BigDecimal getLoadMW() {
		return loadMW;
	}
	public void setLoadMW(BigDecimal loadMW) {
		this.loadMW = loadMW.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	public LocalDateTime  getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime  updateDate) {
		this.updateDate =  updateDate;
	}


}
