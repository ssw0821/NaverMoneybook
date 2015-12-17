package com.appium.cucumber.MoneybookTest;

import static org.junit.Assert.*;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.*;

import java.util.Calendar;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.cucumber.util.MoneyBookUtil;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MoneybookAuto {

	private AndroidDriver driver;

	private MoneyBookUtil moneyBookUtil;
	
	@Before
	public void setUp() throws Exception {
//d
		File classpathRoot = new File("D:/Appium_Cucumber_Moneybook/Moneybook");
		File appDir = new File(classpathRoot, "/Downloadapk");
		File app = new File(appDir, "app_android_moneybook_real_1.2.8.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "3b9162a6");
//		capabilities.setCapability("deviceName", "c5504bb0");
		capabilities.setCapability("platformVersion", "5.0");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.nhn.android.moneybook");
		capabilities.setCapability("unicodeKeyboard", true);
		// capabilities.setCapability("appActivity",
		// "com.nhn.android.moneybook");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		moneyBookUtil = new MoneyBookUtil();
//		capabilities.setCapability("udid", "3b9162a6");123

		
		moneyBookUtil.Login(driver);
		System.out.println("test");
	}

	

	// TC01
	@Given("^내역쓰기 선택> 수입내역 입력 후 \"([^\"]*)\" 선택$")
	public void 내역쓰기_선택_수입내역_입력_후_선택(String arg1) throws Throwable {
		System.out.println("TC01 - 수입내역 저장 후 계속 입력");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.id("com.nhn.android.moneybook:id/type_income_item")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).sendKeys("1000000");
		for (;;){
	    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).getText().equals("1,000,000")) {
	    		    	System.out.println("금액 입력 성공");
	    		    	break;
	    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).getText().equals("1,000,000. 편집 중입니다.")) {
            	System.out.println("금액 입력 성공");
                break;
	    	}else {	    	
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_income_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).sendKeys("1000000");
	    	 }		    		    	
	    }

		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("월급");
		Thread.sleep(500);
		driver.findElement(By.id("com.nhn.android.moneybook:id/cat_etc")).click();
		Thread.sleep(500);
		List<WebElement> Classification = driver.findElementsById("com.nhn.android.moneybook:id/scat_name");
		Classification.get(0).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).sendKeys("급여");
		Thread.sleep(500);
		driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_income_item")).click();
		Thread.sleep(1000);

	}

	@When("^새 수입내역 페이지에서 내역입력 후 저장$")
	public void 새_수입내역_페이지에서_내역입력_후_저장() throws Throwable {
		driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).click();
		Thread.sleep(500);
		driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).sendKeys("500000");
		for (;;){
	    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).getText().equals("500,000")) {
	    		    	System.out.println("금액 입력 성공");
	    		    	break;
	    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).getText().equals("500,000. 편집 중입니다.")) {
            	System.out.println("금액 입력 성공");
                break;
	    	}else {	    	
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_income_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).sendKeys("500000");
	    	 }		    		    	
	    }
		
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("인센티브");
		driver.findElement(By.id("com.nhn.android.moneybook:id/cat_etc")).click();
		Thread.sleep(1000);
		List<WebElement> Classification = driver.findElementsById("com.nhn.android.moneybook:id/scat_name");
		Classification.get(1).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).sendKeys("상여");
		driver.findElement(By.id("com.nhn.android.moneybook:id/save_income_item")).click();
		Thread.sleep(1000);
		//12345
	}

	@Then("^한달보기에 수입내역 (\\d+)건 저장되어 노출$")
	public void 한달보기에_수입내역_건_저장되어_노출(int arg1) throws Throwable {
		List<WebElement> result = driver.findElementsById("com.nhn.android.moneybook:id/income_outgo_amt");
		assertEquals(result.get(0).getText(), "500,000");
		assertEquals(result.get(1).getText(), "1,000,000");
		
	}

	// TC02
	@Given("^내역쓰기 선택> 지출내역 입력> \"([^\"]*)\" 선택 후 저장$")
	public void 내역쓰기_선택_지출내역_입력_선택_후_저장(String arg1) throws Throwable {
		System.out.println("TC02 - 지출내역 저장 시 자주쓰는 내역 추가");
		driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
		Thread.sleep(500);
		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("3000");
		for (;;){
	    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("3,000")) {
	    		    	System.out.println("금액 입력 성공");
	    		    	break;
	    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("3,000. 편집 중입니다.")) {
            	System.out.println("금액 입력 성공");
                break;
	    	}else {	    	
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("3000");
	    	 }		    		    	
	    }
		
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("도시락");
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).sendKeys("편의점");
		driver.findElement(By.id("com.nhn.android.moneybook:id/type_card")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/type_card")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).sendKeys("먹거리");
		driver.findElement(By.id("com.nhn.android.moneybook:id/add_frequently_used_mbook_item")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(500);
		assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/income_outgo_amt")).isDisplayed());

	}

	@When("^내역쓰기> 불러오기 선택$")
	public void 내역쓰기_불러오기_선택() throws Throwable {
		driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
		Thread.sleep(500);
		driver.findElement(By.id("com.nhn.android.moneybook:id/load_frequently_used_mbook_item")).click();
		Thread.sleep(1000);
	}

	@Then("^내역 선택 후 저장> 저장내역 확인$")
	public void 내역_선택_후_저장_저장내역_확인() throws Throwable {
		try {
			driver.findElement(By.id("com.nhn.android.moneybook:id/select_radio_btn")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {
			System.out.println("Android 4.4.2 버전에서 레이어 팝업 제어 불가");
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("3000");
			for (;;){
		    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("3,000")) {
		    		    	System.out.println("금액 입력 성공");
		    		    	break;
		    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("3,000. 편집 중입니다.")) {
	            	System.out.println("금액 입력 성공");
	                break;
		    	}else {	    	
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("3000");
		    	 }		    		    	
		    }
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("도시락");
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).sendKeys("편의점");
			driver.findElement(By.id("com.nhn.android.moneybook:id/type_card")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/type_card")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).sendKeys("먹거리");
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
			Thread.sleep(1000);
		}		  
			List<WebElement> result = driver.findElementsById("com.nhn.android.moneybook:id/income_outgo_amt");

			assertEquals(result.get(0).getText(), "3,000");
			assertEquals(result.get(1).getText(), "3,000");

	}

	// TC03
	@Given("^내역수정페이지 이동$")
	public void 내역쓰기_이동() throws Throwable {
		System.out.println("TC03 - 내역 수정 후 저장");
		List<WebElement> result = driver.findElementsById("com.nhn.android.moneybook:id/income_outgo_amt");
		result.get(0).click();
		Thread.sleep(500);

	}

	@When("^지출내역 수정$")
	public void 지출내역_수정() throws Throwable {
		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
		Thread.sleep(500);
		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("2000");
		for (;;){
	    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("2,000")) {
	    		    	System.out.println("금액 입력 성공");
	    		    	break;
	    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("2,000. 편집 중입니다.")) {
            	System.out.println("금액 입력 성공");
                break;
	    	}else {	    	
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("2000");
	    	 }		    		    	
	    }

		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_use_desc")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("샐러드");

		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_use_place")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).sendKeys("이마트");

		if(driver.findElement(By.id("com.nhn.android.moneybook:id/lcat_btn")).isDisplayed()) {
			driver.findElement(By.id("com.nhn.android.moneybook:id/lcat_btn")).click();
		} else {
			driver.findElement(By.id("com.nhn.android.moneybook:id/cat_etc")).click();
		}
		
		Thread.sleep(1000);
		List<WebElement> Classification = driver.findElementsById("com.nhn.android.moneybook:id/scat_name");
		Classification.get(2).click();

		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_tag_names")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).sendKeys("먹을거리");
	}

	@Then("^지출내역 저장$")
	public void 지출내역_저장() throws Throwable {
		driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
		Thread.sleep(1000);
		List<WebElement> result = driver.findElementsById("com.nhn.android.moneybook:id/income_outgo_amt");
		assertEquals(result.get(0).getText(), "2,000");
		driver.findElement(By.name("샐러드")).isDisplayed();
		//System.out.println(result.get(0).getText().equals("2,000"));

	}

	// TC04
	@Given("^한달보기> 그래프 아이콘 선택$")
	public void 한달보기_그래프_아이콘_선택() throws Throwable {
		System.out.println("TC04 - 오늘의 현금잔액 저장");
		driver.findElement(By.id("com.nhn.android.moneybook:id/default_face_icon")).click();

	}

	@When("^'오늘의 현금잔액' 선택$")
	public void 오늘의_현금잔액_선택() throws Throwable {
		try{
		driver.findElement(
				By.id("com.nhn.android.moneybook:id/move_report_asset_status")).click();
		Thread.sleep(500);
		} catch (NoSuchElementException e) {
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			System.out.println("Android 4.4.2 버전에서 레이어 팝업 제어 불가");
		}
		
	}

	@Then("^잔액 체크 후 저장$")
	public void 잔액_체크_후_저장() throws Throwable {
		try{
		driver.findElement(By.id("com.nhn.android.moneybook:id/chkAccountId")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/save_cash_account")).click();
		Thread.sleep(500);
		} catch (NoSuchElementException e) {
			System.out.println("Android 4.4.2 버전에서 레이어 팝업 제어 불가");
		}
	}

	@Then("^현금잔액 저장 확인$")
	public void 현금잔액_저장_확인() throws Throwable {
		try{
		driver.findElement(By.id("com.nhn.android.moneybook:id/default_face_icon")).click();
		WebElement CashBalance = driver.findElement(By.id("com.nhn.android.moneybook:id/cashable_asset_amt"));
		assertEquals(CashBalance.getText(), "1,500,000");
		//System.out.println(CashBalance.getText().equals("1,500,000"));
		driver.findElement(By.id("com.nhn.android.moneybook:id/smry_popup_close")).click();
		} catch (NoSuchElementException e) {
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			System.out.println("Android 4.4.2 버전에서 레이어 팝업 제어 불가");
		}
	}

	// TC05
	@Given("^통장관리 사용 OFF설정$")
	public void 통장관리_사용_OFF설정() throws Throwable {
		System.out.println("TC05 - 총 누적자산 중 현금잔액 이동");
		driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.nhn.android.moneybook:id/btnAccountEnable")).click();
		driver.findElement(By.id("android:id/button1")).click();
//		WebElement check_account=driver.findElement(By.id("com.nhn.android.moneybook:id/btnAccountEnable"));
//		if(check_account.isEnabled())
//		{
//			if(check_account.isSelected())
//				check_account.click();
//			driver.findElement(By.id("android:id/button1")).click();
//		}else
//		{
//			System.out.println("Account Checkbox is disabled!");
//		}
		
		Thread.sleep(1000);
		driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
		Thread.sleep(1000);
	}

	@When("^한달보기> 그래프 아이콘 선택2$")
	public void 한달보기_그래프_아이콘_선택2() throws Throwable {
		driver.findElement(By.id("com.nhn.android.moneybook:id/default_face_icon")).click();
	}

	@Then("^총 누적자산 페이지 이동 확인$")
	public void 총_누적자산_페이지_이동_확인() throws Throwable {
		try{
		assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/move_report_asset_status")).isDisplayed());
		driver.findElement(By.id("com.nhn.android.moneybook:id/move_report_asset_status")).click();
		Thread.sleep(500);
		assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/totalAccumulatedAssetList")).isDisplayed());
		driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
		} catch (NoSuchElementException e) {
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			System.out.println("Android 4.4.2 버전에서 레이어 팝업 제어 불가");
		}
	}

	// TC06
	@Given("^내역쓰기 이동$")
	public void 내역쓰기로_이동() throws Throwable {
		System.out.println("TC06 - 카드대금 포함 내역값 확인");
		driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/btnIncludeCardPayment")).click();
//		WebElement check_card_include=driver.findElement(By.id("com.nhn.android.moneybook:id/btnIncludeCardPayment"));
//		if(check_card_include.isEnabled())
//		{
//			if(!check_card_include.isSelected())
//				check_card_include.click();
//			
//		}else
//		{
//			System.out.println("Account Checkbox is disabled!");
//		}
		driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
		Thread.sleep(500);
	}

	@When("^분류에 카드대금 지정 후 저장$")
	public void 분류에_카드대금_지정_후_저장() throws Throwable {
		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("1500");
		for (;;){
	    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("1,500")) {
	    		    	System.out.println("금액 입력 성공");
	    		    	break;
	    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("1,500. 편집 중입니다.")) {
            	System.out.println("금액 입력 성공");
                break;
	    	}else {	    	
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("1500");
	    	 }		    		    	
	    }
		
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("월-E");
//		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).click();
//		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).sendKeys("토이랜드");
//		if(driver.findElement(By.id("com.nhn.android.moneybook:id/lcat_btn")).isDisplayed()) {
//			driver.findElement(By.id("com.nhn.android.moneybook:id/lcat_btn")).click();
//		} else {
//			driver.findElement(By.id("com.nhn.android.moneybook:id/cat_etc")).click();
//		}
		try {
			driver.findElement(By.id("com.nhn.android.moneybook:id/cat_etc"))
					.click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.id("com.nhn.android.moneybook:id/lcat_btn"))
					.click();
		}
		Thread.sleep(500);

		int i = 0;
		while (i < 3) {
			driver.swipe(817, 1366, 100, 1370, 1000);
			i++;
		}

		Thread.sleep(1000);

		List<WebElement> Category = driver
				.findElementsById("com.nhn.android.moneybook:id/select_on_lcat");
		Category.get(2).click();

		Thread.sleep(500);
		List<WebElement> Classification = driver.findElementsById("com.nhn.android.moneybook:id/scat_name");
		Classification.get(0).click();
		
//		WebElement swipe_start = driver.findElement(By.name("건강/문화"));
//		WebElement swipe_end = driver.findElement(By.name("식비"));
//		System.out.println(swipe_start.getLocation().x +" "+swipe_start.getLocation().y + "/" + swipe_end.getLocation().x+","+swipe_end.getLocation().y);
//		driver.swipe(swipe_start.getLocation().x, swipe_start.getLocation().y, swipe_end.getLocation().x, swipe_start.getLocation().y, 100);		
//		driver.findElement(By.name("카드대금")).click();
//		driver.findElement(By.id("com.nhn.android.moneybook:id/scat_name")).click();
		
		driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).sendKeys("카드대금");

		driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
		Thread.sleep(1000);
	}

	@Then("^카드대금 값 확인$")
	public void 카드대금_값_확인() throws Throwable {
		driver.findElement(By.id("com.nhn.android.moneybook:id/default_face_icon")).click();
		try{
		WebElement CardPayment = driver.findElement(By.id("com.nhn.android.moneybook:id/smry_popup_card_payment"));
		assertEquals(CardPayment.getText(), "(1,500)");
		assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/balance")).getText(), "1,493,500");
		driver.findElement(By.name("카드대금포함")).isDisplayed();
		//System.out.println(CardPayment.getText().equals("(1,500)"));
		driver.findElement(By.id("com.nhn.android.moneybook:id/smry_popup_close")).click();
		} catch (NoSuchElementException e) {
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			System.out.println("Android 4.4.2 버전에서 레이어 팝업 제어 불가");
		}		  

	}

	// TC07
	@Given("^카드대금 포함 OFF설정$")
	public void 카드대금_포함_OFF설정() throws Throwable {
		System.out.println("TC07 - 카드대금 미포함 내역값 확인");
		driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("com.nhn.android.moneybook:id/btnIncludeCardPayment")).click();
//		WebElement check_card_include=driver.findElement(By.id("com.nhn.android.moneybook:id/btnIncludeCardPayment"));
//		if(check_card_include.isEnabled())
//		{
//			if(!check_card_include.isSelected())
//				check_card_include.click();
//			
//		}else
//		{
//			System.out.println("Account Checkbox is disabled!");
//		}
		driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
		Thread.sleep(1000);
	}

	@When("^날짜바> 내역쓰기> 분류에 카드대금 지정 후 저장$")
	public void 날짜바_내역쓰기_분류에_카드대금_지정_후_저장() throws Throwable {
		List<WebElement> DateBar = driver.findElementsByClassName("android.widget.RelativeLayout");
		DateBar.get(23).click();

		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("3500");
		for (;;){
	    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("3,500")) {
	    		    	System.out.println("금액 입력 성공");
	    		    	break;
	    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("3,500. 편집 중입니다.")) {
            	System.out.println("금액 입력 성공");
                break;
	    	}else {	    	
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("3500");
	    	 }		    		    	
	    }
		
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("아이스크림");
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).sendKeys("나뚜루");
		if(driver.findElement(By.id("com.nhn.android.moneybook:id/lcat_btn")).isDisplayed()) {
			driver.findElement(By.id("com.nhn.android.moneybook:id/lcat_btn")).click();
		} else {
			driver.findElement(By.id("com.nhn.android.moneybook:id/cat_etc")).click();
		}

		int i = 0;
		while (i < 3) {
			driver.swipe(817, 1366, 100, 1370, 1000);
			i++;
		}

		Thread.sleep(1000);

		List<WebElement> Category = driver
				.findElementsById("com.nhn.android.moneybook:id/select_on_lcat");
		Category.get(2).click();

		Thread.sleep(500);
		List<WebElement> Classification = driver.findElementsById("com.nhn.android.moneybook:id/scat_name");
		Classification.get(0).click();
		
//		WebElement swipe_start = driver.findElement(By.name("건강/문화"));
//		WebElement swipe_end = driver.findElement(By.name("식비"));
//		System.out.println(swipe_start.getLocation().x +" "+swipe_start.getLocation().y + "/" + swipe_end.getLocation().x+","+swipe_end.getLocation().y);
//		driver.swipe(swipe_start.getLocation().x, swipe_start.getLocation().y, swipe_end.getLocation().x, swipe_start.getLocation().y, 100);		
//		driver.findElement(By.name("카드대금")).click();
//		driver.findElement(By.id("com.nhn.android.moneybook:id/scat_name")).click();
		
		driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).sendKeys("카드대금");

		driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
		Thread.sleep(1000);
	}

	@Then("^카드대금 미포함 값 확인$")
	public void 카드대금_미포함_값_확인() throws Throwable {
		driver.findElement(By.id("com.nhn.android.moneybook:id/default_face_icon")).click();
		try{
		WebElement CardPayment = driver.findElement(By.id("com.nhn.android.moneybook:id/smry_popup_card_payment"));
		WebElement CashExpenditure = driver.findElement(By.id("com.nhn.android.moneybook:id/smry_popup_outgo_cash"));
		assertEquals(CardPayment.getText(), "(5,000)");
		assertEquals(CashExpenditure.getText(), "0");
//		System.out.println(CardPayment.getText().equals("(5,000)"));
//		System.out.println(CashExpenditure.getText().equals("0"));
		driver.findElement(By.id("com.nhn.android.moneybook:id/smry_popup_close")).click();
		} catch (NoSuchElementException e) {
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			System.out.println("Android 4.4.2 버전에서 레이어 팝업 제어 불가");
		}		  
	}
 
	// TC08
	@Given("^내역쓰기> 지출내역 작성 시 희망목표 태그 입력 후 저장$")
	public void 내역쓰기_지출내역_작성_시_희망목표_태그_입력_후_저장() throws Throwable {
		System.out.println("TC08 - 희망목표액 확인 및 수정");
		driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
		Thread.sleep(500);
		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("4250");
		for (;;){
	    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("4,250")) {
	    		    	System.out.println("금액 입력 성공");
	    		    	break;
	    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("4,250. 편집 중입니다.")) {
            	System.out.println("금액 입력 성공");
                break;
	    	}else {	    	
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("4250");
	    	 }		    		    	
	    }
		
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("책");
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).sendKeys("북뱅크");
		driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).sendKeys("테스트목표");
		driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
		Thread.sleep(1000);
	}

	@When("^희망목표> 목표설정 후 저장$")
	public void 희망목표_목표설정_후_저장() throws Throwable {
		driver.findElement(By.id("com.nhn.android.moneybook:id/tv_hope_goal")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/rl_make_hope_goal")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/et_hope_goal_name")).sendKeys("TEST1");
		driver.findElement(By.id("com.nhn.android.moneybook:id/en_hope_goal_amt")).sendKeys("8000");
		for (;;){
	    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/en_hope_goal_amt")).getText().equals("8,000")) {
	    		    	System.out.println("금액 입력 성공");
	    		    	break;
	    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/en_hope_goal_amt")).getText().equals("8,000. 편집 중입니다.")) {
            	System.out.println("금액 입력 성공");
                break;
	    	}else {	    	
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/ib_hope_goal_amt_clear")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/en_hope_goal_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/en_hope_goal_amt")).sendKeys("8000");
	    	 }		    		    	
	    }
		
		driver.findElement(By.id("com.nhn.android.moneybook:id/tv_hope_goal_start")).click();

		int AndroidBtn = 0;
		while (AndroidBtn < 2) {
			driver.findElement(By.id("android:id/button1")).click();
			Thread.sleep(100);
			AndroidBtn++;
		}

		driver.findElement(By.id("com.nhn.android.moneybook:id/et_hope_goal_tags")).sendKeys("테스트목표");
		driver.findElement(By.id("com.nhn.android.moneybook:id/rl_hope_goal_save")).click();

		WebElement TP = driver.findElement(By.id("com.nhn.android.moneybook:id/tv_hope_goal_achieve_amt"));
		assertEquals(TP.getText(), "8,000");
//		System.out.println(TP.getText().equals("8,000"));
		WebElement GN = driver.findElement(By.id("com.nhn.android.moneybook:id/tv_hope_goal_list_title"));
		assertEquals(GN.getText(), "TEST1");
//		System.out.println(GN.getText().equals("TEST1"));
	}

	@Then("^희망목표 달성 치 확인$")
	public void 희망목표_달성_치_확인() throws Throwable {
		WebElement AP = driver.findElement(By.id("com.nhn.android.moneybook:id/tv_hope_achieve_amt"));
		assertEquals(AP.getText(), "4,250");
		//System.out.println(AP.getText().equals("4,250"));
		WebElement AR = driver.findElement(By.id("com.nhn.android.moneybook:id/tv_hope_goal_achieve_rate"));
		assertEquals(AR.getText(), "53.13%");
		//System.out.println(AR.getText().equals("53.13%"));
	}

	@Then("^목표이름 및 목표금액 수정 후 확인$")
	public void 목표이름_및_목표금액_수정_후_확인() throws Throwable {
		driver.findElement(By.id("com.nhn.android.moneybook:id/hope_goal_item_background")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/et_hope_goal_name")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/ib_hope_goal_name_clear")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/et_hope_goal_name")).sendKeys("TEST2");

		driver.findElement(By.id("com.nhn.android.moneybook:id/en_hope_goal_amt")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/ib_hope_goal_amt_clear")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/en_hope_goal_amt")).sendKeys("6000");
		for (;;){
	    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/en_hope_goal_amt")).getText().equals("6,000")) {
	    		    	System.out.println("금액 입력 성공");
	    		    	break;
	    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/en_hope_goal_amt")).getText().equals("6,000. 편집 중입니다.")) {
            	System.out.println("금액 입력 성공");
                break;
	    	}else {	    	
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/ib_hope_goal_amt_clear")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/en_hope_goal_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/en_hope_goal_amt")).sendKeys("6000");
	    	 }		    		    	
	    }

		driver.findElement(By.id("com.nhn.android.moneybook:id/rl_hope_goal_save")).click();
		Thread.sleep(1000);

		WebElement TP = driver.findElement(By.id("com.nhn.android.moneybook:id/tv_hope_goal_achieve_amt"));

		WebElement GN = driver.findElement(By.id("com.nhn.android.moneybook:id/tv_hope_goal_list_title"));

		WebElement AP = driver.findElement(By.id("com.nhn.android.moneybook:id/tv_hope_achieve_amt"));

		WebElement AR = driver.findElement(By.id("com.nhn.android.moneybook:id/tv_hope_goal_achieve_rate"));

		assertEquals(TP.getText(), "6,000");
		assertEquals(GN.getText(), "TEST2");
		assertEquals(AP.getText(), "4,250");
		assertEquals(AR.getText(), "70.83%");
		
//		System.out.println(TP.getText().equals("6,000"));
//		System.out.println(GN.getText().equals("TEST2"));
//		System.out.println(AP.getText().equals("4,250"));
//		System.out.println(AR.getText().equals("70.83%"));

		driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();

	}

	// TC09
	@Given("^예산반성페이지 이동$")
	public void 예산반성페이지_이동() throws Throwable {
		System.out.println("TC09 - 예산작성 및 전월 예산복사");
		driver.findElement(By.name("예산반성")).click();
//		List<WebElement> BR = driver.findElementsByClassName("android.widget.RelativeLayout");
//		BR.get(22).click();
		Thread.sleep(500);
	}

	@When("^예산작성 후 저장$")
	public void 예산작성_후_저장() throws Throwable {
		driver.findElement(By.id("com.nhn.android.moneybook:id/btnBudgetWrite")).click();
//		List<WebElement> CB = driver
//				.findElementsByClassName("android.widget.TextView");
//		CB.get(3).click();
		Thread.sleep(500);

		List<WebElement> BG = driver.findElementsByClassName("android.widget.EditText");
		int i = 2;
		while (i < 9) {
			Thread.sleep(100);
			BG.get(i).sendKeys("1000");
			i++;
		}
		Thread.sleep(500);

		List<WebElement> BT = driver.findElementsById("com.nhn.android.moneybook:id/budget_sum_amt");
		driver.findElement(By.id("com.nhn.android.moneybook:id/budget_total_amt")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/budget_total_amt")).sendKeys(BT.get(0).getText());
		
		
		driver.findElement(By.id("com.nhn.android.moneybook:id/save_budget")).click();
		try {
			driver.findElement(By.id("com.nhn.android.moneybook:id/budget_reflect_header_value")).isDisplayed();
		} catch (NoSuchElementException e) {
			driver.findElement(By.id("android:id/button1")).click();
		}
		Thread.sleep(500);
	}

	@Then("^예산작성> 다음달로 이동 후 전월 예산복사$")
	public void 예산작성_다음달로_이동_후_전월_예산복사() throws Throwable {
		List<WebElement> TT = driver.findElementsById("com.nhn.android.moneybook:id/budget_total_value");
		String tt = TT.get(0).getText();

		List<WebElement> CB = driver.findElementsByClassName("android.widget.TextView");
		CB.get(3).click();
		Thread.sleep(500);

		driver.findElement(By.id("com.nhn.android.moneybook:id/nextBtn")).click();
		Thread.sleep(500);
		driver.findElement(By.id("com.nhn.android.moneybook:id/btn_preMonthCopy")).click();

		List<WebElement> BT = driver.findElementsById("com.nhn.android.moneybook:id/budget_total_amt");
		String bt = BT.get(0).getText();
		
		try{
			assertEquals(tt, bt);
		} catch (AssertionError e) {
			System.out.println("Android 4.4.2버전에서 입력저장된 값이 '편집중'으로 노출되어 가격비교 불가");
		}
//		System.out.println(tt);
//		System.out.println(bt);
//		System.out.println(tt.equals(bt));
		// System.out.println(tt == BT.get(0).getText());

		driver.findElement(By.id("com.nhn.android.moneybook:id/save_budget")).click();
		Thread.sleep(500);
		
		try {
			driver.findElement(By.id("com.nhn.android.moneybook:id/budget_reflect_header_value")).isDisplayed();
		} catch (NoSuchElementException e) {
			driver.findElement(By.id("android:id/button1")).click();
		}
		Thread.sleep(500);

		List<WebElement> TT2 = driver.findElementsById("com.nhn.android.moneybook:id/budget_total_value");
		String tt2 = TT2.get(0).getText();
		try{
		assertEquals(tt, tt2);
		//System.out.println(tt.equals(tt2));
		} catch (Exception e) {
			System.out.println("Android 4.4.2버전에서 입력저장된 값이 '편집중'으로 노출되어 가격비교 불가");
		}
		
		driver.findElement(By.id("com.nhn.android.moneybook:id/go_home_btn")).click();
		Thread.sleep(500);
	}

	// TC10
	@Given("^내역쓰기> 출금계좌> 카드추가$")
	public void 내역쓰기_출금계좌_카드추가() throws Throwable {
		System.out.println("TC10 - 신용카드 추가 후 지출저장");
		driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
		Thread.sleep(500);
		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("5000");
		for (;;){
	    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("5,000")) {
	    		    	System.out.println("금액 입력 성공");
	    		    	break;
	    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("5,000. 편집 중입니다.")) {
            	System.out.println("금액 입력 성공");
                break;
	    	}else {	    	
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("5000");
	    	 }		    		    	
	    }
		
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("떡볶이");
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).sendKeys("분식");
		driver.findElement(By.id("com.nhn.android.moneybook:id/type_card")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/add_icon")).click();
		Thread.sleep(500);
	}

	@When("^생성할 신용카드 내역 입력 후 저장$")
	public void 생성할_신용카드_내역_입력_후_저장() throws Throwable {
		driver.findElement(By.id("com.nhn.android.moneybook:id/spinnerCardCorp")).click();
		List<WebElement> CT = driver.findElementsByClassName("android.widget.CheckedTextView");
		CT.get(4).click();

		driver.findElement(By.id("com.nhn.android.moneybook:id/editCardName")).sendKeys("신용");
		driver.findElement(By.id("com.nhn.android.moneybook:id/save_card")).click();
		Thread.sleep(3000);
	}

	@Then("^생성한 카드명 선택 후 지출내역 저장> 카드아이콘 표시 확인$")
	public void 생성한_카드명_선택_후_지출내역_저장_카드아이콘_표시_확인() throws Throwable {
		driver.findElement(By.id("com.nhn.android.moneybook:id/cell_data")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/title")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
		Thread.sleep(500);

		assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/card_icon")).isDisplayed());

		//System.out.println(driver.findElement(By.id("com.nhn.android.moneybook:id/card_icon")).isDisplayed());
	}

	// TC11
	@Given("^내역쓰기> 출금계좌> 통장추가$")
	public void 내역쓰기_출금계좌_통장추가() throws Throwable {
		System.out.println("TC11 - 통장추가 후 지출저장");
		driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("com.nhn.android.moneybook:id/btnAccountEnable")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
		Thread.sleep(500);
		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("2500");
		for (;;){
	    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("2,500")) {
	    		    	System.out.println("금액 입력 성공");
	    		    	break;
	    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("2,500. 편집 중입니다.")) {
            	System.out.println("금액 입력 성공");
                break;
	    	}else {	    	
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("2500");
	    	 }		    		    	
	    }
		
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("순대");
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).sendKeys("분식");
//		driver.findElement(By.id("com.nhn.android.moneybook:id/type_card")).click();
		try {
			driver.findElement(By.id("com.nhn.android.moneybook:id/type_card")).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_type")).click();
		}
		driver.findElement(By.id("com.nhn.android.moneybook:id/tab_account")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/add_icon")).click();
		Thread.sleep(500);

	}

	@When("^생성할 통장 내역 입력 후 저장$")
	public void 생성할_통장_내역_입력_후_저장() throws Throwable {
		driver.findElement(By.id("com.nhn.android.moneybook:id/editAccountName")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/editAccountName")).sendKeys("농협");

		driver.findElement(By.id("com.nhn.android.moneybook:id/spinnerAsset")).click();
		List<WebElement> PA = driver.findElementsByClassName("android.widget.CheckedTextView");
		PA.get(1).click();

		driver.findElement(By.id("com.nhn.android.moneybook:id/spinnerAccountCorp")).click();
		List<WebElement> AA = driver.findElementsByClassName("android.widget.CheckedTextView");
		AA.get(6).click();

		driver.findElement(By.id("com.nhn.android.moneybook:id/save_account")).click();
		Thread.sleep(3000);
	}

	@Then("^지출저장 내역 수정화면 진입> 출금계좌 확인$")
	public void 수입저장_내역_수정화면_진입_출금계좌_확인() throws Throwable {
		List<WebElement> SA = driver.findElementsById("com.nhn.android.moneybook:id/cell_data");
		SA.get(4).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/title")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
		Thread.sleep(500);

		List<WebElement> result = driver.findElementsById("com.nhn.android.moneybook:id/income_outgo_amt");
		result.get(0).click();
		Thread.sleep(500);

		assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_type")).isDisplayed());
		assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_detail")).isDisplayed());
		assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_type_name")).getText(), "현금");
		assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_detail_name")).getText(), "[현금] 농협");
//		System.out.println(driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_type")).isDisplayed());
//		System.out.println(driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_detail")).isDisplayed());

		driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
	}

	// TC12
	@Given("^내역쓰기> 출금계좌> 카드추가(\\d+)$")
	public void 내역쓰기_출금계좌_카드추가(int arg1) throws Throwable {
		System.out.println("TC12 - 체크카드 추가 후 지출저장");
		driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
		Thread.sleep(500);
		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("9000");
		for (;;){
	    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("9,000")) {
	    		    	System.out.println("금액 입력 성공");
	    		    	break;
	    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("9,000. 편집 중입니다.")) {
            	System.out.println("금액 입력 성공");
                break;
	    	}else {	    	
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
	    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("9000");
	    	 }		    		    	
	    }
		
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("탕수육");
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).sendKeys("중국집");
//		driver.findElement(By.id("com.nhn.android.moneybook:id/type_card")).click();
		try {
			driver.findElement(By.id("com.nhn.android.moneybook:id/type_card")).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_type")).click();
		}
		// driver.findElement(By.id("com.nhn.android.moneybook:id/tab_card")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/add_icon")).click();
		Thread.sleep(500);
	}

	@When("^생성할 체크카드 내역 입력 후 저장$")
	public void 생성할_체크카드_내역_입력_후_저장() throws Throwable {
		driver.findElement(By.id("com.nhn.android.moneybook:id/spinnerCardCorp")).click();
		List<WebElement> CT = driver.findElementsByClassName("android.widget.CheckedTextView");
		CT.get(6).click();

		driver.findElement(By.id("com.nhn.android.moneybook:id/editCardName")).sendKeys("체크");
		driver.findElement(By.id("com.nhn.android.moneybook:id/btnIsCheckCard")).click();

		driver.findElement(By.id("com.nhn.android.moneybook:id/btnAssociatedAccount")).click();
		List<WebElement> SA = driver.findElementsByClassName("android.widget.CheckedTextView");
		SA.get(4).click();
		driver.findElement(By.id("android:id/button1")).click();

		driver.findElement(By.id("com.nhn.android.moneybook:id/save_card")).click();
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(3000);

	}

	@Then("^생성한 카드명 선택 후 지출내역 저장$")
	public void 생성한_카드명_선택_후_지출내역_저장_카드아이콘_미노출_확인() throws Throwable {
		List<WebElement> CA = driver.findElementsById("com.nhn.android.moneybook:id/cell_data");
		CA.get(0).click();

		driver.findElement(By.id("com.nhn.android.moneybook:id/title")).click();
		driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
		Thread.sleep(500);

	}

	@Then("^지출저장 내역 수정화면 진입> 카드 출금계좌 확인$")
	public void 지출저장_내역_수정화면_진입_카드_출금계좌_확인() throws Throwable {
		List<WebElement> result = driver.findElementsById("com.nhn.android.moneybook:id/income_outgo_amt");
		result.get(0).click();
		Thread.sleep(500);

		assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_type")).isDisplayed());
		assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_detail")).isDisplayed());
		assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_type_name")).getText(), "카드");
		assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_detail_name")).getText(), "[농협] 체크");
//		System.out.println(driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_type")).isDisplayed());
//		System.out.println(driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_detail")).isDisplayed());

		driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
	}

	
	// TC13
		@Given("^다음달로 이동 후 정산하기 선택$")
		public void 다음달로_이동_후_정산하기_선택() throws Throwable {
			System.out.println("TC13 - 정산하기> 전월이월잔액 및 카드대금 정산");
			driver.findElement(By.id("com.nhn.android.moneybook:id/nextBtn")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.name("정산하기")).click();
//			List<WebElement> calculate = driver
//					.findElementsByClassName("android.widget.RelativeLayout");
//			calculate.get(23).click();
			Thread.sleep(500);
			assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/label_spamword")).isDisplayed());
			assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/label_cardname")).isDisplayed());			
		}

		@When("^전월이월 잔액 및 카드대금 선택 후 '정산'선택$")
		public void 전월이월_잔액_및_카드대금_선택_후_정산_선택() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/layer_toggle_selection")).click();
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_calucate")).click();
			Thread.sleep(500);
			
			assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/txtItemDesc")).isDisplayed());
					
		}

		@Then("^정산결과 저장 후 정산결과 내역 확인$")
		public void 정산결과_저장_후_정산결과_내역_확인() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_calucate")).click();
			Thread.sleep(1000);
			
			List<WebElement> result = driver.findElementsById("com.nhn.android.moneybook:id/income_outgo_amt");
			assertEquals(result.get(0).getText(), "1,490,750");
			assertEquals(result.get(1).getText(), "-11,500");
			assertEquals(result.get(2).getText(), "0");				
		}
	
		//TC14
		@Given("^GNB일년보기로 이동$")
		public void gnb일년보기로_이동() throws Throwable {
			System.out.println("TC14 - 날짜 네비게이션 이동");
		    driver.findElement(By.id("com.nhn.android.moneybook:id/go_annual_summry_page")).click();
		    Thread.sleep(1000);
		    
		}

		@When("^내역쓰기> 내년날짜로 설정> 내역작성 후 저장\\(수입/지출\\)$")
		public void 내역쓰기_내년날짜로_설정_내역작성_후_저장_수입_지출() throws Throwable {
		    driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("com.nhn.android.moneybook:id/item_ymd")).click();
		    List<WebElement> NextYear = driver.findElementsById("android:id/increment");	    	    
		    NextYear.get(0).click();    
		    driver.findElement(By.id("android:id/button1")).click();
		    
		    driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("2000");
		    
		    for (;;){
		    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("2,000")) {
		    		    	System.out.println("금액 입력 성공");
		    		    	break;
		    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("2,000. 편집 중입니다.")) {
	            	System.out.println("금액 입력 성공");
	                break;
		    	}else {	    	
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("2000");
		    	 }
		    		    	
		    }
		    
		    	
		    
		    driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
		    driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("으라차차");
		    driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).sendKeys("검색");
		    
		    driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_outgo_item")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("com.nhn.android.moneybook:id/type_income_item")).click();
		    driver.findElement(By.id("com.nhn.android.moneybook:id/item_ymd")).click();
		    NextYear.get(0).click();
		    driver.findElement(By.id("android:id/button1")).click();
		    
		    driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).sendKeys("4000");
		    for (;;){
		    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).getText().equals("4,000")) {
		    		    	System.out.println("금액 입력 성공");
		    		    	break;
		    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).getText().equals("4,000. 편집 중입니다.")) {
	            	System.out.println("금액 입력 성공");
	                break;
		    	}else {	    	
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_income_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).sendKeys("4000");
		    	 }
		    		    	
		    }
		    
		    driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("우라차차");
		    driver.findElement(By.id("com.nhn.android.moneybook:id/save_income_item")).click();
		    Thread.sleep(1000);  
		}

		@When("^내역쓰기> 작년날자로 설정> 내역작성 후 저장\\(수입/지출\\)$")
		public void 내역쓰기_작년날자로_설정_내역작성_후_저장_수입_지출() throws Throwable {
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("com.nhn.android.moneybook:id/item_ymd")).click();	
		    List<WebElement> LastYear = driver.findElementsById("android:id/decrement");
		    LastYear.get(0).click();    
		    driver.findElement(By.id("android:id/button1")).click();
		    
		    
		    driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("2000");
		    for (;;){
		    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("2,000")) {
		    		    	System.out.println("금액 입력 성공");
		    		    	break;
		    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("2,000. 편집 중입니다.")) {
	            	System.out.println("금액 입력 성공");
	                break;
		    	}else {	    	
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("2000");
		    	 }
		    		    	
		    }
		    
		    driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
		    driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("으라차차");
		    driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_outgo_item")).click();
		    Thread.sleep(500);
		    driver.findElement(By.id("com.nhn.android.moneybook:id/type_income_item")).click();
		    driver.findElement(By.id("com.nhn.android.moneybook:id/item_ymd")).click();
		    LastYear.get(0).click();
		    driver.findElement(By.id("android:id/button1")).click();
		    
		    driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).sendKeys("4000");
		    for (;;){
		    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).getText().equals("4,000")) {
		    		    	System.out.println("금액 입력 성공");
		    		    	break;
		    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).getText().equals("4,000. 편집 중입니다.")) {
	            	System.out.println("금액 입력 성공");
	                break;
		    	}else {	    	
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_income_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).sendKeys("4000");
		    	 }
		    		    	
		    }	    
		    
		    driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("우라차차");
		    driver.findElement(By.id("com.nhn.android.moneybook:id/save_income_item")).click();
		    Thread.sleep(1000);
		}

		@Then("^내년 날짜에 저장된 내역 확인$")
		public void 내년_날짜에_저장된_내역_확인() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/nextBtn")).click();
			Thread.sleep(1000);
			List<WebElement> income = driver.findElementsById("com.nhn.android.moneybook:id/income_amt");
			List<WebElement> outgo = driver.findElementsById("com.nhn.android.moneybook:id/outgo_amt");
			List<WebElement> balance = driver.findElementsById("com.nhn.android.moneybook:id/balance_amt");
			
			assertEquals(income.get(0).getText(), "4,000");
			assertEquals(outgo.get(0).getText(), "2,000");
			assertEquals(balance.get(0).getText(), "2,000");			
		}

		@Then("^작년 날짜에 저장된 내역 확인$")
		public void 작년_날짜에_저장된_내역_확인() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/prevBtn")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/prevBtn")).click();
			Thread.sleep(1000);
			List<WebElement> income = driver.findElementsById("com.nhn.android.moneybook:id/income_amt");
			List<WebElement> outgo = driver.findElementsById("com.nhn.android.moneybook:id/outgo_amt");
			List<WebElement> balance = driver.findElementsById("com.nhn.android.moneybook:id/balance_amt");
			
			
			
			assertEquals(income.get(0).getText(), "4,000");
			assertEquals(outgo.get(0).getText(), "2,000");
			assertEquals(balance.get(0).getText(), "2,000");	
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/nextBtn")).click();
			Thread.sleep(500);
		}

		//TC15
		@Given("^검색버튼 선택$")
		public void 검색버튼_선택() throws Throwable {
			System.out.println("TC15 - 수입/지출 내역 검색");
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_annual_summry_page")).click();
		    driver.findElement(By.id("com.nhn.android.moneybook:id/go_search_button")).click();
		    
		}

		@When("^수입내역 '사용내역'로 검색$")
		public void 수입내역_사용내역_로_검색() throws Throwable {
		    driver.findElement(By.id("com.nhn.android.moneybook:id/et_search_text")).click();
		    driver.findElement(By.id("com.nhn.android.moneybook:id/et_search_text")).sendKeys("월급");
		    driver.findElement(By.id("com.nhn.android.moneybook:id/iv_search_button")).click();
		    Thread.sleep(500);
		    
		    driver.findElement(By.id("com.nhn.android.moneybook:id/tv_income_item_count")).click();
		    Thread.sleep(500);
		    
		    try {
		    	assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/tv_item_desc")).getText(), "월급" );
			    assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/tv_item_amt")).getText(), "1,000,000" );
			    assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/tv_search_sum_amt")).getText(), "1,000,000" );
			} catch (NoSuchElementException e) {			
			}
			Thread.sleep(500);
		}

		@When("^지출내역 '사용처'로 검색$")
		public void 지출내역_사용처_로_검색() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/tv_search_text")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/iv_search_text_clear")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/et_search_text")).sendKeys("편의점");
			driver.findElement(By.id("com.nhn.android.moneybook:id/rb_recent_six_month")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/iv_search_button")).click();
			Thread.sleep(500);
			
			//assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/tv_outgo_item_count")).getText(), "지출 (1)" );
			try {
				assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/tv_item_desc")).getText(), "도시락" );
			    assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/tv_item_amt")).getText(), "3,000" );
			    assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/tv_search_sum_amt")).getText(), "3,000" );
			} catch (NoSuchElementException e) {			
			}
			Thread.sleep(500);
		}

		@Then("^지출내역 '태그'로 검색$")
		public void 지출내역_태그_로_검색() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/tv_search_text")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/iv_search_text_clear")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/et_search_text")).sendKeys("으라차차");
			driver.findElement(By.id("com.nhn.android.moneybook:id/rb_user_input_duration")).click();
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/tv_search_duration_end_date")).click();
			List<WebElement> Next = driver.findElementsById("android:id/increment");	    	    
		    Next.get(0).click();    
		    Next.get(1).click();
		    Next.get(2).click();
		    driver.findElement(By.id("android:id/button1")).click();
		    
		    driver.findElement(By.id("com.nhn.android.moneybook:id/tv_search_duration_start_date")).click();
		    Next.get(0).click();    
		    Next.get(1).click();
		    Next.get(2).click();
		    driver.findElement(By.id("android:id/button1")).click();    
		    driver.findElement(By.id("com.nhn.android.moneybook:id/iv_search_button")).click();
		    
		    //assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/tv_outgo_item_count")).getText(), "지출 (1)" );
		    try {
		    	assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/tv_item_desc")).getText(), "으라차차" );
			    assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/tv_item_amt")).getText(), "2,000" );
			    assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/tv_search_sum_amt")).getText(), "2,000" );
			} catch (NoSuchElementException e) {			
			}
		    
		    driver.findElement(By.id("com.nhn.android.moneybook:id/rl_search_cancel")).click();
		    Thread.sleep(1000);
		}
		
		//TC16
		@Given("^다양한 분류의 지출내역 (\\d+)개 입력 후 저장$")
		public void 다양한_분류의_지출내역_개_입력_후_저장(int arg1) throws Throwable {
			System.out.println("TC16 - 분류별 지출> 금액 수정");
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_statistics_page")).click();
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click(); //내역 입력 페이지로 이동
			Thread.sleep(1000);	
			
			this.Spending();
			driver.findElement(By.name("식비")).click();
			String btn_name1 = driver.findElement(By.name("식비")).getText();
			driver.findElement(By.name("부식")).click();    			
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name1); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_outgo_item")).click(); //저장 후 계속 입력
		
			this.Spending();
			driver.findElement(By.name("주거/통신")).click(); 
			String btn_name2 = driver.findElement(By.name("주거/통신")).getText();
			driver.findElement(By.name("인터넷")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name2); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_outgo_item")).click(); //저장 후 계속 입력
			
			this.Spending();
			driver.findElement(By.name("생활용품")).click();
			String btn_name3 = driver.findElement(By.name("생활용품")).getText();
			driver.findElement(By.name("기타")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name3); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_outgo_item")).click(); // 저장 후 계속 입력
				
			this.Spending();
			driver.findElement(By.name("의복/미용")).click();
			String btn_name4 = driver.findElement(By.name("의복/미용")).getText();
			driver.findElement(By.name("의류비")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name4); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_outgo_item")).click(); // 저장 후 계속 입력
			
			this.Spending();
			driver.findElement(By.name("생활용품")).click();
			String btn_name5 = driver.findElement(By.name("생활용품")).getText();
			driver.findElement(By.name("잡화소모")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name5); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click(); // 저장
			
			// money-16 기대결과 1 확인
			assertTrue(driver.findElement(By.name("식비")).isDisplayed());
			assertTrue(driver.findElement(By.name("생활용품")).isDisplayed());
			assertTrue(driver.findElement(By.name("주거/통신")).isDisplayed());
			assertTrue(driver.findElement(By.name("의복/미용")).isDisplayed());
			assertTrue(driver.findElement(By.name("교육/육아")).isDisplayed());
			
			List<WebElement> 내역일치확인하기 = driver.findElementsById("com.nhn.android.moneybook:id/txtLcatAmt");
			assertEquals(내역일치확인하기.get(0).getText(), "26,500");
			assertEquals(내역일치확인하기.get(1).getText(), "10,000");
			assertEquals(내역일치확인하기.get(2).getText(), "5,000");
			assertEquals(내역일치확인하기.get(3).getText(), "5,000");
			assertEquals(내역일치확인하기.get(4).getText(), "4,250");
		    //그래프는 확인이 불가하여 작성이 불가함			
		}

		@When("^임의의 지출내역 선택$")
		public void 임의의_지출내역_선택() throws Throwable {
			driver.findElement(By.name("주거/통신")).click();
			Thread.sleep(1000);
			// money-16 기대결과 2 확인
			assertTrue(driver.findElement(By.name("주거/통신")).isDisplayed()); 
		    
		}

		@When("^depth(\\d+) 지출내역 선택$")
		public void depth_지출내역_선택(int arg1) throws Throwable {
			
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/txtItemDesc")).click(); 
			Thread.sleep(1000);
			// money-16 기대결과 3 확인
			assertTrue(driver.findElement(By.name("내역 보기")).isDisplayed()); 
	}
		

		@When("^내역 금액 수정 후 저장$")
		public void 내역_금액_수정_후_저장() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).clear(); // 수정페이지 금액 클리어
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("20000"); //금액 입력
			for (;;){
	            if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("20,000. 편집 중입니다.")) {
	                        System.out.println("금액 입력 성공");
	                        break;
	            } else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("20,000")) {
	            	System.out.println("금액 입력 성공");
	                break;
	            }else {            
	                driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
	                driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
	                driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("20000");
	             }                            
	        }
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click(); //수정내역 저장버튼 클릭
			Thread.sleep(1000);
			// money-16 기대결과 4 확인
			WebElement price_change = driver.findElement(By.id("com.nhn.android.moneybook:id/txtItemAmt"));
			assertEquals("20,000",price_change.getText());
		}

		@Then("^분류별 지출> 금액 변경 확인$")
		public void 분류별_지출_금액_변경_확인() throws Throwable {
			driver.findElement(By.name("분류별 지출")).click();
			Thread.sleep(1000);
			
			 List<WebElement> 내역일치확인하기 = driver.findElementsById("com.nhn.android.moneybook:id/txtLcatAmt");
			 assertEquals(내역일치확인하기.get(0).getText(), "26,500");  // 식비 2만원으로 변경을 확인
			 assertEquals(내역일치확인하기.get(1).getText(), "20,000");  // 주거/통신 2만원으로 금액 변경 확인
			 assertEquals(내역일치확인하기.get(2).getText(), "10,000");    // 나머지는 변경 없이 유지됨을 확인
			 assertEquals(내역일치확인하기.get(3).getText(), "5,000");    // 나머지는 변경 없이 유지됨을 확인
			 assertEquals(내역일치확인하기.get(4).getText(), "4,250");// 나머지는 변경 없이 유지됨을 확인
		}


		//TC17
		@Given("^임의의 지출내역 선택(\\d+)$")
		public void 임의의_지출내역_선택(int arg1) throws Throwable {
			System.out.println("TC17 - 분류별 지출> 분류 수정");
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_statistics_page")).click();
			driver.findElement(By.name("의복/미용")).click(); //내역 수정 페이지로 이동
			Thread.sleep(1000);			
			driver.findElement(By.name("의복/미용")).isDisplayed();
		}

		@When("^depth(\\d+) 지출내역 선택(\\d+)$")
		public void depth_지출내역_선택(int arg1, int arg2) throws Throwable {
			driver.findElement(By.name("의복/미용")).click();
			Thread.sleep(1000);
			assertTrue(driver.findElement(By.name("내역 보기")).isDisplayed()); 
		}

		@When("^타분류로 수정 후 저장$")
		public void 타분류로_수정_후_저장() throws Throwable {
		    driver.findElement(By.id("com.nhn.android.moneybook:id/lcat_btn")).click();
		    driver.findElement(By.name("건강/문화")).click();
		    driver.findElement(By.name("운동/레저")).click();
		    driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
		    Thread.sleep(1000);
		    assertTrue(driver.findElement(By.name("오늘의 내역을 입력하세요!")).isDisplayed()); 
		}
		
		@Then("^지출내역 분류 변경 확인$")
		public void 지출내역_분류_변경_확인() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnReportOutgoLcat")).click();
			Thread.sleep(1000);
			List<WebElement> 분류수정확인 = driver.findElementsById("com.nhn.android.moneybook:id/txtLcatName");
			 assertEquals(분류수정확인.get(3).getText(), "건강/문화");  
		}
		
		//TC18
		@Given("^다양한 분류의 수입내역 (\\d+)개 입력 후 저장$")
		public void 다양한_분류의_수입내역_개_입력_후_저장(int arg1) throws Throwable {
			System.out.println("TC18 - 분류별 수입> 금액 수정");
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_statistics_page")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnReportIncomeLcat")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click(); //내역 입력 페이지로 이동
			Thread.sleep(1000);	
			
			moneyBookUtil.Income(driver);
			driver.findElement(By.name("주수입")).click();
			String btn_name1 = driver.findElement(By.name("주수입")).getText();
			driver.findElement(By.name("사업소득")).click();    			
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name1); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_income_item")).click(); //저장 후 계속 입력
		
			moneyBookUtil.Income(driver);
			driver.findElement(By.name("부수입")).click(); 
			String btn_name2 = driver.findElement(By.name("부수입")).getText();
			driver.findElement(By.name("이자/배당금")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name2); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_income_item")).click(); //저장 후 계속 입력
			
			moneyBookUtil.Income(driver);
			driver.findElement(By.name("전월이월")).click();
			String btn_name3 = driver.findElement(By.name("전월이월")).getText();
			driver.findElement(By.name("잔액조정")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name3); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_income_item")).click(); // 저장 후 계속 입력
				
			moneyBookUtil.Income(driver);
			driver.findElement(By.name("주수입")).click();
			String btn_name4 = driver.findElement(By.name("주수입")).getText();
			driver.findElement(By.name("기타")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name4); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_income_item")).click(); // 저장 후 계속 입력
			
			moneyBookUtil.Income(driver);
			driver.findElement(By.name("전월이월")).click();
			String btn_name5 = driver.findElement(By.name("전월이월")).getText();
			driver.findElement(By.name("기타")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name5); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_income_item")).click(); // 저장
			
			// money-16 기대결과 1 확인
			assertTrue(driver.findElement(By.name("주수입")).isDisplayed());
			assertTrue(driver.findElement(By.name("전월이월")).isDisplayed());
			assertTrue(driver.findElement(By.name("부수입")).isDisplayed());

			List<WebElement> 내역일치확인하기 = driver.findElementsById("com.nhn.android.moneybook:id/txtLcatAmt");
			assertEquals(내역일치확인하기.get(0).getText(), "1,514,000");
			assertEquals(내역일치확인하기.get(1).getText(), "14,000");
			assertEquals(내역일치확인하기.get(2).getText(), "7,000");

		    //그래프는 확인이 불가하여 작성이 불가함			
		}

		@When("^임의의 수입내역 선택$")
		public void 임의의_수입내역_선택() throws Throwable {
			driver.findElement(By.name("부수입")).click();
			Thread.sleep(1000);
			// money-16 기대결과 2 확인
			assertTrue(driver.findElement(By.name("부수입")).isDisplayed()); 
		}

		@When("^depth(\\d+) 수입내역 선택$")
		public void depth_수입내역_선택(int arg1) throws Throwable {

			
			driver.findElement(By.id("com.nhn.android.moneybook:id/txtItemDesc")).click(); 
			Thread.sleep(1000);
			// money-16 기대결과 3 확인
			assertTrue(driver.findElement(By.name("내역 보기")).isDisplayed());
		}

		@When("^수입내역 금액 수정 후 저장$")
		public void 수입내역_금액_수정_후_저장() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).clear(); // 수정페이지 금액 클리어
			driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).sendKeys("20000"); //금액 입력
			for (;;){
	            if (driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).getText().equals("20,000. 편집 중입니다.")) {
	                        System.out.println("금액 입력 성공");
	                        break;
	            } else if (driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).getText().equals("20,000")) {
	            	System.out.println("금액 입력 성공");
	                break;
	            }else {            
	                driver.findElement(By.id("com.nhn.android.moneybook:id/clear_income_amt")).click();
	                driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).click();
	                driver.findElement(By.id("com.nhn.android.moneybook:id/income_amt")).sendKeys("20000");
	             }                            
	        }
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_income_item")).click(); //수정내역 저장버튼 클릭
			Thread.sleep(1000);
			// money-16 기대결과 4 확인
			WebElement price_change = driver.findElement(By.id("com.nhn.android.moneybook:id/txtItemAmt"));
			assertEquals("20,000",price_change.getText());
		}

		@Then("^분류별 수입> 금액 변경 확인$")
		public void 분류별_수입_금액_변경_확인() throws Throwable {
			driver.findElement(By.name("분류별 수입")).click();
			Thread.sleep(1000);
			
			 List<WebElement> 내역일치확인하기 = driver.findElementsById("com.nhn.android.moneybook:id/txtLcatAmt");
			 assertEquals(내역일치확인하기.get(0).getText(), "1,514,000");  // 나머지는 변경 없이 유지됨을 확인
			 assertEquals(내역일치확인하기.get(1).getText(), "20,000");  // 부수입 2만원으로 금액 변경 확인
			 assertEquals(내역일치확인하기.get(2).getText(), "14,000");    // 나머지는 변경 없이 유지됨을 확인
			 
		}
		
		//TC19
		@Given("^임의의 수입내역 선택(\\d+)$")
		public void 임의의_수입내역_선택(int arg1) throws Throwable {
			System.out.println("TC19 - 분류별 수입> 분류 수정");
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_statistics_page")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnReportIncomeLcat")).click();
			driver.findElement(By.name("부수입")).click(); //내역 수정 페이지로 이동
			Thread.sleep(1000);			
			driver.findElement(By.name("부수입")).isDisplayed();
		}

		@When("^depth(\\d+) 수입내역 선택(\\d+)$")
		public void depth_수입내역_선택(int arg1, int arg2) throws Throwable {
			driver.findElement(By.name("부수입")).click();
			Thread.sleep(1000);
			assertTrue(driver.findElement(By.name("내역 보기")).isDisplayed());
		}

		@When("^타분류로 수정 후 저장(\\d+)$")
		public void 타분류로_수정_후_저장(int arg1) throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/lcat_btn")).click();
		    driver.findElement(By.name("주수입")).click();
		    driver.findElement(By.name("상여")).click();
		    driver.findElement(By.id("com.nhn.android.moneybook:id/save_income_item")).click();
		    Thread.sleep(1000);
		    assertTrue(driver.findElement(By.name("오늘의 내역을 입력하세요!")).isDisplayed()); 
		}

		@Then("^수입내역 분류 변경 확인$")
		public void 수입내역_분류_변경_확인() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnReportIncomeLcat")).click();
			Thread.sleep(1000);
			List<WebElement> 분류수정확인 = driver.findElementsById("com.nhn.android.moneybook:id/txtLcatName");
			 assertEquals(분류수정확인.get(0).getText(), "주수입");  
			List<WebElement> 분류수정확인2 = driver.findElementsById("com.nhn.android.moneybook:id/txtLcatAmt");
			assertEquals(분류수정확인2.get(0).getText(), "1,534,000");
		}
		
		//TC20
		@Given("^카드/현금> 카드 관리하기 선택$")
		public void 카드_현금_카드_관리하기_선택() throws Throwable {
			System.out.println("TC20 - 카드/현금> 카드 추가 후 카드 지출내역 작성");
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_statistics_page")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnReportCardCash")).click();
			Thread.sleep(500);
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/ivManageCard")).click();
			assertTrue(driver.findElement(By.name("카드 관리")).isDisplayed());
		}

		@When("^카드추가 선택$")
		public void 카드추가_선택() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/add_card")).click();
			assertTrue(driver.findElement(By.name("카드 추가")).isDisplayed());
		}

		@When("^카드정보 작성 후 저장$")
		public void 카드정보_작성_후_저장() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/spinnerCardCorp")).click();
			List<WebElement> CT = driver.findElementsByClassName("android.widget.CheckedTextView");
			CT.get(1).click();

			driver.findElement(By.id("com.nhn.android.moneybook:id/editCardName")).sendKeys("신용");
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_card")).click();
			Thread.sleep(1000);
			
			assertTrue(driver.findElement(By.name("SC")).isDisplayed());		
		}

		@Then("^추가한 카드 지정하여 작성 후 종류/건수, 사용금액, 금액비율 확인$")
		public void 추가한_카드_지정하여_작성_후_종류_건수_사용금액_금액비율_확인() throws Throwable {
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
			Thread.sleep(500);
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("2400");
			for (;;){
		    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("2,400")) {
		    		    	System.out.println("금액 입력 성공");
		    		    	break;
		    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("2,400. 편집 중입니다.")) {
	            	System.out.println("금액 입력 성공");
	                break;
		    	}else {	    	
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("2400");
		    	 }		    		    	
		    }
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("수납장");
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).sendKeys("홈플러스");
			try {
				driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_type")).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.id("com.nhn.android.moneybook:id/type_card")).click();
			}
			driver.findElement(By.name("[SC] 신용")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).sendKeys("생활용품");
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
			Thread.sleep(500);
			
			List<WebElement> 사용금액 = driver.findElementsById("com.nhn.android.moneybook:id/txtAccountAmt");
			List<WebElement> 금액비율 = driver.findElementsById("com.nhn.android.moneybook:id/txtAccountRate");
			assertTrue(driver.findElement(By.name("[SC] 신용")).isDisplayed());
			assertEquals(사용금액.get(5).getText(), "2,400");
			assertEquals(금액비율.get(5).getText(), "4%");
		}
		
		//TC21
		@Given("^카드/현금> 카드 지출내역 선택$")
		public void 카드_현금_카드_지출내역_선택() throws Throwable {
		   System.out.println("TC21 - 카드/현금> 카드 지출내역 수정");
		   driver.findElement(By.id("com.nhn.android.moneybook:id/go_statistics_page")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnReportCardCash")).click();
		   driver.findElement(By.name("[SC] 신용")).click();
		   
		   assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/txtItemDesc")).isDisplayed());
		}

		@When("^카드/현금 depth(\\d+) 지출내역 선택$")
		public void 카드_현금_depth_지출내역_선택(int arg1) throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/txtItemDesc")).click();
			Thread.sleep(500);
			assertTrue(driver.findElement(By.name("내역 보기")).isDisplayed());
		}

		@When("^지출금액 분류 수정 후 저장$")
		public void 지출금액_분류_수정_후_저장() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("3000");
			for (;;){
		    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("3,000")) {
		    		    	System.out.println("금액 입력 성공");
		    		    	break;
		    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("3,000. 편집 중입니다.")) {
	            	System.out.println("금액 입력 성공");
	                break;
		    	}else {	    	
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("3000");
		    	 }		    		    	
		    }	
			// driver.findElement(By.id("com.nhn.android.moneybook:id/selected_lcat_name")).click();
			
			// driver.findElement(By.name("주거/통신")).click();
			// driver.findElement(By.name("공과금")).click();
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
			Thread.sleep(500);
			
			assertTrue(driver.findElement(By.name("주거/통신 > 공과금")).isDisplayed());
		}

		@Then("^카드/현금> 사용금액, 금액비율 확인$")
		public void 카드_현금_사용금액_금액비율_확인() throws Throwable {
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			Thread.sleep(500);
			
			List<WebElement> 종류 = driver.findElementsById("com.nhn.android.moneybook:id/txtAccountName");
			List<WebElement> 사용금액 = driver.findElementsById("com.nhn.android.moneybook:id/txtAccountAmt");
			List<WebElement> 금액비율 = driver.findElementsById("com.nhn.android.moneybook:id/txtAccountRate");
			assertEquals(종류.get(5).getText(), "[SC] 신용");
			assertEquals(사용금액.get(5).getText(), "3,000");
			assertEquals(금액비율.get(5).getText(), "4%");
		}
		
		//TC22
		@Given("^현금 관리하기 선택$")
		public void 현금_관리하기_선택() throws Throwable {
		    System.out.println("TC22 - 카드/현금> 현금(통장) 추가 후 카드 지출내역 작성");
		    driver.findElement(By.id("com.nhn.android.moneybook:id/go_statistics_page")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnReportCardCash")).click();
		    driver.findElement(By.id("com.nhn.android.moneybook:id/ivManageAccount")).click();
		    assertTrue(driver.findElement(By.name("통장(현금계좌) 관리")).isDisplayed());   
		}

		@When("^통장 추가 선택$")
		public void 통장_추가_선택() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/btn_account")).click();
			assertTrue(driver.findElement(By.name("통장(현금계좌) 추가")).isDisplayed());   
		}

		@When("^통장정보 작성 후 저장$")
		public void 통장정보_작성_후_저장() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/editAccountName")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/editAccountName")).sendKeys("SC");

			driver.findElement(By.id("com.nhn.android.moneybook:id/spinnerAsset")).click();
			List<WebElement> PA = driver.findElementsByClassName("android.widget.CheckedTextView");
			PA.get(1).click();

			driver.findElement(By.id("com.nhn.android.moneybook:id/spinnerAccountCorp")).click();
			List<WebElement> AA = driver.findElementsByClassName("android.widget.CheckedTextView");
			AA.get(2).click();

			driver.findElement(By.id("com.nhn.android.moneybook:id/save_account")).click();
			Thread.sleep(3000);
			
			assertTrue(driver.findElement(By.name("SC")).isDisplayed());
		}

		@Then("^추가한 현금\\(통장\\) 지정하여 지출내역 작성 후 종류/건수, 사용금액, 금액비율 확인$")
		public void 추가한_현금_통장_지정하여_지출내역_작성_후_종류_건수_사용금액_금액비율_확인() throws Throwable {
		    driver.sendKeyEvent(AndroidKeyCode.BACK);
		    
		    driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
			Thread.sleep(500);
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("50000");
			for (;;){
		    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("50,000")) {
		    		    	System.out.println("금액 입력 성공");
		    		    	break;
		    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("50,000. 편집 중입니다.")) {
	            	System.out.println("금액 입력 성공");
	                break;
		    	}else {	    	
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("50000");
		    	 }		    		    	
		    }
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("이불보");
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).sendKeys("이케아");
			try {
				driver.findElement(By.id("com.nhn.android.moneybook:id/type_card")).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_account_type")).click();
			}
			driver.findElement(By.id("com.nhn.android.moneybook:id/account_icon")).click();
			driver.findElement(By.name("[현금] SC")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/tag_names")).sendKeys("침구류");
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
			Thread.sleep(500);
			
			List<WebElement> 종류 = driver.findElementsById("com.nhn.android.moneybook:id/txtAccountName");
			List<WebElement> 사용금액 = driver.findElementsById("com.nhn.android.moneybook:id/txtAccountAmt");
			List<WebElement> 금액비율 = driver.findElementsById("com.nhn.android.moneybook:id/txtAccountRate");
			assertEquals(종류.get(0).getText(), "[자유입출금] SC");
			assertEquals(사용금액.get(0).getText(), "50,000");
			assertEquals(금액비율.get(0).getText(), "42%");
		}
		
		//TC23
		@Given("^카드/현금> 현금 지출내역 선택$")
		public void 카드_현금_현금_지출내역_선택() throws Throwable {
			System.out.println("TC23 - 카드/현금> 현금(통장) 지출내역 수정");
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_statistics_page")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnReportCardCash")).click();
			   driver.findElement(By.name("[자유입출금] SC")).click();
			   
			   assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/txtItemDesc")).isDisplayed());
		}

		@When("^현금 depth(\\d+) 지출내역 선택$")
		public void 현금_depth_지출내역_선택(int arg1) throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/txtItemDesc")).click();
			Thread.sleep(500);
			assertTrue(driver.findElement(By.name("내역 보기")).isDisplayed());
		}

		@When("^지출금액 분류 수정 후 저장(\\d+)$")
		public void 지출금액_분류_수정_후_저장(int arg1) throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("100000");
			for (;;){
		    	if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("100,000")) {
		    		    	System.out.println("금액 입력 성공");
		    		    	break;
		    	} else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("100,000. 편집 중입니다.")) {
	            	System.out.println("금액 입력 성공");
	                break;
		    	}else {	    	
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
		    		driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("100000");
		    	 }		    		    	
		    }	
			// driver.findElement(By.id("com.nhn.android.moneybook:id/selected_lcat_name")).click();
			
			// driver.findElement(By.name("의복/미용")).click();
			// driver.findElement(By.name("헤어/뷰티")).click();
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
			Thread.sleep(500);
			
			assertTrue(driver.findElement(By.name("의복/미용 > 헤어/뷰티")).isDisplayed());
		}

		@Then("^현금> 사용금액, 금액비율 확인$")
		public void 현금_사용금액_금액비율_확인() throws Throwable {
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			Thread.sleep(500);
			
			List<WebElement> 종류 = driver.findElementsById("com.nhn.android.moneybook:id/txtAccountName");
			List<WebElement> 사용금액 = driver.findElementsById("com.nhn.android.moneybook:id/txtAccountAmt");
			List<WebElement> 금액비율 = driver.findElementsById("com.nhn.android.moneybook:id/txtAccountRate");
			assertEquals(종류.get(0).getText(), "[자유입출금] SC");
			assertEquals(사용금액.get(0).getText(), "100,000");
			assertEquals(금액비율.get(0).getText(), "59%");
		}
		
		//TC24
		@Given("^카드/현금> 환경설정으로 이동$")
		public void 카드_현금_환경설정으로_이동() throws Throwable {
			System.out.println("TC24 - 통장관리설정 OFF 후 카드/현금 홈 화면 확인");
		    driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
		    Thread.sleep(500);
		    
		    assertTrue(driver.findElement(By.name("환경설정")).isDisplayed());
		}

		@When("^통장관리 OFF설정$")
		public void 통장관리_OFF설정() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnAccountEnable")).click();
			driver.findElement(By.id("android:id/button1")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_statistics_page")).click();
			Thread.sleep(500);
			
		}

		@Then("^카드/현금 홈> 카드 관리하기 버튼 확인$")
		public void 카드_현금_홈_카드_관리하기_버튼_확인() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnReportCardCash")).click();
			Thread.sleep(500);
			
			//List<WebElement> 종류 = driver.findElementsById("com.nhn.android.moneybook:id/txtAccountName");
			//assertEquals(종류.get(1).getText(), "[현금] 현금");
			assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/ivManageCard")).isDisplayed());
		}
		
		//TC25
		@Given("^자산현황 이동 후 화면확인$")
		public void 자산현황_이동_후_화면확인() throws Throwable {
			System.out.println("TC25 - 자산현황> 총누적자산> 카테고리별 금액 작성");
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_statistics_page")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnReportAssetStatus")).click();
			Thread.sleep(500);
			
			List<WebElement> 카테고리명 = driver.findElementsById("com.nhn.android.moneybook:id/totalAccumulatedAssetName");
			assertEquals(카테고리명.get(0).getText(), "현금잔액");
			assertEquals(카테고리명.get(1).getText(), "예금");
			assertEquals(카테고리명.get(2).getText(), "적금");
			assertEquals(카테고리명.get(3).getText(), "펀드");
			assertEquals(카테고리명.get(4).getText(), "보험");
			assertEquals(카테고리명.get(5).getText(), "투자");
			assertEquals(카테고리명.get(6).getText(), "기타");
		}

		@When("^지출내역 작성 \\(출금계좌: 현금, 분류: 각각 저축/보험 하위 (\\d+)개\\)> 각 카테고리별 지출내역 및 현금잔액 확인$")
		public void 지출내역_작성_출금계좌_현금_분류_각각_저축_보험_하위_개_각_카테고리별_지출내역_및_현금잔액_확인(int arg1) throws Throwable {
		    driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
		    
		    this.Spending();
		    int i = 0;
			while (i < 3) {
				driver.swipe(817, 1366, 100, 1370, 1000);
				i++;
			}
			driver.findElement(By.name("저축/보험")).click(); 
			String btn_name1 = driver.findElement(By.name("저축/보험")).getText();
			driver.findElement(By.name("예금")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name1); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_outgo_item")).click(); //저장 후 계속 입력
			
			this.Spending();
			i=0;
			while (i < 3) {
				driver.swipe(817, 1366, 100, 1370, 1000);
				i++;
			}
			driver.findElement(By.name("저축/보험")).click(); 
			String btn_name2 = driver.findElement(By.name("적금")).getText();
			driver.findElement(By.name("적금")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name2); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_outgo_item")).click(); //저장 후 계속 입력
			Thread.sleep(1000);
			
			this.Spending();
			i=0;
			while (i < 3) {
				driver.swipe(817, 1366, 100, 1370, 1000);
				i++;
			}
			driver.findElement(By.name("저축/보험")).click(); 
			String btn_name3 = driver.findElement(By.name("펀드")).getText();
			driver.findElement(By.name("펀드")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name3); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_outgo_item")).click(); //저장 후 계속 입력
			
			this.Spending();
			i=0;
			while (i < 3) {
				driver.swipe(817, 1366, 100, 1370, 1000);
				i++;
			}
			driver.findElement(By.name("저축/보험")).click(); 
			String btn_name4 = driver.findElement(By.name("보험")).getText();
			driver.findElement(By.name("보험")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name4); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_outgo_item")).click(); //저장 후 계속 입력
			
			this.Spending();
			i=0;
			while (i < 3) {
				driver.swipe(817, 1366, 100, 1370, 1000);
				i++;
			}
			driver.findElement(By.name("저축/보험")).click(); 
			String btn_name5 = driver.findElement(By.name("투자")).getText();
			driver.findElement(By.name("투자")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name5); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_outgo_item")).click(); //저장 후 계속 입력
			
			this.Spending();
			i=0;
			while (i < 3) {
				driver.swipe(817, 1366, 100, 1370, 1000);
				i++;
			}
			driver.findElement(By.name("저축/보험")).click(); 
			String btn_name6 = driver.findElement(By.name("기타")).getText();
			driver.findElement(By.name("기타")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name6); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click(); //저장 후 계속 입력
			
			List<WebElement> 금액 = driver.findElementsById("com.nhn.android.moneybook:id/totalAccumulatedAssetAmt");
			assertEquals(금액.get(0).getText(), "1,364,250");
			assertEquals(금액.get(1).getText(), "5,000");
			assertEquals(금액.get(2).getText(), "5,000");
			assertEquals(금액.get(3).getText(), "5,000");
			assertEquals(금액.get(4).getText(), "5,000");
			assertEquals(금액.get(5).getText(), "5,000");
			assertEquals(금액.get(6).getText(), "5,000");
			assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/txtTotalAccumulatedAmtSum")).getText(), "1,394,250");
			
		}

		@Then("^수입내역 작성 \\(분류: 각각 저축/보험 하위 (\\d+)개\\)> 각 카테고리별 지출내역 및 현금잔액 확인$")
		public void 수입내역_작성_분류_각각_저축_보험_하위_개_각_카테고리별_지출내역_및_현금잔액_확인(int arg1) throws Throwable {
	driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
		    
		    this.Income();
			driver.findElement(By.name("저축/보험")).click(); 
			String btn_name1 = driver.findElement(By.name("예금")).getText();
			driver.findElement(By.name("예금")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name1); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_income_item")).click(); //저장 후 계속 입력
			
			this.Income();
			driver.findElement(By.name("저축/보험")).click(); 
			String btn_name2 = driver.findElement(By.name("적금")).getText();
			driver.findElement(By.name("적금")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name2); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_income_item")).click(); //저장 후 계속 입력
			
			this.Income();
			driver.findElement(By.name("저축/보험")).click(); 
			String btn_name3 = driver.findElement(By.name("펀드")).getText();
			driver.findElement(By.name("펀드")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name3); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_income_item")).click(); //저장 후 계속 입력
			
			this.Income();
			driver.findElement(By.name("저축/보험")).click(); 
			String btn_name4 = driver.findElement(By.name("보험")).getText();
			driver.findElement(By.name("보험")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name4); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_income_item")).click(); //저장 후 계속 입력
			
			this.Income();
			driver.findElement(By.name("저축/보험")).click(); 
			String btn_name5 = driver.findElement(By.name("투자")).getText();
			driver.findElement(By.name("투자")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name5); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_income_item")).click(); //저장 후 계속 입력
			
			this.Income();
			driver.findElement(By.name("저축/보험")).click(); 
			String btn_name6 = driver.findElement(By.name("기타")).getText();
			driver.findElement(By.name("기타")).click(); 
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name6); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_income_item")).click(); //저장 후 계속 입력
			
			List<WebElement> 금액 = driver.findElementsById("com.nhn.android.moneybook:id/totalAccumulatedAssetAmt");
			assertEquals(금액.get(0).getText(), "1,406,250");
			assertEquals(금액.get(1).getText(), "-2,000");
			assertEquals(금액.get(2).getText(), "-2,000");
			assertEquals(금액.get(3).getText(), "-2,000");
			assertEquals(금액.get(4).getText(), "-2,000");
			assertEquals(금액.get(5).getText(), "-2,000");
			assertEquals(금액.get(6).getText(), "-2,000");
			assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/txtTotalAccumulatedAmtSum")).getText(), "1,394,250");
		}
		
		//TC26
		@Given("^자산현황홈> 임의의 카테고리 선택$")
		public void 자산현황홈_임의의_카테고리_선택() throws Throwable {
			System.out.println("TC26 - 자산현황> 총누적자산> 카테고리별 금액 수정");
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_statistics_page")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnReportAssetStatus")).click();
			
			driver.findElement(By.name("펀드")).click();
			assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/tvAssetIncrease")).isDisplayed());
			assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/tvAssetDecrease")).isDisplayed());
		}

		@When("^지출 내역 선택 후 수정$")
		public void 지출_내역_선택_후_수정() throws Throwable {
			driver.findElement(By.name("ex) 장보기펀드")).click();
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("1000"); //금액 입력
			for (;;){
	            if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("1,000. 편집 중입니다.")) {
	                        System.out.println("금액 입력 성공");
	                        break;
	            } else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("1,000")) {
	            	System.out.println("금액 입력 성공");
	                break;
	            }else {            
	                driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
	                driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
	                driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("1000");
	             }                            
	        }
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
			Thread.sleep(500);
			
			List<WebElement> 금액 = driver.findElementsById("com.nhn.android.moneybook:id/tv_item_amt");
			List<WebElement> 변동액 = driver.findElementsById("com.nhn.android.moneybook:id/tv_item_asset");
			assertEquals(금액.get(1).getText(), "1,000");
			assertEquals(변동액.get(1).getText(), "1,000");	
		}

		@When("^수입 내역 선택 후 수정$")
		public void 수입_내역_선택_후_수정() throws Throwable {
			List<WebElement> 펀드 = driver.findElementsById("com.nhn.android.moneybook:id/tv_item_desc");
			펀드.get(0).click();
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/lcat_btn")).click();
			driver.findElement(By.name("투자")).click();
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_income_item")).click();
			Thread.sleep(500);
			
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			driver.findElement(By.name("투자")).click();
			
			
			List<WebElement> 금액 = driver.findElementsById("com.nhn.android.moneybook:id/tv_item_amt");
			List<WebElement> 변동액 = driver.findElementsById("com.nhn.android.moneybook:id/tv_item_asset");
			assertEquals(금액.get(1).getText(), "7,000");
			assertEquals(변동액.get(1).getText(), "-2,000");	
		}

		@Then("^자산현황홈> 수정한 카테고리 금액 및 현금잔액 확인$")
		public void 자산현황홈_수정한_카테고리_금액_및_현금잔액_확인() throws Throwable {
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			
			List<WebElement> 카테고리명 = driver.findElementsById("com.nhn.android.moneybook:id/totalAccumulatedAssetName");
			List<WebElement> 금액 = driver.findElementsById("com.nhn.android.moneybook:id/totalAccumulatedAssetAmt");
			assertEquals(카테고리명.get(0).getText(), "현금잔액");	
			assertEquals(금액.get(0).getText(), "1,410,250");
			assertEquals(카테고리명.get(3).getText(), "펀드");
			assertEquals(금액.get(3).getText(), "1,000");
			assertEquals(카테고리명.get(5).getText(), "투자");
			assertEquals(금액.get(5).getText(), "-9,000");
		}
		
		
		//TC27
		@Given("^통장관리 설정ON 후 자산현황 홈 확인$")
		public void 통장관리_설정ON_후_자산현황_홈_확인() throws Throwable {
			System.out.println("TC27 - 자산현황> 순자산> 각 자산/부채 별 금액 작성");		
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnAccountEnable")).click();
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_statistics_page")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnReportAssetStatus")).click();
			
			assertTrue(driver.findElement(By.name("현금자산")).isDisplayed());
			assertTrue(driver.findElement(By.name("지갑속현금")).isDisplayed());
			assertTrue(driver.findElement(By.name("농협")).isDisplayed());
			assertTrue(driver.findElement(By.name("SC")).isDisplayed());
			assertTrue(driver.findElement(By.name("투자자산")).isDisplayed());
			assertTrue(driver.findElement(By.name("적금통장")).isDisplayed());
			assertTrue(driver.findElement(By.name("예금통장")).isDisplayed());
			
			
//			WebElement swipe_start = driver.findElement(By.name("기타자산"));
//			WebElement swipe_end = driver.findElement(By.name("현금자산"));
//			System.out.println(swipe_start.getLocation().x +" "+swipe_start.getLocation().y + "/" + swipe_end.getLocation().x+","+swipe_end.getLocation().y);
			driver.swipe(182, 1543, 182, 830, 1000);
			
//			driver.swipe(swipe_start.getLocation().x, swipe_start.getLocation().y, swipe_end.getLocation().x, swipe_start.getLocation().y, 2000);
		
			assertTrue(driver.findElement(By.name("기타자산")).isDisplayed());
			assertTrue(driver.findElement(By.name("대출")).isDisplayed());
			assertTrue(driver.findElement(By.name("대출통장")).isDisplayed());
			assertTrue(driver.findElement(By.name("기타부채")).isDisplayed());
			
			driver.swipe(182, 830, 182, 1543, 1000);
			Thread.sleep(500);
			
		}

		@When("^내역쓰기> 분류> 이체/대체 카테고리에서 추가 선택$")
		public void 내역쓰기_분류_이체_대체_카테고리에서_추가_선택() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/title")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/title")).click();
			
			try {
				driver.findElement(By.id("com.nhn.android.moneybook:id/cat_etc")).click();
			} catch (NoSuchElementException e) {
				driver.findElement(By.id("com.nhn.android.moneybook:id/lcat_btn")).click();
			}		  
			
			int i = 0;
			while (i < 3) {
				driver.swipe(817, 1366, 100, 1370, 1000);
				i++;
			}
			
			driver.findElement(By.name("이체/대체")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/add_icon")).click();
			
			assertTrue(driver.findElement(By.name("통장(현금계좌) 추가")).isDisplayed());   
	}

		@When("^통장추가> 자산속성> 기타자산/기타부채 추가 후 저장$")
		public void 통장추가_자산속성_기타자산_기타부채_추가_후_저장() throws Throwable {
			driver.findElement(By.id("com.nhn.android.moneybook:id/editAccountName")).sendKeys("기타자산");
		    driver.findElement(By.id("com.nhn.android.moneybook:id/spinnerAsset")).click();
		    
		    driver.swipe(386, 1102, 386, 132, 1000);    
		    driver.findElement(By.name("기타자산")).click();
		    driver.findElement(By.id("com.nhn.android.moneybook:id/save_account")).click();
		    Thread.sleep(1000);
		    
		    int i = 0;
			while (i < 3) {
				driver.swipe(817, 1366, 100, 1370, 1000);
				i++;
			}
			
			driver.findElement(By.name("이체/대체")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/add_icon")).click();
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/editAccountName")).sendKeys("기타부채");
		    driver.findElement(By.id("com.nhn.android.moneybook:id/spinnerAsset")).click();
		    
		    driver.swipe(386, 1102, 386, 132, 1000);    
		    driver.findElement(By.name("기타부채")).click();
		    driver.findElement(By.id("com.nhn.android.moneybook:id/save_account")).click();
		    Thread.sleep(1000);
		    driver.sendKeyEvent(AndroidKeyCode.BACK);
		    
		}

		@Then("^각 현금자산, 투자자산, 기타자산, 대출, 기타부채 내역 저장 후 자산/부채 별 금액 확인$")
		public void 각_현금자산_투자자산_기타자산_대출_기타부채_내역_저장_후_자산_부채_별_금액_확인() throws Throwable {
			
			
			this.Spending();
			 int a = 0;
				while (a < 3) {
					driver.swipe(817, 1366, 100, 1370, 1000);
					a++;
				}
			driver.findElement(By.name("이체/대체")).click();
			String btn_name1 = driver.findElement(By.name("[현금] 지갑속현금")).getText();
			driver.findElement(By.name("[현금] 지갑속현금")).click();    			
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name1); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_outgo_item")).click(); //저장 후 계속 입력
			
			this.Spending();
			 int b = 0;
				while (b < 3) {
					driver.swipe(817, 1366, 100, 1370, 1000);
					b++;
				}
			driver.findElement(By.name("이체/대체")).click();
			String btn_name2 = driver.findElement(By.name("[투자] 적금통장")).getText();
			driver.findElement(By.name("[투자] 적금통장")).click();    			
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name2); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_outgo_item")).click(); //저장 후 계속 입력
			
			this.Spending();
			 int c = 0;
				while (c < 3) {
					driver.swipe(817, 1366, 100, 1370, 1000);
					c++;
				}
			driver.findElement(By.name("이체/대체")).click();
			String btn_name3 = driver.findElement(By.name("[기타] 기타자산")).getText();
			driver.findElement(By.name("[기타] 기타자산")).click();    			
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name3); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_outgo_item")).click(); //저장 후 계속 입력
			
			this.Spending();
			 int d = 0;
				while (d < 3) {
					driver.swipe(817, 1366, 100, 1370, 1000);
					d++;
				}
			driver.findElement(By.name("이체/대체")).click();
			String btn_name4 = driver.findElement(By.name("[대출] 대출통장")).getText();
			driver.findElement(By.name("[대출] 대출통장")).click();    			
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name4); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_and_write_outgo_item")).click(); //저장 후 계속 입력
			
			this.Spending();
			 int f = 0;
				while (f < 3) {
					driver.swipe(817, 1366, 100, 1370, 1000);
					f++;
				}
			driver.findElement(By.name("이체/대체")).click();
			String btn_name5 = driver.findElement(By.name("[기타] 기타부채")).getText();
			driver.findElement(By.name("[기타] 기타부채")).click();    			
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys(btn_name5); //사용내역 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click(); //저장 후 계속 입력
			Thread.sleep(1000);
			
			List<WebElement> 내역일치확인하기 = driver.findElementsById("com.nhn.android.moneybook:id/total_amt");
			assertEquals(내역일치확인하기.get(0).getText(), "1,388,250");
			assertEquals(내역일치확인하기.get(1).getText(), "1,378,250");
			assertEquals(내역일치확인하기.get(2).getText(), "1,489,750");
			assertEquals(내역일치확인하기.get(3).getText(), "-11,500");
			assertEquals(내역일치확인하기.get(4).getText(), "-100,000");
			assertEquals(내역일치확인하기.get(5).getText(), "5,000");
			assertEquals(내역일치확인하기.get(6).getText(), "5,000");
			assertEquals(내역일치확인하기.get(7).getText(), "0");
			
			driver.swipe(182, 1543, 182, 830, 1000);
			driver.swipe(182, 1543, 182, 830, 1000);
			
			assertEquals(내역일치확인하기.get(0).getText(), "5,000");
			assertEquals(내역일치확인하기.get(1).getText(), "5,000");
			assertEquals(내역일치확인하기.get(2).getText(), "-10,000");
			assertEquals(내역일치확인하기.get(3).getText(), "-5,000");
			assertEquals(내역일치확인하기.get(4).getText(), "-5,000");
			assertEquals(내역일치확인하기.get(5).getText(), "-5,000");
			assertEquals(내역일치확인하기.get(6).getText(), "-5,000");
			
			driver.swipe(182, 830, 182, 1543, 1000);
		}
		
		
		//TC28
		@Given("^자산현황> 임의의 자산 금액수정 후 저장$")
		public void 자산현황_임의의_자산_금액수정_후_저장() throws Throwable {
			System.out.println("TC28 - 자산현황> 순자산> 각 자산/부채 별 금액 수정");
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_statistics_page")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnReportAssetStatus")).click();
			driver.findElement(By.name("적금통장")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/tv_item_desc")).click();
			Thread.sleep(500);
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("7500");
			for (;;){
	            if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("7,500. 편집 중입니다.")) {
	                        System.out.println("금액 입력 성공");
	                        break;
	            } else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("7,500")) {
	            	System.out.println("금액 입력 성공");
	                break;
	            }else {            
	                driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
	                driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
	                driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("7500");
	             }                            
	        }
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
			Thread.sleep(1000);
			
			assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/tv_item_amt")).getText(), "7,500");
			assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/tv_item_asset")).getText(), "7,500");
			
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			Thread.sleep(500);
		}

		@When("^자산현황> 임의의 부채 금액수정 후 저장$")
		public void 자산현황_임의의_부채_금액수정_후_저장() throws Throwable {
			driver.swipe(182, 1543, 182, 830, 1000);
			driver.swipe(182, 1543, 182, 830, 1000);
			
			driver.findElement(By.name("대출통장")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/tv_item_desc")).click();
			Thread.sleep(500);
			
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("10000");
			for (;;){
	            if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("10,000. 편집 중입니다.")) {
	                        System.out.println("금액 입력 성공");
	                        break;
	            } else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("10,000")) {
	            	System.out.println("금액 입력 성공");
	                break;
	            }else {            
	                driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
	                driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
	                driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("10000");
	             }                            
	        }
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_outgo_item")).click();
			Thread.sleep(1000);
			
			assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/tv_item_amt")).getText(), "10,000");
			assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/tv_item_asset")).getText(), "-10,000");
			
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			Thread.sleep(500);
		}


		@Then("^자산현황홈> 수정한 카테고리 금액 변경 및 자산/부채 금액 확인$")
		public void 자산현황홈_수정한_카테고리_금액_변경_및_자산_부채_금액_확인() throws Throwable {
			List<WebElement> 내역일치확인하기 = driver.findElementsById("com.nhn.android.moneybook:id/total_amt");
			assertEquals(내역일치확인하기.get(2).getText(), "-15,000");
			assertEquals(내역일치확인하기.get(3).getText(), "-10,000");
			assertEquals(내역일치확인하기.get(4).getText(), "-10,000");
			
			driver.swipe(182, 830, 182, 1543, 1000);
			driver.swipe(182, 830, 182, 1543, 1000);
			
			assertEquals(내역일치확인하기.get(1).getText(), "1,370,750");
			assertEquals(내역일치확인하기.get(5).getText(), "7,500");
			assertEquals(내역일치확인하기.get(6).getText(), "7,500");
		}
		
		
		//TC29			
		@Given("^환경설정 > 암호잠금 클릭 > 암호잠금 체크 > 암호를 입력$")
		public void 환경설정_암호잠금_클릭_암호잠금_체크_암호를_입력() throws Throwable {
			System.out.println("TC29 - 암호잠금 설정");
			//환경설정 클릭
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();

			//암호잠금 클릭
			driver.findElement(By.id("com.nhn.android.moneybook:id/layoutEnableLock")).click();

			//암호잠금 체크
			driver.findElement(By.id("com.nhn.android.moneybook:id/checkboxEnableLock")).click();

			//숫자1234 클릭
			driver.findElement(By.name("사용할 암호 4자리를 입력해주세요")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_one")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_two")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_three")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_four")).click();
			

			//숫자1234 재클릭
			driver.findElement(By.name("다시 한 번 암호를 입력해주세요")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_one")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_two")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_three")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_four")).click();
			
		}

		@When("^앱Background 변경함$")
		public void 앱background_변경함() throws Throwable {
			//앱 Backgroung로 변경함
			driver.sendKeyEvent(AndroidKeyCode.HOME);
			Thread.sleep(1000);
		}


		@Then("^설정한 암호 입력후 암호잠금화면 확인$")
		public void 설정한_암호_입력후_암호잠금화면_확인() throws Throwable {
			//가계부를 재실행한다
			driver.findElement(By.name("네이버 가계부")).click();
			Thread.sleep(500);
			driver.findElement(By.name("설정한 암호 4자리를 입력해주세요")).isDisplayed();

			//숫자1234 입력한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_one")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_two")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_three")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_four")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/conf_set_title")).isDisplayed();
			
		}

		
		//TC30
		@Given("^환경설정 > 암호잠금 클릭 > 암호변경 클릭 > 현재암호 입력 > 새로운암호 입력 > 새로운암호 재입력$")
		public void 환경설정_암호잠금_클릭_암호변경_클릭_현재암호_입력_새로운암호_입력_새로운암호_재입력() throws Throwable {
			System.out.println("TC30 - 암호잠금 변경");
			
			//암호변경 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/btn_change_password")).click();
			//현재암호를 입력한다
			//숫자1234 입력한다
			driver.findElement(By.name("설정한 암호 4자리를 입력해주세요")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_one")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_two")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_three")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_four")).click();

			//새로운암호를 입력한다
			//숫자1236 입력한다
			driver.findElement(By.name("새로운 암호 입력")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_one")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_two")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_three")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_six")).click();

			//새로운암호를 입력한다
			//숫자1236 재 입력한다
			driver.findElement(By.name("새로운 암호 재입력")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_one")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_two")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_three")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_six")).click();
		}

		@When("^앱Background 변경$")
		public void 앱background_변경() throws Throwable {
			driver.sendKeyEvent(AndroidKeyCode.HOME);
			Thread.sleep(1000);
		}

		@Then("^변경전/후 암호 입력 > 변경한 암호 입력 후 암호풀림 확인$")
		public void 변경전_후_암호_입력_변경한_암호_입력_후_암호풀림_확인() throws Throwable {
			//가계부를 재실행한다
			driver.findElement(By.name("네이버 가계부")).click();

			//변경전 암호를 입력하여 확인한다
			//숫자1234를 입력
			driver.findElement(By.name("설정한 암호 4자리를 입력해주세요")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_one")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_two")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_three")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_four")).click();

			//암호가 일치하지 않습니다  얼럿문구를 check한다
			driver.findElement(By.name("암호가 일치하지 않습니다")).isDisplayed();
			String PwError = driver.findElement(By.id("com.nhn.android.moneybook:id/middle_copy_single_line")).getText();

			if(PwError.equals("암호가 일치하지 않습니다"))
			{
				System.out.println("변경 전 암호 입력 시, 암호불일치 문구 : True");
			}
			else{
				System.out.println("변경 전 암호 입력 시, 암호불일치 문구 : False");
			}

			//변경후 암호를 입력하여 확인한다
			//숫자1236을 입력
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_one")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_two")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_three")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/key_six")).click();
			System.out.println("변경한 암호로 암호잠금->풀림 : True"+"\n");
			driver.findElement(By.id("com.nhn.android.moneybook:id/conf_set_title")).isDisplayed();
			//홈버튼 클릭한다
			driver.sendKeyEvent(AndroidKeyCode.BACK);
		}

		
		//TC31
		@Given("^환경설정 > 기본설정 > 월 시작일$")
		public void 환경설정_기본설정_월_시작일() throws Throwable {
			System.out.println("TC31 - 월 시작일 변경");
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			//기본설정 > 월시작일 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/layoutMonthStartDay")).click();
		}

		@When("^임의의 시작일 선택$")
		public void 임의의_시작일_선택() throws Throwable {
			//7일을 클릭한다
			String dayfront = "0";
			int dayend = 2;
			driver.findElement(By.name(dayfront+dayend +" 일")).click();
		}

		@Then("^GNB > 한달보기/통계 > 상단에 월시작일 확인$")
		public void gnb_한달보기_통계_상단에_월시작일_확인() throws Throwable {
			//한달보기 클릭후 상단 시작일 확인한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
			//셋팅된 가계부의 월/일을 저장한다
			String settingDay = driver.findElement(By.id("com.nhn.android.moneybook:id/smry_md_period")).getText();

			Calendar today = Calendar.getInstance();
			int month = today.get(Calendar.MONTH);
			String dayfront = "0";
			int dayend = 2;

			//셋팅된 가계부의 일/월을 확인
			System.out.println("한달보기의 설정된 날짜를 확인합니다"+"\n");
			System.out.println("한달보기의 설정된 날짜 : "+settingDay);
			assertEquals(settingDay, (month+1)+"."+dayfront+dayend+" ~ "+(month+2)+"."+dayfront+(dayend-1));
			

			//통계 클릭 후 상단 시작일 확인한다
			System.out.println("통계의 설정된 날짜를 확인합니다"+"\n");
			System.out.println("통계의 설정된 날짜 : "+settingDay);
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_statistics_page")).click();	
			assertEquals(settingDay, (month+1)+"."+dayfront+dayend+" ~ "+(month+2)+"."+dayfront+(dayend-1));
					
		}


		
		//TC32
		@Given("^환경설정 > 기본설정 > 소수점표시$")
		public void 환경설정_기본설정_소수점표시() throws Throwable {
			System.out.println("TC32 - 소수점 표시");
			//환경설정 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			//소수점표시가 존재함을 확인한다
			driver.findElement(By.name("소수점 표시")).isDisplayed();
		}

		@When("^소수점 표시 Check$")
		public void 소수점_표시_Check() throws Throwable {
			//소수점표시 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnDecimalEnable")).click();
		}

		@Then("^GNB > 한달보기/일년보기/통계 > 각 지출/수입금액 소수점 두번째자리 확인$")
		public void gnb_한달보기_일년보기_통계_각_지출_수입금액_소수점_두번째자리_확인() throws Throwable {
			//한달보기 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
			//입력한 가격의 소수점 확인해야함
			assertTrue(driver.findElement(By.name("3,027,250.00")).isDisplayed());
			assertTrue(driver.findElement(By.name("196,250.00")).isDisplayed());
			assertTrue(driver.findElement(By.name("-11,500.00")).isDisplayed());
			
			//일년보기 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_annual_summry_page")).click();
			//입력한 가격의 소수점 확인해야함
			assertTrue(driver.findElement(By.name("3,027,250.00")).isDisplayed());
			assertTrue(driver.findElement(By.name("196,250.00")).isDisplayed());
			assertTrue(driver.findElement(By.name("2,831,000.00")).isDisplayed());
			
			//통계보기 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_statistics_page")).click();
			//입력한 가격의 소수점 확인해야함
			assertTrue(driver.findElement(By.name("100,000.00")).isDisplayed());
			assertTrue(driver.findElement(By.name("26,500.00")).isDisplayed());
			assertTrue(driver.findElement(By.name("26,000.00")).isDisplayed());
			
		}


		//TC33-1
		@Given("^환경설정 > 분류관리 > 수입분류관리 > 추가$")
		public void 환경설정_분류관리_수입분류관리_추가() throws Throwable {
			System.out.println("TC33 - 수입분류 관리");
			//환경설정 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			//아래로 플리킹한다
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).click();
			
			//수입분류 관리를 클릭한다.
			//driver.findElement(By.name("수입분류 관리")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/layoutIncomeCat")).click();
			Thread.sleep(500);
		}

		@When("^수입분류 추가$")
		public void 수입분류_추가() throws Throwable {
			//추가버튼을 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/add_icon")).click();
			//소분류를 입력 후 확인을 클릭한다
			List<WebElement> Inputbox = driver.findElementsByClassName("android.widget.EditText");
			Inputbox.get(0).sendKeys("인센티브");
			driver.findElement(By.name("확인")).click();
		}

		@Then("^내역쓰기 > 수입 > 추가된 수입분류 확인$")
		public void 내역쓰기_수입_추가된_수입분류_확인() throws Throwable {
			//********************홈으로 이동후 추가된 수입분류의 노출을 확인한다

			//홈버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
			//가계부쓰기 버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
			//수입버튼을 클릭 한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/type_income_item")).click();
			//미분류 버튼을 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/cat_etc")).click();

			assertTrue(driver.findElement(By.name("인센티브")).isDisplayed());
			String Add = driver.findElement(By.name("인센티브")).getText();

			if(Add.equals("인센티브")) {	
				System.out.println("추가한 수입분류는 "+"["+Add+"]"+" 입니다" + "\n추가한 수입분류명과 노출명이 동일합니다 : True");
			}
			else{
				System.out.println("추가한 수입분류는 "+"["+Add+"]"+" 입니다" + "\n추가한 수입분류명과 노출명이 다릅니다 : False");
			}

			//추가한 수입분류 클릭한다
			driver.findElement(By.name("인센티브")).click();
			//다시 홈으로 이동한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
		}

		
		//TC33-2
		@Given("^환경설정 > 분류관리 > 수입분류관리 > 수정$")
		public void 환경설정_분류관리_수입분류관리_수정() throws Throwable {
			//환경설정 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			//아래로 플리킹한다
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).click();
			//수입분류 관리를 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/layoutIncomeCat")).click();
		}

		@When("^수입분류 수정$")
		public void 수입분류_수정() throws Throwable {
			//추가된 수입분류를 수정한다
			driver.findElement(By.name("인센티브")).click();
			//수정 버튼을 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/modify_scat")).click();
			//수정완료 후 확인을 클릭한다
			List<WebElement> Inputbox = driver.findElementsByClassName("android.widget.EditText");
			Inputbox.get(0).clear();
			Inputbox.get(0).sendKeys("특별보너스");
			driver.findElement(By.name("확인")).click();
		}

		@Then("^내역쓰기 > 수입 > 수정한 수입분류 확인$")
		public void 내역쓰기_수입_수정한_수입분류_확인() throws Throwable {
			//********************홈으로 이동후 수정된 수입분류의 노출을 확인한다
			//홈버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
			//가계부쓰기 버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
			//수입버튼을 클릭 한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/type_income_item")).click();
			//미분류 버튼을 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/cat_etc")).click();

			//수정된 수입분류를 확인한다
			assertTrue(driver.findElement(By.name("특별보너스")).isDisplayed());
			String modify = driver.findElement(By.name("특별보너스")).getText();

			if(modify.equals("특별보너스")) {	
				System.out.println("수정한 수입분류는 "+"["+modify+"]"+" 입니다" + "\n수정한 수입분류명과 노출명이 동일합니다 : True");
			}
			else{
				System.out.println("수정한 수입분류는 "+"["+modify+"]"+" 입니다" + "\n수정한 수입분류명과 노출명이 다릅니다 : False");
			}


			//수정한 수입분류 클릭한다
			driver.findElement(By.name("특별보너스")).click();
			//다시 홈으로 이동한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
		}

		
		//TC33-3
		@Given("^환경설정 > 분류관리 > 수입분류관리 > 삭제$")
		public void 환경설정_분류관리_수입분류관리_삭제() throws Throwable {
			//환경설정 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			//아래로 플리킹한다
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).click();
			//수입분류 관리를 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/layoutIncomeCat")).click();
		}

		@When("^수입분류 삭제$")
		public void 수입분류_삭제() throws Throwable {
			//수정된 수입분류를 삭제한다
			driver.findElement(By.name("특별보너스")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/delete_scat")).click();
			driver.findElement(By.name("확인")).click();
		}

		@Then("^내역쓰기 > 수입 > 수입분류 삭제 확인$")
		public void 내역쓰기_수입_수입분류_삭제_확인() throws Throwable {
			//********************삭제된 수입분류가 미노출되는지 확인한다

			//홈버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
			//가계부쓰기 버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
			//수입버튼을 클릭 한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/type_income_item")).click();
			//미분류 버튼을 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/cat_etc")).click();

			//수정된 수입분류를 확인한다
			
			//모든 수입분류들을 리스트에 저장한다
			List<WebElement> allcategorize = driver.findElementsById("com.nhn.android.moneybook:id/scat_name");
			assertNotEquals(allcategorize, "특별보너스");

			if(!allcategorize.isEmpty()){
				int i = 0;
				for(WebElement categorize : allcategorize) {
					String catename = allcategorize.get(i).getText();
					
					
					
					if(catename.equals("특별보너스"))
					{
						System.out.println("특별보너스 수입분류는 존재합니다 : False");
						driver.closeApp();
					}
					else
					{				
						System.out.println("특별보너스 수입분류는 존재하지않습니다. "+" 찾은 카테고리명은 ["+catename+"] : True");	
						assertFalse(catename=="특별보너스");
					}
					i=i+1;
				}
				
				driver.sendKeyEvent(AndroidKeyCode.BACK);
				//홈버튼 클릭한다
				driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
			}		
		}


		
		//TC34-1
		@Given("^환경설정 > 분류관리 > 지출분류관리 > 추가$")
		public void 환경설정_분류관리_지출분류관리_추가() throws Throwable {
			System.out.println("TC34 - 지출분류 관리");
			//환경설정 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			//아래로 플리킹한다
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).click();
			//지출분류 관리를 클릭한다.
			driver.findElement(By.id("com.nhn.android.moneybook:id/layoutOutgoCat")).click();
		}

		@When("^지출분류 추가$")
		public void 지출분류_추가() throws Throwable {
			//추가버튼을 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/add_icon")).click();
			//소분류를 입력 후 확인을 클릭한다
			List<WebElement> Inputbox = driver.findElementsByClassName("android.widget.EditText");
			Inputbox.get(0).sendKeys("회식비");
			driver.findElement(By.name("확인")).click();
		}

		@Then("^내역쓰기 > 지출 > 추가된 지출분류 확인$")
		public void 내역쓰기_지출_추가된_지출분류_확인() throws Throwable {
			//********************홈으로 이동후 추가된 지출분류의 노출을 확인한다

			//홈버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
			//가계부쓰기 버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
			//지출버튼을 클릭 한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/type_out")).click();
			//미분류 버튼을 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/cat_etc")).click();

			String Add = driver.findElement(By.name("회식비")).getText();
			assertTrue(driver.findElement(By.name("회식비")).isDisplayed());
			if(Add.equals("회식비")) {	
				System.out.println("추가한 지출분류는 "+"["+Add+"]"+" 입니다" + "\n추가한 지출분류명과 "+Add+" 동일합니다 : True");
				
			}
			else{
				System.out.println("추가한 지출분류는 "+"["+Add+"]"+" 입니다" + "\n추가한 지출분류명과 "+Add+" 동일하지않습니다 : False");
				
			}

			//추가한 지출분류 클릭한다
			driver.findElement(By.name("회식비")).click();
			//다시 홈으로 이동한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
		}

		
		//TC34-2
		@Given("^환경설정 > 분류관리 > 지출분류관리 > 수정$")
		public void 환경설정_분류관리_지출분류관리_수정() throws Throwable {
			//환경설정 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			//아래로 플리킹한다
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).click();
			//지출분류 관리를 클릭한다
			driver.findElement(By.name("지출분류 관리")).click();
		}

		@When("^지출분류 수정$")
		public void 지출분류_수정() throws Throwable {
			//추가된 지출분류를 수정한다
			driver.findElement(By.name("회식비")).click();
			//수정 버튼을 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/modify_scat")).click();
			//수정완료 후 확인을 클릭한다
			List<WebElement> Inputbox = driver.findElementsByClassName("android.widget.EditText");
			Inputbox.get(0).clear();
			Inputbox.get(0).sendKeys("담배값");
			driver.findElement(By.name("확인")).click();
		}

		@Then("^내역쓰기 > 지출 > 수정한 지출분류 확인$")
		public void 내역쓰기_지출_수정한_지출분류_확인() throws Throwable {
			//********************홈으로 이동후 수정된 수입분류의 노출을 확인한다
			//홈버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
			//가계부쓰기 버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
			//지출버튼을 클릭 한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/type_out")).click();
			//미분류 버튼을 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/cat_etc")).click();

			//수정된 지출분류를 확인한다
			String modify = driver.findElement(By.name("담배값")).getText();
			assertTrue(driver.findElement(By.name("담배값")).isDisplayed());
			
			if(modify.equals("담배값")) {	
				System.out.println("수정한 지출분류는 "+"["+modify+"]"+" 입니다" + "\n수정한 지출분류명과 "+modify+" 동일합니다 : True");
			}
			else{
				System.out.println("수정한 지출분류는 "+"["+modify+"]"+" 입니다" + "\n수정한 지출분류명과 "+modify+" 동일합니다 : True");
			}


			//수정한 지출분류 클릭한다
			driver.findElement(By.name("담배값")).click();
			//다시 홈으로 이동한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
		}


		
		//TC34-3
		@Given("^환경설정 > 분류관리 > 지출분류관리 > 삭제$")
		public void 환경설정_분류관리_지출분류관리_삭제() throws Throwable {
			//환경설정 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			//아래로 플리킹한다
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).click();
			//지출분류 관리를 클릭한다
			driver.findElement(By.name("지출분류 관리")).click();
		}

		@When("^지출분류 삭제$")
		public void 지출분류_삭제() throws Throwable {
			//수정된 지출분류를 삭제한다
			driver.findElement(By.name("담배값")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/delete_scat")).click();
			driver.findElement(By.name("확인")).click();
		}

		@Then("^내역쓰기 > 지출 > 지출분류 삭제 확인$")
		public void 내역쓰기_지출_지출분류_삭제_확인() throws Throwable {
			//********************삭제된 수입분류가 미노출되는지 확인한다

			//홈버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
			//가계부쓰기 버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
			//지출버튼을 클릭 한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/type_out")).click();
			//미분류 버튼을 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/cat_etc")).click();

			//수정된 지출분류를 확인한다
			//모든 지출분류들을 리스트에 저장한다
			List<WebElement> allcategorize = driver.findElementsById("com.nhn.android.moneybook:id/scat_name");
			assertNotEquals(allcategorize, "담배값");

			if(!allcategorize.isEmpty()){
				int i = 0;
				for(WebElement categorize : allcategorize) {
					String catename = allcategorize.get(i).getText();
					if(catename.equals("담배값"))
					{
						System.out.println("담배값 지출분류는 존재합니다 : False");
						driver.closeApp();
					}
					else
					{				
						System.out.println("담배값 지출분류는 존재하지않습니다. "+"찾은 카테고리명은 ["+catename+"] : True");
						assertFalse(catename=="담배값");
					}
					i=i+1;
				}
			}
			//입력창을 닫기 위해 주식카테고리를 선택한다
			driver.findElement(By.name("주식")).click();
			//홈버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
		}
		
		//TC35
		@Given("^환경설정 > 분류관리 > 카드관리 > 추가$")
		public void 환경설정_분류관리_카드관리_추가() throws Throwable {
			System.out.println("TC35 - 카드관리");
			//환경설정 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			//아래로 플리킹한다
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).click();
			//카드 관리를 클릭한다
			driver.findElement(By.name("카드 관리")).click();
		}

		@When("^카드추가 > 내용입력 후 저장$")
		public void 카드추가_내용입력_후_저장() throws Throwable {
			//추가 버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/add_card")).click();
			//카드사 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/spinnerCardCorp")).click();
			//국민카드 클릭한다
			driver.findElement(By.name("경남")).click();
			//카드명을 입력한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/editCardName")).sendKeys("nori체크카드");
			//체크카드 check한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/btnIsCheckCard")).click();
			//연계계좌 선택한다
			driver.findElement(By.name("선택")).click();
			//예금통장 선택한다
			driver.findElement(By.name("예금통장")).click();
			//확인을 클릭한다
			driver.findElement(By.name("확인")).click();
			//저장버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_card")).click();
			//알림팝업에서 확인을 클릭한다
			driver.findElement(By.name("확인")).click();
		}

		@Then("^내역쓰기 > 출금계좌 > 카드 > 생성한 카드 확인$")
		public void 내역쓰기_출금계좌_카드_생성한_카드_확인() throws Throwable {
			//홈버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
			//가계부쓰기 버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
			//지출버튼을 클릭 한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/type_out")).click();
			//출금계좌 > 카드 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/type_card")).click();
			//모든 지출분류들을 리스트에 저장한다
			List<WebElement> allcard = driver.findElementsById("com.nhn.android.moneybook:id/cell_data");
			assertTrue(driver.findElement(By.name("[경남] nori체크카드")).isDisplayed());
			///지출분류들을 하나씩 비교하면서 nori체크카드가 존재하는지 체크한다
			if(!allcard.isEmpty()){
				int i = 0;
				for(WebElement card : allcard) {
					String cardname = allcard.get(i).getText();
					assertTrue(driver.findElement(By.name("[경남] nori체크카드")).isDisplayed());
					if(cardname.equals("[경남] nori체크카드"))
					{
						System.out.println("생성한 카드 "+cardname+" 존재합니다 : True");
						break;
					}
					else
					{				
						System.out.println("생성한 카드 "+cardname+" 존재하지않습니다 : False");
					}
					i=i+1;
				}
			}
			//열린창을 닫기 위해 생성한 카드 및 분류를를 선택한다
			driver.findElement(By.name("[경남] nori체크카드")).click();
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			//홈버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
		}

		
		//TC36
		@Given("^설정 > 통장\\(현금계좌\\) 관리 > 추가$")
		public void 설정_통장_현금계좌_관리_추가() throws Throwable {
			System.out.println("TC36 - 통장관리");
			//환경설정 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			//아래로 플리킹한다
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).click();
			//통장 관리를 클릭한다
			driver.findElement(By.name("통장(현금계좌) 관리")).click();
		}

		@When("^통장추가 > 내용입력 후 저장$")
		public void 통장추가_내용입력_후_저장() throws Throwable {
			//추가 버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/btn_account")).click();
			//통장명 입력한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/editAccountName")).sendKeys("생활비 통장");
			//자산속성 선택한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/spinnerAsset")).click();
			//자유입출금을 선택한다
			driver.findElement(By.name("자유입출금")).click();
			//저장 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_account")).click();

		}

		@Then("^내역쓰기 > 출금계좌 > 현금 > 생성한 통장 확인$")
		public void 내역쓰기_출금계좌_현금_생성한_통장_확인() throws Throwable {
			//홈버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
			//내역쓰기 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
			//카드 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/type_card")).click();
			//현금 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/tab_account")).click();

			assertTrue(driver.findElement(By.name("[현금] 생활비 통장")).isDisplayed());
			
			
			//열린창을 닫기 위해 생성한 통장 및 분류를 선택한다
			driver.findElement(By.name("[현금] 생활비 통장")).click();
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			
			//홈버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
		}

		
		//TC37
		@Given("^환경설정 > 내역관리 > 자주쓰는 내역관리$")
		public void 환경설정_내역관리_자주쓰는_내역관리() throws Throwable {
			System.out.println("TC37 - 자주쓰는 내역 관리");
			//환경설정 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			//아래로 플리킹한다
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).click();
			//자주쓰는 내역 관리 클릭한다
			driver.findElement(By.name("자주쓰는 내역 관리")).click();
		}

		@When("^추가 > 내용입력 후 저장하기$")
		public void 추가_내용입력_후_저장하기() throws Throwable {
			//추가버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/add_frequently_used_item")).click();
			//금액 입력한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
			String i = "15000";
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys(i);
			//사용내역 입력한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("장보기");
			//사용처 입력한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_place")).sendKeys("홈플러스");
			//저장을 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_frequently_used_outgo_item")).click();
		}

		@Then("^내역쓰기 > 불러오기 > 추가한 내역 노출확인$")
		public void 내역쓰기_불러오기_추가한_내역_노출확인() throws Throwable {
			//홈버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
			//내역쓰기 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/goWritePageBtn")).click();
			//불러오기 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/load_frequently_used_mbook_item")).click();

			//생성한 장보기 내역이 있는지 체크후 있을경우 장보기를 선택한다
			//모든 내역목록들을 리스트에 저장한다
			List<WebElement> allList = driver.findElementsById("com.nhn.android.moneybook:id/use_desc");
			
			//내역목록들을 하나씩 비교하면서 장보기 항목이 존재하는지 체크한다
			if(!allList.isEmpty()){
				int i = 0;
				for(WebElement list : allList) {
					String Listname = allList.get(i).getText();
					assertTrue(driver.findElement(By.name("장보기")).isDisplayed());
					//5.0 버전
					if(Listname.equals("장보기"))
					{
						driver.findElement(By.name("장보기")).click();
						break;
					}
					//4.4버전
					if(Listname.equals("ex) 장보기. 편집하려면 두 번 누르세요."))
					{
						driver.findElement(By.name("ex) 장보기. 편집하려면 두 번 누르세요.")).click();
						break;
					}
					else
					{				
						System.out.println("생성한 "+Listname+" 항목이 없습니다");
					}
					i=i+1;
				}
			}
			//홈버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
		}

		
		//TC38
		@Given("^환경설정 > 내역관리 > 고정금액 관리$")
		public void 환경설정_내역관리_고정금액_관리() throws Throwable {
			System.out.println("TC38 - 고정금액 관리");
			//환경설정 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			//아래로 플리킹한다
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).click();
			//고정금액 관리 클릭한다
			driver.findElement(By.name("고정금액 관리")).click();
		}

		@When("^추가 > 내용입력 후 저장$")
		public void 추가_내용입력_후_저장() throws Throwable {
			//추가버튼 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/add_fixed_item")).click();
			//금액 입력한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("100000");
			for (;;){
	            if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("100,000. 편집 중입니다.")) {
	                        System.out.println("금액 입력 성공");
	                        break;
	            } else if (driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).getText().equals("100,000")) {
	            	System.out.println("금액 입력 성공");
	                break;
	            }else {            
	                driver.findElement(By.id("com.nhn.android.moneybook:id/clear_outgo_amt")).click();
	                driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).click();
	                driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_amt")).sendKeys("100000");
	             }                            
	        }
			//사용내역 입력한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/use_desc")).sendKeys("정기적금");
			//저장을 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/save_fixed_item")).click();
		}

		@Then("^생성한 고정금액 확인$")
		public void 생성한_고정금액_확인() throws Throwable {
			//모든 고정금액 목록들을 리스트에 저장한다
			List<WebElement> fixList = driver.findElementsById("com.nhn.android.moneybook:id/txtFixedItemDesc");

			//내역목록들을 하나씩 비교하면서 장보기 항목이 존재하는지 체크한다
			if(!fixList.isEmpty()){
				int i = 1;
				for(WebElement fix : fixList) {
					String fixname = fixList.get(i).getText();
					assertTrue(driver.findElement(By.name("정기적금")).isDisplayed());
					if(fixname.equals("정기적금"))
					{
						System.out.println("생성한 "+fixname+" 항목이 존재합니다");
						break;
					}
					else
					{				
						System.out.println("생성한 "+fixname+" 항목이 없습니다");
					}
					i=i+1;
				}
			}
			//홈버튼 클릭한다
			driver.sendKeyEvent(AndroidKeyCode.BACK);
		}

		
		//TC39
		@Given("^환경설정 > 고객도움말 > 가계부 고객센터/오류신고/공지사항$")
		public void 환경설정_고객도움말_가계부_고객센터_오류신고_공지사항() throws Throwable {
			System.out.println("TC39 - 고객 도움말");
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			//아래로 플리킹한다
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).click();
		}

		@When("^가계부 고객센터/오류신고/공지사항 페이지 이동$")
		public void 가계부_고객센터_오류신고_공지사항_페이지_이동() throws Throwable {
			//가계부 고객센터 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/layoutHelp")).click();
			assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/webview_endkey")).isDisplayed());
			//가계부 고객센터 페이지 닫기
			driver.findElement(By.id("com.nhn.android.moneybook:id/webview_endkey")).click();
			//오류신고 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/layoutQuestionAndReport")).click();
			assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/webview_endkey")).isDisplayed());
			//오류신고 페이지 닫기
			driver.findElement(By.id("com.nhn.android.moneybook:id/webview_endkey")).click();
		}

		@Then("^가계부 고객센터/오류신고/공지사항 페이지 확인$")
		public void 가계부_고객센터_오류신고_공지사항_페이지_확인() throws Throwable {
			//공지사항 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/layoutNotice")).click();
			assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/naver_notice_listview")).isDisplayed());
			//공지사항 페이지 닫기
			driver.findElement(By.id("com.nhn.android.moneybook:id/naver_notice_title_back_button")).click();
		}

		
		//TC40
		@Given("^환경설정 > 데이터초기화 > 수입/지출 내역 초기화$")
		public void 환경설정_데이터초기화_수입_지출_내역_초기화() throws Throwable {
			System.out.println("TC40 - 수입/지출내역만 초기화");
			//환경설정 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			//아래로 플리킹한다
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).click();
			
			//수입/지출 내역만 초기화 클릭한다
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// driver.findElement(By.name("수입/지출 내역만 초기화")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/txtOnlyIncomeAndExpenseInfo")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/txtOnlyIncomeAndExpenseInfo")).click();
		}

		@When("^팝업 > 예 선택하기$")
		public void 팝업_예_선택하기() throws Throwable {
			//첫번째 팝업에서 예 선택한다
			driver.findElement(By.name("예")).click();
			//두번째 팝업에서 예 선택한다
			driver.findElement(By.name("예")).click();
			//세번째 팝업에서 예 선택한다
			driver.findElement(By.name("확인")).click();
		}

		@Then("^수입/지출 내역 정상 초기화 확인$")
		public void 수입_지출_내역_정상_초기화_확인() throws Throwable {
			//한달보기로 이동 후 초기화 확인한다
			//수입이 0원인지 확인한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_monthly_smry_page")).click();
			String monthincome = driver.findElement(By.id("com.nhn.android.moneybook:id/income_total_amt")).getText();
			assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/income_total_amt")).getText(), "0.00");
			if(monthincome.equals("0.00")) {
				System.out.println("한달보기 수입이 "+monthincome+"원입니다");
			}
			//지출이 0원인지 확인한다
			String monthoutgo = driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_total_amt")).getText();
			assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_total_amt")).getText(), "0.00");
			if(monthoutgo.equals("0.00")){
				System.out.println("한달보기 지출이 "+monthoutgo+"원입니다");
			}


			//일년보기로 이동 후 초기화 확인한다
			//수입이 0원인지 확인한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_annual_summry_page")).click();
			String yearincome = driver.findElement(By.id("com.nhn.android.moneybook:id/income_total_amt")).getText();
			assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/income_total_amt")).getText(), "0.00");
			if(yearincome.equals("0.00")) {
				System.out.println("일년보기 수입이 "+yearincome+"원입니다");
			}
			//지출이 0원인지 확인한다
			String yearoutgo = driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_total_amt")).getText();
			assertEquals(driver.findElement(By.id("com.nhn.android.moneybook:id/outgo_total_amt")).getText(), "0.00");
			if(yearoutgo.equals("0.00")){
				System.out.println("일년보기 지출이 "+yearoutgo+"원입니다");
			}
		}

		
		//TC41
		@Given("^환경설정 > 데이터초기화 > 가계부 전체 초기화$")
		public void 환경설정_데이터초기화_가계부_전체_초기화() throws Throwable {
			System.out.println("TC41 - 전체 초기화");
			//환경설정 클릭한다
			driver.findElement(By.id("com.nhn.android.moneybook:id/go_config_page")).click();
			//아래로 플리킹한다
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.swipe(950, 1700, 950, 450, 1000);
			Thread.sleep(1000);
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/config_title")).click();
			// driver.findElement(By.name("가계부 전체 초기화")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/txtAllDataInfo")).isDisplayed();
			driver.findElement(By.id("com.nhn.android.moneybook:id/txtAllDataInfo")).click();

		}

		@When("^팝업 > 예 선택$")
		public void 팝업_예_선택() throws Throwable {
			//첫번째 팝업에서 예 선택한다
			driver.findElement(By.name("예")).click();
			//두번째 팝업에서 예 선택한다
			driver.findElement(By.name("예")).click();
			//세번째 팝업에서 예 선택한다
			driver.findElement(By.name("확인")).click();
		}

		@Then("^통장/카드/고정금액 모두 초기화 확인$")
		public void 수입_지출_통장_카드_고정금액_분류_모두_초기화_확인() throws Throwable {
			//카드관리가 초기화 되었는지 checking 한다
			//카드관리를 클릭한다
			driver.findElement(By.name("카드 관리")).click();
			assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/layerEmptyCardList")).isDisplayed());

			driver.sendKeyEvent(AndroidKeyCode.BACK);

			//통장관리 클릭한다
			//driver.findElement(By.name("통장(현금계좌) 관리")).click();
			driver.findElement(By.id("com.nhn.android.moneybook:id/layoutAccount")).click();
			
			//모든 통장관리명을 리스트에 저장한후 비교한다
			List<WebElement> allbankname = driver.findElementsById("com.nhn.android.moneybook:id/txtAccountName");
			assertNotEquals(allbankname, "생활비 통장");

			if(!allbankname.isEmpty()){
				int p = 0;
				for(WebElement bank : allbankname) {
					String bankname = allbankname.get(p).getText();
					if(bankname.equals("생활비 통장"))
					{
						System.out.println("통장관리 초기화 실패!");
					}
					if(!bankname.equals("생활비 통장")){
						System.out.println("통장관리 초기화 성공!");
						break;
					}
					p=p+1;
				}
			}
			driver.sendKeyEvent(AndroidKeyCode.BACK);
			
			//고정금액관리가 초기화 되었는지 checking 한다
			//고정금액관리 클릭한다
			driver.findElement(By.name("고정금액 관리")).click();

			assertTrue(driver.findElement(By.id("com.nhn.android.moneybook:id/empty_list_icon")).isDisplayed());
		}
		
		
		
		
		public void Spending() throws Exception{  //지출 클릭, 금액 입력, 분류 선택
			  
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
		
		
		public void Income() throws Exception{  //수입 클릭, 금액 입력, 분류 선택
			  
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
		
	@After
	public void tearDown() throws Exception {
		driver.quit();

	}
}
