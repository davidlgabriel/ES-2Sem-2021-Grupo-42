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

	public int getIdMetodo() {
		return idMetodo;
	}

	public String getNomePacote() {
		return nomePacote;
	}

	public String getNomeClasse() {
		return nomeClasse;
	}

	public String getNomeMetodo() {
		return nomeMetodo;
	}

	public int getNOM_Class() {
		return NOM_Class;
	}

	public int getLOC_Class() {
		return LOC_Class;
	}

	public int getWMC_Class() {
		return WMC_Class;
	}

	public String isIs_God_Class() {
		return is_God_Class;
	}

	public int getLOC_Method() {
		return LOC_Method;
	}

	public int getCyclo_Method() {
		return Cyclo_Method;
	}

	public String isIs_Long_Method() {
		return is_Long_Method;
	}

	
	@Override
	public String toString() {
		return "Linha [idMetodo=" + idMetodo + ", nomePacote=" + nomePacote + ", nomeClasse=" + nomeClasse
				+ ", nomeMetodo=" + nomeMetodo + ", NOM_Class=" + NOM_Class + ", LOC_Class=" + LOC_Class
				+ ", WMC_Class=" + WMC_Class + ", is_God_Class=" + is_God_Class + ", LOC_Method=" + LOC_Method
				+ ", Cyclo_Method=" + Cyclo_Method + ", is_Long_Method=" + is_Long_Method + "]";
	}
	
	
}
