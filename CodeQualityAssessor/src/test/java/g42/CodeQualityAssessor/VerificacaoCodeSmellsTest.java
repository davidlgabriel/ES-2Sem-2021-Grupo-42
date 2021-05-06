package g42.CodeQualityAssessor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import javax.script.ScriptException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class VerificacaoCodeSmellsTest {
	
	static VerificacaoCodeSmells v;

	@BeforeAll
	static void setUpBeforeClass() throws EncryptedDocumentException, IOException, ScriptException{
		Regra regra1 = new Regra("regra1", "LOC_method>50 && CYCLO_method>10", true, 0);
		Regra regra2 = new Regra("regra2", "WMC_class>50 || NOM_class>10", false, 1);
		v = new VerificacaoCodeSmells("jasml_0.10", regra1, regra2);
		
		Regra regra3 = new Regra("regra1", "LOC_method>50 && CYCLO_method>10", false, 0);
		Regra regra4 = new Regra("regra2", "WMC_class>50 || NOM_class>10", true, 1);
		VerificacaoCodeSmells v1 = new VerificacaoCodeSmells("jasml_0.10", regra3, regra4);
	}
	
	@Test
	final void testGetVerdadeiros_positivos() {
		assertEquals(19, v.getVerdadeiros_positivos());
	}
	
	@Test
	final void testGetFalsos_positivos() {
		assertEquals(82, v.getFalsos_positivos());
	}
	
	@Test
	final void testGetVerdadeiros_negativos() {
		assertEquals(331, v.getVerdadeiros_negativos());
	}
	
	@Test
	final void testGetFalsos_negativos() {
		assertEquals(58, v.getFalsos_negativos());
	}
}