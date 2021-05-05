package g42.CodeQualityAssessor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CodeSmellMetodoTest {
	
	static CodeSmellMetodo codeSmellMetodo;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		codeSmellMetodo = new CodeSmellMetodo("pacote.classe.metodo",true,false);
	}

	@Test
	final void testGetIs_God_Class() {
		assertTrue(codeSmellMetodo.getIs_God_Class());
	}

	@Test
	final void testGetIs_Long_Method() {
		assertFalse(codeSmellMetodo.getIs_Long_Method());
	}
	
	@Test
	final void testGetpacote_classe_metodo() {
		assertEquals("pacote.classe.metodo",codeSmellMetodo.getpacote_classe_metodo());
	}
}
