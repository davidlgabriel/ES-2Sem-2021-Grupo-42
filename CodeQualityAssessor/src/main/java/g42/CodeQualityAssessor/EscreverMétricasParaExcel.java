package g42.CodeQualityAssessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

public class EscreverMétricasParaExcel {
	
	//Atributos
	
	private ArrayList<String> classes;
	
	private int NOM_class;
	private int LOC_class;
	private int WMC_class;
	private int LOC_method;
	private int CYCLO_method;
	
	//Construtor
	
	public EscreverMétricasParaExcel() {
		this.LOC_class=0;
	}
	
	public EscreverMétricasParaExcel(ArrayList<String> classes) {
		this.classes=classes;
		this.NOM_class=0;
		this.LOC_class=0;
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
	
	public void NOM_class() throws FileNotFoundException {
		for (String caminhoClasse : this.classes) {			
			File ficheiroClasse = new File(caminhoClasse);	
			Scanner lerFicheiroClasse = new Scanner(ficheiroClasse);	
			while (lerFicheiroClasse.hasNextLine()) {
				String linha = lerFicheiroClasse.nextLine();
				Pattern pattern = Pattern.compile("delimitação de método"); //delimitar inicio do metodo
			    Matcher matcher = pattern.matcher(linha);
			    boolean matchFound = matcher.find();
			    if(matchFound) {
			    	this.NOM_class++;
			    }
			}
			this.NOM_class=0;
			lerFicheiroClasse.close();
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
			//escrever em Excel que esta classe tem este número de linhas (fazê-lo nas células corretas).
			this.LOC_class=0;
			lerFicheiroClasse.close();
		}

	}
	
	
	
	
	//Testar
	private static final String FILE_PATH = "C:\\Users\\David Gabriel\\git\\ES-2Sem-2021-Grupo-42\\CodeQualityAssessor\\src\\main\\java\\g42\\CodeQualityAssessor\\App.java";

	public static void main(String[] args) throws FileNotFoundException {
		
		CompilationUnit cu = StaticJavaParser.parse(new File(FILE_PATH));
		//EscreverMétricasParaExcel a = new EscreverMétricasParaExcel();
		//a.LOC_class();
	}
	

}
