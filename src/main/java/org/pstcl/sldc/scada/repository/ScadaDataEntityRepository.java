package org.pstcl.sldc.scada.repository;

import java.time.LocalDate;
import java.util.List;

import org.pstcl.sldc.scada.model.ScadaDataEntity;
import org.pstcl.sldc.scada.model.ScadaEntityId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel="scadadata",path="scadadata")
public interface ScadaDataEntityRepository extends PagingAndSortingRepository<ScadaDataEntity, ScadaEntityId> {
	
	
	@Override
    @RestResource(exported = false)
    public List<ScadaDataEntity> findAll();
	
	

	@RestResource(exported = false)
    @Query(value="select entity from ScadaDataEntity entity where entity.entityId.dateS >= :dateS")
    List<ScadaDataEntity> findAllWithdateS(@Param("dateS") LocalDate dateS);
	//@DateTimeFormat(pattern="yyyy-MM-dd")@Param("dateS")
	
	
//	@RestResource(exported = false)
//    @Query("select entity from ScadaDataEntity entity where entity.entityId.dateS >= :dateS")
//    List<ScadaDataEntity> findAllWithdateS(
//    		@DateTimeFormat(pattern="yyyy-MM-dd")    		@Param("dateS") LocalDate dateS);
//	

//  
	
	
	@RestResource(exported = false)
	@Query(value="SELECT obj from ScadaDataEntity obj where obj.entityId.ddeItem = :ddeItem ")
	List<ScadaDataEntity> findByDdeItem(@Param("ddeItem") String ddeItem, Pageable pageable);

	
	@RestResource(exported = false)
	@Query(value="SELECT entity from ScadaDataEntity entity where entity.entityId.ddeItem = '*/Rate=10'")
	List<ScadaDataEntity> findAllWithFrequency(@Param("limit") int limit);
	
	
	@RestResource(exported = false)
	@Query(value="SELECT entity from ScadaDataEntity entity where entity.entityId.ddeItem = 'nrldc_pg.line.pseb_drwl.mw/rate=10' ")
	List <ScadaDataEntity> findAllDrawal(@Param("limit") int limit);
	
	@RestResource(exported = false)
	@Query(value="SELECT entity from ScadaDataEntity entity where entity.entityId.ddeItem = 'nrldc_pg.shdl.pseb_s.mw/rate=10' ")
	List <ScadaDataEntity> findAllSchedule(@Param("limit") int limit);
	
	@RestResource(exported = false)
	@Query(value="SELECT entity from ScadaDataEntity entity where entity.entityId.ddeItem = 'nrldc_pg.line.pseb_od_ud.mw/rate=10' ")
	List <ScadaDataEntity> findAllOD_UD(@Param("limit") int limit);
	
	@RestResource(exported = false)
	@Query(value="SELECT entity from ScadaDataEntity entity where entity.entityId.ddeItem = 'nrldc_pg.ld.pseb_load.mw/rate=10' ")
	List <ScadaDataEntity> findAllLoad(@Param("limit") int limit);
}
