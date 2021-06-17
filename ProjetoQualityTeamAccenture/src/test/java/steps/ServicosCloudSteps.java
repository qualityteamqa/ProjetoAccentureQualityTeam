package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class ServicosCloudSteps {
	
	WebDriver driver;
    WebDriverWait wait;
    
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/brunaprado/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

	@Dado("que eu estou na pagina da accenture")
	public void que_eu_estou_na_pagina_da_accenture() {
		driver.get("https://www.accenture.com/br-pt");
	}

	@Quando("clico no menu serviços")
	public void clico_no_menu_serviços() {
		
	    driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/nav/div/div[1]/div[3]/div[1]/div[2]/div[1]/span")).click();
	}

	@Quando("clico no item do menu Cloud")
	public void clico_no_item_do_menu_cloud() {
		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cloud")));
	    
	    driver.findElement(By.linkText("Cloud")).click();
	}

	@Então("devo encontrar o título {string}")
	public void devo_encontrar_o_título(String titulo) {
	    String tituloSite = driver.findElement(By.tagName("h1")).getText();
	    Assert.assertEquals(titulo, tituloSite);
	}
	
	@After
	public void dps() {
		driver.quit();
	}
}
