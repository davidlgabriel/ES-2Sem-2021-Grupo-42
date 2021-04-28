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
	
	private List<Linha> lista = new ArrayList<Linha>();
	
	public LerFicheiro(String nomeFicheiro){
		try {
			workbook = new XSSFWorkbook(new FileInputStream(nomeFicheiro));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
		} catch (IOException e) {
			System.out.println("Error reading file.");
		}
		sheet = workbook.getSheetAt(0);
	}
	
	public Linha lerLinha(int linha_a_Ler){
		XSSFRow linha = sheet.getRow(linha_a_Ler); 
		int methodID = (int)linha.getCell(0).getNumericCellValue();
		String packageNome = linha.getCell(1).getStringCellValue();
		String classNome = linha.getCell(2).getStringCellValue();
		String methodNome = linha.getCell(3).getStringCellValue();
		int NOM_Class = (int)linha.getCell(4).getNumericCellValue();
		int LOC_Class = (int)linha.getCell(5).getNumericCellValue();
		int WMC_Class = (int)linha.getCell(6).getNumericCellValue();
		boolean is_God_Class=false;
		if (!linha.getCell(7).getCellType().toString().equals("STRING")) {
			is_God_Class = linha.getCell(7).getBooleanCellValue();
		}
		int LOC_Method = (int)linha.getCell(8).getNumericCellValue();
		int Cyclo_Method= (int)linha.getCell(9).getNumericCellValue();
		boolean is_Long_Method =false;
		if (!linha.getCell(10).getCellType().toString().equals("STRING")) {
			 is_Long_Method = linha.getCell(10).getBooleanCellValue();
		}
		return new Linha(methodID, packageNome, classNome, methodNome, NOM_Class, LOC_Class,WMC_Class, is_God_Class, LOC_Method, Cyclo_Method, is_Long_Method);
	}

	
	public List<Linha> lerTodasLinhas(){
		int ultimaLinha = sheet.getLastRowNum();
		for(int i = 1; i<=ultimaLinha; i++){
			Linha linha= lerLinha(i);
			lista.add(linha);
		}
	
		return lista;
	}

	

}
