package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//1-C01_TekrarTesti isimli bir class olusturun
public class C01_tekrarTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//div[text()='Ik ga akkoord']")).click();
        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle= driver.getTitle();
        String expectedTitle="Goggle";
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title test : Passed");
        }else{
            System.out.println("Title test : Failed");
        }
        //5- Arama cubuguna “Nutella” yazip aratin
      WebElement seachBox=  driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        seachBox.sendKeys("Nutella");
        seachBox.submit();
        //6-Bulunan sonuc sayisini yazdirin
      WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
      String resultString=result.getText();
      System.out.println(resultString);
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String arr[]= resultString.split(" ");
        String valueString= arr[1];
        String valueStringWithoutDot=valueString.replace(".","");
        int value = Integer.parseInt(valueStringWithoutDot);

        System.out.println(value > 10000000 ? "Result is greater than 10 million" : "result is NOT greater than 10 million");
        //8-Sayfayi kapatin
        driver.close();
    }
}
