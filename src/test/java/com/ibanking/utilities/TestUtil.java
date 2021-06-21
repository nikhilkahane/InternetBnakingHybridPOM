package com.ibanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
	
	public static Object[][] dataProvider(String path) throws IOException {
		
		FileInputStream fis = null;
		
		try {
			fis= new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet  sheet = book.getSheetAt(0);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				if(sheet.getRow(i+1).getCell(j)==null || sheet.getRow(i+1).getCell(j).toString().equals("")) {
					data[i][j]="empty";
				}else {
					data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
		}
		
		return data;
		
	}

}