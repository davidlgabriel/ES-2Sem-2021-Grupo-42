package g42.CodeQualityAssessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
	}
	
	public void LOC_class() throws FileNotFoundException {
		for (String caminhoClasse : this.classes) {			
			File ficheiroClasse = new File(caminhoClasse);	
			Scanner lerFicheiroClasse = new Scanner(ficheiroClasse);	
			//extrair o nome da classe e colocá-lo corretamente no Excel
			while (lerFicheiroClasse.hasNextLine()) {		
				this.LOC_class++;							
				lerFicheiroClasse.nextLine();				
			}
			//escrever em Excel que esta classe tem este número de linhas (fazê-lo nas células corretas).
			this.LOC_class=0;
			lerFicheiroClasse.close();
		}

	}
	
	public static void main(String[] args) throws FileNotFoundException {
		EscreverMétricasParaExcel a = new EscreverMétricasParaExcel();
		a.LOC_class();
	}
	

}
