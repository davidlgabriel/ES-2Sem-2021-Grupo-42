package g42.CodeQualityAssessor;

public class Linha {


	private int idMetodo;
	private String nomePacote;
	private String nomeClasse;
	private String nomeMetodo;
	private int NOM_Class;
	private int LOC_Class;
	private int WMC_Class;
	private String is_God_Class;
	private int LOC_Method;
	private int Cyclo_Method; 
	private String is_Long_Method;

	/**
     * Inicializa um objeto Linha 
     * @param idMetodo - refere-se ao id de cada linha do excel
     * @param nomePacote - refere-se ao nome do package associada a classe  
     * @param nomeClasse - nome da classe
     * @param nomeMetodo - nome do metodo
     * @param nOM_Class - numero de metodos de cada classe
     * @param lOC_Class - numero de linhas de cada classe
     * @param wMC_Class  - Complexidade da classe
     * @param is_God_Class - Code Smells 
     * @param lOC_Method - numero de linhas de cada metodo
     * @param cyclo_Method - complexidade ciclomatica de cada metodo
     * @param is_Long_Method - Code Smells 
     */

	public Linha(int idMetodo, String nomePacote, String nomeClasse, String nomeMetodo, int nOM_Class, int lOC_Class,
			int wMC_Class, String is_God_Class, int lOC_Method, int cyclo_Method, String is_Long_Method) {
		super();
		this.idMetodo = idMetodo;
		this.nomePacote = nomePacote;
		this.nomeClasse = nomeClasse;
		this.nomeMetodo = nomeMetodo;
		this.NOM_Class = nOM_Class;
		this.LOC_Class = lOC_Class;
		this.WMC_Class = wMC_Class;
		this.is_God_Class = is_God_Class;
		this.LOC_Method = lOC_Method;
		this.Cyclo_Method = cyclo_Method;
		this.is_Long_Method = is_Long_Method;
	}
	
	/**
     * Devolve o id de cada linha do excel
     * @return idMetodo
     */

	public int getIdMetodo() {
		return idMetodo;
	}
	
	/**
     * Devolve o nome do package associada a classe
     * @return nomePacote  
     */
	public String getNomePacote() {
		return nomePacote;
	}
	
	/**
     * Devolve o nome da classe
     * @return nomeClasse  
     */
	public String getNomeClasse() {
		return nomeClasse;
	}

	/**
     * Devolve o nome do metodo
     * @return nomeMetodo  
     */
	public String getNomeMetodo() {
		return nomeMetodo;
	}
	
	/**
     * Devolve o numero de metodos de cada classe
     * @return NOM_Class  
     */
	public int getNOM_Class() {
		return NOM_Class;
	}

	/**
     * Devolve o numero de linhas de cada classe
     * @return LOC_Class  
     */
	public int getLOC_Class() {
		return LOC_Class;
	}
	
	/**
     * Devolve a complexidade da classe
     * @return WMC_Class  
     */
	public int getWMC_Class() {
		return WMC_Class;
	}

	/**
     * Devolve um code smells 
     * @return is_God_Class  
     */
	public String isIs_God_Class() {
		return is_God_Class;
	}

	/**
     * Devolve o numero de linhas de cada metodo
     * @return LOC_Method  
     */
	public int getLOC_Method() {
		return LOC_Method;
	}

	/**
     * Devolve a complexidade ciclomatica de cada metodo
     * @return Cyclo_Method  
     */
	public int getCyclo_Method() {
		return Cyclo_Method;
	}
	
	/**
     * Devolve um code smells 
     * @return is_Long_Method  
     */
	public String isIs_Long_Method() {
		return is_Long_Method;
	}

	/**
     * Representação em texto do objeto Linha
     * @return String com a informacao do objeto
     */
	
	@Override
	public String toString() {
		return "Linha [idMetodo=" + idMetodo + ", nomePacote=" + nomePacote + ", nomeClasse=" + nomeClasse
				+ ", nomeMetodo=" + nomeMetodo + ", NOM_Class=" + NOM_Class + ", LOC_Class=" + LOC_Class
				+ ", WMC_Class=" + WMC_Class + ", is_God_Class=" + is_God_Class + ", LOC_Method=" + LOC_Method
				+ ", Cyclo_Method=" + Cyclo_Method + ", is_Long_Method=" + is_Long_Method + "]";
	}
	
	
}
