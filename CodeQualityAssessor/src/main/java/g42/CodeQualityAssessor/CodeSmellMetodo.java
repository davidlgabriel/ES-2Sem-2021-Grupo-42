package g42.CodeQualityAssessor;

public class CodeSmellMetodo {
	
	private String pacote_classe_metodo;
	private boolean is_God_Class;
	private boolean is_Long_Method;
	
	/**
     * Inicializa os atributos com os valores passados
     * @param pacote_classe_metodo - nome do pacote, classe e metodo
     * @param is_God_Class - indica se se verifica o code smell God Class
     * @param is_Long_Method - indica se se verifica o code smell Long Method
     */
	public CodeSmellMetodo(String pacote_classe_metodo, boolean is_God_Class, boolean is_Long_Method) {
		this.pacote_classe_metodo = pacote_classe_metodo;
		this.is_God_Class = is_God_Class;
		this.is_Long_Method = is_Long_Method;
	}
	
	/**
     * Devolve o valor boolean do code smell God Class
     * @return boolean do code smell God Class
     */
	public boolean getIs_God_Class() {
		return is_God_Class;
	}
	
	/**
     * Devolve o valor boolean do code smell Long Method
     * @return boolean do code smell Long Method
     */
	public boolean getIs_Long_Method() {
		return is_Long_Method;
	}

	/**
     * Devolve o nome do pacote, classe e metodo
     * @return String com pacote, classe e metodo
     */
	public String getpacote_classe_metodo() {
		return pacote_classe_metodo;
	}
}