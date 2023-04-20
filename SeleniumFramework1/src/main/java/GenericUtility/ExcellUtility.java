package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellUtility {
	public String getExcellData(String sheetName, int rowNum, int cellNum) throws Throwable, Throwable
	{
		FileInputStream fes=new FileInputStream("./src/test/resources/Properties.xlsx.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(cellNum);
        String value = cell.getStringCellValue();
		return value;
	}
	
 public String getExcellDataFormatter(String sheetName, int rowNum, int cellNum) throws Throwable, Throwable
 {
 FileInputStream fes=new FileInputStream("./src/test/resources/Properties.xlsx.xlsx");
	Workbook book = WorkbookFactory.create(fes);
	DataFormatter format=new DataFormatter();
String data = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
return data;
 }
	public Object[][] readMultipleData(String SheetName,int rowNum,int cellNum) throws Throwable{
		FileInputStream fes=new FileInputStream("./src/test/resources/Properties.xlsx.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet she = book.getSheet(SheetName);
		int lastRow = she.getLastRowNum()+1;
		int lastcell = she.getRow(0).getLastCellNum();
		Object[][] obj=new Object[lastRow][lastcell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;i<lastcell;j++)
			{
				obj[i][j]=she.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return obj;
		
	}
}

 
