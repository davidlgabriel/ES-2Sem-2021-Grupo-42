package g42.CodeQualityAssessor;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FicheiroTest {

	static EscreverMétricasParaExcel objeto;
	static Ficheiro ficheiro;
	static LerFicheiro ler;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Interface interf = new Interface();
		interf.setSelectedFile(new File("C:\\Users\\dacv2\\Desktop\\jasml_0.10"));
		ArrayList<String> array = new ArrayList<String>();
		interf.percorrer();
		array = interf.getCaminhoFicheiros();
		objeto = new EscreverMétricasParaExcel(array);
		objeto.escreverNoFicheiro();
		ficheiro = new Ficheiro(objeto.getProjeto_name()+".xlsx");
		ler = new LerFicheiro(objeto.getProjeto_name()+".xlsx");
	}
	
	@Test
	final void testGetFileName() {
		assertEquals(objeto.getProjeto_name()+".xlsx", ficheiro.getNomeFicheiro());
	}
	
	@Test
	final void testGetLista() {
		assertEquals(ler.lerTodasLinhas().size(), ficheiro.getListaLinhas().size());
		for(int i=0; i<ler.lerTodasLinhas().size(); i++) {
			assertTrue(ficheiro.getListaLinhas().get(i).toString().equals(ler.lerTodasLinhas().get(i).toString()));
		}
	}
	
	
}
