package org.pstcl.sldc.scada.service;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;

import org.pstcl.sldc.scada.model.LatestDynamicData;
import org.pstcl.sldc.scada.model.NRGeneration;
import org.pstcl.sldc.scada.model.PunjabOwnGenerationModel;
import org.pstcl.sldc.scada.model.entity.ScadaDataEntity;
import org.springframework.stereotype.Service;

@Service
public class LiveDataExcelService extends  ExcelService {


	public LatestDynamicData getLatestDynamicData(File fileToRead) {

		LatestDynamicData dynamicData = null;
		try {
			dynamicData = new LatestDynamicData();

			HashMap<String, ScadaDataEntity> map = readExcelToHashMap(fileToRead);

			ScadaDataEntity scadaDataEntity = map.get(parameterNames.getFrequencyParameterName().toLowerCase());
			dynamicData.setFrequencyHz(scadaDataEntity.getValue());

			scadaDataEntity = map.get(parameterNames.getDrawalParameterName().toLowerCase());
			dynamicData.setDrawalMW(scadaDataEntity.getValue());

			scadaDataEntity = map.get(parameterNames.getLoadParameterName().toLowerCase());
			dynamicData.setLoadMW(scadaDataEntity.getValue());

			scadaDataEntity = map.get(parameterNames.getScheduleParameterName().toLowerCase());
			dynamicData.setScheduleMW(scadaDataEntity.getValue());
			scadaDataEntity = map.get(parameterNames.getOdudParameterName().toLowerCase());

			dynamicData.setOdUD(scadaDataEntity.getValue());
			LocalDate localDate = scadaDataEntity.getDateS();
			LocalTime localTime = scadaDataEntity.getTimeS();

			LocalDateTime dateTime = LocalDateTime.of(localDate, localTime);

			// Date date = new
			// Date(localDate.getYear(),localDate.getMonthValue(),localDate.getDayOfMonth(),localTime.getHour(),localTime.getMinute(),
			// localTime.getSecond());
			dynamicData.setUpdateDate(dateTime);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		return dynamicData;
	}


	public PunjabOwnGenerationModel getPunjabGenData2(File fileToRead) {

		PunjabOwnGenerationModel ownGenerationModel = null;

		try {
			ownGenerationModel = new PunjabOwnGenerationModel();

			HashMap<String, ScadaDataEntity> list = readExcelToHashMap(fileToRead);

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

			ownGenerationModel.setResSolar(list.get(parameterNames.getTotalSOLARGenerationParameter().toLowerCase()));
			ownGenerationModel.setResNonSolar(list.get(parameterNames.getTotalNonSOLARGenerationParameter().toLowerCase()));
			ownGenerationModel.setTotalResGeneration(list.get(parameterNames.getTotalResGenParameter().toLowerCase()));
			ownGenerationModel.calculateGrossGeneration();
		} catch (Exception e) {
			e.printStackTrace();

		} 
		return ownGenerationModel;
	}


	public NRGeneration getNRGeneration(File fileToRead ) {

		NRGeneration nrGenerationModel = null;

		try {
			nrGenerationModel = new NRGeneration();

			HashMap<String, ScadaDataEntity> list = readExcelToHashMap(fileToRead);

			nrGenerationModel.setChd_drwl(list.get(parameterNames.getChd_drwlParameterName().toLowerCase()));
			nrGenerationModel.setChd_load(list.get(parameterNames.getChd_loadParameterName().toLowerCase()));
			nrGenerationModel.setChd_odud(list.get(parameterNames.getChd_odudParameterName().toLowerCase()));
			nrGenerationModel.setChd_sch(list.get(parameterNames.getChd_schParameterName().toLowerCase()));
			nrGenerationModel.setDelhi_drwl(list.get(parameterNames.getDelhi_drwlParameterName().toLowerCase()));
			nrGenerationModel.setDelhi_load(list.get(parameterNames.getDelhi_loadParameterName().toLowerCase()));
			nrGenerationModel.setDelhi_odud(list.get(parameterNames.getDelhi_odudParameterName().toLowerCase()));
			nrGenerationModel.setDelhi_sch(list.get(parameterNames.getDelhi_schParameterName().toLowerCase()));
			nrGenerationModel.setHaryana_drwl(list.get(parameterNames.getHaryana_drwlParameterName().toLowerCase()));
			nrGenerationModel.setHaryana_load(list.get(parameterNames.getHaryana_loadParameterName().toLowerCase()));
			nrGenerationModel.setHaryana_odud(list.get(parameterNames.getHaryana_odudParameterName().toLowerCase()));
			nrGenerationModel.setHaryana_sch(list.get(parameterNames.getHaryana_schParameterName().toLowerCase()));
			nrGenerationModel.setHp_drwl(list.get(parameterNames.getHp_drwlParameterName().toLowerCase()));
			nrGenerationModel.setHp_load(list.get(parameterNames.getHp_loadParameterName().toLowerCase()));
			nrGenerationModel.setHp_odud(list.get(parameterNames.getHp_odudParameterName().toLowerCase()));
			nrGenerationModel.setHp_sch(list.get(parameterNames.getHp_schParameterName().toLowerCase()));
			nrGenerationModel.setJk_drwl(list.get(parameterNames.getJk_drwlParameterName().toLowerCase()));
			nrGenerationModel.setJk_load(list.get(parameterNames.getJk_loadParameterName().toLowerCase()));
			nrGenerationModel.setJk_odud(list.get(parameterNames.getJk_odudParameterName().toLowerCase()));
			nrGenerationModel.setJk_sch(list.get(parameterNames.getJk_schParameterName().toLowerCase()));
			nrGenerationModel.setPun_drwl(list.get(parameterNames.getDrawalParameterName().toLowerCase()));
			nrGenerationModel.setPun_load(list.get(parameterNames.getLoadParameterName().toLowerCase()));
			nrGenerationModel.setPun_odud(list.get(parameterNames.getOdudParameterName().toLowerCase()));
			nrGenerationModel.setPun_sch(list.get(parameterNames.getScheduleParameterName().toLowerCase()));
			nrGenerationModel.setRaj_drwl(list.get(parameterNames.getRaj_drwlParameterName().toLowerCase()));
			nrGenerationModel.setRaj_load(list.get(parameterNames.getRaj_loadParameterName().toLowerCase()));
			nrGenerationModel.setRaj_odud(list.get(parameterNames.getRaj_odudParameterName().toLowerCase()));
			nrGenerationModel.setRaj_sch(list.get(parameterNames.getRaj_schParameterName().toLowerCase()));
			nrGenerationModel.setUk_drwl(list.get(parameterNames.getUk_drwlParameterName().toLowerCase()));
			nrGenerationModel.setUk_load(list.get(parameterNames.getUk_loadParameterName().toLowerCase()));
			nrGenerationModel.setUk_odud(list.get(parameterNames.getUk_odudParameterName().toLowerCase()));
			nrGenerationModel.setUk_sch(list.get(parameterNames.getUk_schParameterName().toLowerCase()));
			nrGenerationModel.setUp_drwl(list.get(parameterNames.getUp_drwlParameterName().toLowerCase()));
			nrGenerationModel.setUp_load(list.get(parameterNames.getUp_loadParameterName().toLowerCase()));
			nrGenerationModel.setUp_odud(list.get(parameterNames.getUp_odudParameterName().toLowerCase()));
			nrGenerationModel.setUp_sch(list.get(parameterNames.getUp_schParameterName().toLowerCase()));


		} catch (Exception e) {
			e.printStackTrace();

		}
		return nrGenerationModel;
	}




}
