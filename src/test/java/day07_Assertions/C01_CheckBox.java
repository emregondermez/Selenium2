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

public class C01_CheckBox {

    // verilen web sayfasina gidin
    // https://the-internet.herokuapp.com/checkboxes
    // checkbox 1 ve checkbox 2 elementlerini locate edin
    // checkbox 1 secili degilse onay kutusunu tiklayin
    //  checkbox 2 secili degilse onay kutusunu tiklayin

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
        // verilen web sayfasina gidin
        // https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        // checkbox 1 ve checkbox 2 elementlerini locate edin
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        // checkbox 1 secili degilse onay kutusunu tiklayin
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        //  checkbox 2 secili degilse onay kutusunu tiklayin
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }
    }

    @After
    public void teardown() throws InterruptedException {
    Thread.sleep(5000);
    driver.close();
    }
}
