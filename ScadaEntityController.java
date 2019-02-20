package org.pstcl.sldc.scada.controller;


import java.time.LocalDate;
import java.util.List;
import org.pstcl.sldc.scada.model.ScadaDataEntity;
import org.pstcl.sldc.scada.repository.ScadaDataEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ScadaEntityController {

	@Autowired
	private  ScadaDataEntityRepository scadaDataEntityRepository;
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/dateS/{date}") 
    public  List<ScadaDataEntity> findAllWithdateS(@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date) {
        List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findAllWithdateS(date);
        return scadaEntityList; 
    }

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/frequency/{limit}") 
    public  List<ScadaDataEntity> findAllWithFrequency(@PathVariable("limit") int limit) {
        List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findAllWithFrequency(limit);
        return scadaEntityList;
    }

	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/drawal/{limit}") 
	public  List<ScadaDataEntity> findAllDrawal(@PathVariable("limit") int limit) {
        List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findAllDrawal(limit);
        return scadaEntityList; 
    }
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/schedule/{limit}") 
    public  List<ScadaDataEntity> findAllSchedule(@PathVariable("limit") int limit) {
        List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findAllSchedule(limit);
            return scadaEntityList; 
    }
	
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/findAll/{limit}") 
    public  List<ScadaDataEntity> findAllData(@PathVariable("limit") int limit) {
        List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findAllWithFrequency(limit);
        scadaEntityList.addAll(scadaDataEntityRepository.findAllDrawal(limit));
        scadaEntityList.addAll(scadaDataEntityRepository.findAllSchedule(limit));
        scadaEntityList.addAll(scadaDataEntityRepository.findAllOD_UD(limit));
        scadaEntityList.addAll(scadaDataEntityRepository.findAllLoad(limit));
            return scadaEntityList; 
    }
	
	
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/od_ud/{limit}") 
	public  List<ScadaDataEntity> findAllOD_UD(@PathVariable("limit") int limit) {
        List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findAllOD_UD(limit);
        return scadaEntityList;
    }
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/scadadata/load/{limit}") 
	public  List<ScadaDataEntity> findAllLoad(@PathVariable("limit") int limit) {
        List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findAllLoad(limit);
       return scadaEntityList;
       }
	
}
