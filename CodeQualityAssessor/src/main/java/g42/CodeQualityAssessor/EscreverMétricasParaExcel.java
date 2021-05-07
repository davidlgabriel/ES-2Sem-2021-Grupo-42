package g42.CodeQualityAssessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
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
	private ArrayList<String> nomePacotes;
	private ArrayList<String> nomeClasses;
	private ArrayList<String> nomeMetodos;

	private int NOM_class;
	private int LOC_class;
	private int WMC_class;
	private int LOC_method;
	private int CYCLO_method;
	private String nomeProjeto;
	private int numeroClasses;

	
	//Construtor

	/**
     * Inicializa um objeto EscreverMetricasParaExcel
     * @param classes - com o nome do projeto (primeira posiçao) e caminho para cada classe (restantes posiçoes)
     */
	public EscreverMétricasParaExcel(ArrayList<String> classes) {
		this.classes=classes;
		String nomeProjeto = this.classes.remove(0);
		this.nomeProjeto=nomeProjeto;
		this.nomeMetodos= new ArrayList<String>();
		this.repeticoes_NOM=new ArrayList<Integer>();
		this.LOC_method_array=new ArrayList<Integer>();
		this.CYCLO_method_array=new ArrayList<Integer>();
		this.NOM_class_array = new ArrayList<Integer>();
		this.WMC_class_array=new ArrayList<Integer>();
		this.LOC_class_array=new ArrayList<Integer>();
		this.nomePacotes=new ArrayList<String>();
		this.nomeClasses=new ArrayList<String>();
		this.NOM_class=0;
		this.LOC_class=1;
		this.WMC_class=0;
		this.LOC_method=0;
		this.CYCLO_method=0;
		this.numeroClasses=0;
	}


	//Getters
	
	
	/**
     * Devolve um ArrayList contendo todos os nomes dos pacotes
     * @return getnomePackages
     */
	public ArrayList<String> getnomePackages() {
		return nomePacotes;
	}

	/**
     * Devolve o nome do projeto
     * @return nomeProjeto
     */
	public String getProjeto_name() {
		return nomeProjeto;
	}

	/**
     * Devolve o numero de classes do projeto
     * @return numeroClasses
     */
	public int getNumberClasses() {
		return numeroClasses;
	}
	
	/**
     * Devolve um ArrayList contendo todos os nomes das classes
     * @return nomeClasses
     */
	public ArrayList<String> getnomeClasses() {
		return nomeClasses;
	}

	/**
     * Devolve um ArrayList contendo o numero de linhas de cada classe
     * @return LOC_class_array
     */
	public ArrayList<Integer> getLOC_class_array() {
		return LOC_class_array;
	}

	/**
     * Devolve um ArrayList contendo o numero referente a complexidade de cada classe
     * @return WMC_class_array
     */
	public ArrayList<Integer> getWMC_class_array() {
		return WMC_class_array;
	}

	/**
     * Devolve um ArrayList contendo o numero de linhas de cada metodo
     * @return LOC_method_array
     */
	public ArrayList<Integer> getLOC_method_array() {
		return LOC_method_array;
	}
	
	/**
     * Devolve um ArrayList contendo o numero referente a complexidade ciclomatica de cada metodo
     * @return CYCLO_method_array
     */
	public ArrayList<Integer> getCYCLO_method_array() {
		return CYCLO_method_array;
	}
	
	/**
     * Devolve um ArrayList contendo o numero de metodos de cada classe
     * @return NOM_class_array
     */
	public ArrayList<Integer> getNOM_class_array(){
		return NOM_class_array;
	}


	//Métodos

	/**
     * Corre a extraçao de metricas do projeto em questao, cria um ficheiro excel e escreve nele as informaçoes que obteve da extraçao das metricas
     */
	public void escreverNoFicheiro() throws FileNotFoundException, IOException {
		
//		testar();
		
		NOM_class();
		LOC_class();
		WMC_class();
		LOC_method();
		CYCLO_method();

		retirarNomePacotes();
		retirarNomeClasses();
		retirarNomeMetodos();

		Workbook xlsxWorkbook = new XSSFWorkbook();


		Sheet sheet1 = xlsxWorkbook.createSheet(this.nomeProjeto);
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
			rowj.createCell(1).setCellValue(this.nomePacotes.get(j-1));
			rowj.createCell(2).setCellValue(this.nomeClasses.get(j-1));
			rowj.createCell(3).setCellValue(this.nomeMetodos.get(j-1));
			rowj.createCell(4).setCellValue(this.NOM_class_array.get(j-1));
			rowj.createCell(5).setCellValue(this.LOC_class_array.get(j-1));
			rowj.createCell(6).setCellValue(this.WMC_class_array.get(j-1));
			rowj.createCell(7).setCellValue("");
			rowj.createCell(8).setCellValue(this.LOC_method_array.get(j-1));
			rowj.createCell(9).setCellValue(this.CYCLO_method_array.get(j-1));
			rowj.createCell(10).setCellValue("");
		}

		xlsxWorkbook.write(new FileOutputStream( this.nomeProjeto + ".xlsx" ));
		xlsxWorkbook.close();		
	}
	

	
	
	private static class NomeMetodo extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(MethodDeclaration md, List<String> collector) {
			super.visit(md,collector);
			collector.add(md.getDeclarationAsString());
		}
	}
	
	private static class NomeConstrutor extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(ConstructorDeclaration md, List<String> collector) {
			super.visit(md,collector);
			collector.add(md.getDeclarationAsString());
		}
	}
	
	/**
     * Retira o nome dos metodos de cada classe
     */
	public void retirarNomeMetodos() throws FileNotFoundException {

		for (String caminhoClasse : this.classes) {		
			File ficheiroClasse = new File(caminhoClasse);	
			CompilationUnit f = StaticJavaParser.parse(ficheiroClasse);
			List<String> MethodName = new ArrayList<>();
			VoidVisitor<List<String>> MethodNameVisitor = new NomeMetodo();
			MethodNameVisitor.visit(f, MethodName);

			List<String> ConstructorName = new ArrayList<>();
			VoidVisitor<List<String>> ConstrutorNameVisitor = new NomeConstrutor();
			ConstrutorNameVisitor.visit(f, ConstructorName);

			for (String string : MethodName) {
				ConstructorName.add(string);
			}
			
			colocarMetodosArray(ConstructorName);
		}
	}


	private void colocarMetodosArray(List<String> ConstructorName) {
		for (String string : ConstructorName) {
			adicinarAoNomeMetodos(string);
		}
	}


	private void adicinarAoNomeMetodos(String string) {
		String Metodo = extrairNomeMetodo(string);
		this.nomeMetodos.add(Metodo);
	}


	private String extrairNomeMetodo(String string) {
		String[] vetor = string.split("\\(");
		String parametrosMethod = vetor[1];
		String firstMethod = vetor[0];
		String[] nameMethod = firstMethod.split(" ");
		String Method = nameMethod[nameMethod.length - 1].concat("(" + parametrosMethod);
		String[] auxSplit = Method.split(" throws ");
		String[] splitMetodo = auxSplit[0].split(" ");
		String Metodo = splitMetodo[0];
		Metodo = juntarNomeMetodo(splitMetodo, Metodo);
		return Metodo;
	}


	private String juntarNomeMetodo(String[] splitMetodo, String Metodo) {
		for(int i=1; i!=splitMetodo.length; i++) {
			if(i%2==0) {
				Metodo=Metodo+","+splitMetodo[i];
			}
		}
		if(!Metodo.endsWith(")")) {
			Metodo=Metodo+")";
		}
		return Metodo;
	}
	
	
	private static class NomePacote extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(PackageDeclaration md, List<String> collector) {
			super.visit(md,collector);
			collector.add(md.getNameAsString());
		}
	}

	/**
     * Retira o nome do pacote de cada classe
     */
	public void retirarNomePacotes() throws FileNotFoundException {
		int rep =0;
		for (String caminhoClasse : this.classes) {		
			File ficheiroClasse = new File(caminhoClasse);	
			CompilationUnit f = StaticJavaParser.parse(ficheiroClasse);
			List<String> PackageName = new ArrayList<>();
			VoidVisitor<List<String>> PackageNameVisitor = new NomePacote();
			PackageNameVisitor.visit(f, PackageName);
			adicionarAoNomePacotes(rep, PackageName);
			rep++;

		}
	}


	private void adicionarAoNomePacotes(int rep, List<String> PackageName) {
		for (int i = 0; i < this.repeticoes_NOM.get(rep); i++) {
			this.nomePacotes.add(PackageName.get(0));
		}
	}
	
	
	private static class ColecionarNomeConstrutor extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(ConstructorDeclaration md, List<String> collector) {
			super.visit(md,collector);
			collector.add(md.getNameAsString());
		}
	}

	private static class ColecionarNomeMetodo extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(MethodDeclaration md, List<String> collector) {
			super.visit(md,collector);
			collector.add(md.getNameAsString());
		}
	}
	
	/**
     * Calcula o numero de metodos de cada classe
     */
	public void NOM_class() throws FileNotFoundException {
		for (String caminhoClasse : this.classes) {		
			File ficheiroClasse = new File(caminhoClasse);	
			CompilationUnit f = StaticJavaParser.parse(ficheiroClasse);
			List<String> methodNames = new ArrayList<>();
			VoidVisitor<List<String>> methodNameCollector = new ColecionarNomeMetodo();
			methodNameCollector.visit(f, methodNames);

			List<String> constructorNames = new ArrayList<>();
			VoidVisitor<List<String>> constructorNameCollector = new ColecionarNomeConstrutor();
			constructorNameCollector.visit(f, constructorNames);
			adicionarAoRepeticoes_NOM(methodNames, constructorNames);
			adicionarAoNOM_class_array();

			this.NOM_class=0;
		}
	}

	private void adicionarAoRepeticoes_NOM(List<String> methodNames, List<String> constructorNames) {
		for (String string : methodNames) {
			constructorNames.add(string);
		}
		for (String string : constructorNames) {
			this.NOM_class++;
		}
		this.repeticoes_NOM.add(this.NOM_class);
	}


	private void adicionarAoNOM_class_array() {
		for (int i = 0; i < this.NOM_class; i++) {
			this.NOM_class_array.add(this.NOM_class);
		}
	}

	private static class ColecionarClasse extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(ClassOrInterfaceDeclaration md, List<String> collector) {
			super.visit(md, collector);
			collector.add(md.toString());
		}
	}

	/**
     * Calcula o numero de linhas de codigo de cada classe
     */
	public void LOC_class() throws FileNotFoundException {
		int rep =0; 
		for (String caminhoClasse : this.classes) {			
			File ficheiroClasse = new File(caminhoClasse);	
			CompilationUnit f = StaticJavaParser.parse(ficheiroClasse);
			List<String> classCollector = new ArrayList<>();
			VoidVisitor<List<String>> ClassCollector = new ColecionarClasse();
			ClassCollector.visit(f, classCollector);
			
			contagemLinhasPorClasse(rep, classCollector);

			this.LOC_class=1;
			rep++;
		}

	}


	private void contagemLinhasPorClasse(int rep, List<String> classCollector) {
		for (String string : classCollector) {
			String [] vectorS =null;
			vectorS = string.split("\n");
			this.LOC_class = vectorS.length;
			
		}

		adicionarAoLOC_class_array(rep);
	}


	private void adicionarAoLOC_class_array(int rep) {
		for (int i = 0; i < this.repeticoes_NOM.get(rep); i++) {
			this.LOC_class_array.add(this.LOC_class);
		}
	}


	private static class ColecionarMetodo extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(MethodDeclaration md, List<String> collector) {
			super.visit(md, collector);
			collector.add(md.toString());
		}
	}
	
	private static class ColecionarConstrutor extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(ConstructorDeclaration md, List<String> collector) {
			super.visit(md, collector);
			collector.add(md.toString());
		}
	}
	
	/**
     * Calcula a complexidade de cada classe baseando-se para isso na soma das complexidades ciclomaticas de cada metodo da classe
     */
	public void WMC_class() throws FileNotFoundException {
		int rep =0;
		for (String caminhoClasse : this.classes) {			
			File ficheiroClasse = new File(caminhoClasse);		
			CompilationUnit f = StaticJavaParser.parse(ficheiroClasse);
			List<String> methods = new ArrayList<>();
			VoidVisitor<List<String>> methodCollector = new ColecionarMetodo();
			methodCollector.visit(f, methods);

			List<String> constructors = new ArrayList<>();
			VoidVisitor<List<String>> constructorCollector = new ColecionarConstrutor();
			constructorCollector.visit(f, constructors);

			adicionarAoWMC_class_array(rep, methods, constructors);

			rep++;
			this.WMC_class=0;
		}
	}


	private void adicionarAoWMC_class_array(int rep, List<String> methods, List<String> constructors) {
		for (String string : methods) {
			constructors.add(string);
		}

		for (String string : constructors) {
			this.WMC_class = this.WMC_class + contarComplexidadeDeMetodo(string);
		}
		for (int i = 0; i < this.repeticoes_NOM.get(rep); i++) {
			this.WMC_class_array.add(this.WMC_class);
		}
	}

	/**
     * Calcula o numero de linhas de codigo de cada metodo
     */
	public void LOC_method() throws FileNotFoundException {
		for (String caminhoClasse : this.classes) {			
			File ficheiroClasse = new File(caminhoClasse);		
			CompilationUnit f = StaticJavaParser.parse(ficheiroClasse);
			List<String> methods = new ArrayList<>();
			VoidVisitor<List<String>> methodCollector = new ColecionarMetodo();
			methodCollector.visit(f, methods);

			List<String> constructors = new ArrayList<>();
			VoidVisitor<List<String>> constructorCollector = new ColecionarConstrutor();
			constructorCollector.visit(f, constructors);

			for (String string : methods) {
				constructors.add(string);
			}

			for (String string : constructors) {
				adicionarAoLOC_method_array(string);
				this.LOC_method =0;
			}
		}
	}


	private void adicionarAoLOC_method_array(String string) {
		String[] vectorS = null;
		vectorS = string.split("\n");
		this.LOC_method = vectorS.length;
		this.LOC_method_array.add(this.LOC_method);
	}


	private int contarComplexidadeDeMetodo(String s) {
		int result=0;
		String [] vectorS = null;
		vectorS = s.split(" ");
		for(int i=0; i<vectorS.length; i++) {
			if(vectorS[i].contains("for") || vectorS[i].contains("while") || vectorS[i].contains("if") || vectorS[i].contains("case") || vectorS[i].contains("default")) {
				result++;
			}
		}
		result++;
		return result;
	}

	/**
     * Calcula a complexidade ciclomatica de cada metodo
     */
	public void CYCLO_method() throws FileNotFoundException {
		for (String caminhoClasse : this.classes) {			
			File ficheiroClasse = new File(caminhoClasse);		
			CompilationUnit f = StaticJavaParser.parse(ficheiroClasse);
			List<String> methods = new ArrayList<>();
			VoidVisitor<List<String>> methodCollector = new ColecionarMetodo();
			methodCollector.visit(f, methods);

			List<String> constructors = new ArrayList<>();
			VoidVisitor<List<String>> constructorCollector = new ColecionarConstrutor();
			constructorCollector.visit(f, constructors);

			for (String string : methods) {
				constructors.add(string);
			}

			for (String string : constructors) {
				adicionarAoCYCLO_method_array(string);
				this.CYCLO_method=0;
			}
		}
	}


	private void adicionarAoCYCLO_method_array(String string) {
		this.CYCLO_method = contarComplexidadeDeMetodo(string);
		this.CYCLO_method_array.add(this.CYCLO_method);
	}


	private static class ColecionarNomeClasse extends VoidVisitorAdapter<List<String>>{
	    @Override
	    public void visit(ClassOrInterfaceDeclaration n, List<String> collector) {
	        super.visit(n, collector);
	        collector.add(n.getNameAsString());
	    }
	}

	/**
     * Retira o nome das classes do projeto selecionado pelo utilizador
     */
	public void retirarNomeClasses() throws FileNotFoundException {
		
		int rep =0;
		for (String caminhoClasse : this.classes) {											
			List<String> className = new ArrayList<>();
		    CompilationUnit cu = StaticJavaParser.parse(new File(caminhoClasse));
		    VoidVisitor<List<String>> classNameVisitor = new ColecionarNomeClasse();
		    classNameVisitor.visit(cu,className);
			adicionarAoNomeClasses(rep, className);
			rep++;
		}
		this.numeroClasses=rep;
	}


	private void adicionarAoNomeClasses(int rep, List<String> className) {
		for (int i = 0; i < this.repeticoes_NOM.get(rep); i++) {
			this.nomeClasses.add(className.get(className.size()-1));
		}
	}

	
}