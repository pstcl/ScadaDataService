package org.pstcl.sldc.scada.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pstcl.sldc.scada.model.ScadaDataEntity;
import org.pstcl.sldc.scada.repository.ScadaDataEntityRepository;
import org.pstcl.sldc.scada.util.ExcelParameterNameProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;

public class ChartDataService extends ExcelService {





	

	@Autowired
	private ScadaDataEntityRepository scadaDataEntityRepository;

	@Autowired
	private ExcelParameterNameProperties parameterNames;



}
