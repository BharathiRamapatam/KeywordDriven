package com.qtpselenium.test;
import static com.qtpselenium.test.DriverScript.APP_LOGS;
import static com.qtpselenium.test.DriverScript.CONFIG;
import static com.qtpselenium.test.DriverScript.OR;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Keywords {
	
	public static String Winning_numbers = null;
	 public static String bonous_numbers;
	public WebDriver driver;
	
	
	
	public  String openBrowser(String object,String data){		
		APP_LOGS.debug("Opening browser");
		if(data.equals("Mozilla"))
			driver=new FirefoxDriver();
		else if(CONFIG.getProperty(data).equals("IE"))
			driver=new InternetExplorerDriver();
		else if(CONFIG.getProperty(data).equals("Chrome"))
			
			driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(80,TimeUnit.SECONDS);
		
		//long implicitWaitTime=Long.parseLong(CONFIG.getProperty("implicitwait"));
		//driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		return Constants.KEYWORD_PASS;
		}
	
	public  String navigate(String object,String data){		
		APP_LOGS.debug("Navigating to URL");
		try{
			driver.navigate().to(data);
			}catch(Exception e){
				return Constants.KEYWORD_FAIL+" -- Not able to navigate";
			}
			return Constants.KEYWORD_PASS;
		
		
		
		
	}
	
	public  String clickSubmit(String object,String data){
        APP_LOGS.debug("Clicking on submit button");
        try{
        driver.findElement((By.id(OR.getProperty(object)))).click();
        
      
        }catch(Exception e){
        	System.out.println(e);
           return Constants.KEYWORD_FAIL;
        }
		return Constants.KEYWORD_PASS;
	}
	
	public  String inputviewByGame(String object, String data){
		APP_LOGS.debug("writing into view by game input box - Prises and result");
		try{
		driver.findElement(By.id(OR.getProperty(object))).sendKeys(data);
		
		driver.navigate().to("https://www.lottery.ie/prizes-and-results/?game=5-4-3-2-1");
		Thread.sleep(8000);

		return Constants.KEYWORD_PASS;
		
		}catch (Exception e){
			System.out.println(e);
		       
			return Constants.KEYWORD_FAIL;
			
		}
	}
	public  String inputviewByDraw(String object, String data){
		APP_LOGS.debug("writing into view by Draw input box - Prises and result");
		try{
		driver.findElement(By.id(OR.getProperty(object))).sendKeys(data);
		Thread.sleep(8000);

		return Constants.KEYWORD_PASS;
		
		}catch (Exception e){
			System.out.println(e);
		       
			return Constants.KEYWORD_FAIL;
			
		}
	}
	public  String inputviewByDateYear(String object, String data){
		APP_LOGS.debug("writing into view by Year input box - Prises and result");
		try{
		driver.findElement(By.id(OR.getProperty(object))).sendKeys(data);
		Thread.sleep(8000);

		return Constants.KEYWORD_PASS;
		
		}catch (Exception e){
			System.out.println(e);
		       
			return Constants.KEYWORD_FAIL + e;
			
		}
	}
	public  String inputviewByDateMonth(String object, String data){
		APP_LOGS.debug("writing into view by month input box - Prises and result");
		try{
		driver.findElement(By.id(OR.getProperty(object))).sendKeys(data);
       Thread.sleep(8000);
		return Constants.KEYWORD_PASS;
		
		}catch (Exception e){
			System.out.println(e);
		       
			return Constants.KEYWORD_FAIL;
			
		}
	}
	
	
	public  String clickPrizesAndResult(String object, String data){
        APP_LOGS.debug("Clicking on Prizes and Result link");
        try{
        driver.findElement((By.linkText(OR.getProperty(object)))).click();
        Thread.sleep(3000);
        return Constants.KEYWORD_PASS;
        
    }catch(Exception e){
    	System.out.println(e);
       return Constants.KEYWORD_FAIL;
    }
	
}
	public  String clickPrizesAndResultSubmit(String object, String data){
        APP_LOGS.debug("Clicking on Prizes and Result submit button");
        try{
        driver.findElement((By.xpath(OR.getProperty(object)))).click();
        Thread.sleep(8000);
        return Constants.KEYWORD_PASS;
        
    }catch(Exception e){
    	System.out.println(e);
       return Constants.KEYWORD_FAIL;
    }
	
}
        
		
		
	
	
	public  String inputviewByDate(String object, String data){
		APP_LOGS.debug("input date prizes and result");
		try{
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);

			return Constants.KEYWORD_PASS;
			
			}catch (Exception e){
				System.out.println(e);
			       
				return Constants.KEYWORD_FAIL;
				
			}
		}
		
	
	public  String selectList(){
		APP_LOGS.debug("Selecting from list");
		
		return Constants.KEYWORD_PASS;	
	}
	
	public  String verifyListSelection(){
		APP_LOGS.debug("Verifying the selection of the list");
		
		return Constants.KEYWORD_PASS;	
	}
	
	public  String verifyAllListElements(){
		APP_LOGS.debug("Verifying all the list elements");
		
		return Constants.KEYWORD_PASS;	

	}
	
	public  String selectRadio(){
		APP_LOGS.debug("Selecting a radio button");
		
		return Constants.KEYWORD_PASS;	

	}
	
	public  String verifyRadioSelected(){
		APP_LOGS.debug("Verify Radio Selected");
		
		return Constants.KEYWORD_PASS;	

	}
	
	public  String getDate(String object, String data){
		APP_LOGS.debug("getting text day and month");
		
		WebElement Result_Date = driver.findElement(By.xpath(OR.getProperty(object)));
		String day = Result_Date.getText();
		System.out.println(day);
		String expected = data;
		String actual = day;
		
		if(actual.equals(expected)){
			return Constants.KEYWORD_PASS + day;
		}else{
			return Constants.KEYWORD_FAIL;
		}
			
		
		
		
	}
	
	
	public  String verifyWelcomeText(String object, String data ){
		
		APP_LOGS.debug("Verifying the Welcome text");
		try{
			
		String Welcome_message = driver.findElement(By.xpath(OR.getProperty(object))).getText();
		System.out.println(Welcome_message);
		return Constants.KEYWORD_PASS + Welcome_message;
		}catch (Exception e){
		System.out.println(e);
		}
		return Constants.KEYWORD_FAIL;
		
		//String username_print = driver.findElement(By.id(OR.getProperty(object))).getText();
		
	}
	public  String verifyWelcomeUsername(String object, String data ){
		APP_LOGS.debug("Verifying the username text");
		try{
		String username_message = driver.findElement(By.xpath(OR.getProperty(object))).getText();
		System.out.println(username_message);
		if(username_message.equals(data)){
			return Constants.KEYWORD_PASS +"--"+ username_message;
			
		}else{
			return Constants.KEYWORD_FAIL;
		}
		}catch (Exception e){
			System.out.println(e);
			return Constants.KEYWORD_FAIL;
			}
		}
	
	public  String writeInInput(String object, String data){
		APP_LOGS.debug("Writing in username text box");
		APP_LOGS.debug(object);
		APP_LOGS.debug(data);
		try{
		driver.findElement(By.id(OR.getProperty(object))).sendKeys(data);
		}catch (Exception e){
		return Constants.KEYWORD_FAIL+" -- unable to write";
		//driver.findElement(By.id(OR.getProperty(object))).sendKeys(data);
		//driver.findElement(By.id("submit_button")).click();
		}
		return Constants.KEYWORD_PASS;
		
	}
	public  String writeInPassword(String object, String data){
		APP_LOGS.debug("Writing in password text box");
		APP_LOGS.debug(object);
		APP_LOGS.debug(data);
		try{
		//driver.findElement(By.id(OR.getProperty(object))).sendKeys(data);
		driver.findElement(By.id(OR.getProperty(object))).sendKeys(data);
		}catch (Exception e){
		return Constants.KEYWORD_FAIL+" -- unable to write";
		
		//driver.findElement(By.id("submit_button")).click();
		}
		return Constants.KEYWORD_PASS;
		
	}
	
	public  String verify54321ResultsNumbers(String object , String data){
       APP_LOGS.debug("Verifying 54321 results numbers ");
       List<WebElement> numbers = driver.findElements(By.xpath(OR.getProperty(object)));
       System.out.println("Total numbers = "+ numbers.size());
       try{
       
       for(int i=0; i<numbers.size(); i++){
    	  System.out.print( numbers.get(i).getText());
    	   
    	 }
       return Constants.KEYWORD_PASS;
    		 
    	 
	}catch (Exception e){
		return Constants.KEYWORD_FAIL + e;	
	}
	}
     		
	
	
	
	public  String verify54321BonusNumbers(String object, String data){
	       APP_LOGS.debug("Verifying 54321 bonus numbers");
	       List<WebElement> numbers = driver.findElements(By.xpath(OR.getProperty(object)));
	       System.out.println(numbers.size());
	       try{
	      
		for(int i = 0; i<numbers.size(); i++){
	    	   System.out.print("Total Bonas Numbers " + numbers.get(i).getText());
	    	   
			       }return Constants.KEYWORD_PASS;
	       }catch (Exception e ){
	    	   return Constants.KEYWORD_FAIL + e;	   
			       }
	          
	               }
	
	public  String verifyFileName(){
	       APP_LOGS.debug("Verifying inage filename");
			
			return Constants.KEYWORD_PASS;
	}
	
	public  String pause(String object) throws InterruptedException{
	       APP_LOGS.debug("Waiting");
	       long time = (long)Double.parseDouble(object);
			Thread.sleep(time*1000L);
			
			
			return Constants.KEYWORD_PASS;
	}
	
	
	public  String store(){
	       APP_LOGS.debug("Storing value");
			
			return Constants.KEYWORD_PASS;
	}
	
	public  String verifyTitle(){
	       APP_LOGS.debug("Verifying title");
			
			return Constants.KEYWORD_PASS;
	}
	
	public  String exist(){
	       APP_LOGS.debug("Checking existance of element");
			
			return Constants.KEYWORD_PASS;
	}
	
	public  String click(){
	       APP_LOGS.debug("Clicking on any element");
			
			return Constants.KEYWORD_PASS;
	}
	
	public  String synchronize(){
		APP_LOGS.debug("Waiting for page to load");
		
		return Constants.KEYWORD_PASS;
	}
	
	public  String waitForElementVisibility(){
		APP_LOGS.debug("Waiting for an elelement to be visible");
		
		return Constants.KEYWORD_PASS;
	}
	
	public  String logout(String object, String data){
		APP_LOGS.debug("Closing the browser");
		try{
		driver.findElement(By.xpath(OR.getProperty(object))).click();
		return Constants.KEYWORD_PASS;
		}catch (Exception e ){
			
		}
		return Constants.KEYWORD_FAIL;

	}
	public  String closingBrowser(String object, String data){
		APP_LOGS.debug("Closing the browser");
		try{
		driver.close();
		return Constants.KEYWORD_PASS;
		}catch (Exception e ){
			
		}
		return Constants.KEYWORD_FAIL;

	}
	
	
	/************************APPLICATION SPECIFIC KEYWORDS********************************/
	
	public  String validateLogin(String object, String data){
        APP_LOGS.debug("Verifying the laptops in app");
        
     String error = driver.findElement(By.xpath(OR.getProperty(object))).getText();
     System.out.println(error);
     driver.findElement(By.xpath(OR.getProperty("okButton_loginError"))).click();
     driver.findElement((By.id(OR.getProperty("username_input")))).clear();
     //driver.findElement((By.id(OR.getProperty("password_input")))).clear();
             
        
		
		return Constants.KEYWORD_PASS + "--"+ error;
		
	}
	public void captureScreenshot(String filename, String keyword_execution_result) throws IOException{
		// take screen shots
		if(CONFIG.getProperty("screenshot_everystep").equals("Y")){
			// capturescreen
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"//screenshots//"+filename+".jpg"));
			
		}else if (keyword_execution_result.startsWith(Constants.KEYWORD_FAIL) && CONFIG.getProperty("screenshot_error").equals("Y") ){
		// capture screenshot
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"//screenshots//"+filename+".jpg"));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
