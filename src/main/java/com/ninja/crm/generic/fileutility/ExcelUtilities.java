package com.ninja.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {
	public String getDataFromexcelFile(String sheetname, int row , int col) throws EncryptedDocumentException, IOException {
		 FileInputStream fis= new FileInputStream("./src/test/resources/testdata.xlsx");
		 
		   Workbook wo = WorkbookFactory.create(fis);
		   String data = wo.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	
		return data;
	}
public	int getRowCount (String sheetname1) throws EncryptedDocumentException, IOException {
		FileInputStream fis2= new FileInputStream("./src/test/resources/testdata.xlsx");
		 
		   Workbook wo2 = WorkbookFactory.create(fis2);
		   int rowcount=wo2.getSheet(sheetname1).getLastRowNum();
		   return rowcount;
	}

public void setDataIntoExcel(String sheetname , int row, int col, String data) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis= new FileInputStream("./src/test/resources/testdata.xlsx");
	Workbook wo = WorkbookFactory.create(fis);
	wo.getSheet(sheetname).getRow(row).createCell(col);
	
	FileOutputStream fos = new FileOutputStream("./src/test/resources/testdata.xlsx");
	wo.write(fos);
	wo.close();
	
}
		

}
