package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class RoughWork2 {
	public static WebDriver driver ;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
driver = new FirefoxDriver();
		//driver = new HtmlUnitDriver();
driver.get("https://www.lottery.ie");
		
		
		/*

		driver.findElement(By.id("ctl00_ucLogin_LoginViewControl_txtUsername")).sendKeys("bharathi");
	driver.findElement(By.id("ctl00_ucLogin_LoginViewControl_txtPassword")).sendKeys("Testing2015");
	driver.findElement(By.id("ctl00_ucLogin_LoginViewControl_BtnLogin")).click();
	
	
		clickOnElement("//*[@id='ctl00_ucLogin_LoginViewControl_lnkMyAccount']");
		
		clickOnElement("//*[@id='ctl00_plcMain_phWidgetArea2_lt_zoneProfileWidgets680_I3_MyAccountIcon_18_myAccountPod']/p");
		clickOnElement("//*[@id='ctl00_plcMain_MyAccountControlLoader_ctl00_btnAddNew']");
		
		*/
		
		//*[@id='ctl00_plcMain_ucPrizesAndResults_pnl54321']/div/div[1]/div[3]/ul/li
		driver.findElement(By.linkText("Prizes & Results")).click();
		driver.findElement(By.id("ctl00_plcMain_ucPrizesAndResults_ddlGame")).sendKeys("5-4-3-2-1");
		Thread.sleep(3000);
		driver.navigate().to("https://www.lottery.ie/prizes-and-results/?game=5-4-3-2-1");
		driver.findElement(By.xpath("//*[@id='ctl00_plcMain_ucPrizesAndResults_ddlMonth']")).sendKeys("December");
		driver.findElement(By.id("ctl00_plcMain_ucPrizesAndResults_ddlDay")).sendKeys("2");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='ctl00_plcMain_ucPrizesAndResults_btnSelectResultsByDate']")).click();
		Thread.sleep(5000);
		
		List<WebElement> numbers = driver.findElements(By.xpath("//*[@id='ctl00_plcMain_ucPrizesAndResults_pnl54321']/div/div[1]/div[2]/ul/li"));
		System.out.println(numbers.size());
	for(int i=0; i<numbers.size();i++){
		System.out.print(numbers.get(i).getText());
	}
	System.out.println("-------------------------------------------------");
	Thread.sleep(5000);
	List<WebElement> bonusNumber = driver.findElements(By.xpath("//*[@id='ctl00_plcMain_ucPrizesAndResults_pnl54321']/div/div[1]/div[3]/ul/li"));
	System.out.println(bonusNumber.size());
	for(int j = 0; j<bonusNumber.size();j++){
		System.out.print ( numbers.get(j).getText());
	}
	driver.close();
	
	}

	public static void clickOnElement(String xathExp){
		driver.findElement(By.xpath(xathExp)).click();
		
		
	}
}
