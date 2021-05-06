package g42.CodeQualityAssessor;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class InterfaceTest {
	
	static Interface inter;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		inter = new Interface();
	}
	
	@Test
	final void test() {
		inter.setdiretorioEscolhido(new File("jasml_0.10"));
		inter.acaoCriarExcel();
	}
}