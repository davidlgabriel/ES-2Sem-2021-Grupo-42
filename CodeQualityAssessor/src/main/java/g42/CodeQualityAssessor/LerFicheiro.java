package g42.CodeQualityAssessor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class LerFicheiro {
	private XSSFWorkbook workbook;
	
	private XSSFSheet sheet;
	
	private List<Linha> listaLinhas;
	
	public LerFicheiro(String nomeFicheiro){
		try {
			workbook = new XSSFWorkbook(new FileInputStream(nomeFicheiro));
		} catch (IOException e) {
			System.out.println("File error.");
		}
		sheet = workbook.getSheetAt(0);
	}
	
	public Linha lerLinha(int linha_a_Ler){
		XSSFRow linha = sheet.getRow(linha_a_Ler); 
		int idMetodo = (int)linha.getCell(0).getNumericCellValue();
		String nomePacote = linha.getCell(1).getStringCellValue();
		String nomeClasse = linha.getCell(2).getStringCellValue();
		String nomeMetodo = linha.getCell(3).getStringCellValue();
		int NOM_Class = (int)linha.getCell(4).getNumericCellValue();
		int LOC_Class = (int)linha.getCell(5).getNumericCellValue();
		int WMC_Class = (int)linha.getCell(6).getNumericCellValue();
		String is_God_Class = linha.getCell(7).getStringCellValue();
		int LOC_Method = (int)linha.getCell(8).getNumericCellValue();
		int Cyclo_Method= (int)linha.getCell(9).getNumericCellValue();
		String is_Long_Method = linha.getCell(10).getStringCellValue();
		return new Linha(idMetodo, nomePacote, nomeClasse, nomeMetodo, NOM_Class, LOC_Class,WMC_Class, is_God_Class, LOC_Method, Cyclo_Method, is_Long_Method);
	}

	
	public List<Linha> lerTodasLinhas(){
		listaLinhas = new ArrayList<Linha>();
		int ultimaLinha = sheet.getLastRowNum();
		for(int i = 1; i<=ultimaLinha; i++){
			Linha linha= lerLinha(i);
			listaLinhas.add(linha);
		}
		return listaLinhas;
	}

	
}
