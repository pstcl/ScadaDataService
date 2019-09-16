package org.pstcl.sldc.scada.service;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
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
import org.pstcl.sldc.scada.model.entity.ScadaDataEntity;
import org.pstcl.sldc.scada.util.ExcelParameterNameProperties;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ExcelService {


	@Autowired
	protected ExcelParameterNameProperties parameterNames;


	protected Map<String, int[]> getColumnIndices(Sheet datatypeSheet, File fileToRead, Workbook wb) {
		Map<String, int[]> map = new HashMap<>();
		for (Row row : datatypeSheet) {

			for (Cell cell : row) {

				if (cell.getCellType() == CellType.STRING) {
					if (cell.getRichStringCellValue().getString().trim().equals("DdeItem")) {
						int[] array = { cell.getColumnIndex(), cell.getRowIndex() };
						map.put(cell.getRichStringCellValue().getString().trim(), array);

					}

					if (cell.getRichStringCellValue().getString().trim().equals("PointsID")) {

						int[] array = { cell.getColumnIndex(), cell.getRowIndex() };
						map.put(cell.getRichStringCellValue().getString().trim(), array);
					}

					if (cell.getRichStringCellValue().getString().trim().equals("DateS")) {

						int[] array = { cell.getColumnIndex(), cell.getRowIndex() };
						map.put(cell.getRichStringCellValue().getString().trim(), array);
					}

					if (cell.getRichStringCellValue().getString().trim().equals("TimeS")) {

						int[] array = { cell.getColumnIndex(), cell.getRowIndex() };
						map.put(cell.getRichStringCellValue().getString().trim(), array);
					}
					if (cell.getRichStringCellValue().getString().trim().equals("Time")) {

						int[] array = { cell.getColumnIndex(), cell.getRowIndex() };

						map.put(cell.getRichStringCellValue().getString().trim(), array);
					}
					if (cell.getRichStringCellValue().getString().trim().equals("Value")) {

						int[] array = { cell.getColumnIndex(), cell.getRowIndex() };
						map.put(cell.getRichStringCellValue().getString().trim(), array);
					}
					if (cell.getRichStringCellValue().getString().trim().equals("Flag")) {

						int[] array = { cell.getColumnIndex(), cell.getRowIndex() };
						map.put(cell.getRichStringCellValue().getString().trim(), array);
					}
				}
			}
		}
		return map;

	}

//	public List<ScadaDataEntity> readExcel(File fileToRead) {
//		List<ScadaDataEntity> list = new ArrayList();
//		FileInputStream inputStream = null;
//		try {
//			inputStream = new FileInputStream(fileToRead);
//			Workbook workbook = new XSSFWorkbook(inputStream);
//			// workbook.getSettings().setRegion(CountryCode.INDIA);
//			Sheet datatypeSheet = workbook.getSheetAt(0);
//			Map<String, int[]> columnIndices = getColumnIndices(datatypeSheet, fileToRead, workbook);
//
//			if (columnIndices != null && !columnIndices.isEmpty()) {
//				for (Row row : datatypeSheet) {
//					ScadaDataEntity scadaEntity = getRowScadaEntity(columnIndices, row);
//
//					if (null != scadaEntity) {
//						list.add(scadaEntity);
//					}
//				}
//			}
//			inputStream.close();
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//
//	}

	public LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
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
					ScadaDataEntity scadaEntity = getRowScadaEntity(columnIndices, row);
					if (scadaEntity != null) {
						list.put(scadaEntity.getDdeItem().toLowerCase(), scadaEntity);
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

		ScadaDataEntity entity = null;
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
					Date dateS = new Date(
							formatter.parse(row.getCell(columnIndices.get("DateS")[0]).getStringCellValue()).getTime());
					entity.setDateS(
							LocalDate.from(Instant.ofEpochMilli(dateS.getTime()).atZone(ZoneId.systemDefault())));
				}
				if (null != row.getCell(columnIndices.get("TimeS")[0])) {

					DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
					// java.sql.Time timeValue = new
					// java.sql.Time(formatter.parse(row.getCell(columnIndices.get("TimeS")[0]).getStringCellValue()).getTime());
					entity.setTimeS(LocalTime.parse(row.getCell(columnIndices.get("TimeS")[0]).getStringCellValue()));
				}
				if (null != row.getCell(columnIndices.get("Time")[0])) {

					if (row.getCell(columnIndices.get("Time")[0]).getCellType() == CellType.NUMERIC) {
						entity.setDateTimeWrongFormat(row.getCell(columnIndices.get("Time")[0]).getDateCellValue());
					}

				}
				if (null != row.getCell(columnIndices.get("Value")[0])) {
					entity.setValue(new BigDecimal(row.getCell(columnIndices.get("Value")[0]).getNumericCellValue()));
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
