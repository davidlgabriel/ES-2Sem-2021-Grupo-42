package g42.CodeQualityAssessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class EscreverMétricasParaExcel {
	
	//Atributos
	
	private ArrayList<String> classes;
	
	private int NOM_class;
	private int LOC_class;
	private int WMC_class;
	private int LOC_method;
	private int CYCLO_method;
	
	//Construtor
	
	public EscreverMétricasParaExcel(ArrayList<String> classes) {
		this.classes=classes;
		this.NOM_class=0;
		this.LOC_class=1;
		this.WMC_class=0;
		this.LOC_method=0;
		this.CYCLO_method=0;
	}

	//Getters
	
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
	
	public void escreverNomeDoFicheiro() {
		String nomeProjeto = this.classes.remove(0);
		//dar o nome ao Excel
		//extrair o nome das classes
		//extrair o nome dos métodos
	}
	
	/*public static void main(String[] args) throws Exception {
	    String wordToSearch = "the";
	    String data = "the their father them therefore then";
	    int count = 0;
	    for (int index = data.indexOf(wordToSearch); 
	             index != -1; 
	             index = data.indexOf(wordToSearch, index + 1)) {
	        count++;
	    }

	    System.out.println(count);
	}*/
	
	private static class MethodCollector extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(MethodDeclaration md, List<String> collector) {
			super.visit(md, collector);
			collector.add(md.toString());
		}
	}
	private static class MethodNameCollector extends VoidVisitorAdapter<List<String>> {

		@Override
		public void visit(MethodDeclaration md, List<String> collector) {
			super.visit(md,collector);
			collector.add(md.getNameAsString());
		}
	}
	
	public void NOM_class() throws FileNotFoundException {
		for (String caminhoClasse : this.classes) {			
			File ficheiroClasse = new File(caminhoClasse);	
			CompilationUnit f = StaticJavaParser.parse(ficheiroClasse);
			List<String> methodNames = new ArrayList<>();
			VoidVisitor<List<String>> methodNameCollector = new MethodNameCollector();
			methodNameCollector.visit(f, methodNames);
			for(String s : methodNames) {
				if(!s.equals("main")) {
					this.NOM_class++;
				}
			}
			//System.out.println(this.NOM_class);
			this.NOM_class=0;
		}
	}
	
	public void LOC_class() throws FileNotFoundException {
		for (String caminhoClasse : this.classes) {			
			File ficheiroClasse = new File(caminhoClasse);	
			Scanner lerFicheiroClasse = new Scanner(ficheiroClasse);	
			while (lerFicheiroClasse.hasNextLine()) {		
				this.LOC_class++;							
				lerFicheiroClasse.nextLine();				
			}
			//System.out.println(this.LOC_class);
			this.LOC_class=1;
			lerFicheiroClasse.close();
		}

	}
	
	public void LOC_method() throws FileNotFoundException {
		for (String caminhoClasse : this.classes) {			
			File ficheiroClasse = new File(caminhoClasse);		
			CompilationUnit f = StaticJavaParser.parse(ficheiroClasse);
			List<String> methods = new ArrayList<>();
			VoidVisitor<List<String>> methodCollector = new MethodCollector();
			methodCollector.visit(f, methods);
			String [] vectorS =null;
			for (String s : methods) {
				if (!s.contains("void main")) {
					vectorS = s.split("\n");
					this.LOC_method = vectorS.length;
				}
				//System.out.println(this.LOC_method);
				this.LOC_method =0;
				vectorS = null;
			}
		}
	}
	
	
	//Testar

	public static void main(String[] args) throws FileNotFoundException {
		/*String cu = "C:\\Users\\David Gabriel\\git\\ES-2Sem-2021-Grupo-42\\CodeQualityAssessor\\src\\main\\java\\g42\\CodeQualityAssessor\\App.java";
		CompilationUnit cu1 = StaticJavaParser.parse(new File(cu));
		List<String> methodNames = new ArrayList<>();
		VoidVisitor<List<String>> methodNameCollector = new MethodNameCollector();
		methodNameCollector.visit(cu1, methodNames);
		System.out.println(methodNames);*/
		//methodNames.forEach(n -> System.out.println("Method Name Collected: " + n));

		
		
		ArrayList<String> lista = new ArrayList<String>();
		String s = "C:\\Users\\David Gabriel\\git\\ES-2Sem-2021-Grupo-42\\CodeQualityAssessor\\src\\main\\java\\g42\\CodeQualityAssessor\\App.java";
		lista.add(s);
		EscreverMétricasParaExcel a = new EscreverMétricasParaExcel(lista);
		a.LOC_class();
		a.NOM_class();
		a.LOC_method();
	}
	

}
