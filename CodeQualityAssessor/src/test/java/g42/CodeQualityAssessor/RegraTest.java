package g42.CodeQualityAssessor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegraTest {

	static Regra regra;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		regra = new Regra("regra1", "NOM_method > 5",true,0);
	}
	
	@Test
	final void testGetNome() {
		assertEquals("regra1",regra.getNome());
	}
	
	@Test
	final void testGetExpressao() {
		assertEquals("NOM_method > 5",regra.getExpressao());
	}
	
	@Test
	final void testGetValorCodeSmell() {
		assertTrue(regra.getValorCodeSmell());
	}

	@Test
	final void testGetTipoCodeSmell() {
		assertEquals(0,regra.getTipoCodeSmell());
	}
}