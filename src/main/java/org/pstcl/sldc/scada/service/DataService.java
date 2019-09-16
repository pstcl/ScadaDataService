package org.pstcl.sldc.scada.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.ReportAsSingleViolation;

import org.pstcl.sldc.scada.model.LatestDynamicData;
import org.pstcl.sldc.scada.model.NRGeneration;
import org.pstcl.sldc.scada.model.PunjabOwnGenerationModel;
import org.pstcl.sldc.scada.model.entity.HistoricalDataEntity;
import org.pstcl.sldc.scada.model.entity.ScadaDataEntity;
import org.pstcl.sldc.scada.repository.HistoricalDataEntityRepository;
import org.pstcl.sldc.scada.repository.ScadaDataEntityRepository;
import org.pstcl.sldc.scada.util.ExcelParameterNameProperties;
import org.pstcl.sldc.scada.util.GlobalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
public class DataService {

	@Autowired
	private LiveDataExcelService excelService;

	@Autowired
	protected GlobalProperties globalProperties;

	@Autowired
	private ScadaDataEntityRepository scadaDataRepository;

	@Autowired
	private HistoricalDataEntityRepository historicalDataEntityRepository;

	@Autowired
	protected ExcelParameterNameProperties parameterNames;

	@Scheduled(cron = "0 14 5 * * *")
	public void deleteOldEntities() {

		List<ScadaDataEntity> entitiesToBeDeleted = scadaDataRepository.findAllWithDateSBefore(LocalDate.now());
		for (ScadaDataEntity scadaDataEntity : entitiesToBeDeleted) {
			scadaDataRepository.delete(scadaDataEntity);
		}
	}

	@Scheduled(fixedRate = 3000 * 1000)
	public void saveFileDataToRepoScheduled() {
		File fileToRead = getFileCopy();
		HashMap<String, ScadaDataEntity> map;
		map = excelService.readExcelToHashMap(fileToRead);
		saveScadaFrequentlyAccessibleData(map);
		saveHistoricalEntities(map);
		deleteFile(fileToRead);
	}

	private void saveHistoricalEntities(HashMap<String, ScadaDataEntity> list) {
		List<ScadaDataEntity> dataEntities = new ArrayList<>(list.values());
		List<HistoricalDataEntity> historicalEntities = new ArrayList<>();
		for (ScadaDataEntity scadaDataEntity : dataEntities) {
			HistoricalDataEntity historicalDataEntity = new HistoricalDataEntity(scadaDataEntity);
			historicalEntities.add(historicalDataEntity);
		}
		historicalDataEntityRepository.saveAll(historicalEntities);
	}

	private void saveScadaFrequentlyAccessibleData(HashMap<String, ScadaDataEntity> map) {
		try {


			ScadaDataEntity freqEntity = map.get(parameterNames.getFrequencyParameterName().toLowerCase());

			if (freqEntity != null) {
				scadaDataRepository.save(freqEntity);
			}
			ScadaDataEntity drawalEntity = map.get(parameterNames.getDrawalParameterName().toLowerCase());
			if (drawalEntity != null) {
				scadaDataRepository.save(drawalEntity);
			}
			ScadaDataEntity loadEntity = map.get(parameterNames.getLoadParameterName().toLowerCase());
			if (loadEntity != null) {
				scadaDataRepository.save(loadEntity);
			}

			ScadaDataEntity scheduleEntity = map.get(parameterNames.getScheduleParameterName().toLowerCase());
			if (scheduleEntity != null) {
				scadaDataRepository.save(scheduleEntity);
			}

			ScadaDataEntity odudEntity = map.get(parameterNames.getOdudParameterName().toLowerCase());
			if (odudEntity != null) {
				scadaDataRepository.save(odudEntity);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	protected Boolean deleteFile(File tempFile) {
		Boolean zipDeleted = false;
		try {
			zipDeleted = Files.deleteIfExists(tempFile.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return zipDeleted;
	}

	protected File getFileCopy() {
		File originalFile = new File(globalProperties.getFileLocation() + globalProperties.getFileName());
		String tempDirectoryName = globalProperties.getTempDirName();
		File tempDirectory = new File(tempDirectoryName);
		if (!tempDirectory.exists()) {
			tempDirectory.mkdirs();
			// If you require it to make the entire directory path including parents,
			// use directory.mkdirs(); here instead.
		}
		File tempFile = new File(tempDirectory, (System.currentTimeMillis()) + originalFile.getName());
		Integer size = -1;
		try {
			size = FileCopyUtils.copy(originalFile, tempFile);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempFile;

	}

	public LatestDynamicData getLatestDynamicData() {
		File fileToRead = null;
		LatestDynamicData dynamicData = null;
		try {
			fileToRead = getFileCopy();
			dynamicData = excelService.getLatestDynamicData(fileToRead);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			deleteFile(fileToRead);

		}
		deleteFile(fileToRead);
		return dynamicData;
	}

	public PunjabOwnGenerationModel getPunjabGenData2() {

		File fileToRead = null;
		PunjabOwnGenerationModel dynamicData = null;
		try {
			fileToRead = getFileCopy();
			dynamicData = excelService.getPunjabGenData2(fileToRead);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			deleteFile(fileToRead);

		}

		deleteFile(fileToRead);
		// TODO Auto-generated method stub
		return dynamicData;
	}

	public NRGeneration getNRGeneration() {
		File fileToRead = null;
		NRGeneration dynamicData = null;
		try {
			fileToRead = getFileCopy();
			dynamicData = excelService.getNRGeneration(fileToRead);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			deleteFile(fileToRead);

		}

		deleteFile(fileToRead);
		// TODO Auto-generated method stub
		return dynamicData;
	}

}
