package g42.CodeQualityAssessor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class VerificacaoCodeSmells {

	private String projeto_name;
	private Regra regra_long_method;
	private Regra regra_god_class;
	
	public VerificacaoCodeSmells(String projeto_name, Regra regra_long_method, Regra regra_god_class) throws EncryptedDocumentException, IOException, ScriptException {
		super();
		this.projeto_name = projeto_name;
		this.regra_long_method = regra_long_method;
		this.regra_god_class = regra_god_class;
		percorrerFicheiro();
	}
	
	private void percorrerFicheiro() throws EncryptedDocumentException, IOException, ScriptException{
		InputStream inp = new FileInputStream(projeto_name + ".xlsx");
		Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheet(projeto_name);
	    for(int i=1; i<= sheet.getLastRowNum(); i++){
	    	Row row = sheet.getRow(i);
	    	int valor_NOM_class = (int) row.getCell(4).getNumericCellValue();
	    	int valor_LOC_class = (int) row.getCell(5).getNumericCellValue();
	    	int valor_WMC_class = (int) row.getCell(6).getNumericCellValue();
	    	
	    	int valor_LOC_method = (int) row.getCell(8).getNumericCellValue();
	    	int valor_CYCLO_method = (int) row.getCell(9).getNumericCellValue();
	    	
	    	boolean valor_long_method = VerificarLongMethod(valor_LOC_method, valor_CYCLO_method);
	    	boolean valor_god_class = VerificarGodClass(valor_NOM_class, valor_LOC_class, valor_WMC_class);
	    	
	    	row.getCell(10).setCellValue(valor_long_method);
	    	row.getCell(7).setCellValue(valor_god_class);
	    }
	   
	        wb.write(new FileOutputStream(projeto_name + ".xlsx"));
	    
	}
	
	private boolean  VerificarLongMethod (int valor_LOC_method, int valor_CYCLO_method) throws ScriptException{
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine se = sem.getEngineByName("nashorn");
		se.put("LOC_method", valor_LOC_method);
		se.put("CYCLO_method", valor_CYCLO_method);
		
		String resultado_avaliacao = se.eval(regra_long_method.getExpressao()).toString();
		
		if(resultado_avaliacao.equals("true")){
			return regra_long_method.getValorCodeSmell();
		} else {
			return !regra_long_method.getValorCodeSmell();
		}
	}
	
	private boolean  VerificarGodClass (int valor_NOM_class, int valor_LOC_class, int valor_WMC_class) throws ScriptException{
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine se = sem.getEngineByName("nashorn");
		se.put("NOM_class", valor_NOM_class);
		se.put("LOC_class", valor_LOC_class);
		se.put("WMC_class", valor_WMC_class);
		
		String resultado_avaliacao = se.eval(regra_god_class.getExpressao()).toString();
		
		if(resultado_avaliacao.equals("true")){
			return regra_god_class.getValorCodeSmell();
		} else {
			return !regra_god_class.getValorCodeSmell();
		}
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, ScriptException {
		Regra regra1 = new Regra("regra1", "LOC_method>50 && CYCLO_method>10", true, 0);
		Regra regra2 = new Regra("regra2", "WMC_class>50 || NOM_class>10", false, 1);
		VerificacaoCodeSmells v = new VerificacaoCodeSmells("Projeto", regra1, regra2);
		
	}
	
}
