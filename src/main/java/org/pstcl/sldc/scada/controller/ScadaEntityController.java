package org.pstcl.sldc.scada.controller;


import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pstcl.sldc.scada.model.ScadaDataEntity;
import org.pstcl.sldc.scada.repository.ScadaDataEntityRepository;
import org.pstcl.sldc.scada.util.ExcelParameterNameProperties;
import org.pstcl.sldc.scada.util.GlobalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ScadaEntityController {

	@Autowired
	private  ScadaDataEntityRepository scadaDataEntityRepository;


	@Autowired
	private ExcelParameterNameProperties parameterNames;


	private Pageable getPageRequest(int limit)
	{
		Pageable pageRequest =PageRequest.of(0, limit, Sort.by("entityId.dateS").descending().and(Sort.by("entityId.timeS").descending()));
		return pageRequest;

	}



	//	*/Rate=10'

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/freq/{limit}") 
	public  List<ScadaDataEntity> findAllWithFreq(@PathVariable("limit") int limit,HttpServletResponse response,HttpServletRequest request) {


//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Credentials", "true");
//		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//		response.setHeader("Access-Control-Max-Age", "3600");
//		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
//


		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getFrequencyParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}


	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/frequency/{limit}") 
	public  List<ScadaDataEntity> findAllWithFrequency(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getFrequencyParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/drawal/{limit}") 
	public  List<ScadaDataEntity> findAllDrawal(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getDrawalParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/schedule/{limit}") 
	public  List<ScadaDataEntity> findAllSchedule(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getScheduleParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}


	//	@CrossOrigin(allowCredentials="true")
	//	@GetMapping(value = "/scadadata/findAll/{limit}") 
	//	public  List<ScadaDataEntity> findAllData(@PathVariable("limit") int limit) {
	//		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findAllWithFrequency(limit);
	//		scadaEntityList.addAll(scadaDataEntityRepository.findAllDrawal(limit));
	//		scadaEntityList.addAll(scadaDataEntityRepository.findAllSchedule(limit));
	//		scadaEntityList.addAll(scadaDataEntityRepository.findAllOD_UD(limit));
	//		scadaEntityList.addAll(scadaDataEntityRepository.findAllLoad(limit));
	//		return scadaEntityList; 
	//	}



	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/od_ud/{limit}") 
	public  List<ScadaDataEntity> findAllOD_UD(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getOdudParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/load/{limit}") 
	public  List<ScadaDataEntity> findAllLoad(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getLoadParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	//	@CrossOrigin(allowCredentials="true")
	//	@GetMapping(value = "/scadadata/dateS/{date}") 
	//	public  List<ScadaDataEntity> findAllWithdateS(@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date) {
	//		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findAllWithdateS(date);
	//		return scadaEntityList; 
	//	}


}
