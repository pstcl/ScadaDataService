package org.pstcl.sldc.scada.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.pstcl.sldc.scada.model.ScadaDataEntity;
import org.pstcl.sldc.scada.model.ScadaEntityId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

@RepositoryRestResource(collectionResourceRel="scadadata",path="scadadata")
public interface ScadaDataEntityRepository extends PagingAndSortingRepository<ScadaDataEntity, ScadaEntityId> {
	
	
	@Override
    @RestResource(exported = false)
    public List<ScadaDataEntity> findAll();
	
	

	@RestResource(exported = false)
    @Query("select entity from ScadaDataEntity entity where entity.entityId.dateS >= :dateS")
    List<ScadaDataEntity> findAllWithdateS(
    		@DateTimeFormat(pattern="yyyy-MM-dd")    		@Param("dateS") LocalDate dateS);
	//@DateTimeFormat(pattern="yyyy-MM-dd")@Param("dateS")

//    @Query("select entity from ScadaDataEntity entity where entity.entityId.dateS >= :dateS")
//    List<ScadaDataEntity> findAllWithDdeitem(
//    		@DateTimeFormat(pattern="yyyy-MM-dd")@Param("dateS") Date dateS);
//	
//	
	
}
