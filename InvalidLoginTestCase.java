package keywordDrivenFramework;

import java.io.IOException;

import org.openqa.selenium.By;

public class InvalidLoginTestCase extends BaseTest{
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		BaseTest bt = new BaseTest();
		bt.openBrowser();

		Flib flib = new Flib();
		
		int rc = flib.getLastRowCount(EXCEL_PATH, INVALID_SHEETNAME);
		
		Thread.sleep(2000);
		
		for(int i=1;i<=rc;i++)
		{
			driver.findElement(By.name("username")).sendKeys(flib.readExcelData(EXCEL_PATH, INVALID_SHEETNAME, i, 0));
			
			driver.findElement(By.name("pwd")).sendKeys(flib.readExcelData(EXCEL_PATH, INVALID_SHEETNAME, i, 1));
			
			driver.findElement(By.id("loginButton")).click();
			
			driver.findElement(By.name("username")).clear();
			
			
		}

		Thread.sleep(2000);
		
		bt.CloseBrowser();
	}

}
