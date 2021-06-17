package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class ListaServicosSteps {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Before
    public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/brunaprado/Desktop/chromedriver");
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    wait = new WebDriverWait(driver, 10);
    }
	
	@Dado("que eu estou no site da accenture na pagina inicial")	
	public void que_eu_estou_no_site_da_accenture_na_pagina_inicial()  {
		wait =  new WebDriverWait(driver, 30);
		driver.findElement(By.cssSelector("#navigation-menu>div.nav-submenu.panel.layout-column.short>div.gh-item.nav-submenu-label")).click();
	}  
	
	@Então("devo ver os serviços abaixo")
	public void devo_ver_os_serviços_abaixo() {
		wait =  new WebDriverWait(driver, 30);
		String itens = driver.findElement(By.xpath("//*[@id='primaryLink2_Servios']>div>div>ul/li")).getText();
		System.out.println(itens);//testar
	    
	}
	
	@Dado("clico no menu servicos")
	public void clico_no_menu_servicos() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Então("devo ver os Accenture Strategy abaixo")
	public void devo_ver_os_accenture_strategy_abaixo() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	/*
	COM ISSO NÃO MOSTRA A LISTAGEM COM SERVIÇOS
	@After
	public void dps() {
		driver.quit();
	*/
	

	
}
