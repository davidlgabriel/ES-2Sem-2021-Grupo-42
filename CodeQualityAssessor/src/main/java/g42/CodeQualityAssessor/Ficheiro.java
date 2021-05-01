package g42.CodeQualityAssessor;

import java.util.ArrayList;
import java.util.List;



public class Ficheiro {

	private String nomeFicheiro;
	
	private List<Linha> lista = new ArrayList<Linha>();
	
	public Ficheiro(String fileName){
		this.nomeFicheiro = fileName;
		lerFicheiro();
	}
	
	private void lerFicheiro(){
		LerFicheiro file = new LerFicheiro(nomeFicheiro);
		lista = file.lerTodasLinhas();
	}
	
	public String getNomeFicheiro(){
		return nomeFicheiro;
	}
	
	public List<Linha> getLista() {
		return lista;
	}
	
}
