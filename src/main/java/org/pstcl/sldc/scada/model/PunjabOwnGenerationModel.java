package org.pstcl.sldc.scada.model;

import java.math.BigDecimal;

import org.pstcl.sldc.scada.model.entity.ScadaDataEntity;

public class PunjabOwnGenerationModel {



	private ScadaDataJsonPojo grossGeneration;



	private ScadaDataEntity hydroRSD1 ;

	private ScadaDataEntity hydroRSD2 ;

	private ScadaDataEntity hydroRSD3 ;

	private ScadaDataEntity hydroRSD4 ;

	private ScadaDataEntity hydroRSDASHP1 ;

	private ScadaDataEntity hydroRSDASHP2 ;

	private ScadaDataEntity hydroRSDMHP ;

	private ScadaDataEntity hydroRSDUBDC ;

	private ScadaDataEntity hydroShanan;

	private ScadaDataEntity hydroShananJog1;

	private ScadaDataEntity hydroShananJog2;

	private ScadaDataEntity hydroShananJog3;

	private ScadaDataEntity hydroShananJog4;

	private ScadaDataEntity hydroShananJog5;

	private ScadaDataEntity hydroShananJog6;

	private ScadaDataEntity ippGVK1;


	private ScadaDataEntity ippGVK2;

	private ScadaDataEntity ippGVK3;

	private ScadaDataEntity ippRajpura1;

	private ScadaDataEntity ippRajpura2;

	private ScadaDataEntity ippRajpura3;

	private ScadaDataEntity ippTalwandiSabo1;

	private ScadaDataEntity ippTalwandiSabo2;

	private ScadaDataEntity ippTalwandiSabo3;

	private ScadaDataEntity resNonSolar;
	private ScadaDataEntity resSolar;

	private ScadaDataEntity thermalGGSSTPRopar1;


	private ScadaDataEntity thermalGGSSTPRopar2;

	private ScadaDataEntity thermalGGSSTPRopar3;

	private ScadaDataEntity thermalGGSSTPRopar4;



	private ScadaDataEntity thermalGGSSTPRopar5;

	private ScadaDataEntity thermalGGSSTPRopar6;

	private ScadaDataEntity thermalGHTPLehraMohabbat1;

	private ScadaDataEntity thermalGHTPLehraMohabbat2;

	private ScadaDataEntity thermalGHTPLehraMohabbat3;

	private ScadaDataEntity thermalGHTPLehraMohabbat4;

	private ScadaDataEntity thermalGHTPLehraMohabbat5;

	private ScadaDataEntity thermalGHTPLehraMohabbat6;
	
	//totalGGSSTPRopar totalGHTPLehraMohabbat totalRSD totalIppRajpura totalIppTalwandiSabo totalIppGVK
	

	private ScadaDataEntity totalGGSSTPRopar;

	private ScadaDataEntity totalGHTPLehraMohabbat;

	private ScadaDataEntity totalHydro;

	private ScadaDataEntity totalIpp;

	private ScadaDataEntity totalIppGVK;

	private ScadaDataEntity totalIppRajpura;
	

	private ScadaDataEntity totalIppTalwandiSabo;

	private ScadaDataEntity totalResGeneration;



	private ScadaDataEntity totalRSD;



	private ScadaDataEntity totalThermal;



	public PunjabOwnGenerationModel() {
		super();
	}



	public void calculateGrossGeneration() {
		ScadaDataJsonPojo dataEntity=new ScadaDataJsonPojo();
		dataEntity.setValue(BigDecimal.ZERO);
		if(null!=this.getTotalResGeneration())
		dataEntity.setValue(dataEntity.getValue().add(this.getTotalResGeneration().getValue()));
		if(null!=this.calculateTotalHydro())
			
		dataEntity.setValue(dataEntity.getValue().add(this.calculateTotalHydro().getValue()));
		if(null!=this.calculateTotalThermal())
			
		dataEntity.setValue(dataEntity.getValue().add(this.calculateTotalThermal().getValue()));
		if(null!=this.calculateTotalIpp())
			
		dataEntity.setValue(dataEntity.getValue().add(this.calculateTotalIpp().getValue()));
		
		grossGeneration=dataEntity;
	}


	public ScadaDataEntity calculateTotalGGSSTPRopar() {
		ScadaDataEntity dataEntity=new ScadaDataEntity();
		dataEntity.setValue(BigDecimal.ZERO);
		if(null!=this.getThermalGGSSTPRopar1())
		dataEntity.setValue(dataEntity.getValue().add(this.getThermalGGSSTPRopar1().getValue()));
		if(null!=this.getThermalGGSSTPRopar2())
		dataEntity.setValue(dataEntity.getValue().add(this.getThermalGGSSTPRopar2().getValue()));
		if(null!=this.getThermalGGSSTPRopar3())
		dataEntity.setValue(dataEntity.getValue().add(this.getThermalGGSSTPRopar3().getValue()));
		if(null!=this.getThermalGGSSTPRopar4())
		dataEntity.setValue(dataEntity.getValue().add(this.getThermalGGSSTPRopar4().getValue()));
		if(null!=this.getThermalGGSSTPRopar5())
		dataEntity.setValue(dataEntity.getValue().add(this.getThermalGGSSTPRopar5().getValue()));
		if(null!=this.getThermalGGSSTPRopar6())
		dataEntity.setValue(dataEntity.getValue().add(this.getThermalGGSSTPRopar6().getValue()));
		this.totalGGSSTPRopar=dataEntity;
		return totalGGSSTPRopar;
	}

	public ScadaDataEntity calculateTotalGHTPLehraMohabbat() {
		ScadaDataEntity dataEntity=new ScadaDataEntity();
		dataEntity.setValue(BigDecimal.ZERO);
		if(null!=this.getThermalGHTPLehraMohabbat1())
		dataEntity.setValue(dataEntity.getValue().add(this.getThermalGHTPLehraMohabbat1().getValue()));
		if(null!=this.getThermalGHTPLehraMohabbat2())
			
		dataEntity.setValue(dataEntity.getValue().add(this.getThermalGHTPLehraMohabbat2().getValue()));
		if(null!=this.getThermalGHTPLehraMohabbat3())
			
		dataEntity.setValue(dataEntity.getValue().add(this.getThermalGHTPLehraMohabbat3().getValue()));
		if(null!=this.getThermalGHTPLehraMohabbat4())
			
		dataEntity.setValue(dataEntity.getValue().add(this.getThermalGHTPLehraMohabbat4().getValue()));
	//	dataEntity.setValue(dataEntity.getValue().add(this.getThermalGHTPLehraMohabbat5().getValue()));
	//	dataEntity.setValue(dataEntity.getValue().add(this.getThermalGHTPLehraMohabbat6().getValue()));

		this.totalGHTPLehraMohabbat=dataEntity;
		return totalGHTPLehraMohabbat;	}
	public ScadaDataEntity calculateTotalHydro() {
		ScadaDataEntity dataEntity=new ScadaDataEntity();
		dataEntity.setValue(BigDecimal.ZERO);
		if(null!=this.calculateTotalRSD())
		dataEntity.setValue(dataEntity.getValue().add(this.calculateTotalRSD().getValue()));
		if(null!=this.getHydroRSDASHP1())
		dataEntity.setValue(dataEntity.getValue().add(this.getHydroRSDASHP1().getValue()));
		if(null!=this.getHydroRSDASHP2())
		dataEntity.setValue(dataEntity.getValue().add(this.getHydroRSDASHP2().getValue()));
		if(null!=this.getHydroRSDMHP())
		dataEntity.setValue(dataEntity.getValue().add(this.getHydroRSDMHP().getValue()));
		if(null!=this.getHydroRSDUBDC())
		dataEntity.setValue(dataEntity.getValue().add(this.getHydroRSDUBDC().getValue()));
		if(null!=this.getHydroShanan())
		dataEntity.setValue(dataEntity.getValue().add(this.getHydroShanan().getValue()));

		this.totalHydro=dataEntity;
		return totalHydro;	
		
	}
	public ScadaDataEntity calculateTotalIpp() {
		ScadaDataEntity dataEntity=new ScadaDataEntity();
		dataEntity.setValue(BigDecimal.ZERO);
		if(null!=this.calculateTotalIppGVK())
		dataEntity.setValue(dataEntity.getValue().add(this.calculateTotalIppGVK().getValue()));
		if(null!=this.calculateTotalIppRajpura())dataEntity.setValue(dataEntity.getValue().add(this.calculateTotalIppRajpura().getValue()));
		if(null!=this.calculateTotalIppTalwandiSabo())	dataEntity.setValue(dataEntity.getValue().add(this.calculateTotalIppTalwandiSabo().getValue()));

		this.totalIpp=dataEntity;
		return totalIpp;	
	}



	public ScadaDataEntity calculateTotalIppGVK() {
		ScadaDataEntity dataEntity=new ScadaDataEntity();
		dataEntity.setValue(BigDecimal.ZERO);
		if(null!=this.getIppGVK1())dataEntity.setValue(dataEntity.getValue().add(this.getIppGVK1().getValue()));
		if(null!=this.getIppGVK2())dataEntity.setValue(dataEntity.getValue().add(this.getIppGVK2().getValue()));
		if(null!=this.getIppGVK3())dataEntity.setValue(dataEntity.getValue().add(this.getIppGVK3().getValue()));

		this.totalIppGVK=dataEntity;
		return dataEntity;

	}

	public ScadaDataEntity calculateTotalIppRajpura() {
		ScadaDataEntity dataEntity=new ScadaDataEntity();
		dataEntity.setValue(BigDecimal.ZERO);
		if(null!=this.getIppRajpura1())dataEntity.setValue(dataEntity.getValue().add(this.getIppRajpura1().getValue()));
		if(null!=this.getIppRajpura2())	dataEntity.setValue(dataEntity.getValue().add(this.getIppRajpura2().getValue()));
		if(null!=this.getIppRajpura3())	dataEntity.setValue(dataEntity.getValue().add(this.getIppRajpura3().getValue()));

		this.totalIppRajpura=dataEntity;
		return dataEntity;
	}

	public ScadaDataEntity calculateTotalIppTalwandiSabo() {
		ScadaDataEntity dataEntity=new ScadaDataEntity();
		dataEntity.setValue(BigDecimal.ZERO);
		if(null!=this.getIppTalwandiSabo1())dataEntity.setValue(dataEntity.getValue().add(this.getIppTalwandiSabo1().getValue()));
		if(null!=this.getIppTalwandiSabo2())dataEntity.setValue(dataEntity.getValue().add(this.getIppTalwandiSabo2().getValue()));
		if(null!=this.getIppTalwandiSabo3())dataEntity.setValue(dataEntity.getValue().add(this.getIppTalwandiSabo3().getValue()));

		this.totalIppTalwandiSabo=dataEntity;
		return dataEntity;
}

	public ScadaDataEntity calculateTotalRSD() {
		ScadaDataEntity dataEntity=new ScadaDataEntity();
		dataEntity.setValue(BigDecimal.ZERO);
		if(null!=this.getHydroRSD1())
		dataEntity.setValue(dataEntity.getValue().add(this.getHydroRSD1().getValue()));
		if(null!=this.getHydroRSD2())dataEntity.setValue(dataEntity.getValue().add(this.getHydroRSD2().getValue()));
		if(null!=this.getHydroRSD3())dataEntity.setValue(dataEntity.getValue().add(this.getHydroRSD3().getValue()));
		if(null!=this.getHydroRSD4())dataEntity.setValue(dataEntity.getValue().add(this.getHydroRSD4().getValue()));

		this.totalRSD=dataEntity;
		return dataEntity;

	}

	

	public ScadaDataEntity calculateTotalThermal() {
		ScadaDataEntity dataEntity=new ScadaDataEntity();
		dataEntity.setValue(BigDecimal.ZERO);
		dataEntity.setValue(dataEntity.getValue().add(this.calculateTotalGGSSTPRopar().getValue()));
		dataEntity.setValue(dataEntity.getValue().add(this.calculateTotalGHTPLehraMohabbat().getValue()));
		
		this.totalThermal=dataEntity;
		
		return dataEntity;
	}



	public ScadaDataEntity getGrossGeneration() {
		return grossGeneration;
	}



	public ScadaDataEntity getHydroRSD1() {
		return hydroRSD1;
	}



	public ScadaDataEntity getHydroRSD2() {
		return hydroRSD2;
	}



	public ScadaDataEntity getHydroRSD3() {
		return hydroRSD3;
	}



	public ScadaDataEntity getHydroRSD4() {
		return hydroRSD4;
	}



	public ScadaDataEntity getHydroRSDASHP1() {
		return hydroRSDASHP1;
	}



	public ScadaDataEntity getHydroRSDASHP2() {
		return hydroRSDASHP2;
	}



	public ScadaDataEntity getHydroRSDMHP() {
		return hydroRSDMHP;
	}

	public ScadaDataEntity getHydroRSDUBDC() {
		return hydroRSDUBDC;
	}


	public ScadaDataEntity getHydroShanan() {
		return hydroShanan;
	}


	public ScadaDataEntity getHydroShananJog1() {
		return hydroShananJog1;
	}

	public ScadaDataEntity getHydroShananJog2() {
		return hydroShananJog2;
	}

	
	public ScadaDataEntity getHydroShananJog3() {
		return hydroShananJog3;
	}

	
	public ScadaDataEntity getHydroShananJog4() {
		return hydroShananJog4;
	}

	public ScadaDataEntity getHydroShananJog5() {
		return hydroShananJog5;
	}

	public ScadaDataEntity getHydroShananJog6() {
		return hydroShananJog6;
	}

	public ScadaDataEntity getIppGVK1() {
		return ippGVK1;
	}
	public ScadaDataEntity getIppGVK2() {
		return ippGVK2;
	}
	public ScadaDataEntity getIppGVK3() {
		return ippGVK3;
	}
	public ScadaDataEntity getIppRajpura1() {
		return ippRajpura1;
	}
	public ScadaDataEntity getIppRajpura2() {
		return ippRajpura2;
	}
	public ScadaDataEntity getIppRajpura3() {
		return ippRajpura3;
	}

	public ScadaDataEntity getIppTalwandiSabo1() {
		return ippTalwandiSabo1;
	}

	public ScadaDataEntity getIppTalwandiSabo2() {
		return ippTalwandiSabo2;
	}

	public ScadaDataEntity getIppTalwandiSabo3() {
		return ippTalwandiSabo3;
	}

	public ScadaDataEntity getResNonSolar() {
		return resNonSolar;
	}

	public ScadaDataEntity getResSolar() {
		return resSolar;
	}

	public ScadaDataEntity getThermalGGSSTPRopar1() {
		return thermalGGSSTPRopar1;
	}

	public ScadaDataEntity getThermalGGSSTPRopar2() {
		return thermalGGSSTPRopar2;
	}

	public ScadaDataEntity getThermalGGSSTPRopar3() {
		return thermalGGSSTPRopar3;
	}

	public ScadaDataEntity getThermalGGSSTPRopar4() {
		return thermalGGSSTPRopar4;
	}

	public ScadaDataEntity getThermalGGSSTPRopar5() {
		return thermalGGSSTPRopar5;
	}


	public ScadaDataEntity getThermalGGSSTPRopar6() {
		return thermalGGSSTPRopar6;
	}

	public ScadaDataEntity getThermalGHTPLehraMohabbat1() {
		return thermalGHTPLehraMohabbat1;
	}

	public ScadaDataEntity getThermalGHTPLehraMohabbat2() {
		return thermalGHTPLehraMohabbat2;
	}

	public ScadaDataEntity getThermalGHTPLehraMohabbat3() {
		return thermalGHTPLehraMohabbat3;
	}

	public ScadaDataEntity getThermalGHTPLehraMohabbat4() {
		return thermalGHTPLehraMohabbat4;
	}


	public ScadaDataEntity getThermalGHTPLehraMohabbat5() {
		return thermalGHTPLehraMohabbat5;
	}

	public ScadaDataEntity getThermalGHTPLehraMohabbat6() {
		return thermalGHTPLehraMohabbat6;
	}

	public ScadaDataEntity getTotalGGSSTPRopar() {
		return totalGGSSTPRopar;
	}

	public ScadaDataEntity getTotalGHTPLehraMohabbat() {
		return totalGHTPLehraMohabbat;
	}

	public ScadaDataEntity getTotalHydro() {
		return totalHydro;
	}

	

	public ScadaDataEntity getTotalIpp() {
		return totalIpp;
	}

	public ScadaDataEntity getTotalIppGVK() {
		return totalIppGVK;
	}

	public ScadaDataEntity getTotalIppRajpura() {
		return totalIppRajpura;
	}

	public ScadaDataEntity getTotalIppTalwandiSabo() {
		return totalIppTalwandiSabo;
	}

	public ScadaDataEntity getTotalResGeneration() {
		return totalResGeneration;
	}

	public ScadaDataEntity getTotalRSD() {
		return totalRSD;
	}

	

	public ScadaDataEntity getTotalThermal() {
		return totalThermal;
	}

	public void setGrossGeneration(ScadaDataJsonPojo grossGeneration) {
		this.grossGeneration = grossGeneration;
	}


	public void setHydroRSD1(ScadaDataEntity hydroRSD1) {
		this.hydroRSD1 = hydroRSD1;
	}

	public void setHydroRSD2(ScadaDataEntity hydroRSD2) {
		this.hydroRSD2 = hydroRSD2;
	}

	public void setHydroRSD3(ScadaDataEntity hydroRSD3) {
		this.hydroRSD3 = hydroRSD3;
	}

	public void setHydroRSD4(ScadaDataEntity hydroRSD4) {
		this.hydroRSD4 = hydroRSD4;
	}

	public void setHydroRSDASHP1(ScadaDataEntity hydroRSDASHP1) {
		this.hydroRSDASHP1 = hydroRSDASHP1;
	}

	public void setHydroRSDASHP2(ScadaDataEntity hydroRSDASHP2) {
		this.hydroRSDASHP2 = hydroRSDASHP2;
	}

	public void setHydroRSDMHP(ScadaDataEntity hydroRSDMHP) {
		this.hydroRSDMHP = hydroRSDMHP;
	}

	public void setHydroRSDUBDC(ScadaDataEntity hydroRSDUBDC) {
		this.hydroRSDUBDC = hydroRSDUBDC;
	}

	public void setHydroShanan(ScadaDataEntity hydroShanan) {
		this.hydroShanan = hydroShanan;
	}

	public void setHydroShananJog1(ScadaDataEntity hydroShananJog1) {
		this.hydroShananJog1 = hydroShananJog1;
	}

	public void setHydroShananJog2(ScadaDataEntity hydroShananJog2) {
		this.hydroShananJog2 = hydroShananJog2;
	}

	public void setHydroShananJog3(ScadaDataEntity hydroShananJog3) {
		this.hydroShananJog3 = hydroShananJog3;
	}

	public void setHydroShananJog4(ScadaDataEntity hydroShananJog4) {
		this.hydroShananJog4 = hydroShananJog4;
	}

	public void setHydroShananJog5(ScadaDataEntity hydroShananJog5) {
		this.hydroShananJog5 = hydroShananJog5;
	}

	public void setHydroShananJog6(ScadaDataEntity hydroShananJog6) {
		this.hydroShananJog6 = hydroShananJog6;
	}

	public void setIppGVK1(ScadaDataEntity ippGVK1) {
		this.ippGVK1 = ippGVK1;
	}

	public void setIppGVK2(ScadaDataEntity ippGVK2) {
		this.ippGVK2 = ippGVK2;
	}

	public void setIppGVK3(ScadaDataEntity ippGVK3) {
		this.ippGVK3 = ippGVK3;
	}

	public void setIppRajpura1(ScadaDataEntity ippRajpura1) {
		this.ippRajpura1 = ippRajpura1;
	}

	public void setIppRajpura2(ScadaDataEntity ippRajpura2) {
		this.ippRajpura2 = ippRajpura2;
	}

	public void setIppRajpura3(ScadaDataEntity ippRajpura3) {
		this.ippRajpura3 = ippRajpura3;
	}

	public void setIppTalwandiSabo1(ScadaDataEntity ippTalwandiSabo1) {
		this.ippTalwandiSabo1 = ippTalwandiSabo1;
	}

	public void setIppTalwandiSabo2(ScadaDataEntity ippTalwandiSabo2) {
		this.ippTalwandiSabo2 = ippTalwandiSabo2;
	}

	public void setIppTalwandiSabo3(ScadaDataEntity ippTalwandiSabo3) {
		this.ippTalwandiSabo3 = ippTalwandiSabo3;
	}

	public void setResNonSolar(ScadaDataEntity resNonSolar) {
		this.resNonSolar = resNonSolar;
	}

	public void setResSolar(ScadaDataEntity resSolar) {
		this.resSolar = resSolar;
	}

	public void setThermalGGSSTPRopar1(ScadaDataEntity thermalGGSSTPRopar1) {
		this.thermalGGSSTPRopar1 = thermalGGSSTPRopar1;
	}

	public void setThermalGGSSTPRopar2(ScadaDataEntity thermalGGSSTPRopar2) {
		this.thermalGGSSTPRopar2 = thermalGGSSTPRopar2;
	}

	public void setThermalGGSSTPRopar3(ScadaDataEntity thermalGGSSTPRopar3) {
		this.thermalGGSSTPRopar3 = thermalGGSSTPRopar3;
	}

	public void setThermalGGSSTPRopar4(ScadaDataEntity thermalGGSSTPRopar4) {
		this.thermalGGSSTPRopar4 = thermalGGSSTPRopar4;
	}

	public void setThermalGGSSTPRopar5(ScadaDataEntity thermalGGSSTPRopar5) {
		this.thermalGGSSTPRopar5 = thermalGGSSTPRopar5;
	}

	public void setThermalGGSSTPRopar6(ScadaDataEntity thermalGGSSTPRopar6) {
		this.thermalGGSSTPRopar6 = thermalGGSSTPRopar6;
	}

	public void setThermalGHTPLehraMohabbat1(ScadaDataEntity thermalGHTPLehraMohabbat1) {
		this.thermalGHTPLehraMohabbat1 = thermalGHTPLehraMohabbat1;
	}

	public void setThermalGHTPLehraMohabbat2(ScadaDataEntity thermalGHTPLehraMohabbat2) {
		this.thermalGHTPLehraMohabbat2 = thermalGHTPLehraMohabbat2;
	}

	public void setThermalGHTPLehraMohabbat3(ScadaDataEntity thermalGHTPLehraMohabbat3) {
		this.thermalGHTPLehraMohabbat3 = thermalGHTPLehraMohabbat3;
	}

	public void setThermalGHTPLehraMohabbat4(ScadaDataEntity thermalGHTPLehraMohabbat4) {
		this.thermalGHTPLehraMohabbat4 = thermalGHTPLehraMohabbat4;
	}



	public void setThermalGHTPLehraMohabbat5(ScadaDataEntity thermalGHTPLehraMohabbat5) {
		this.thermalGHTPLehraMohabbat5 = thermalGHTPLehraMohabbat5;
	}



	public void setThermalGHTPLehraMohabbat6(ScadaDataEntity thermalGHTPLehraMohabbat6) {
		this.thermalGHTPLehraMohabbat6 = thermalGHTPLehraMohabbat6;
	}



	public void setTotalGGSSTPRopar(ScadaDataEntity totalGGSSTPRopar) {
		this.totalGGSSTPRopar = totalGGSSTPRopar;
	}



	public void setTotalGHTPLehraMohabbat(ScadaDataEntity totalGHTPLehraMohabbat) {
		this.totalGHTPLehraMohabbat = totalGHTPLehraMohabbat;
	}



	public void setTotalHydro(ScadaDataEntity totalHydro) {
		this.totalHydro = totalHydro;
	}



	public void setTotalIpp(ScadaDataEntity totalIpp) {
		this.totalIpp = totalIpp;
	}



	public void setTotalIppGVK(ScadaDataEntity totalIppGVK) {
		this.totalIppGVK = totalIppGVK;
	}



	public void setTotalIppRajpura(ScadaDataEntity totalIppRajpura) {
		this.totalIppRajpura = totalIppRajpura;
	}



	public void setTotalIppTalwandiSabo(ScadaDataEntity totalIppTalwandiSabo) {
		this.totalIppTalwandiSabo = totalIppTalwandiSabo;
	}



	public void setTotalResGeneration(ScadaDataEntity totalResGeneration) {
		this.totalResGeneration = totalResGeneration;
	}



	public void setTotalRSD(ScadaDataEntity totalRSD) {
		this.totalRSD = totalRSD;
	}



	public void setTotalThermal(ScadaDataEntity totalThermal) {
		this.totalThermal = totalThermal;
	}





}
