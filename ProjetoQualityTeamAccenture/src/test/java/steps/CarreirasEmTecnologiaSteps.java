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

public class CarreirasEmTecnologiaSteps {
	
	WebDriver driver;
    WebDriverWait wait;
    
   @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/brunaprado/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

	@Dado("que eu estou no site da Accenture")
	public void que_eu_estou_no_site_da_accenture() {
        driver.get("https://www.accenture.com/br-pt");
    }

    @Quando("clico no menu carreiras")
    public void clico_no_menu_carreiras() {
        driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/nav/div/div[1]/div[3]/div[1]/div[4]/div[1]/span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Vagas em tecnologia")));
    }

    @Quando("clico no item do menu vagas em tecnologia")
    public void clico_no_item_do_menu_vagas_em_tecnologia() {
        driver.findElement(By.linkText("Vagas em tecnologia")).click();
    }

    @Então("devo ver o destaque em {string}")
    public void devo_ver_o_destaque_em(String carreiras) {
        String msgDeValidacao = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(carreiras, msgDeValidacao);
    }

    @After
	public void dps() {
		driver.quit();
	}
}
