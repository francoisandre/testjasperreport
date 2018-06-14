package testjasperreport;

import java.io.File;
import java.util.Collections;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class TestGeneration {

	@Test
	public void testGeneration() throws Exception {
		AnnotationConfigApplicationContext contexte = new AnnotationConfigApplicationContext(EmpyConfiguration.class);
		Resource resource = contexte.getResource("rapport.jrxml");
		JasperReport rapport = JasperCompileManager.compileReport(resource.getInputStream());

		Auteur hugo = new Auteur("Victor", "Hugo", 83);
		hugo.ajouteLivre("Les Misérables", 5);
		hugo.ajouteLivre("93", 5);

		JRBeanCollectionDataSource sourceDonnees = new JRBeanCollectionDataSource(Collections.singletonList(hugo));
		JasperPrint imprimeur = JasperFillManager.fillReport(rapport, null, sourceDonnees);
		File aux = File.createTempFile("testjasper", ".pdf");
		JasperExportManager.exportReportToPdfFile(imprimeur, aux.getPath());
		System.out.println("Le rapport a été généré dans le fichier " + aux);
	}

}
