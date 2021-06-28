package com.ibanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ibanking.base.TestBase;

public class TestUtil extends TestBase{
	
	
	public static boolean validateTitle(String expTitle) {
		boolean flag=false;
		String actTitle=driver.getTitle();
		System.out.println(actTitle);
		
		if(actTitle.equals(expTitle)) {
			flag=true;
		}
		
		return flag;
	}
	
	public static Object[][] dataProvider(String path, String sheetname) throws IOException {
		
		FileInputStream fis = null;
		
		try {
			fis= new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet  sheet = book.getSheet(sheetname);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				if(sheet.getRow(i+1).getCell(j)==null || sheet.getRow(i+1).getCell(j).toString().equals("")) {
					data[i][j]="empty";
				}else {
					data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
					//System.out.println(data[i][j]);
				}
			}
		}
		book.close();
		fis.close();
		return data;
		
	}
	
	public static void writeToExcel(String row, String path, String val, String sheetname) throws IOException {
		FileInputStream fis = null;
		
		try {
			fis= new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("test util values "+row);
		System.out.println(path);
		System.out.println(val);
		
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet  sheet = book.getSheet(sheetname);
		
		int col = sheet.getRow(0).getLastCellNum() - 1;
		
		int row1 = Integer.parseInt(row);
		
		sheet.getRow(row1).createCell(col).setCellValue(val);
		

		FileOutputStream fos = new FileOutputStream(path);//these lines are required to write into sheet
		book.write(fos);

		book.close();
		fis.close();
		
		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
