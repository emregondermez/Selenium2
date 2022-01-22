package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;

import java.time.Duration;

public class C02_Test {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement password= driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).submit();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
       String stringProduct =firstProduct.getText();
        firstProduct.click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("(//button[@id='add-to-cart-sauce-labs-backpack'])")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String expectedName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();

        System.out.println(stringProduct.equals(expectedName) ? "The product has been added to the cart." : "The product could not be added to the cart.");
        //9. Sayfayi kapatin
        driver.close();
    }
}
