import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Helpers {

    WebDriver driver;

    public void selectItemForCategoryPickles(String path){
        //click on dropdown next to search
        driver.findElement(By.xpath(Constant.categoryDropdown)).click();
        //click on one of the category
        driver.findElement(By.xpath(Constant.picklesCategory)).click();
        //click search
        driver.findElement(By.xpath(Constant.searchHomePage)).click();
        //select the item
        driver.findElement(By.xpath(path)).click();
    }


}
