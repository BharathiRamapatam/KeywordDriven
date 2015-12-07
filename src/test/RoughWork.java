package test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RoughWork {
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		driver = new FirefoxDriver();
		
		driver.navigate().to("https://www.lottery.ie/");
		//Assert.assertFalse(isElementPresent(By.xpath("//*[@id='ctl00_ucLogin_LoginViewControl_lnkMyAccount']")));
		
			
			driver.findElement(By.id("ctl00_ucLogin_LoginViewControl_txtUsername")).sendKeys("bharathi");
		driver.findElement(By.id("ctl00_ucLogin_LoginViewControl_txtPassword")).sendKeys("Testing2015");
		driver.findElement(By.id("ctl00_ucLogin_LoginViewControl_BtnLogin")).click();
		//String Welcome_message = "//*[@id='ctl00_ucLogin_LoginViewControl_lblGreeting']";
		//String Welcome_Message = driver.findElement(By.xpath("//*[@id='ctl00_ucLogin_LoginViewControl_lblGreeting']")).getText();
		String Welcome_Messag= getelementText("//*[@id='ctl00_ucLogin_LoginViewControl_lblGreeting']");
		System.out.println(Welcome_Messag);
		
		String username = driver.findElement(By.xpath("//*[@id='ctl00_ucLogin_LoginViewControl_lblSalutation']")).getText();
		
		System.out.println(username);
		
		String my_accountLink= "//*[@id='ctl00_ucLogin_LoginViewControl_lnkMyAccount']";
		String transferFunds ="//*[@id='ctl00_ucLogin_LoginViewControl_lnkTransferFunds']";
		
		String myAccout_herf = driver.findElement(By.xpath(my_accountLink)).getAttribute("href");
		System.out.println(myAccout_herf);
		
		String transferFunds_herf = driver.findElement(By.xpath(transferFunds)).getAttribute("href");
		System.out.println(transferFunds_herf);
		
		Assert.assertTrue(isElementPresent(By.xpath("//*[@id='ctl00_ucLogin_LoginViewControl_lnkMyAccount']")));
		Assert.assertEquals("https://www.lottery.ie/Player/My-Wallet/Transfer-Funds-to-Wallet", transferFunds_herf);
		
		
		driver.findElement(By.xpath("//*[@id='ctl00_ucLogin_LoginViewControl_lnkMyAccount']")).click();
		
		//List<WebElement> allItems = driver.findElements(By.xpath("//*[@id='ctl00_divMain']/div[2]/div/div/div/a/p/span"));
		//System.out.println(allItems.size());
		
		//for(WebElement link : allItems)
			//System.out.println(link.getText());
		
		clickLinkByHref("//*[@id='ctl00_divMain']/div[2]/div/div/div/a/p/span","My Details");
		
		
		
		
		//*[@id='ctl00_divMain']/div[2]/div/div/div/a/p/span
		
		
		
		
		
		
		
		
		
		
		//driver.findElement(By.id("ctl00_ucLogin_LoginViewControl_hypLogOut']")).click();
		
		
		
		

	}
	
	
	
	
	
	public static String  getelementText(String element){
		 return driver.findElement(By.xpath(element)).getText();

		
		
	}
	
	public static void findElement( String xpathidentifier){
		driver.findElement(By.xpath(xpathidentifier));
		
	}
	
	// assertTrue(isElementPresent(By.id("login_login_username")));---- example of how to use is element present
		public static boolean isElementPresent(By by){
			try {
				driver.findElement(by);
				return true;
			} catch (NoSuchElementException e) {
				 
				e.printStackTrace();
			}
		
		return false;
				
			}

		public static void clickLinkByHref(String list, String text) {
		    List<WebElement> anchors = driver.findElements(By.xpath(list));
		    Iterator<WebElement> i = anchors.iterator();
		 
		    while(i.hasNext()) {
		        WebElement anchor = i.next();
		     if(anchor.getText().equals(text)) {
		         anchor.click();
		         break;
		        }
		    }
		}
	
}
