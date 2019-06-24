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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.pstcl.sldc.scada.model.PunjabOwnGenerationModel2;
import org.pstcl.sldc.scada.model.ScadaDataEntity;
import org.pstcl.sldc.scada.util.ExcelParameterNameProperties;
import org.pstcl.sldc.scada.util.GlobalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
public class LiveDataExcelService {

	@Autowired
	private GlobalProperties globalProperties;

	@Autowired
	private ExcelParameterNameProperties parameterNames;

	private File getFileCopy() {
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

//	public PunjabOwnGenerationModel getPunjabGenData() {
//		File fileToRead = null;
//		PunjabOwnGenerationModel ownGenerationModel = null;
//		
//		try {
//			ownGenerationModel = new PunjabOwnGenerationModel();
//			fileToRead = getFileCopy();
//			HashMap<String, ScadaDataEntity> list = readExcel(fileToRead);
//
//			ownGenerationModel.setHydroRSD1(list.get(parameterNames.getRsd1ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setHydroRSD2(list.get(parameterNames.getRsd2ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setHydroRSD3(list.get(parameterNames.getRsd3ParameterName().toLowerCase()).getValue());
//			
//			ownGenerationModel.setHydroRSD4ASHP1(list.get(parameterNames.getAshp1ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setHydroRSD4ASHP2(list.get(parameterNames.getAshp2ParameterName().toLowerCase()).getValue());
//
//			ownGenerationModel.setHydroRSD4MHP(list.get(parameterNames.getMphParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setHydroRSD4UBDC(list.get(parameterNames.getUbdcParameterName().toLowerCase()).getValue());
//
//			ownGenerationModel.setHydroShananJog1(list.get(parameterNames.getJoginder1ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setHydroShananJog2(list.get(parameterNames.getJoginder2ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setHydroShananJog3(list.get(parameterNames.getJoginder3ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setHydroShananJog4(list.get(parameterNames.getJoginder4ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setHydroShananJog5(list.get(parameterNames.getJoginder5ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setHydroShananJog6(list.get(parameterNames.getJoginder6ParameterName().toLowerCase()).getValue());
//
//			ownGenerationModel
//					.setHydroShanan(ownGenerationModel.getHydroShananJog1().add(ownGenerationModel.getHydroShananJog2())
//							.add(ownGenerationModel.getHydroShananJog3()).add(ownGenerationModel.getHydroShananJog4())
//							.add(ownGenerationModel.getHydroShananJog5()).add(ownGenerationModel.getHydroShananJog6()));
//
//			ownGenerationModel.setIppGVK1(list.get(parameterNames.getGvk1ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setIppGVK2(list.get(parameterNames.getGvk2ParameterName().toLowerCase()).getValue());
//
//			ownGenerationModel.setTotalIppGVK(ownGenerationModel.getIppGVK1().add(ownGenerationModel.getIppGVK2()));
//
//			ownGenerationModel.setIppRajpura1(list.get(parameterNames.getNpl1ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setIppRajpura2(list.get(parameterNames.getNpl2ParameterName().toLowerCase()).getValue());
//
//			ownGenerationModel
//					.setTotalIppRajpura(ownGenerationModel.getIppRajpura1().add(ownGenerationModel.getIppRajpura2()));
//
//			ownGenerationModel.setIppTalwandiSabo1(list.get(parameterNames.getTldtp1ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setIppTalwandiSabo2(list.get(parameterNames.getTldtp2ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setIppTalwandiSabo3(list.get(parameterNames.getTldtp3ParameterName().toLowerCase()).getValue());
//
//			ownGenerationModel.setTotalIppTalwandiSabo(ownGenerationModel.getIppTalwandiSabo1()
//					.add(ownGenerationModel.getIppTalwandiSabo2().add(ownGenerationModel.getIppTalwandiSabo3())));
//
//			ownGenerationModel.setThermalGGSSTPRopar1(list.get(parameterNames.getGgsstp1ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setThermalGGSSTPRopar2(list.get(parameterNames.getGgsstp2ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setThermalGGSSTPRopar3(list.get(parameterNames.getGgsstp3ParameterName().toLowerCase()).getValue());
//
//			ownGenerationModel.setThermalGGSSTPRopar4(list.get(parameterNames.getGgsstp4ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setThermalGGSSTPRopar5(list.get(parameterNames.getGgsstp5ParameterName().toLowerCase()).getValue());
//			ownGenerationModel.setThermalGGSSTPRopar6(list.get(parameterNames.getGgsstp6ParameterName().toLowerCase()).getValue());
//
//			ownGenerationModel
//					.setThermalGHTPLehraMohabbat1(list.get(parameterNames.getGhtp1ParameterName().toLowerCase()).getValue());
//			ownGenerationModel
//					.setThermalGHTPLehraMohabbat2(list.get(parameterNames.getGhtp2ParameterName().toLowerCase()).getValue());
//			ownGenerationModel
//					.setThermalGHTPLehraMohabbat3(list.get(parameterNames.getGhtp3ParameterName().toLowerCase()).getValue());
//			ownGenerationModel
//					.setThermalGHTPLehraMohabbat4(list.get(parameterNames.getGhtp4ParameterName().toLowerCase()).getValue());
//			// ownGenerationModel.setThermalGHTPLehraMohabbat5(list.get(parameterNames.getGhtp5ParameterName().toLowerCase()).getValue());
//			// ownGenerationModel.setThermalGHTPLehraMohabbat6(list.get(parameterNames.getGhtp6ParameterName().toLowerCase()).getValue());
//
//			ownGenerationModel.setTotalGGSSTPRopar(ownGenerationModel.getThermalGGSSTPRopar1()
//					.add(ownGenerationModel.getThermalGGSSTPRopar2()).add(ownGenerationModel.getThermalGGSSTPRopar3())
//					.add(ownGenerationModel.getThermalGGSSTPRopar4()).add(ownGenerationModel.getThermalGGSSTPRopar5())
//					.add(ownGenerationModel.getThermalGGSSTPRopar6()));
//
//			ownGenerationModel.setTotalGHTPLehraMohabbat(ownGenerationModel.getThermalGHTPLehraMohabbat1()
//					.add(ownGenerationModel.getThermalGHTPLehraMohabbat2())
//					.add(ownGenerationModel.getThermalGHTPLehraMohabbat3())
//					.add(ownGenerationModel.getThermalGHTPLehraMohabbat4()));
//
//			ownGenerationModel.setTotalRSD(ownGenerationModel.getHydroRSD1().add(ownGenerationModel.getHydroRSD2())
//					.add(ownGenerationModel.getHydroRSD3()));
//
//			ownGenerationModel.setTotalIpp(ownGenerationModel.getTotalIppRajpura()
//					.add(ownGenerationModel.getTotalIppGVK()).add(ownGenerationModel.getTotalIppTalwandiSabo()));
//
//			ownGenerationModel
//					.setTotalHydro(ownGenerationModel.getTotalRSD().add(ownGenerationModel.getHydroRSD4ASHP1())
//							.add(ownGenerationModel.getHydroRSD4ASHP2()).add(ownGenerationModel.getHydroRSD4MHP())
//							.add(ownGenerationModel.getHydroRSD4UBDC()).add(ownGenerationModel.getHydroShanan()));
//
//			ownGenerationModel
//					.setGrossGeneration(ownGenerationModel.getTotalHydro().add(ownGenerationModel.getTotalIpp())
//							.add(ownGenerationModel.getTotalThermal()).add(ownGenerationModel.getTotalResGeneration()));
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} finally {
//			deleteFile(fileToRead);
//
//		}
//
//		deleteFile(fileToRead);
//		return ownGenerationModel;
//	}


	public PunjabOwnGenerationModel2 getPunjabGenData2() {
		File fileToRead = null;
		PunjabOwnGenerationModel2 ownGenerationModel = null;
		
		try {
			ownGenerationModel = new PunjabOwnGenerationModel2();
			fileToRead = getFileCopy();
			HashMap<String, ScadaDataEntity> list = readExcel(fileToRead);

			ownGenerationModel.setHydroRSD1(list.get(parameterNames.getRsd1ParameterName().toLowerCase()));
			ownGenerationModel.setHydroRSD2(list.get(parameterNames.getRsd2ParameterName().toLowerCase()));
			ownGenerationModel.setHydroRSD3(list.get(parameterNames.getRsd3ParameterName().toLowerCase()));
			ownGenerationModel.setHydroRSD4(list.get(parameterNames.getRsd4ParameterName().toLowerCase()));
			
			ownGenerationModel.setHydroRSDASHP1(list.get(parameterNames.getAshp1ParameterName().toLowerCase()));
			ownGenerationModel.setHydroRSDASHP2(list.get(parameterNames.getAshp2ParameterName().toLowerCase()));

			ownGenerationModel.setHydroRSDMHP(list.get(parameterNames.getMphParameterName().toLowerCase()));

			ownGenerationModel.setHydroRSDUBDC(list.get(parameterNames.getUbdcParameterName().toLowerCase()));


			ownGenerationModel
					.setHydroShanan(list.get(parameterNames.getShananParameterName().toLowerCase()));
							
			ownGenerationModel.setIppGVK1(list.get(parameterNames.getGvk1ParameterName().toLowerCase()));
			ownGenerationModel.setIppGVK2(list.get(parameterNames.getGvk2ParameterName().toLowerCase()));

//			ownGenerationModel.setTotalIppGVK(ownGenerationModel.getIppGVK1().add(ownGenerationModel.getIppGVK2()));

			ownGenerationModel.setIppRajpura1(list.get(parameterNames.getNpl1ParameterName().toLowerCase()));
			ownGenerationModel.setIppRajpura2(list.get(parameterNames.getNpl2ParameterName().toLowerCase()));


			ownGenerationModel.setIppTalwandiSabo1(list.get(parameterNames.getTldtp1ParameterName().toLowerCase()));
			ownGenerationModel.setIppTalwandiSabo2(list.get(parameterNames.getTldtp2ParameterName().toLowerCase()));
			ownGenerationModel.setIppTalwandiSabo3(list.get(parameterNames.getTldtp3ParameterName().toLowerCase()));


			ownGenerationModel.setThermalGGSSTPRopar1(list.get(parameterNames.getGgsstp1ParameterName().toLowerCase()));
			ownGenerationModel.setThermalGGSSTPRopar2(list.get(parameterNames.getGgsstp2ParameterName().toLowerCase()));
			ownGenerationModel.setThermalGGSSTPRopar3(list.get(parameterNames.getGgsstp3ParameterName().toLowerCase()));

			ownGenerationModel.setThermalGGSSTPRopar4(list.get(parameterNames.getGgsstp4ParameterName().toLowerCase()));
			ownGenerationModel.setThermalGGSSTPRopar5(list.get(parameterNames.getGgsstp5ParameterName().toLowerCase()));
			ownGenerationModel.setThermalGGSSTPRopar6(list.get(parameterNames.getGgsstp6ParameterName().toLowerCase()));

			ownGenerationModel
					.setThermalGHTPLehraMohabbat1(list.get(parameterNames.getGhtp1ParameterName().toLowerCase()));
			ownGenerationModel
					.setThermalGHTPLehraMohabbat2(list.get(parameterNames.getGhtp2ParameterName().toLowerCase()));
			ownGenerationModel
					.setThermalGHTPLehraMohabbat3(list.get(parameterNames.getGhtp3ParameterName().toLowerCase()));
			ownGenerationModel
					.setThermalGHTPLehraMohabbat4(list.get(parameterNames.getGhtp4ParameterName().toLowerCase()));
			
			ownGenerationModel.setResSolar(list.get(parameterNames.getTotalSOLARGenerationParameter()));
			ownGenerationModel.setResNonSolar(list.get(parameterNames.getTotalNonSOLARGenerationParameter()));
			ownGenerationModel.setTotalResGeneration(list.get(parameterNames.getTotalResGenParameter()));
			ownGenerationModel.calculateGrossGeneration();
					} catch (Exception e) {
			e.printStackTrace();

		} finally {
			deleteFile(fileToRead);

		}

		deleteFile(fileToRead);
		return ownGenerationModel;
	}

	

	private Boolean deleteFile(File tempFile) {
		Boolean zipDeleted = false;
		try {
			zipDeleted = Files.deleteIfExists(tempFile.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return zipDeleted;
	}

	private Map<String, int[]> getColumnIndices(Sheet datatypeSheet, File fileToRead, Workbook wb) {
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

	public HashMap<String, ScadaDataEntity> readExcel(File fileToRead) {
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
					if (row.getRowNum() != columnIndices.get("DdeItem")[1]
							&& row.getCell(columnIndices.get("DdeItem")[0]) != null
							&& row.getCell(columnIndices.get("DdeItem")[0]).getCellType() != CellType.BLANK) {
						ScadaDataEntity entity = new ScadaDataEntity();
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
							//
							//
							//// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy
							// hh:mm:ss");
							//
							//
							//// row.getCell(columnIndices.get("Time")[0]).setCellType(CellType.STRING);
							//
							// String dateString;
							// try {
							// dateString= row.getCell(columnIndices.get("Time")[0]).getStringCellValue();
							//
							// }
							// catch (Exception e) {
							// //date = formatter.parse(s);
							// dateString=row.getCell(columnIndices.get("Time")[0]).getStringCellValue();
							// }
						}
						if (null != row.getCell(columnIndices.get("Value")[0])) {
							entity.setValue(
									new BigDecimal(row.getCell(columnIndices.get("Value")[0]).getNumericCellValue()));
						}
						if (null != row.getCell(columnIndices.get("Flag")[0])) {
							entity.setFlag(row.getCell(columnIndices.get("Flag")[0]).getStringCellValue());
						}

						list.put(entity.getDdeItem().toLowerCase(), entity);
					}

				}
			}

			inputStream.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

}
