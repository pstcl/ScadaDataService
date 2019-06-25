package org.pstcl.sldc.scada.model.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class ScadaBigDecimal extends BigDecimal{

	private static MathContext context = new MathContext(120, RoundingMode.HALF_UP);

	public ScadaBigDecimal(BigInteger val) {
		super(val,context);
		

	}

    
}
