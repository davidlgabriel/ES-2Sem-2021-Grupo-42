package g42.CodeQualityAssessor;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LinhaTest {

	static EscreverMétricasParaExcel objeto;
	static LerFicheiro ler;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Interface interf = new Interface();
		interf.setSelectedFile(new File("C:\\Users\\dacv2\\Desktop\\jasml_0.10"));
		ArrayList<String> array = new ArrayList<String>();
		interf.percorrer();
		array = interf.getCaminhoFicheiros();
		objeto = new EscreverMétricasParaExcel(array);
		objeto.escreverNomeDoFicheiro();
		ler = new LerFicheiro(objeto.getProjeto_name()+".xlsx");
	}

	@Test
	final void testGetMethodID() {
		System.out.println(ler.lerLinha(1).toString());
		System.out.println(ler.lerTodasLinhas().get(0));
		assertEquals(1, ler.lerTodasLinhas().get(0).getMethodID());
	}
	
	@Test
	final void testGetPackageNome() {
		assertTrue(ler.lerTodasLinhas().get(0).getPackageNome().equals("com.jasml.classes"));
	}
	
	@Test
	final void testGetClassNome() {
		assertTrue(ler.lerTodasLinhas().get(0).getClassNome().equals("Attribute"));
	}
	
	@Test
	final void testGetMethodNome() {
		assertTrue(ler.lerTodasLinhas().get(0).getMethodNome().equals("Attribute(byte attrTag, int attrLength)"));
	}
	
	@Test
	final void testGetNOM_Class() {
		assertEquals(2, ler.lerTodasLinhas().get(0).getNOM_Class());
	}
	
	@Test
	final void testGetLOC_Class() {
		assertEquals(32, ler.lerTodasLinhas().get(0).getLOC_Class());
	}
	
	@Test
	final void testGetWMC_Class() {
		assertEquals(4, ler.lerTodasLinhas().get(0).getWMC_Class());
	}
	
	@Test
	final void testIsIs_God_Class() {
		assertEquals(false, ler.lerTodasLinhas().get(0).isIs_God_Class());
	}
	
	@Test
	final void testGetLOC_Method() {
		assertEquals(8, ler.lerTodasLinhas().get(0).getLOC_Method());
	}
	
	@Test
	final void testGetCyclo_Method() {
		assertEquals(2, ler.lerTodasLinhas().get(0).getCyclo_Method());
	}
	
	@Test
	final void testIsIs_Long_Method() {
		assertEquals(false, ler.lerTodasLinhas().get(0).isIs_Long_Method());
	}
	
	@Test
	final void testToString() {
		assertTrue(ler.lerTodasLinhas().get(0).toString().equals("Linha [methodID=1, packageNome=com.jasml.classes, classNome=Attribute, methodNome=Attribute(byte attrTag, int attrLength), NOM_Class=2, LOC_Class=32, WMC_Class=4, is_God_Class=false, LOC_Method=8, Cyclo_Method=2, is_Long_Method=false]"));
	}

}
