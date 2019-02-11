package org.pstcl.sldc.scada.repository;

import org.pstcl.sldc.scada.model.ScadaDataEntity;
import org.pstcl.sldc.scada.model.ScadaEntity;
import org.pstcl.sldc.scada.model.ScadaEntityId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="scadadata",path="scadadata")
public interface ScadaDataEntityRepository extends CrudRepository<ScadaDataEntity, ScadaEntityId> {

}
