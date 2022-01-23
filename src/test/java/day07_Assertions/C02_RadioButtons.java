package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_RadioButtons {

    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //1. Bir class oluşturun : RadioButtonTest
        //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //Cookies’i kabul edin
        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();
        //“Create an Account” button’una basin
        driver.findElement(By.xpath("(//a[@data-testid='open-registration-form-button'])")).click();
        //“radio buttons” elementlerini locate edin
        WebElement male = driver.findElement(By.xpath("(//input[@value='2'])"));
        WebElement female = driver.findElement(By.xpath("(//input[@value='1'])"));
        WebElement other = driver.findElement(By.xpath("(//input[@value='-1'])"));

        //Secili degilse cinsiyet butonundan size uygun olani secin
    male.click();
    }

    @After
    public void teardown() {
    driver.close();
    }
}
