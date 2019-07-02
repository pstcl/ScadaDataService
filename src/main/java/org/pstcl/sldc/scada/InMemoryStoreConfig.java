package org.pstcl.sldc.scada;

import java.util.LinkedHashSet;
import java.util.Set;

import org.pstcl.sldc.scada.model.ScadaDataEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InMemoryStoreConfig {

	@Bean(name = "odudList")
	public Set<ScadaDataEntity> odudList() {
		return new LinkedHashSet<ScadaDataEntity>();
	}

	@Bean(name = "loadList")
	public Set<ScadaDataEntity> loadList() {
		return new LinkedHashSet<ScadaDataEntity>();
	}

	@Bean(name = "scheduleList")
	public Set<ScadaDataEntity> scheduleList() {
		return new LinkedHashSet<ScadaDataEntity>();
	}

	@Bean(name = "drawalList")
	public Set<ScadaDataEntity> drawalList() {
		return new LinkedHashSet<ScadaDataEntity>();
	}

	@Bean(name = "frequencyList")
	public Set<ScadaDataEntity> frequencyList() {
		return new LinkedHashSet<ScadaDataEntity>();
	}

}
