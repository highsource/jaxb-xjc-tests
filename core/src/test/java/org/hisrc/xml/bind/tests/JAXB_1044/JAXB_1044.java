package org.hisrc.xml.bind.tests.JAXB_1044;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import com.sun.tools.xjc.XJCFacade;

public class JAXB_1044 {

	@Test
	public void compilesFromRewrittenURL() throws Throwable {

		final File targetDirectory = new File(
				"target/generated-sources/JAXB_1044");
		// Khm...
		targetDirectory.mkdirs();

		URL a_xsd = new URL("http://www.ab.org/a.xsd");
//		URL a_xsd = getClass().getResource("a.xsd");
		URL a_xjb = getClass().getResource("a.xjb");
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
				a_xsd.toExternalForm(),
				//
				"-b", a_xjb.toExternalForm()
				};

		// TODO
		System.setProperty("javax.xml.accessExternalSchema", "all");
		// TODO
		System.setProperty("javax.xml.accessExternalDTD", "all");
		XJCFacade.main(arguments);

	}
}
