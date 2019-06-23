package org.pstcl.sldc.scada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScadaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScadaApplication.class, args);
	}

}

//
//a_FREQUENCY = "*/Rate=10"
//a_DRAWAL = "nrldc_pg.line.pseb_drwl.mw/rate=10"
//a_SCHEDULE = "nrldc_pg.shdl.pseb_s.mw/rate=10"
//a_ODUD = "nrldc_pg.line.pseb_od_ud.mw/rate=10"
//a_LOAD ="nrldc_pg.ld.pseb_load.mw/rate=10"
//a_CURRENTTIME = "nrldc_pg.line.pseb_drwl.mw/rate=10"
