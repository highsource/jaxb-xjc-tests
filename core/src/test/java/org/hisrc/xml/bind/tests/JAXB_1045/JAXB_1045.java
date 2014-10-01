package org.hisrc.xml.bind.tests.JAXB_1045;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import com.sun.tools.xjc.XJCFacade;

public class JAXB_1045 {

	@Test
	public void compilesFromRewrittenURL() throws Throwable {

		final File targetDirectory = new File(
				"target/generated-sources/JAXB_1045");
		// Khm...
		targetDirectory.mkdirs();

		// xjc -catalog catalog.cat ab/c.xsd -b cd.xjb

		URL c_xsd = getClass().getResource("ab/c.xsd");
		// URL a_xsd = getClass().getResource("a.xsd");
		URL cd_xjb = getClass().getResource("cd.xjb");
		URL catalog = getClass().getResource("catalog.cat");
		final String[] arguments = new String[] {
				//
				"-catalog", catalog.toExternalForm(),
				//
				"-d", targetDirectory.getAbsolutePath(),
				//
				"-disableXmlSecurity",
				//
				"-extension",
				//
				"-nv",
				//
				"-xmlschema",
				//
				c_xsd.toExternalForm(),
				//
				"-b", cd_xjb.toExternalForm()

		};

		// // TODO
		// System.setProperty("javax.xml.accessExternalSchema", "all");
		// // TODO
		// System.setProperty("javax.xml.accessExternalDTD", "all");
		XJCFacade.main(arguments);

	}
}
