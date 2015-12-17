package com.appium.cucumber.util;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MoneyBookUtil {
	public void Spending(AndroidDriver driver) throws Exception{  //지출 클릭, 금액 입력, 분류 선택
		  
		driver.findElement(By.id("com.nhn.android.moneybook:id/type_out")).click(); //지출버튼 클릭
		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("5000"); //금액 입력
		for (;;){
            if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("5,000. 편집 중입니다.")) {
                        System.out.println("금액 입력 성공");
                        break;
            } else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("5,000")) {
            	System.out.println("금액 입력 성공");
                break;
            }else {            
                driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
                driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
                driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("5000");
             }                            
        }
		try {
			driver.findElement(By.id("com.nhn.android.moneybook:id/cat_etc")).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.id("com.nhn.android.moneybook:id/lcat_btn")).click();
		}		  
	  }
	
	
	public void Income(AndroidDriver driver) throws Exception{  //수입 클릭, 금액 입력, 분류 선택
		  
		driver.findElement(By.id("com.nhn.android.moneybook:id/income_icon")).click(); //수입버튼 클릭
		driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).sendKeys("7000"); //금액 입력
		for (;;){
            if (driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).getText().equals("7,000. 편집 중입니다.")) {
                        System.out.println("금액 입력 성공");
                        break;
            } else if (driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).getText().equals("7,000")) {
            	System.out.println("금액 입력 성공");
                break;
            }else {            
                driver.findElement(By.id("com.nhn.android.moneybook:id/clear_income_amt")).click();
                driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).click();
                driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).sendKeys("7000");
             }                            
        }
		try {
			driver.findElement(By.id("com.nhn.android.moneybook:id/cat_etc")).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.id("com.nhn.android.moneybook:id/lcat_btn")).click();
		}		  
	  }	
	
	public void Login(AndroidDriver driver) throws Exception{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		List<WebElement> ID_PW_element = driver
				.findElementsByClassName("android.widget.EditText");
		ID_PW_element.get(0).sendKeys("nvhb21");
		ID_PW_element.get(1).sendKeys("govlqls21");
		driver.findElement(
				By.id("com.nhn.android.moneybook:id/nloginglobal_normal_signin_bt_signin"))
				.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		driver.findElement(
				By.id("com.nhn.android.moneybook:id/enable_sms_auto_save"))
				.click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		assertTrue(driver.findElement(
				By.id("com.nhn.android.moneybook:id/default_face_icon"))
				.isDisplayed());

		
		driver.findElement(
				By.id("com.nhn.android.moneybook:id/close_noti_for_touch_face_icon"))
				.click();
	}
	
}
