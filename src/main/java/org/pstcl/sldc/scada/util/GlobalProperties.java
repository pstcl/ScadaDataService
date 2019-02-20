package org.pstcl.sldc.scada.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:file.properties")
public class GlobalProperties {

	@Autowired
	private     Environment environment;

	@Value("${excel.file.dir}")
	private String fileLocation;

	@Value("${excel.file.name}")
	private String fileName;
	//getters and setters

	@Value("${temp.dir}")
	private String tempDirName;
	//getters and setters

	
	public String getFileLocation() {
		return fileLocation;
	}

	public String getTempDirName() {
		return tempDirName;
	}

	public void setTempDirName(String tempDirName) {
		this.tempDirName = tempDirName;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



}