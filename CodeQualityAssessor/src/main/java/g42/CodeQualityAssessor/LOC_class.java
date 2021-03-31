package g42.CodeQualityAssessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LOC_class {
	
	//Atributos
	
	private int LOC_class;
	
	public LOC_class(ArrayList<String> classes) throws FileNotFoundException {
		classes.remove(0);								
		for (String caminhoClasse : classes) {			
			File ficheiroClasse = new File(caminhoClasse);	
			Scanner lerFicheiroClasse = new Scanner(ficheiroClasse);	
			//extrair o nome da classe e colocá-lo corretamente no Excel
			while (lerFicheiroClasse.hasNextLine()) {		
				this.LOC_class++;							
				lerFicheiroClasse.nextLine();				
			}
			//escrever em Excel que esta classe tem este número de linhas (fazê-lo nas células corretas).
			this.LOC_class=0;
			lerFicheiroClasse.close();
		}
	}
	
	
	
}
