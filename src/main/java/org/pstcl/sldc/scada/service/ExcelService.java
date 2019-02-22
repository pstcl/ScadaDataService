package org.pstcl.sldc.scada.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.pstcl.sldc.scada.model.ScadaDataEntity;
import org.pstcl.sldc.scada.repository.ScadaDataEntityRepository;
import org.pstcl.sldc.scada.util.GlobalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
public class ExcelService {

	@Autowired
	private GlobalProperties globalProperties;


	@Autowired
	ScadaDataEntityRepository repository;

	@Scheduled(fixedRate = 30*1000)
	public void scheduleFixedRateTask() {

		File fileToRead=getFileCopy();
		List<ScadaDataEntity> list;
		
		

		list= readExcel(fileToRead);
		//REMOVE THIS BLOCK BELOW
		//REMOVE THIS BLOCK BELOW
		//REMOVE THIS BLOCK BELOW
		//REMOVE THIS BLOCK BELOW
		for (ScadaDataEntity entity : list) {
			
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			
			Date dateS = new Date(System.currentTimeMillis());
			LocalDateTime localDateTime =convertToLocalDateTimeViaInstant(dateS);
		       
			entity.setDateS(localDateTime.toLocalDate());

			entity.setTimeS(localDateTime.toLocalTime());
			double random=(Math.random()/10) + .95;
			entity.setValue(entity.getValue().multiply(new BigDecimal(random)));
		}
		//REMOVE THIS BLOCK ABOVE

		//REMOVE THIS BLOCK ABOVE

		//REMOVE THIS BLOCK ABOVE
		
		repository.saveAll(list);
		deleteFile(fileToRead);

		//		for (ScadaDataEntity scadaEntity : list) {
		//			System.out.println(globalProperties.getFileLocation()+""+globalProperties.getFileName());
		//			
		//		}
	}


	private File getFileCopy()
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

	private Boolean deleteFile(File tempFile)
	{
		Boolean zipDeleted = false;
		try {
			zipDeleted = Files.deleteIfExists(tempFile.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return zipDeleted;
	}
	private Map<String,int[]> getColumnIndices(Sheet datatypeSheet, File fileToRead,Workbook wb)
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
					if(row.getRowNum()!=columnIndices.get("DdeItem")[1]
							&&row.getCell(columnIndices.get("DdeItem")[0])!= null 
							&& row.getCell(columnIndices.get("DdeItem")[0]).getCellType() != CellType.BLANK)
					{
						ScadaDataEntity entity=new ScadaDataEntity();
						if(null!=row.getCell(columnIndices.get("DdeItem")[0]))
						{
							entity.setDdeItem(row.getCell(columnIndices.get("DdeItem")[0]).getStringCellValue());
						}
						if(null!=row.getCell(columnIndices.get("PointsID")[0]))
						{
							entity.setPointID(row.getCell(columnIndices.get("PointsID")[0]).getStringCellValue());

						}
						else
						{
							entity.setPointID(" ");
						}
						if(null!=row.getCell(columnIndices.get("DateS")[0]))
						{

							DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
							Date dateS = new Date(formatter.parse(row.getCell(columnIndices.get("DateS")[0]).getStringCellValue()).getTime());
							entity.setDateS(LocalDate.from(Instant.ofEpochMilli(dateS.getTime()).atZone(ZoneId.systemDefault())));
						}
						if(null!=row.getCell(columnIndices.get("TimeS")[0]))
						{

							DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
							//java.sql.Time timeValue = new java.sql.Time(formatter.parse(row.getCell(columnIndices.get("TimeS")[0]).getStringCellValue()).getTime());
							entity.setTimeS(LocalTime.parse(row.getCell(columnIndices.get("TimeS")[0]).getStringCellValue()));
						}
						if(null!=row.getCell(columnIndices.get("Time")[0]))
						{

							if(row.getCell(columnIndices.get("Time")[0]).getCellType()==CellType.NUMERIC)
							{
								entity.setDateTimeWrongFormat(row.getCell(columnIndices.get("Time")[0]).getDateCellValue());
							}
							//
							//
							////							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
							//
							//
							////							row.getCell(columnIndices.get("Time")[0]).setCellType(CellType.STRING);
							//							
							//							String dateString;
							//							try {
							//								dateString= row.getCell(columnIndices.get("Time")[0]).getStringCellValue();
							//
							//							}
							//							catch (Exception e) {
							//								//date = formatter.parse(s);
							//								dateString=row.getCell(columnIndices.get("Time")[0]).getStringCellValue();
							//							}
						}
						if(null!=row.getCell(columnIndices.get("Value")[0]))
						{
							entity.setValue(new BigDecimal(row.getCell(columnIndices.get("Value")[0]).getNumericCellValue()));
						}
						if(null!=row.getCell(columnIndices.get("Flag")[0]))
						{
							entity.setFlag(row.getCell(columnIndices.get("Flag")[0]).getStringCellValue());
						}

						list.add(entity);
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

}
