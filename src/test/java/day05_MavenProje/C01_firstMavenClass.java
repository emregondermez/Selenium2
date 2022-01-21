package day05_MavenProje;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class C01_firstMavenClass {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.navigate().to("https://www.amazon.com/");
        //2- arama kutusunu locate edelim
        WebElement searhBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        //3- “Samsung headphones” ile arama yapalim
        searhBox.sendKeys("Samsung headphones");
        searhBox.submit();
        //4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisiElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucSayisiElementi.getText());
        //5- Ilk urunu tiklayalim
       WebElement firstProduct = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        firstProduct.click();

        //6- onceki sayfaya donup Sayfadaki tum basliklari yazdiralim
       driver.navigate().back();
        List<WebElement> headTitles = driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));
        System.out.println("Baslik sayisi : "+headTitles.size());

        driver.close();
    }
}
