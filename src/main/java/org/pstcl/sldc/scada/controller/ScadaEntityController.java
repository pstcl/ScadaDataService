package org.pstcl.sldc.scada.controller;


import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pstcl.sldc.scada.model.LatestDynamicData;
import org.pstcl.sldc.scada.model.NRGeneration;
import org.pstcl.sldc.scada.model.PunjabOwnGenerationModel;
import org.pstcl.sldc.scada.model.PunjabOwnGenerationModel2;
import org.pstcl.sldc.scada.model.ScadaDataEntity;
import org.pstcl.sldc.scada.repository.ScadaDataEntityRepository;
import org.pstcl.sldc.scada.service.ExcelService;
import org.pstcl.sldc.scada.service.LiveDataExcelService;
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
	
	@Autowired
	private ExcelService excelService;

	@Autowired
	private LiveDataExcelService liveDataExcelService;

	private Pageable getPageRequest(int limit)
	{
		Pageable pageRequest =PageRequest.of(0, limit, Sort.by("entityId.dateS").descending().and(Sort.by("entityId.timeS").descending()));
		return pageRequest;

	}



	//	*/Rate=10'


	private  LatestDynamicData dynamicdata2(HttpServletResponse response,HttpServletRequest request) {
		LatestDynamicData latestDynamicData=new LatestDynamicData();
		int limit=1;
		latestDynamicData.setFrequencyHz(scadaDataEntityRepository.findByDdeItem (parameterNames.getFrequencyParameterName(),getPageRequest(limit)).get(0).getValue());
		latestDynamicData.setDrawalMW(scadaDataEntityRepository.findByDdeItem (parameterNames.getDrawalParameterName(),getPageRequest(limit)).get(0).getValue());
		latestDynamicData.setLoadMW(scadaDataEntityRepository.findByDdeItem (parameterNames.getLoadParameterName(),getPageRequest(limit)).get(0).getValue());
		latestDynamicData.setScheduleMW(scadaDataEntityRepository.findByDdeItem (parameterNames.getScheduleParameterName(),getPageRequest(limit)).get(0).getValue());
		latestDynamicData.setOdUD(scadaDataEntityRepository.findByDdeItem (parameterNames.getOdudParameterName(),getPageRequest(limit)).get(0).getValue());
		latestDynamicData.setUpdateDate(LocalDateTime.now());
		return latestDynamicData;
	}

//	@CrossOrigin(allowCredentials="true")
//	@GetMapping(value = "/scadadata/pbGenData") 
//	public  PunjabOwnGenerationModel pbGenData(HttpServletResponse response,HttpServletRequest request) {
//		PunjabOwnGenerationModel generationModel=liveDataExcelService.getPunjabGenData();
//		
//		return generationModel;
//	}
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/pbGenData2") 
	public  PunjabOwnGenerationModel2 pbGenData2(HttpServletResponse response,HttpServletRequest request) {
		PunjabOwnGenerationModel2 generationModel=liveDataExcelService.getPunjabGenData2();
		
		return generationModel;
	}
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/nrGenData") 
	public  NRGeneration nrGenData(HttpServletResponse response,HttpServletRequest request) {
		NRGeneration nrGenDataModel=liveDataExcelService.getNRGeneration();
		return nrGenDataModel;
	}
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/dynamicdata") 
	public  LatestDynamicData dynamicdata(HttpServletResponse response,HttpServletRequest request) {
		LatestDynamicData latestDynamicData=excelService.getLatestDynamicData();
		if(latestDynamicData==null)
		{
			latestDynamicData=dynamicdata2(response, request);
		}
		return latestDynamicData;
	}

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
	public  List<ScadaDataEntity> findAllWithFrequency(@PathVariable("limit") int limit,HttpServletResponse response,HttpServletRequest request) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getFrequencyParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/drawal/{limit}") 
	public  List<ScadaDataEntity> findAllDrawal(@PathVariable("limit") int limit,HttpServletResponse response,HttpServletRequest request) {
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
	@GetMapping(value = "/scadadata/Haryana_sch/{limit}") 
	public  List<ScadaDataEntity> findAllWithHaryana_sch(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getHaryana_schParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Haryana_drw1/{limit}") 
	public  List<ScadaDataEntity> findAllWithHaryana_drw1(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getHaryana_drwlParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Haryana_odud/{limit}") 
	public  List<ScadaDataEntity> findAllWithHaryana_odud(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getHaryana_odudParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Haryana_load/{limit}") 
	public  List<ScadaDataEntity> findAllWithHaryana_load(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getHaryana_loadParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	//testing src modification and ignore

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Gvk1/{limit}") 
	public  List<ScadaDataEntity> findAllWithGvk1(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getGvk1ParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Gvk2/{limit}") 
	public  List<ScadaDataEntity> findAllWithGvk2(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getGvk2ParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Raj_sch/{limit}") 
	public  List<ScadaDataEntity> findAllWithRaj_sch(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getRaj_schParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Raj_drw1/{limit}") 
	public  List<ScadaDataEntity> findAllWithRaj_drw1(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getRaj_drwlParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Raj_odud/{limit}") 
	public  List<ScadaDataEntity> findAllWithRaj_odud(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getRaj_odudParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Raj_load/{limit}") 
	public  List<ScadaDataEntity> findAllWithRaj_load(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getRaj_loadParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Delhi_sch/{limit}") 
	public  List<ScadaDataEntity> findAllWithDelhi_sch(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getDelhi_schParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Delhi_drw1/{limit}") 
	public  List<ScadaDataEntity> findAllWithDelhi_drw1(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getDelhi_drwlParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Delhi_odud/{limit}") 
	public  List<ScadaDataEntity> findAllWithDelhi_odud(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getDelhi_odudParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Delhi_load/{limit}") 
	public  List<ScadaDataEntity> findAllWithDelhi_load(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getDelhi_loadParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Up_sch/{limit}") 
	public  List<ScadaDataEntity> findAllWithUp_sch(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getUp_schParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Up_drw1/{limit}") 
	public  List<ScadaDataEntity> findAllWithUp_drw1(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getUp_drwlParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Up_odud/{limit}") 
	public  List<ScadaDataEntity> findAllWithUp_odud(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getUp_odudParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Up_load/{limit}") 
	public  List<ScadaDataEntity> findAllWithUp_load(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getUp_loadParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Uk_sch/{limit}") 
	public  List<ScadaDataEntity> findAllWithUk_sch(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getUk_schParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Uk_drw1/{limit}") 
	public  List<ScadaDataEntity> findAllWithUk_drw1(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getUk_drwlParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Uk_odud/{limit}") 
	public  List<ScadaDataEntity> findAllWithUk_odud(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getUk_odudParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Uk_load/{limit}") 
	public  List<ScadaDataEntity> findAllWithUk_load(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getUk_loadParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Chd_sch/{limit}") 
	public  List<ScadaDataEntity> findAllWithChd_sch(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getChd_schParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Chd_drw1/{limit}") 
	public  List<ScadaDataEntity> findAllWithChd_drw1(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getChd_drwlParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Chd_odud/{limit}") 
	public  List<ScadaDataEntity> findAllWithChd_odud(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getChd_odudParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Hp_sch/{limit}") 
	public  List<ScadaDataEntity> findAllWithHp_sch(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getHp_schParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Hp_drw1/{limit}") 
	public  List<ScadaDataEntity> findAllWithHp_drw1(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getHp_drwlParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Hp_odud/{limit}") 
	public  List<ScadaDataEntity> findAllWithHp_odud(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getHp_odudParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Hp_load/{limit}") 
	public  List<ScadaDataEntity> findAllWithHp_load(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getHp_loadParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Jk_sch/{limit}") 
	public  List<ScadaDataEntity> findAllWithJk_sch(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getJk_schParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Jk_drw1/{limit}") 
	public  List<ScadaDataEntity> findAllWithJk_drw1(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getJk_drwlParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Jk_odud/{limit}") 
	public  List<ScadaDataEntity> findAllWithJk_odud(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getJk_odudParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Jk_load/{limit}") 
	public  List<ScadaDataEntity> findAllWithJk_load(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getJk_loadParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Npl1/{limit}") 
	public  List<ScadaDataEntity> findAllWithNpl1(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getNpl1ParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Npl2/{limit}") 
	public  List<ScadaDataEntity> findAllWithNpl2(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getNpl2ParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Tldtp1/{limit}") 
	public  List<ScadaDataEntity> findAllWithTldtp1(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getTldtp1ParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Tldtp2/{limit}") 
	public  List<ScadaDataEntity> findAllWithTldtp2(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getTldtp2ParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/Tldtp3/{limit}") 
	public  List<ScadaDataEntity> findAllWithTldtp3(@PathVariable("limit") int limit) {
		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findByDdeItem (parameterNames.getTldtp3ParameterName(),getPageRequest(limit));
		return scadaEntityList;
	}





	//	@CrossOrigin(allowCredentials="true")
	//	@GetMapping(value = "/scadadata/dateS/{date}") 
	//	public  List<ScadaDataEntity> findAllWithdateS(@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date) {
	//		List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findAllWithdateS(date);
	//		return scadaEntityList; 
	//	}


}
