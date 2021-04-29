package g42.CodeQualityAssessor;

import java.util.ArrayList;
import java.util.List;



public class Ficheiro {

	private String fileName;
	
	private List<Linha> lista = new ArrayList<Linha>();
	
	public Ficheiro(String fileName){
		this.fileName = fileName;
		readFile();
	}
	
	private void readFile(){
		LerFicheiro file = new LerFicheiro(fileName);
		lista = file.lerTodasLinhas();
	}
	
	public String getFileName(){
		return fileName;
	}
	
	public List<Linha> getLista() {
		return lista;
	}
	
}
