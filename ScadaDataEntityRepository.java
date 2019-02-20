package org.pstcl.sldc.scada.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.pstcl.sldc.scada.model.ResultScada;
import org.pstcl.sldc.scada.model.ResultScadaValue;
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
    @Query(value="select * from scadadata4 where dateS >= :dateS",nativeQuery=true)
    List<ScadaDataEntity> findAllWithdateS(@Param("dateS") LocalDate dateS);
	//@DateTimeFormat(pattern="yyyy-MM-dd")@Param("dateS")


	@RestResource(exported = false)
	@Query(value="SELECT * from scadadata4 where ddeItem = '*/Rate=10'  ORDER BY dateS DESC,timeS DESC LIMIT :limit",nativeQuery=true)
	List<ScadaDataEntity> findAllWithFrequency(@Param("limit") int limit);
	
	
	@RestResource(exported = false)
	@Query(value="SELECT * from scadadata4 where ddeItem = 'nrldc_pg.line.pseb_drwl.mw/rate=10'  ORDER BY dateS DESC,timeS DESC LIMIT :limit",nativeQuery=true)
	List <ScadaDataEntity> findAllDrawal(@Param("limit") int limit);
	
	@RestResource(exported = false)
	@Query(value="SELECT * from scadadata4 where ddeItem = 'nrldc_pg.shdl.pseb_s.mw/rate=10'  ORDER BY dateS DESC,timeS DESC LIMIT :limit",nativeQuery=true)
	List <ScadaDataEntity> findAllSchedule(@Param("limit") int limit);
	
	@RestResource(exported = false)
	@Query(value="SELECT * from scadadata4 where ddeItem = 'nrldc_pg.line.pseb_od_ud.mw/rate=10'  ORDER BY dateS DESC,timeS DESC LIMIT :limit",nativeQuery=true)
	List <ScadaDataEntity> findAllOD_UD(@Param("limit") int limit);
	
	@RestResource(exported = false)
	@Query(value="SELECT * from scadadata4 where ddeItem = 'nrldc_pg.ld.pseb_load.mw/rate=10'  ORDER BY dateS DESC,timeS DESC LIMIT :limit",nativeQuery=true)
	List <ScadaDataEntity> findAllLoad(@Param("limit") int limit);
}
