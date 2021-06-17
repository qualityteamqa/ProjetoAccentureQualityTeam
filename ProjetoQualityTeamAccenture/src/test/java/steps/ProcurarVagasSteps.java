package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class ProcurarVagasSteps {
	
	WebDriver driver;
    WebDriverWait wait;
    
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/brunaprado/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
    }
	
	@Dado("que eu estou no site da accenture na página inicial")
	public void que_eu_estou_no_site_da_accenture_na_página_inicial() {
		driver.get("https://www.accenture.com/br-pt/");
	}

	@Quando("acessa a área de carreiras")
	public void acessa_a_área_de_carreiras() {
		driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/nav/div/div[1]/div[3]/div[1]/div[4]/div[1]/span")).click();
	}

	@Quando("clica em procure por vagas")
	public void clica_em_procure_por_vagas() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Procure Por Vagas")));
        driver.findElement(By.linkText("Procure Por Vagas")).click();
	}

	@Quando("digite no campo de busca desenvolvedor")
	public void digite_no_campo_de_busca_desenvolvedor() {
		driver.findElement(By.id("job-search-hero-bar")).sendKeys("desenvolvedor");
	}

	@Quando("clico no botão procurar")
	public void clico_no_botão_procurar() {
		driver.findElement(By.xpath("/html/body/div[1]/section[4]/div[1]/div/form/div/div/div/div[1]/div[2]/button")).click();
	}

	@Então("devo encontrar vagas para programadores")
	public void devo_encontrar_vagas_para_programadores() {
		
		WebElement todasVagas = driver.findElement(By.xpath("//*[@id=\"latest-nav\"]/h2"));
		wait.until(ExpectedConditions.textToBePresentInElement(todasVagas, "TODAS AS VAGAS"));
	    
		String tituloEsperado = driver.findElement(By.xpath("/html/body/div[1]/section[4]/div[4]/div/div/div/div[1]/ul/li[1]/a/h2/span[1]")).getText();
	    Assert.assertEquals("TODAS AS VAGAS", tituloEsperado);
	}
	
	@After
	public void dps() {
		driver.quit();
	}

}
