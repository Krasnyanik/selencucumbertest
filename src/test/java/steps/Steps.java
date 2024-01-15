package steps;

import io.cucumber.java.ru.И;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Steps {
    private WebDriver driver = new ChromeDriver();
    private WebElement buttonAddProduct;

    @И("открыта страница по адресу {string}")
    public void открыта_страница_по_адресу(String string) {

        System.setProperty("webdriver.chromedriver.driver",
                "src/test/resources/chromedriver.exe");
        driver.get(string);
        driver.manage().timeouts().pageLoadTimeout(20,
                TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @И("выполнено нажатие на {string}")
    public void выполнено_нажатие_на(String string){
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        buttonAddProduct = driver.findElement(By.xpath("//*[contains(text(),'" + string + "')]"));
        buttonAddProduct.click();
    }

    @И("поле {string} видимо")
    public void поле_видимо(String string){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@placeholder=\"" + string + "\"]")).isEnabled();
    }

    @И("поле {string} заполняется значением {string}")
    public void поле_заполняется_значением(String arg0, String arg1){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement inputNameProduct = driver.findElement(By.xpath("//input[@placeholder=\"" + arg0 + "\"]"));
        inputNameProduct.sendKeys(arg1);
    }

    @И("в поле {string} выбрана категория {string}")
    public void в_поле_выбрана_категория(String arg0, String arg1){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement selectCategory = driver.findElement(By.xpath("//select[@name=\"type\"]"));
        selectCategory.click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement selectType = driver.findElement(By.xpath("//option[@value=\"" + arg1 + "\"]"));
        selectType.click();
    }

    @И("прожат чекбокс Экзотический")
    public void прожат_чекбокс_Экзотический(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement checkbox = driver.findElement(By.xpath("//input[@type =\"checkbox\"]"));
        checkbox.click();
    }
}