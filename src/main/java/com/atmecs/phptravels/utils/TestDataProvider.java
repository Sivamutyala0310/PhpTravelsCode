package com.atmecs.phptravels.utils;

import org.testng.annotations.DataProvider;

import com.atmecs.phptravels.constants.ConstantFilePaths;


public class TestDataProvider  {

	@DataProvider(name = "testdata")
	public static Object[][] testData() {
		ExcelFileRead file = new ExcelFileRead(com.atmecs.phptravels.constants.ConstantFilePaths.TESTDATA_FILE);
		int sheetIndex = 0;
		int rowCount = file.totalRowsinSheet(sheetIndex);
		int colCount = file.totalColsinSheet(sheetIndex);

		Object[][] data = new Object[rowCount][colCount];

		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			for (int colIndex = 0; colIndex < colCount; colIndex++) {
				data[rowIndex][colIndex] = file.getData(sheetIndex, rowIndex+1 , colIndex);
			}
		}
		return data;
	}
	
	public static String[][] profileData() {
		ExcelFileRead file = new ExcelFileRead(ConstantFilePaths.TESTDATA_FILE);
		int sheetIndex = 0;
		int rowCount = file.totalRowsinSheet(sheetIndex);
		int colCount = file.totalColsinSheet(sheetIndex);

		String[][] profileData = new String[rowCount][colCount];

		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			for (int colIndex = 0; colIndex < colCount; colIndex++) {
				profileData[rowIndex][colIndex] = file.getData(sheetIndex, rowIndex+1 , colIndex);
			}
		}
		return profileData;
	}
	
	
}
	


