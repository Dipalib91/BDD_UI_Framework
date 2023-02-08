package utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtiils {
	public Workbook getWorkBook(String excelFilePath) throws EncryptedDocumentException, IOException {
		return WorkbookFactory.create(new File(excelFilePath));
	}
	public Sheet getSheetByName(String excelFilePath, String sheetName) throws EncryptedDocumentException, IOException {
		Sheet sheet=  getWorkBook(excelFilePath).getSheet(sheetName);
		return sheet;
	}
	public Map<String, String> getExcelDataAsMap(String excelFilePath,String sheetName) throws EncryptedDocumentException, IOException {
		Workbook workbook =  WorkbookFactory.create(new File(excelFilePath));
		Sheet sh =  workbook.getSheet(sheetName);
		Map<String, String> data = new HashMap<String, String>();
		int rowCount = sh.getPhysicalNumberOfRows();
		
		for(int i=1;i<rowCount;i++) {
			Row row = sh.getRow(i);
			String fieldName = row.getCell(0).getStringCellValue();
			String fieldValue = row.getCell(1).getStringCellValue();
			data.put(fieldName, fieldValue);
		}
		return data;
	}
	
}
