package g42.CodeQualityAssessor;

import java.util.ArrayList;
import java.util.List;



public class Ficheiro {

	/** The file name. */
	private String fileName;
	
	/** The row list. */
	private List<Linha> lista = new ArrayList<Linha>();
	
	/**
	 * Instantiates a new my file.
	 *
	 * @param fileName the file name
	 */
	public Ficheiro(String fileName){
		this.fileName = fileName;
		readFile();
	}
	
	public Linha getRowOfMethodID(int methodID){
		return lista.get(methodID-1);
	}
	
	/**
	 * Read file.
	 */
	private void readFile(){
		LerFicheiro file = new LerFicheiro(fileName);
		lista = file.lerTodasLinhas();
	}
	
	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 */
	public String getFileName(){
		return fileName;
	}
	
	/**
	 * Gets the row list.
	 *
	 * @return the row list
	 */
	public List<Linha> getLista() {
		return lista;
	}
	
}
