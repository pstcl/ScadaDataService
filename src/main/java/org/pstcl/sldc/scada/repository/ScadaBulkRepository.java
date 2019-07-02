package org.pstcl.sldc.scada.repository;

import java.time.LocalDateTime;

import org.pstcl.sldc.scada.model.ScadaMap;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ScadaBulkRepository extends PagingAndSortingRepository<ScadaMap, LocalDateTime> {


}
