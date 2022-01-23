package day07_Assertions;

import io.github.bonigarcia.wdm.WdmAgent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestBuyAssetions {

    //1) https://www.bestbuy.com/ Adresine gidin farkli
    // test method’lari olusturarak asagidaki testleri yapin
    //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //		○ logoTest => BestBuy logosunun görüntülendigini test edin
    //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

   static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void test01() {
     //   ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        driver.get("https://www.bestbuy.com/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bestbuy.com/");
    }

    @Test
    public void test02() {
      //  ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        Assert.assertFalse(driver.getTitle().contains("Rest"));
    }
    @Test
    public void test03() {
        //		○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isEnabled());
    }

    @Test
    public void test04() {
        	//	○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement french = driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(french.isEnabled());
    }
    @AfterClass
    public static void teardown() {
       driver.close();
    }
}
