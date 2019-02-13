package org.pstcl.sldc.scada.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.pstcl.sldc.scada.model.ScadaDataEntity;
import org.pstcl.sldc.scada.repository.ScadaDataEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class ScadaEntityController {

	@Autowired
	private  ScadaDataEntityRepository scadaDataEntityRepository;
	
	@GetMapping(value = "/scadadata") 
    public @ResponseBody ResponseEntity<?> getScadaEntityList() {
       // List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findAll(new PageRequest(1, 100)).getContent(); 
        //
        // do some intermediate processing, logging, etc. with the producers
        //
		LocalDate date= LocalDate.of(2019,2, 3);   //		new Date(System.currentTimeMillis()-(1000*60*60*24*15));
		
		System.out.println(date);
        List<ScadaDataEntity> scadaEntityList = scadaDataEntityRepository.findAllWithdateS(date);
        Resources<ScadaDataEntity> resources = new Resources<ScadaDataEntity>(scadaEntityList); 

        resources.add(linkTo(methodOn(ScadaEntityController.class).getScadaEntityList()).withSelfRel()); 

        // add other links as needed

        return ResponseEntity.ok(resources); 
    }



}
