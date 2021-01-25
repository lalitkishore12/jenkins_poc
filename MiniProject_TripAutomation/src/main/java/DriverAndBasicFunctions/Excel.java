package DriverAndBasicFunctions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import objectRepository.CabLocator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel extends CabLocator {
	public static int j = 0;

	public static void createExcel() {
		j = j + 1;
		CabLocator.cabType();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet samplesheet = workbook.createSheet("Sample Sheet");
		// Creating column heading
		Object[][] heading = { { "Type", "Fare" }, { car, fare } };
		int rownum = 0;
		for (Object[] key : heading) {
			Row row = samplesheet.createRow(rownum++);
			int cellNum = 0;
			for (Object value : key) {
				Cell cell = row.createCell(cellNum++);
				if (value instanceof String)
					cell.setCellValue((String) value);
				else if (value instanceof Integer)
					cell.setCellValue((Integer) value);
			}
		}
		FileOutputStream writeFile;
		try {
			writeFile = new FileOutputStream(System.getProperty("user.dir")
					+ "//excel-files//Cab_Details" + j + ".xlsx");
			workbook.write(writeFile);
			writeFile.close();
			System.out.println("Excel File created");
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
