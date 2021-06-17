package steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;


public class AceitarCookiesLGPDSteps {

	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/brunaprado/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Dado("que eu estou no site da accenture")
	public void que_eu_estou_no_site_da_accenture() {
		driver.get("https://www.accenture.com/br-pt");
	}
	
	@Quando("abro as configuraçoes de cookies")
	public void abro_as_configuraçoes_de_cookies() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement btnConfiguracaoesDeCookie = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("onetrust-pc-btn-handler"))));
		btnConfiguracaoesDeCookie.click();
	}
	
	@E("clico em Confirmar minhas escolhas")
	public void clico_em_confirmar_minhas_escolhas() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement btnConfirmarEscolhas = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"onetrust-pc-sdk\"]/div[3]/div[1]/button[1]"))));
		btnConfirmarEscolhas.click();
	}

	@Então("deve fechar o modal")
	public void deve_fechar_o_modal() {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		Boolean caixaDeInformcoes = wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("ot-content"))));

		assertTrue(caixaDeInformcoes);		
	}
	
	@After
	public void dps() {
		driver.quit();
	}

}
