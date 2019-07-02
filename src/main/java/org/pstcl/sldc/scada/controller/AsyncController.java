package org.pstcl.sldc.scada.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pstcl.sldc.scada.model.ScadaDataEntity;
import org.pstcl.sldc.scada.repository.ScadaDataEntityRepository;
import org.pstcl.sldc.scada.service.ExcelService;
import org.pstcl.sldc.scada.service.LiveDataExcelService;
import org.pstcl.sldc.scada.util.ExcelParameterNameProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AsyncController {

	
	@Autowired
	private  ScadaDataEntityRepository scadaDataEntityRepository;


	@Autowired
	private ExcelParameterNameProperties parameterNames;
	
	@Autowired
	private ExcelService excelService;

	@Autowired
	private LiveDataExcelService liveDataExcelService;

	private Pageable getPageRequest(int limit)
	{
		Pageable pageRequest =PageRequest.of(0, limit, Sort.by("entityId.dateS").descending().and(Sort.by("entityId.timeS").descending()));
		return pageRequest;

	}


	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/frequency/{limit}") 
	public  Set<ScadaDataEntity> findAllWithFrequency(@PathVariable("limit") int limit,HttpServletResponse response,HttpServletRequest request) {
		//Set<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getFrequencyParameterName(),getPageRequest(limit));
		//return scadaEntityList;
		
		return excelService.getFrequencyList();
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/drawal/{limit}") 
	public  Set<ScadaDataEntity> findAllDrawal(@PathVariable("limit") int limit,HttpServletResponse response,HttpServletRequest request) {
//		Set<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getDrawalParameterName(),getPageRequest(limit));
//		return scadaEntityList;
		
		return excelService.getDrawalList();
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/schedule/{limit}") 
	public  Set<ScadaDataEntity> findAllSchedule(@PathVariable("limit") int limit) {
//		Set<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getScheduleParameterName(),getPageRequest(limit));
//		return scadaEntityList;
		
		return excelService.getScheduleList();
	}



	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/od_ud/{limit}") 
	public  Set<ScadaDataEntity> findAllOD_UD(@PathVariable("limit") int limit) {
//		Set<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getOdudParameterName(),getPageRequest(limit));
//		return scadaEntityList;
		
		return excelService.getOdudList();
	}

	
	
//	@CrossOrigin(allowCredentials="true")
//	@GetMapping(value = "/scadadata/frequency/{limit}") 
//	public  Set<ScadaDataEntity> findAllWithFrequency(@PathVariable("limit") int limit,HttpServletResponse response,HttpServletRequest request) {
//		Set<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getFrequencyParameterName(),getPageRequest(limit));
//		return scadaEntityList;
//	}
//
//	@CrossOrigin(allowCredentials="true")
//	@GetMapping(value = "/scadadata/drawal/{limit}") 
//	public  Set<ScadaDataEntity> findAllDrawal(@PathVariable("limit") int limit,HttpServletResponse response,HttpServletRequest request) {
//		Set<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getDrawalParameterName(),getPageRequest(limit));
//		return scadaEntityList;
//	}
//
//	@CrossOrigin(allowCredentials="true")
//	@GetMapping(value = "/scadadata/schedule/{limit}") 
//	public  Set<ScadaDataEntity> findAllSchedule(@PathVariable("limit") int limit) {
//		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getScheduleParameterName(),getPageRequest(limit));
//		return scadaEntityList;
//	}
//
//
//
//	@CrossOrigin(allowCredentials="true")
//	@GetMapping(value = "/scadadata/od_ud/{limit}") 
//	public  List<ScadaDataEntity> findAllOD_UD(@PathVariable("limit") int limit) {
//		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getOdudParameterName(),getPageRequest(limit));
//		return scadaEntityList;
//	}
//

	
}
