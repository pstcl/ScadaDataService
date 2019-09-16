package org.pstcl.sldc.scada.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.pstcl.sldc.scada.model.entity.ScadaDataEntity;

public class ScadaDataJsonPojo extends ScadaDataEntity {
	
	
	@Override
	public BigDecimal getValue() {
		return super.getValue().setScale(0,RoundingMode.HALF_UP);
		
		//return super.getValue();
	}

}
