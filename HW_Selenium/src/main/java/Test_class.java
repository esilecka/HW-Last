
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class Test_class {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void Test_class () {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().setSize(new Dimension(1050, 708));
        driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.findElement(By.linkText("1")).click();
        driver.findElement(By.cssSelector("*[data-test=\"continue-shopping\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        driver.findElement(By.linkText("2")).click();
        driver.findElement(By.cssSelector("*[data-test=\"remove-sauce-labs-backpack\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"checkout\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"firstName\"]")).sendKeys("Olena");
        driver.findElement(By.cssSelector("*[data-test=\"lastName\"]")).sendKeys("Siletska");
        driver.findElement(By.cssSelector("*[data-test=\"postalCode\"]")).sendKeys("dfdfdfdfdfdfdfdf");
        driver.findElement(By.cssSelector("*[data-test=\"continue\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"finish\"]")).click();
        driver.findElement(By.id("checkout_complete_container")).click();
        assertThat(driver.findElement(By.cssSelector(".complete-text")).getText(), is("Your order has been dispatched, and will arrive just as fast as the pony can get there!"));
        driver.findElement(By.id("react-burger-menu-btn")).click();
      //  driver.findElement(By.id("logout_sidebar_link")).click();
    

    }
}
