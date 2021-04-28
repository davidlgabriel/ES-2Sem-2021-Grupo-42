package g42.CodeQualityAssessor;

public class Linha {


	private int methodID;
	private String packageNome;
	private String classNome;
	private String methodNome;
	private int NOM_Class;
	private int LOC_Class;
	private int WMC_Class;
	private boolean is_God_Class ;
	private int LOC_Method;
	private int Cyclo_Method; 
	private boolean is_Long_Method;

	public Linha(int methodID, String packageNome, String classNome, String methodNome, int nOM_Class, int lOC_Class,int wMC_Class, boolean is_God_Class, int lOC_Method, int cyclo_Method, boolean is_Long_Method) {
		this.methodID = methodID;
		this.packageNome = packageNome;
		this.classNome = classNome;
		this.methodNome = methodNome;
		this.NOM_Class = nOM_Class;
		this.LOC_Class = lOC_Class;
		this.WMC_Class = wMC_Class;
		this.is_God_Class = is_God_Class;
		this.LOC_Method = lOC_Method;
		this.Cyclo_Method = cyclo_Method;
		this.is_Long_Method = is_Long_Method;
	}

	public int getMethodID() {
		return methodID;
	}

	public String getPackageNome() {
		return packageNome;
	}

	public String getClassNome() {
		return classNome;
	}

	public String getMethodNome() {
		return methodNome;
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

	public boolean isIs_God_Class() {
		return is_God_Class;
	}

	public int getLOC_Method() {
		return LOC_Method;
	}

	public int getCyclo_Method() {
		return Cyclo_Method;
	}

	public boolean isIs_Long_Method() {
		return is_Long_Method;
	}

	@Override
	public String toString() {
		return "Linha [methodID=" + methodID + ", packageNome=" + packageNome + ", classNome=" + classNome
				+ ", methodNome=" + methodNome + ", NOM_Class=" + NOM_Class + ", LOC_Class=" + LOC_Class
				+ ", WMC_Class=" + WMC_Class + ", is_God_Class=" + is_God_Class + ", LOC_Method=" + LOC_Method
				+ ", Cyclo_Method=" + Cyclo_Method + ", is_Long_Method=" + is_Long_Method + "]";
	}
	
	



}
