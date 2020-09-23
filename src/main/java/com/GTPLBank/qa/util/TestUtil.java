package com.GTPLBank.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
public static String TESTDATA_SHEET_PATH = "F:/BDD_Project/GTPLBankTest/src/main/java/com/GTPBank/qa/testdata/NewCustomerEntry.xlsx";
	
	static Workbook book;
	static Sheet sheet1;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet1 = book.getSheet(sheetName);
		Object[][] data = new Object[sheet1.getLastRowNum()][sheet1.getRow(1).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet1.getLastRowNum(); i++) {
			for (int k = 0; k < sheet1.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet1.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
}
