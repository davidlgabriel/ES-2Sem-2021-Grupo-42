package g42.CodeQualityAssessor;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class LerFicheiroTest {

	static EscreverMétricasParaExcel objeto;
	static Ficheiro ficheiro;
	static LerFicheiro ler;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Interface interf = new Interface();
		interf.setdiretorioEscolhido(new File("jasml_0.10"));
		ArrayList<String> array = new ArrayList<String>();
		interf.percorrer();
		array = interf.getCaminhoFicheiros();
		objeto = new EscreverMétricasParaExcel(array);
		objeto.escreverNoFicheiro();
		ficheiro = new Ficheiro(objeto.getProjeto_name()+".xlsx");
		ler = new LerFicheiro(objeto.getProjeto_name()+".xlsx");
	}

	@Test
	final void testLerLinha() {
		assertTrue(ler.lerLinha(1).toString().equals(ficheiro.getListaLinhas().get(0).toString()));
	}
	
	@Test
	final void testLerTodasLinhas() {
		assertEquals(ficheiro.getListaLinhas().size(), ler.lerTodasLinhas().size());
		for(int i=0; i<ficheiro.getListaLinhas().size(); i++) {
			assertTrue(ler.lerTodasLinhas().get(i).toString().equals(ficheiro.getListaLinhas().get(i).toString()));
		}
	}
}