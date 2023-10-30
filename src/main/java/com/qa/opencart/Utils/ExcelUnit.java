package com.qa.opencart.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUnit {
	public static final String  TEST_DATA_SHEET_PATH="./src/test/resources/testdata/openCartAPPTestData.xlsx";
   public static  Workbook book;
   public static Sheet sheet;

public static void getTestData(String SheeetName) {
	Object data[][]=null;
	
	
	try {
		FileInputStream ip=new FileInputStream(TEST_DATA_SHEET_PATH);
		
		book=WorkbookFactory.create(ip);
		sheet=book.getSheet(SheeetName);
		data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
