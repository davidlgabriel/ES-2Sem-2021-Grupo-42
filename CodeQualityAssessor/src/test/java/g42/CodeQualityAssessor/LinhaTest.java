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
		interf.setSelectedFile(new File("jasml_0.10"));
		ArrayList<String> array = new ArrayList<String>();
		interf.percorrer();
		array = interf.getCaminhoFicheiros();
		objeto = new EscreverMétricasParaExcel(array);
		objeto.escreverNoFicheiro();
		ler = new LerFicheiro(objeto.getProjeto_name()+".xlsx");
	}

	@Test
	final void testGetMethodID() {
		assertEquals(1, ler.lerTodasLinhas().get(0).getIdMetodo());
	}
	
	@Test
	final void testGetPackageNome() {
		assertTrue(ler.lerTodasLinhas().get(0).getNomePacote().equals("com.jasml.classes"));
	}
	
	@Test
	final void testGetClassNome() {
		assertTrue(ler.lerTodasLinhas().get(0).getNomeClasse().equals("Attribute"));
	}
	
	@Test
	final void testGetMethodNome() {
		assertTrue(ler.lerTodasLinhas().get(0).getNomeMetodo().equals("Attribute(byte attrTag, int attrLength)"));
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
		assertEquals("", ler.lerTodasLinhas().get(0).isIs_God_Class());
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
		assertEquals("", ler.lerTodasLinhas().get(0).isIs_Long_Method());
	}
	
	@Test
	final void testToString() {
		assertTrue(ler.lerTodasLinhas().get(0).toString().equals("Linha [idMetodo=1, nomePacote=com.jasml.classes, nomeClasse=Attribute, nomeMetodo=Attribute(byte attrTag, int attrLength), NOM_Class=2, LOC_Class=32, WMC_Class=4, is_God_Class=, LOC_Method=8, Cyclo_Method=2, is_Long_Method=]"));
	}

}
