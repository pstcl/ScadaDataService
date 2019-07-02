package org.pstcl.sldc.scada.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.pstcl.sldc.scada.model.LatestDynamicData;
import org.pstcl.sldc.scada.model.ScadaDataEntity;
import org.pstcl.sldc.scada.model.ScadaDataHolder;
import org.pstcl.sldc.scada.model.ScadaMap;
import org.pstcl.sldc.scada.repository.ScadaBulkRepository;
import org.pstcl.sldc.scada.repository.ScadaDataEntityRepository;
import org.pstcl.sldc.scada.util.ExcelParameterNameProperties;
import org.pstcl.sldc.scada.util.GlobalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
public class ExcelService {

	public List<ScadaDataEntity> getOdudList() {
		return odudList;
	}

	private Pageable getPageRequest(int limit) {
		Pageable pageRequest = PageRequest.of(0, limit,
				Sort.by("entityId.dateS").descending().and(Sort.by("entityId.timeS").descending()));
		return pageRequest;

	}
	void initialiseLists()
	{
		Integer limit= parameterNames.getListInitSize();
		frequencyList.addAll(repository.findByDdeItem(parameterNames.getFrequencyParameterName(), getPageRequest(limit)));
		drawalList.addAll(repository.findByDdeItem(parameterNames.getDrawalParameterName(), getPageRequest(limit)));
		scheduleList.addAll(repository.findByDdeItem(parameterNames.getScheduleParameterName(), getPageRequest(limit)));
		odudList.addAll(repository.findByDdeItem(parameterNames.getOdudParameterName(), getPageRequest(limit)));
		loadList.addAll(repository.findByDdeItem(parameterNames.getLoadParameterName(), getPageRequest(limit)));
	}



	public void setOdudList(List<ScadaDataEntity> odudList) {
		this.odudList = odudList;
	}




	public List<ScadaDataEntity> getLoadList() {
		return loadList;
	}




	public void setLoadList(List<ScadaDataEntity> loadList) {
		this.loadList = loadList;
	}




	public List<ScadaDataEntity> getScheduleList() {
		return scheduleList;
	}




	public void setScheduleList(List<ScadaDataEntity> scheduleList) {
		this.scheduleList = scheduleList;
	}




	public List<ScadaDataEntity> getDrawalList() {
		return drawalList;
	}




	public void setDrawalList(List<ScadaDataEntity> drawalList) {
		this.drawalList = drawalList;
	}




	public List<ScadaDataEntity> getFrequencyList() {
		return frequencyList;
	}




	public void setFrequencyList(List<ScadaDataEntity> frequencyList) {
		this.frequencyList = frequencyList;
	}




	@Autowired
	@Qualifier("odudList")
	protected List<ScadaDataEntity> odudList;

	@Autowired
	@Qualifier("loadList")
	protected List<ScadaDataEntity> loadList;

	@Autowired
	@Qualifier("scheduleList")
	protected List<ScadaDataEntity> scheduleList;

	@Autowired
	@Qualifier("drawalList")
	protected List<ScadaDataEntity> drawalList;

	@Autowired
	@Qualifier("frequencyList")
	protected List<ScadaDataEntity> frequencyList;



	@Autowired
	protected GlobalProperties globalProperties;


	@Autowired
	protected ExcelParameterNameProperties parameterNames;


	@Autowired
	protected ScadaDataEntityRepository repository;


	@Autowired
	protected ScadaBulkRepository scadaBulkRepository;


	public LatestDynamicData getLatestDynamicData() {
		File fileToRead = null;
		LatestDynamicData dynamicData=null;


		try
		{
			dynamicData= new LatestDynamicData();
			fileToRead=getFileCopy();
			List<ScadaDataEntity> list= readExcel(fileToRead);

			for (ScadaDataEntity scadaDataEntity : list) {

				if(scadaDataEntity.getDdeItem().equalsIgnoreCase(parameterNames.getFrequencyParameterName()))
				{
					dynamicData.setFrequencyHz(scadaDataEntity.getValue());

				}
				if(scadaDataEntity.getDdeItem().equalsIgnoreCase(parameterNames.getDrawalParameterName()))
				{
					dynamicData.setDrawalMW(scadaDataEntity.getValue());

				}
				if(scadaDataEntity.getDdeItem().equalsIgnoreCase(parameterNames.getLoadParameterName()))
				{
					dynamicData.setLoadMW(scadaDataEntity.getValue());
				}
				if(scadaDataEntity.getDdeItem().equalsIgnoreCase(parameterNames.getScheduleParameterName()))
				{
					dynamicData.setScheduleMW(scadaDataEntity.getValue());
				}
				if(scadaDataEntity.getDdeItem().equalsIgnoreCase(parameterNames.getOdudParameterName()))
				{
					dynamicData.setOdUD(scadaDataEntity.getValue());
					LocalDate localDate=scadaDataEntity.getDateS();
					LocalTime localTime=scadaDataEntity.getTimeS();
					LocalDateTime dateTime= LocalDateTime.of(localDate, localTime);
					dynamicData.setUpdateDate(dateTime);

				}

			}
		}	
		catch(Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			deleteFile(fileToRead);

		}


		deleteFile(fileToRead);
		return dynamicData;
	}




	@Scheduled(fixedRate = 30*1000)
	public void scheduleFixedRateTask() {

		File fileToRead=getFileCopy();
		ScadaDataHolder dataHolder=readExcelToScadaDataHolder(fileToRead);


		ScadaDataEntity loadEntity= dataHolder.getScadaMap().get(parameterNames.getLoadParameterName());
		if(loadEntity!=null)
		{
			ScadaMap scadaMap=new ScadaMap();
			scadaMap.setScadaMap(dataHolder.getScadaMap());

			scadaMap.setExcelAccessTime(loadEntity.getChartDate());
			scadaBulkRepository.save(scadaMap);
		}
		repository.saveAll(dataHolder.getDataEntities());
		if(frequencyList.size()<10)
		{
			initialiseLists();
		}


		ScadaDataEntity frequencyEntity= dataHolder.getScadaMap().get(parameterNames.getFrequencyParameterName());
		ScadaDataEntity odudEntity= dataHolder.getScadaMap().get(parameterNames.getOdudParameterName());
		ScadaDataEntity scheduleEntity= dataHolder.getScadaMap().get(parameterNames.getScheduleParameterName());
		ScadaDataEntity drawalEntity= dataHolder.getScadaMap().get(parameterNames.getDrawalParameterName());

		if(frequencyEntity!=null)
		{
			frequencyList.add(frequencyEntity);
			frequencyList.remove(0);
		}
		if(loadEntity!=null)
		{

			loadList.add(loadEntity);
			loadList.remove(0);
		}
		if(odudEntity!=null)
		{

			odudList.add(odudEntity);
			odudList.remove(0);
		}
		if(drawalEntity!=null)
		{

			drawalList.add(drawalEntity);
			drawalList.remove(0);
		}
		if(scheduleEntity!=null)
		{
			scheduleList.add(scheduleEntity);
			scheduleList.remove(0);

		}

		deleteFile(fileToRead);
	}


	protected File getFileCopy()
	{
		File originalFile=new File(globalProperties.getFileLocation()+globalProperties.getFileName());
		String tempDirectoryName = globalProperties.getTempDirName() ;

		File tempDirectory = new File(tempDirectoryName);

		if (!tempDirectory.exists()) {
			tempDirectory.mkdirs();
			// If you require it to make the entire directory path including parents,
			// use directory.mkdirs(); here instead.
		}
		File tempFile = new File(tempDirectory, (System.currentTimeMillis())+originalFile.getName());
		Integer size=-1;
		try {
			size=FileCopyUtils.copy(originalFile, tempFile);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempFile;
	}


	protected Map<String,int[]> getColumnIndices(Sheet datatypeSheet, File fileToRead,Workbook wb)
	{
		Map<String,int[]> map=new HashMap<>();
		for (Row row : datatypeSheet) {

			for (Cell cell : row) {

				if (cell.getCellType() == CellType.STRING) {
					if (cell.getRichStringCellValue().getString().trim().equals("DdeItem")) 
					{
						int[] array={cell.getColumnIndex(),cell.getRowIndex()};
						map.put(cell.getRichStringCellValue().getString().trim(), array);

					}

					if (cell.getRichStringCellValue().getString().trim().equals("PointsID")) 
					{

						int[] array={cell.getColumnIndex(),cell.getRowIndex()};
						map.put(cell.getRichStringCellValue().getString().trim(), array);
					}

					if (cell.getRichStringCellValue().getString().trim().equals("DateS")) 
					{

						int[] array={cell.getColumnIndex(),cell.getRowIndex()};
						map.put(cell.getRichStringCellValue().getString().trim(), array);
					}

					if (cell.getRichStringCellValue().getString().trim().equals("TimeS")) 
					{

						int[] array={cell.getColumnIndex(),cell.getRowIndex()};
						map.put(cell.getRichStringCellValue().getString().trim(), array);
					}
					if (cell.getRichStringCellValue().getString().trim().equals("Time")) 
					{

						int[] array={cell.getColumnIndex(),cell.getRowIndex()};

						map.put(cell.getRichStringCellValue().getString().trim(), array);
					}
					if (cell.getRichStringCellValue().getString().trim().equals("Value")) 
					{

						int[] array={cell.getColumnIndex(),cell.getRowIndex()};
						map.put(cell.getRichStringCellValue().getString().trim(), array);
					}
					if (cell.getRichStringCellValue().getString().trim().equals("Flag")) 
					{

						int[] array={cell.getColumnIndex(),cell.getRowIndex()};
						map.put(cell.getRichStringCellValue().getString().trim(), array);
					}
				}
			}
		}
		return map;

	}

	public ScadaDataHolder readExcelToScadaDataHolder(File fileToRead) {
		ScadaDataHolder dataHolder=new ScadaDataHolder();
		List<ScadaDataEntity> list=new ArrayList();
		HashMap<String, ScadaDataEntity> map = new HashMap();
		FileInputStream inputStream=null;
		try {
			inputStream = new FileInputStream(fileToRead);
			Workbook workbook = new XSSFWorkbook(inputStream);
			//workbook.getSettings().setRegion(CountryCode.INDIA); 
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Map<String,int[]> columnIndices= getColumnIndices(datatypeSheet,fileToRead,workbook);

			if(columnIndices!=null&&!columnIndices.isEmpty())
			{
				for (Row row : datatypeSheet) {
					ScadaDataEntity scadaEntity= getRowScadaEntity( columnIndices, row);

					if(null!=scadaEntity)
					{
						list.add(scadaEntity);
						map.put(scadaEntity.getDdeItem().toLowerCase().replace('.', '`'),scadaEntity);

					}

				}

			}
			dataHolder.setDataEntities(list);
			dataHolder.setScadaMap(map);
			inputStream.close();
			return dataHolder;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dataHolder;


	}



	public List<ScadaDataEntity> readExcel(File fileToRead) {
		List<ScadaDataEntity> list=new ArrayList();
		FileInputStream inputStream=null;
		try {
			inputStream = new FileInputStream(fileToRead);
			Workbook workbook = new XSSFWorkbook(inputStream);
			//workbook.getSettings().setRegion(CountryCode.INDIA); 
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Map<String,int[]> columnIndices= getColumnIndices(datatypeSheet,fileToRead,workbook);

			if(columnIndices!=null&&!columnIndices.isEmpty())
			{
				for (Row row : datatypeSheet) {
					ScadaDataEntity scadaEntity= getRowScadaEntity( columnIndices, row);

					if(null!=scadaEntity)
					{
						list.add(scadaEntity);
					}
				}
			}
			inputStream.close();
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;


	}



	public LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDateTime();
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




	public HashMap<String, ScadaDataEntity> readExcelToHashMap(File fileToRead) {
		HashMap<String, ScadaDataEntity> list = new HashMap();
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(fileToRead);
			Workbook workbook = new XSSFWorkbook(inputStream);
			// workbook.getSettings().setRegion(CountryCode.INDIA);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Map<String, int[]> columnIndices = getColumnIndices(datatypeSheet, fileToRead, workbook);

			if (columnIndices != null && !columnIndices.isEmpty()) {

				for (Row row : datatypeSheet) {
					ScadaDataEntity scadaEntity= getRowScadaEntity( columnIndices, row);
					if(scadaEntity!=null)
					{
						list.put(scadaEntity.getDdeItem().toLowerCase(),scadaEntity);
					}
				}
			}

			inputStream.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}




	private ScadaDataEntity getRowScadaEntity(Map<String, int[]> columnIndices, Row row) {

		ScadaDataEntity entity=null;
		try {
			if (row.getRowNum() != columnIndices.get("DdeItem")[1]
					&& row.getCell(columnIndices.get("DdeItem")[0]) != null
					&& row.getCell(columnIndices.get("DdeItem")[0]).getCellType() != CellType.BLANK) {
				entity = new ScadaDataEntity();
				if (null != row.getCell(columnIndices.get("DdeItem")[0])) {
					entity.setDdeItem(row.getCell(columnIndices.get("DdeItem")[0]).getStringCellValue());
				}
				if (null != row.getCell(columnIndices.get("PointsID")[0])) {
					entity.setPointID(row.getCell(columnIndices.get("PointsID")[0]).getStringCellValue());

				} else {
					entity.setPointID(" ");
				}
				if (null != row.getCell(columnIndices.get("DateS")[0])) {

					DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					Date dateS = new Date(formatter
							.parse(row.getCell(columnIndices.get("DateS")[0]).getStringCellValue()).getTime());
					entity.setDateS(LocalDate
							.from(Instant.ofEpochMilli(dateS.getTime()).atZone(ZoneId.systemDefault())));
				}
				if (null != row.getCell(columnIndices.get("TimeS")[0])) {

					DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
					// java.sql.Time timeValue = new
					// java.sql.Time(formatter.parse(row.getCell(columnIndices.get("TimeS")[0]).getStringCellValue()).getTime());
					entity.setTimeS(
							LocalTime.parse(row.getCell(columnIndices.get("TimeS")[0]).getStringCellValue()));
				}
				if (null != row.getCell(columnIndices.get("Time")[0])) {

					if (row.getCell(columnIndices.get("Time")[0]).getCellType() == CellType.NUMERIC) {
						entity.setDateTimeWrongFormat(
								row.getCell(columnIndices.get("Time")[0]).getDateCellValue());
					}

				}
				if (null != row.getCell(columnIndices.get("Value")[0])) {
					entity.setValue(
							new BigDecimal(row.getCell(columnIndices.get("Value")[0]).getNumericCellValue()));
				}
				if (null != row.getCell(columnIndices.get("Flag")[0])) {
					entity.setFlag(row.getCell(columnIndices.get("Flag")[0]).getStringCellValue());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return entity;

	}




}
