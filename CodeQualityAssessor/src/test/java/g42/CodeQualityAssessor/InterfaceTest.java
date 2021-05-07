package g42.CodeQualityAssessor;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class InterfaceTest {
	
	static Interface inter;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		inter = new Interface();
		inter.testarInterface("regraTeste", "jasml_0.10");
	}
	
	@Test
	final void testExcel() {
		File f = new File("jasml_0.10.xlsx");
		assertTrue(f.exists());
	}
	
	@Test
	final void testRegra() {
		assertEquals("regraTeste",inter.getRegraLM("regraTeste").getNome());
		assertEquals("regraTeste",inter.getRegraGC("regraTeste").getNome());
	}
	
	@Test
	final void testAcertos() {
		assertEquals(0,inter.getVerificacaoCodeSmells().getVerdadeiros_positivos());
		assertEquals(91,inter.getVerificacaoCodeSmells().getFalsos_positivos());
		assertEquals(322, inter.getVerificacaoCodeSmells().getVerdadeiros_negativos());
		assertEquals(77, inter.getVerificacaoCodeSmells().getFalsos_negativos());
	}
}