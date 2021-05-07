package g42.CodeQualityAssessor;

import java.util.ArrayList;
import java.util.List;



public class Ficheiro {

	private String nomeFicheiro;
	
	private List<Linha> listaLinhas = new ArrayList<Linha>();
	
	/**
     * Inicializa um objeto Ficheiro
     * @param fileName - com o nome do ficheiro
     */
	public Ficheiro(String fileName){
		this.nomeFicheiro = fileName;
		lerFicheiro();
	}
	
	private void lerFicheiro(){
		LerFicheiro file = new LerFicheiro(nomeFicheiro);
		listaLinhas = file.lerTodasLinhas();
	}
	
	/**
     * Devolve o nome do ficheiro
     * @return nomeFicheiro
     */
	public String getNomeFicheiro(){
		return nomeFicheiro;
	}
	
	/**
     * Devolve uma lista com as linhas do ficheiro
     * @return listaLinhas
     */
	public List<Linha> getListaLinhas() {
		return listaLinhas;
	}
	
}
