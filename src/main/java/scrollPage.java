import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class scrollPage {
    WebDriver driver;
    @Test
    public void ByPixel() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/thanos-imac/Desktop/scrollpageapp/src/main/resources/chromedriver");
        driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Launch the application
        driver.get("https://github.com/");

        //To maximize the window. This code may not work with Selenium 3 jars. If script fails you can remove the line below
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // This  will scroll down the page by  1000 pixel vertical
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(5000);

        //This will scroll the web page till end.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5000);

        //This will scroll the page Horizontally till the element is found
        WebElement Element = driver.findElement(By.linkText("Training"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(5000);
    }

    @AfterTest
    public void after(){
        driver.close();
        driver.quit();
        System.out.println("Scroll UP or Down a page in Selenium Webdriver");
    }




}
