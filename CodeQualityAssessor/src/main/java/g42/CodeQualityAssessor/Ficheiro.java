package g42.CodeQualityAssessor;

import java.util.ArrayList;
import java.util.List;



public class Ficheiro {

	private String nomeFicheiro;
	
	private List<Linha> listaLinhas = new ArrayList<Linha>();
	
	public Ficheiro(String fileName){
		this.nomeFicheiro = fileName;
		lerFicheiro();
	}
	
	private void lerFicheiro(){
		LerFicheiro file = new LerFicheiro(nomeFicheiro);
		listaLinhas = file.lerTodasLinhas();
	}
	
	public String getNomeFicheiro(){
		return nomeFicheiro;
	}
	
	public List<Linha> getListaLinhas() {
		return listaLinhas;
	}
	
}
