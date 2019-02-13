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
import org.pstcl.sldc.scada.model.ScadaDataEntity;
import org.pstcl.sldc.scada.repository.ScadaDataEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
public class ExcelService {


	@Autowired
	ScadaDataEntityRepository repository;

	@Scheduled(fixedRate = 5*60*1000)
	public void scheduleFixedRateTask() {

		File fileToRead=getFileCopy();
		List<ScadaDataEntity> list= readExcel(fileToRead);
		repository.saveAll(list);
		deleteFile(fileToRead);
		for (ScadaDataEntity scadaEntity : list) {
			System.out.println(scadaEntity);
		}
	}

	private static final String FILE_NAME = "E:\\scada-data\\scadadata.xlsm";

	private File getFileCopy()
	{
		File originalFile=new File(FILE_NAME);
		String tempDirectoryName = "E:\\SLDC_ENERGY_ACC\\Temp\\" ;

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
	private Map<String,int[]> getColumnIndices(Sheet datatypeSheet)
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
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Map<String,int[]> columnIndices= getColumnIndices(datatypeSheet);

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
							java.sql.Time timeValue = new java.sql.Time(formatter.parse(row.getCell(columnIndices.get("TimeS")[0]).getStringCellValue()).getTime());
							entity.setTimeS(timeValue);
						}
						if(null!=row.getCell(columnIndices.get("Time")[0]))
						{
						//	entity.setDateTimeWrongFormat(row.getCell(columnIndices.get("Time")[0]).getDateCellValue());
							
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
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			return list;
		}

	}





}
