package g42.CodeQualityAssessor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

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
	private int verdadeiros_positivos;
	private int falsos_positivos;
	private int verdadeiros_negativos;
	private int falsos_negativos;
	private HashMap <String,CodeSmellMetodo> codeSmellsMetodos = new HashMap<>();
	
	/**
     * Inicializa os atributos com os valores passados
     * @param projeto_name - nome do projeto
     * @param regra_long_method - regra do code smell Long Method
     * @param regra_god_class - regra do code smell God Class
     */
	public VerificacaoCodeSmells(String projeto_name, Regra regra_long_method, Regra regra_god_class) throws EncryptedDocumentException, IOException, ScriptException {
		this.projeto_name = projeto_name;
		this.regra_long_method = regra_long_method;
		this.regra_god_class = regra_god_class;
		this.verdadeiros_positivos=0;
		this.falsos_positivos=0;
		this.verdadeiros_negativos=0;
		this.falsos_negativos=0;
		verificarCodeSmells();
		verificarIndicadores();
	} 
	
	private void verificarIndicadores() throws EncryptedDocumentException, IOException {
		percorrerFicheiro_CodeSmells();
		InputStream inp = new FileInputStream(projeto_name+".xlsx");
		Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheet(projeto_name);
	    for(int i=1; i<= sheet.getLastRowNum(); i++){
	    	Row row = sheet.getRow(i);
	    	String pacote = row.getCell(1).getStringCellValue();
	    	String classe = row.getCell(2).getStringCellValue();
	    	String metodo = row.getCell(3).getStringCellValue();
	    	CodeSmellMetodo codeSmellMetodo = codeSmellsMetodos.get(pacote+classe+metodo);
	    	String is_God_Class = row.getCell(7).getStringCellValue();
		    String is_Long_Method = row.getCell(10).getStringCellValue();
		    verificarIndicador(is_God_Class,codeSmellMetodo.getIs_God_Class());
		    verificarIndicador(is_Long_Method,codeSmellMetodo.getIs_Long_Method());
	    }
	}

	private void verificarIndicador(String valorVerificacao, boolean valorCodeSmell) {
		if(valorVerificacao.equals("true")) {
			if(valorCodeSmell)
				this.verdadeiros_positivos++;
			else
				this.falsos_positivos++;
		}else{
			if(valorCodeSmell)
				this.falsos_negativos++;
			else
				this.verdadeiros_negativos++;
		}
	}

	private void percorrerFicheiro_CodeSmells() throws EncryptedDocumentException, IOException {
		InputStream inp = new FileInputStream("Code_Smells.xlsx");
		Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheet("Code Smells");
	    for(int i=1; i<= sheet.getLastRowNum(); i++){
	    	retirarCodeSmellMetodo(sheet, i);
	    }
	}

	private void retirarCodeSmellMetodo(Sheet sheet, int i) {
		Row row = sheet.getRow(i);
		String pacote = row.getCell(1).getStringCellValue();
		String classe = row.getCell(2).getStringCellValue().split("\\.")[0];
		String metodo = row.getCell(3).getStringCellValue();

		if(row.getCell(7).getCellType().toString().equals("BOOLEAN") && row.getCell(10).getCellType().toString().equals("BOOLEAN")) {
			boolean is_God_Class = row.getCell(7).getBooleanCellValue();
			boolean is_Long_Method = row.getCell(10).getBooleanCellValue();
			
			CodeSmellMetodo codeSmellMetodo = new CodeSmellMetodo(pacote+classe+metodo,is_God_Class,is_Long_Method);
			
			this.codeSmellsMetodos.put(pacote+classe+metodo, codeSmellMetodo);
		}
	}

	/**
     * Devolve o número de falsos negativos
     * @return falsos negativos
     */
	public int getFalsos_negativos() {
		return falsos_negativos;
	}
	
	/**
     * Devolve o número de verdadeiros positivos
     * @return verdadeiros positivos
     */
	public int getVerdadeiros_positivos() {
		return verdadeiros_positivos;
	}
	
	/**
     * Devolve o número de falsos positivos
     * @return falsos positivos
     */
	public int getFalsos_positivos() {
		return falsos_positivos;
	}
	
	/**
     * Devolve o número de verdadeiros negativos
     * @return verdadeiros negativos
     */
	public int getVerdadeiros_negativos() {
		return verdadeiros_negativos;
	}

	private void verificarCodeSmells() throws EncryptedDocumentException, IOException, ScriptException{
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
	    	
	    	String valor_long_method = VerificarLongMethod(valor_LOC_method, valor_CYCLO_method);
	    	String valor_god_class = VerificarGodClass(valor_NOM_class, valor_LOC_class, valor_WMC_class);
	    	
	    	row.getCell(10).setCellValue(valor_long_method);
	    	row.getCell(7).setCellValue(valor_god_class);
	    }
	   
	        wb.write(new FileOutputStream(projeto_name + ".xlsx"));
	    
	}
	
	private String  VerificarLongMethod (int valor_LOC_method, int valor_CYCLO_method) throws ScriptException{
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine se = sem.getEngineByName("nashorn");
		se.put("LOC_method", valor_LOC_method);
		se.put("CYCLO_method", valor_CYCLO_method);
		
		String resultado_avaliacao = se.eval(regra_long_method.getExpressao()).toString();
		
		if(resultado_avaliacao.equals("true")){
			if(regra_long_method.getValorCodeSmell())
				return "true";
			else
				return "false";
		} else {
			if(regra_long_method.getValorCodeSmell())
				return "false";
			else
				return "true";
		}
	}
	
	private String  VerificarGodClass (int valor_NOM_class, int valor_LOC_class, int valor_WMC_class) throws ScriptException{
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine se = sem.getEngineByName("nashorn");
		se.put("NOM_class", valor_NOM_class);
		se.put("LOC_class", valor_LOC_class);
		se.put("WMC_class", valor_WMC_class);
		
		String resultado_avaliacao = se.eval(regra_god_class.getExpressao()).toString();
		
		if(resultado_avaliacao.equals("true")){
			if(regra_god_class.getValorCodeSmell())
				return "true";
			else
				return "false";
		} else {
			if(regra_god_class.getValorCodeSmell())
				return "false";
			else
				return "true";
		}
	}
}