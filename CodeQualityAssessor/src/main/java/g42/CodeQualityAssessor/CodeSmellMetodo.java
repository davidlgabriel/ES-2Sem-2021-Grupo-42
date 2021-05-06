package g42.CodeQualityAssessor;

public class CodeSmellMetodo {
	
	private String pacote_classe_metodo;
	private boolean is_God_Class;
	private boolean is_Long_Method;
	
	public CodeSmellMetodo(String pacote_classe_metodo, boolean is_God_Class, boolean is_Long_Method) {
		this.pacote_classe_metodo = pacote_classe_metodo;
		this.is_God_Class = is_God_Class;
		this.is_Long_Method = is_Long_Method;
	}
	
	public boolean getIs_God_Class() {
		return is_God_Class;
	}
	public boolean getIs_Long_Method() {
		return is_Long_Method;
	}

	public String getpacote_classe_metodo() {
		return pacote_classe_metodo;
	}
}
