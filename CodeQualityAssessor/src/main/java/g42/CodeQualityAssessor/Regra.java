package g42.CodeQualityAssessor;

public class Regra {
		private String nome;
		private String expressao;
		private boolean valorCodeSmell;
		private int tipoCodeSmell; // 0 long method, 1 god class
		
		/**
	     * Inicializa os atributos com os valores passados
	     * @param nome - nome da regra
	     * @param expressao - expressão da regra
	     * @param valorCodeSmell - valor boolean do code smell caso se verifique a expressão
	     * @param tipoCodeSmell- 0 para Long Method e 1 para God Class
	     */
		public Regra(String nome, String expressao, boolean valorCodeSmell, int tipoCodeSmell) {
			this.nome = nome;
			this.expressao = expressao;
			this.valorCodeSmell = valorCodeSmell;
			this.tipoCodeSmell = tipoCodeSmell;
		}
		
		/**
	     * Devolve o nome da regra
	     * @return nome da regra
	     */
		public String getNome() {
			return nome;
		}
		
		/**
	     * Devolve a expressão da regra
	     * @return expressão da regra
	     */
		public String getExpressao() {
			return expressao;
		}
		
		/**
	     * Devolve o valor boolean da regra associada a um code smell
	     * @return valor boolean
	     */
		public boolean getValorCodeSmell() {
			return valorCodeSmell;
		}
		
		/**
	     * Devolve o tipo de code smell a que a regra está associada
	     * @return tipo do code smell
	     */
		public int getTipoCodeSmell() {
			return tipoCodeSmell;
		}
	}