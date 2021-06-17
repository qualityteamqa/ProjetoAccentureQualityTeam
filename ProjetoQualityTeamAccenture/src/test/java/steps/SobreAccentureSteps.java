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

public class SobreAccentureSteps {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Before
    public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/brunaprado/Desktop/chromedriver");
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    wait = new WebDriverWait(driver, 10);
    }
	
	@Dado("que eu estou tela inicial da accenture")
	public void que_eu_estou_tela_inicial_da_accenture() {
		driver.get("https://www.accenture.com/br-pt");
	}

	@Quando("clico no menu sobre a accenture")
	public void clico_no_menu_sobre_a_accenture() {
	    driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/nav/div/div[1]/div[3]/div[1]/div[5]/div[1]/span")).click();
	}

	@Quando("clico no submenu sobre a accenture")
	public void clico_no_submenu_sobre_a_accenture() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sobre a Accenture")));
		driver.findElement(By.linkText("Sobre a Accenture")).click();	
	}

	@Então("devo ver o destaque em Nosso propósito")
	public void devo_ver_o_destaque_em_nosso_propósito() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        
		String nossoProp = driver.findElement(By.tagName("h3")).getText();
		Assert.assertEquals("Nosso propósito:", nossoProp);
	}
	
	@After
	public void dps() {
		driver.quit();
	}

}
