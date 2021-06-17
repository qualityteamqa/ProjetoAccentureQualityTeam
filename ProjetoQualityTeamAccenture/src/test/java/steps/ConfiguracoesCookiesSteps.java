package steps;

import static org.junit.Assert.assertEquals;

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

public class ConfiguracoesCookiesSteps {
	
	WebDriver driver;
    WebDriverWait wait;
    
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/brunaprado/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
	
	@Dado("que eu estou na pagina inicial da accenture")
	public void que_eu_estou_na_pagina_inicial_da_accenture() {
        driver.get("https://www.accenture.com/br-pt");
	}

	@Quando("abrir as configuraçoes de cookies")
	public void abro_as_configurações_de_cookies() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement btnConfiguracaoesDeCookie = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("onetrust-pc-btn-handler"))));
		btnConfiguracaoesDeCookie.click();
	}
	
	@E("clico em confirmar minhas escolhas")
	public void clico_em_confirmar_minhas_escolhas() {
		driver.findElement(By.xpath("/html/body/div[8]/div[2]/div[3]/div[1]/button[1]")).click();
	}
	
	@E("clico no botão configurações de cookie")
	public void clico_no_botão_configurações_de_cookie() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement btnConfiguracaoesDeCookie = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("optanon-minimize-button"))));
		btnConfiguracaoesDeCookie.click();
	}

	@Então("devo ver o item de sua privacidade")
	public void devo_ver_o_item_de_sua_privacidade(){
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement btnSuaPrivacidade = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("privacy-text"))));
		
		String textoElement = driver.findElement(By.id("privacy-text")).getText();
		
        assertEquals("Sua privacidade", textoElement);
	}

	@E("devo ver Cookies estritamente necessárias")
	public void devo_ver_cookies_estritamente_necessárias() {

		String textoElement = driver.findElement(By.id("ot-header-id-1")).getText();
		
        assertEquals("Cookies estritamente necessárias", textoElement);
	}

	@E("devo ver Cookies Analíticos de Primeira Parte")
	public void devo_ver_cookies_analíticos_de_primeira_parte() {
			
		String textoElement = driver.findElement(By.id("ot-header-id-2")).getText();
		
        assertEquals("Cookies Analíticos de Primeira Parte", textoElement);
	}

	@E("devo ver Cookies de Desempenho e Cookies Funcionais")
	public void devo_ver_cookies_de_desempenho_e_cookies_funcionais() {
		
		String textoElement = driver.findElement(By.id("ot-header-id-3")).getText();
		
        assertEquals("Cookies de Desempenho e Cookies Funcionais", textoElement);
	}

	@Então("devo ver Cookies de Publicidade e Redes Sociais")
	public void devo_ver_cookies_de_publicidade_e_redes_sociais() {
		
		String textoElement = driver.findElement(By.id("ot-header-id-4")).getText();
		
        assertEquals("Cookies de Publicidade e Redes Sociais", textoElement);
	}
	
	@After
	public void dps() {
		driver.quit();
	}

}
