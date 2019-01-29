package com.sampleProject.testUtilities;

import java.io.File;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static Object[][] readExcel(String path, String sheetName, int col)
			throws InvalidFormatException, IOException {

		File file = new File(path);

		XSSFWorkbook excel = new XSSFWorkbook(file);

		XSSFSheet sheet = excel.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();
		System.out.println("Total number of rows are:" + rowCount);

		Object[][] data = new Object[rowCount][col];

		for (int r = 1; r <= rowCount; r++) {
			for (int c = 0; c < col; c++) {

				if (sheet.getRow(r).getCell(c) != null) {
					if (sheet.getRow(r).getCell(c).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
						double colvalue = sheet.getRow(r).getCell(c).getNumericCellValue();

						data[r - 1][c] = String.valueOf(colvalue);
						

					} else {
						String colvalue = sheet.getRow(r).getCell(c).getStringCellValue();

						data[r - 1][c] = colvalue;
					}
				}

				else {
					data[r - 1][c] = "";
				}
			}

		}

		return data;

	}

}
