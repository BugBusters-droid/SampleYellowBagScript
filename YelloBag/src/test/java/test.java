import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class test {

    WebDriver driver;
    Helpers helpers = new Helpers();

    @BeforeTest
    public void setup(){
        System.setProperty(Constant.webDriverKey, Constant.webDriverValue);
        driver = new ChromeDriver();
        driver.get(Constant.hostUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        System.out.println("Title is "+driver.getTitle());
    }

    @Test
    public void testPicklesCategory() throws InterruptedException {
        helpers.selectItemForCategoryPickles("//a[@href = 'https://www.yellowbag-sg.com/product/pickles-2/']");
        //increase the quantity
        driver.findElement(By.xpath(Constant.itemIncreaseIconOnAddToCartPage)).click();
        //click on add to cart
        driver.findElement(By.xpath(Constant.addToCart)).click();
        Thread.sleep(3000);
        //go to cart
        driver.findElement(By.xpath(Constant.gotToCart)).click();
        //find the quantity being displayed on cart against that item
        String quantityOfItemInCart = driver.findElement(By.xpath("//input[@id='quantity_60c4b47d515ea']")).getText();
        System.out.println(quantityOfItemInCart);
        Assert.assertEquals(quantityOfItemInCart, "2");
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

}
