package g42.CodeQualityAssessor;

public class Regra {
	
	private String nome;
	private String expressao;
	private boolean valorCodeSmell;
	private int tipoCodeSmell; // 0 long method, 1 god class
	
	public Regra(String nome, String expressao, boolean valorCodeSmell, int tipoCodeSmell) {
		this.nome = nome;
		this.expressao = expressao;
		this.valorCodeSmell = valorCodeSmell;
		this.tipoCodeSmell = tipoCodeSmell;
	}

	public String getNome() {
		return nome;
	}

	public String getexpressao() {
		return expressao;
	}

	public boolean getvalorCodeSmell() {
		return valorCodeSmell;
	}
	
	public int gettipoCodeSmell() {
		return tipoCodeSmell;
	}
}