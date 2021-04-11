package g42.CodeQualityAssessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class EscreverMétricasParaExcel {


	//Atributos

	private ArrayList<String> classes;
	private ArrayList<Integer> NOM_class_array;
	private ArrayList<Integer> LOC_class_array;
	private ArrayList<Integer> WMC_class_array;
	private ArrayList<Integer> LOC_method_array;
	private ArrayList<Integer> CYCLO_method_array;
	private ArrayList<Integer> repeticoes_NOM;
	private ArrayList<String> nomePackages;
	private ArrayList<String> nomeClasses;
	private ArrayList<String> nomeMethods;

	private int NOM_class;
	private int LOC_class;
	private int WMC_class;
	private int LOC_method;
	private int CYCLO_method;
	private String projeto_name;


	//Construtor

	public EscreverMétricasParaExcel(ArrayList<String> classes) {
		this.classes=classes;
		String nomeProjeto = this.classes.remove(0);
		this.projeto_name=nomeProjeto;
		this.nomeMethods= new ArrayList<String>();
		this.repeticoes_NOM=new ArrayList<Integer>();
		this.LOC_method_array=new ArrayList<Integer>();
		this.CYCLO_method_array=new ArrayList<Integer>();
		this.NOM_class_array = new ArrayList<Integer>();
		this.WMC_class_array=new ArrayList<Integer>();
		this.LOC_class_array=new ArrayList<Integer>();
		this.nomePackages=new ArrayList<String>();
		this.nomeClasses=new ArrayList<String>();
		this.NOM_class=0;
		this.LOC_class=1;
		this.WMC_class=0;
		this.LOC_method=0;
		this.CYCLO_method=0;
	}


	//Getters

	public ArrayList<String> getnomePackages() {
		return nomePackages;
	}
	
	public ArrayList<String> getnomeClasses() {
		return nomeClasses;
	}
	
	public ArrayList<Integer> getLOC_class_array() {
		return LOC_class_array;
	}

	public ArrayList<Integer> getWMC_class_array() {
		return WMC_class_array;
	}

	public ArrayList<Integer> getLOC_method_array() {
		return LOC_method_array;
	}

	public ArrayList<Integer> getCYCLO_method_array() {
		return CYCLO_method_array;
	}

	public ArrayList<Integer> getNOM_class_array(){
		return NOM_class_array;
	}
	public ArrayList<String> getClasses() {
		return classes;
	}

	public int getNOM_class() {
		return NOM_class;
	}

	public int getLOC_class() {
		return LOC_class;
	}

	public int getWMC_class() {
		return WMC_class;
	}

	public int getLOC_method() {
		return LOC_method;
	}

	public int getCYCLO_method() {
		return CYCLO_method;
	}


	//Métodos

	public void escreverNomeDoFicheiro() throws FileNotFoundException, IOException {
		NOM_class();
		LOC_class();
		WMC_class();
		LOC_method();
		CYCLO_method();
		
		retirarNomePackages();
		retirarNomeClasses();
		retirarNomeMethod();
		
		Workbook xlsxWorkbook = new XSSFWorkbook();


		Sheet sheet1 = xlsxWorkbook.createSheet(this.projeto_name);
		CellStyle style = xlsxWorkbook.createCellStyle();
		Row row1 = sheet1.createRow(0);
		Font font = xlsxWorkbook.createFont();
		font.setBold(true);
		style.setFont(font);
		String[] first_row = {"MethodID","package","class","method","NOM_class","LOC_class","WMC_class","is_God_Class","LOC_method","CYCLO_method","is_Long_Method"};
		for (int j = 0; j <= 10; j++) {
			row1.createCell(j).setCellValue(first_row[j]);
			row1.getCell(j).setCellStyle(style);
		}

		for (int j = 1; j <= this.NOM_class_array.size() ; j++) {
			Row rowj = sheet1.createRow(j);
			rowj.createCell(0).setCellValue(j);
			rowj.createCell(1).setCellValue(this.nomePackages.get(j-1));
			rowj.createCell(2).setCellValue(this.nomeClasses.get(j-1));
			rowj.createCell(3).setCellValue(this.nomeMethods.get(j-1));
			rowj.createCell(4).setCellValue(this.NOM_class_array.get(j-1));
			rowj.createCell(5).setCellValue(this.LOC_class_array.get(j-1));
			rowj.createCell(6).setCellValue(this.WMC_class_array.get(j-1));
			rowj.createCell(7).setCellValue("");
			rowj.createCell(8).setCellValue(this.LOC_method_array.get(j-1));
			rowj.createCell(9).setCellValue(this.CYCLO_method_array.get(j-1));
			rowj.createCell(10).setCellValue("");
		}






		xlsxWorkbook.write(new FileOutputStream( this.projeto_name + ".xlsx" ));
		System.out.println("Excel criado com sucesso!!");
		//dar o nome ao Excel
		//extrair o nome das classes
		//extrair o nome dos métodos
	}


	//	public void escreverNoExcel(int x, int y, int res) {
	//		
	//	}

	private static class ConstructorCollector extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(ConstructorDeclaration md, List<String> collector) {
			super.visit(md, collector);
			collector.add(md.toString());
		}
	}

	private static class MethodCollector extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(MethodDeclaration md, List<String> collector) {
			super.visit(md, collector);
			collector.add(md.toString());
		}
	}

	private static class ConstructorNameCollector extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(ConstructorDeclaration md, List<String> collector) {
			super.visit(md,collector);
			collector.add(md.getNameAsString());
		}
	}

	private static class MethodNameCollector extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(MethodDeclaration md, List<String> collector) {
			super.visit(md,collector);
			collector.add(md.getNameAsString());
		}
	}
	
	private static class NamePackage extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(PackageDeclaration md, List<String> collector) {
			super.visit(md,collector);
			collector.add(md.getNameAsString());
		}
	}
	private static class NameConstructor extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(ConstructorDeclaration md, List<String> collector) {
			super.visit(md,collector);
			collector.add(md.getDeclarationAsString());
		}
	}
	private static class NameMethod extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(MethodDeclaration md, List<String> collector) {
			super.visit(md,collector);
			collector.add(md.getDeclarationAsString());
		}
	}
	public void retirarNomeMethod() throws FileNotFoundException {
		
		for (String caminhoClasse : this.classes) {		
			File ficheiroClasse = new File(caminhoClasse);	
			CompilationUnit f = StaticJavaParser.parse(ficheiroClasse);
			List<String> MethodName = new ArrayList<>();
			VoidVisitor<List<String>> MethodNameVisitor = new NameMethod();
			MethodNameVisitor.visit(f, MethodName);
			
			List<String> ConstructorName = new ArrayList<>();
			VoidVisitor<List<String>> ConstrutorNameVisitor = new NameConstructor();
			ConstrutorNameVisitor.visit(f, ConstructorName);
			
			for (String string : MethodName) {
				ConstructorName.add(string);
			}
			
			for (String string : ConstructorName) {
				if(!string.contains("main")) {
					System.out.println(string);
					String [] vetor = string.split("\\(");
					String parametrosMethod = vetor[1];
					String firstMethod = vetor[0];
					String [] nameMethod = firstMethod.split(" ");
					String Method = nameMethod[nameMethod.length-1].concat("("+parametrosMethod);
					
					this.nomeMethods.add(Method);

				}
			}
			
			
			
			
		}
	}

	public void retirarNomePackages() throws FileNotFoundException {
		int rep =0;
		for (String caminhoClasse : this.classes) {		
			File ficheiroClasse = new File(caminhoClasse);	
			CompilationUnit f = StaticJavaParser.parse(ficheiroClasse);
			List<String> PackageName = new ArrayList<>();
			VoidVisitor<List<String>> PackageNameVisitor = new NamePackage();
			PackageNameVisitor.visit(f, PackageName);
			for (int i = 0; i < this.repeticoes_NOM.get(rep); i++) {
				this.nomePackages.add(PackageName.get(0));
			}
			rep++;
			
		}
	}
	
	public void NOM_class() throws FileNotFoundException {
		for (String caminhoClasse : this.classes) {		
			File ficheiroClasse = new File(caminhoClasse);	
			CompilationUnit f = StaticJavaParser.parse(ficheiroClasse);
			List<String> methodNames = new ArrayList<>();
			VoidVisitor<List<String>> methodNameCollector = new MethodNameCollector();
			methodNameCollector.visit(f, methodNames);
			
			List<String> constructorNames = new ArrayList<>();
			VoidVisitor<List<String>> constructorNameCollector = new ConstructorNameCollector();
			constructorNameCollector.visit(f, constructorNames);
			for (String string : methodNames) {
				constructorNames.add(string);
			}
			
			for (String string : constructorNames) {
				if(!string.equals("main")) {
					this.NOM_class++;
				}
			}
			//System.out.println(this.NOM_class);
			this.repeticoes_NOM.add(this.NOM_class);
			for (int i = 0; i < this.NOM_class; i++) {
				this.NOM_class_array.add(this.NOM_class);
			}

			//Escrever no excel
			this.NOM_class=0;
		}
	}


	public void LOC_class() throws FileNotFoundException {
		int rep =0; 
		for (String caminhoClasse : this.classes) {			
			File ficheiroClasse = new File(caminhoClasse);	
			Scanner lerFicheiroClasse = new Scanner(ficheiroClasse);	
			while (lerFicheiroClasse.hasNextLine()) {		
				this.LOC_class++;							
				lerFicheiroClasse.nextLine();				
			}
			//System.out.println(this.LOC_class);

			for (int i = 0; i < this.repeticoes_NOM.get(rep); i++) {
				this.LOC_class_array.add(this.LOC_class);
			}

			//Escrever no excel
			this.LOC_class=1;
			rep++;
			lerFicheiroClasse.close();
		}

	}


	public void WMC_class() throws FileNotFoundException {
		int rep =0;
		for (String caminhoClasse : this.classes) {			
			File ficheiroClasse = new File(caminhoClasse);		
			CompilationUnit f = StaticJavaParser.parse(ficheiroClasse);
			List<String> methods = new ArrayList<>();
			VoidVisitor<List<String>> methodCollector = new MethodCollector();
			methodCollector.visit(f, methods);
			
			List<String> constructors = new ArrayList<>();
			VoidVisitor<List<String>> constructorCollector = new ConstructorCollector();
			constructorCollector.visit(f, constructors);
		
			for (String string : methods) {
				constructors.add(string);
			}
			
			for (String string : constructors) {
				if (!string.contains("public static void main")) {
					this.WMC_class = this.WMC_class + contarComplexidadeDeMetodo(string);
				}
			}
			//System.out.println(this.WMC_class);
			for (int i = 0; i < this.repeticoes_NOM.get(rep); i++) {
				this.WMC_class_array.add(this.WMC_class);
			}

			//Escrever no excel
			rep++;
			this.WMC_class=0;
		}
	}


	public void LOC_method() throws FileNotFoundException {
		for (String caminhoClasse : this.classes) {			
			File ficheiroClasse = new File(caminhoClasse);		
			CompilationUnit f = StaticJavaParser.parse(ficheiroClasse);
			List<String> methods = new ArrayList<>();
			VoidVisitor<List<String>> methodCollector = new MethodCollector();
			methodCollector.visit(f, methods);
			
			List<String> constructors = new ArrayList<>();
			VoidVisitor<List<String>> constructorCollector = new ConstructorCollector();
			constructorCollector.visit(f, constructors);
		
			for (String string : methods) {
				constructors.add(string);
			}
			
			for (String string : constructors) {
				String [] vectorS =null;
				if (!string.contains("public static void main")) {
					vectorS = string.split("\n");
					this.LOC_method = vectorS.length;
					this.LOC_method_array.add(this.LOC_method);
				}
				//System.out.println(this.LOC_method);

				//Escrever no excel
				this.LOC_method =0;
			}
		}
	}


	private int contarComplexidadeDeMetodo(String s) {
		int result=0;
		String [] vectorS = null;
		vectorS = s.split(" ");
		for(int i=0; i<vectorS.length; i++) {
			if(vectorS[i].contains("for") || vectorS[i].contains("while") || vectorS[i].contains("if") || vectorS[i].contains("case")) {
				result++;
			}
		}
		return result;
	}


	public void CYCLO_method() throws FileNotFoundException {
		for (String caminhoClasse : this.classes) {			
			File ficheiroClasse = new File(caminhoClasse);		
			CompilationUnit f = StaticJavaParser.parse(ficheiroClasse);
			List<String> methods = new ArrayList<>();
			VoidVisitor<List<String>> methodCollector = new MethodCollector();
			methodCollector.visit(f, methods);
			
			List<String> constructors = new ArrayList<>();
			VoidVisitor<List<String>> constructorCollector = new ConstructorCollector();
			constructorCollector.visit(f, constructors);
		
			for (String string : methods) {
				constructors.add(string);
			}
			
			for (String string : constructors) {
				if (!string.contains("public static void main")) {
					this.CYCLO_method=contarComplexidadeDeMetodo(string);
					this.CYCLO_method_array.add(this.CYCLO_method);
				}
				//System.out.println(this.CYCLO_method);
				//Escrever no excel
				this.CYCLO_method=0;
			}
		}
	}


	
	
	
	public void retirarNomeClasses() {
		int rep =0;
		String nomeClasse = null;
		for (String caminhoClasse : this.classes) {				
			String[] vetor = caminhoClasse.split("/");
			String classe = vetor[vetor.length-1];
			String[] vetor2 = classe.split("\\."); //se coloca-se só o ponto dava erro por causa do Regex
			nomeClasse=vetor2[0];							
			
			for (int i = 0; i < this.repeticoes_NOM.get(rep); i++) {
				this.nomeClasses.add(nomeClasse);
			}
			rep++;
		}

	}



	//Testar

	public static void main(String[] args) throws IOException {

		ArrayList<String> lista = new ArrayList<String>();
		String s = "ficheiro_excel";
		String app = "C:/Users/David Gabriel/git/ES-2Sem-2021-Grupo-42/CodeQualityAssessor/src/main/java/g42/CodeQualityAssessor/App.java";
		lista.add(s);
		lista.add(app);
		EscreverMétricasParaExcel a = new EscreverMétricasParaExcel(lista);
		a.escreverNomeDoFicheiro();

	}
}