package mainTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class footerTest{
    private WebDriver driver;

    @BeforeClass

    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testFooterPresence(){
        driver.get("https://only.digital/");
        WebElement footer = driver.findElement(By.className("Footer_root___6Q28"));
        Assert.assertNotNull(footer,"Футер не был найден");

        List<WebElement> footerLink = footer.findElements(By.tagName("a"));
        Assert.assertTrue(footerLink.size() > 0, "В футере нет ссылок");

        WebElement email = footer.findElement(By.linkText("hello@only.digital"));
        Assert.assertNotNull(email, "Элемент почты не найден");
    }
    @AfterClass
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
