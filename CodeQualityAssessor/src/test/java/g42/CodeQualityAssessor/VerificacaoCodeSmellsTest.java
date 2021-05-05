package g42.CodeQualityAssessor;

import java.io.IOException;

import javax.script.ScriptException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.jupiter.api.Test;

class VerificacaoCodeSmellsTest {

	@Test
	public final void test() throws EncryptedDocumentException, IOException, ScriptException{
		Regra regra1 = new Regra("regra1", "LOC_method>50 && CYCLO_method>10", true, 0);
		Regra regra2 = new Regra("regra2", "WMC_class>50 || NOM_class>10", false, 1);
		VerificacaoCodeSmells v = new VerificacaoCodeSmells("jasml_0.10", regra1, regra2);
		
		Regra regra3 = new Regra("regra1", "LOC_method>50 && CYCLO_method>10", false, 0);
		Regra regra4 = new Regra("regra2", "WMC_class>50 || NOM_class>10", true, 1);
		VerificacaoCodeSmells v1 = new VerificacaoCodeSmells("jasml_0.10", regra3, regra4);
	}
}