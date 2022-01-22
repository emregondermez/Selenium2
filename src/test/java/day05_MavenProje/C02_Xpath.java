package day05_MavenProje;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.navigate().to("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
        //3. Login alanine  “username” yazdirin
        driver.findElement(By.id("user_login")).sendKeys("username");
        //4. Password alanine “password” yazdirin
        driver.findElement(By.id("user_password")).sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.name("submit")).click();

        driver.findElement(By.xpath("//button[@id='primary-button']")).click();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("45");
        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@name='date']")).sendKeys("2020-09-10");
        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@value='Pay']")).click();
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
       WebElement isSubmitted = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
        System.out.println(isSubmitted.isDisplayed()?"Submit test : Passed":"Submit test : Failed");

        System.out.println("GOREV TAMAMLANDI");

        driver.close();

    }
}
