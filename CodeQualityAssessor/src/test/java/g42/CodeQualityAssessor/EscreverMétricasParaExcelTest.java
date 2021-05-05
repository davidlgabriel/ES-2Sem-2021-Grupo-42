package g42.CodeQualityAssessor;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

class EscreverMétricasParaExcelTest {

	static EscreverMétricasParaExcel objeto;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Interface interf = new Interface();
		interf.setSelectedFile(new File("C:\\Users\\dacv2\\Desktop\\jasml_0.10"));
		ArrayList<String> array = new ArrayList<String>();
		interf.percorrer();
		array = interf.getCaminhoFicheiros();
		objeto = new EscreverMétricasParaExcel(array);
		objeto.escreverNoFicheiro();;
	}

	
	@Test
	final void testGetnomePackages() {
		assertEquals(245, objeto.getnomePackages().size());
	}

	@Test
	final void testGetNumberClasses() {
		assertEquals(42, objeto.getNumberClasses());
	}

	@Test
	final void testGetnomeClasses() {
		assertEquals(245, objeto.getnomeClasses().size());
	}

	@Test
	final void testGetLOC_class_array() {
		assertEquals(245, objeto.getLOC_class_array().size());
	}

	@Test
	final void testGetWMC_class_array() {
		assertEquals(245, objeto.getWMC_class_array().size());
	}

	@Test
	final void testGetLOC_method_array() {
		assertEquals(245, objeto.getLOC_method_array().size());
	}

	@Test
	final void testGetCYCLO_method_array() {
		assertEquals(245, objeto.getCYCLO_method_array().size());
	}

	@Test
	final void testGetNOM_class_array() {
		assertEquals(245, objeto.getNOM_class_array().size());
	}


}
