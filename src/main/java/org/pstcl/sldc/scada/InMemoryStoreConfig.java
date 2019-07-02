package org.pstcl.sldc.scada;

import java.util.ArrayList;
import java.util.List;

import org.pstcl.sldc.scada.model.ScadaDataEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InMemoryStoreConfig {

	@Bean(name = "odudList")
	public List<ScadaDataEntity> odudList() {
		return new ArrayList<ScadaDataEntity>();
	}

	@Bean(name = "loadList")
	public List<ScadaDataEntity> loadList() {
		return new ArrayList<ScadaDataEntity>();
	}

	@Bean(name = "scheduleList")
	public List<ScadaDataEntity> scheduleList() {
		return new ArrayList<ScadaDataEntity>();
	}

	@Bean(name = "drawalList")
	public List<ScadaDataEntity> drawalList() {
		return new ArrayList<ScadaDataEntity>();
	}

	@Bean(name = "frequencyList")
	public List<ScadaDataEntity> frequencyList() {
		return new ArrayList<ScadaDataEntity>();
	}

}
