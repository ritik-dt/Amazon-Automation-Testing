package AmazonAutomation;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AmazonTest {

        WebDriver driver;
        @BeforeTest
        public void setup()
        {
            driver= new ChromeDriver();

            driver.manage().window().maximize();

            driver.get("https://www.google.com/");

            WebElement searchBox = driver.findElement(By.xpath("//textarea[@title='Search']"));
            searchBox.sendKeys(Keys.chord("Amazon", Keys.ENTER));

            WebElement currentLink = driver.findElement(By.xpath("//*[@id='tads']/div[3]/div/div/div/div[1]/a/div[1]/span"));
            currentLink.click();
        }
        @Test(priority = 1)
        public void mobileTesting()
        {
            WebElement mobilelink= driver.findElement(By.linkText("Mobiles"));
            mobilelink.click();

            WebElement mobile= driver.findElement(By.linkText("Smartphones & Basic Mobiles"));
            mobile.click();

            WebElement firstMobile= driver.findElement(By.xpath("//*[@id='a-page']/div[1]/div[2]/div[3]/div[1]/div/div[2]/div[2]/ul/li[1]/span/div/a/div/div"));
            firstMobile.click();

            WebElement text= driver.findElement(By.xpath("//*[@id='productTitle']"));
            text.click();

            String st=text.getText();
            System.out.println("Mobile:"+st);

            WebElement home= driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]"));
            home.click();

        }
        @Test(priority = 2, dependsOnMethods = "mobileTesting")
        public void searchingTest()
        {
            WebElement search= driver.findElement(By.id("twotabsearchtextbox"));
            search.sendKeys(Keys.chord("Playstation", Keys.ENTER));

            WebElement playstation= driver.findElement(By.xpath("//*[@id=\"p_123/358345\"]/span/a/span"));
            playstation.click();
            

            WebElement home= driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]"));
            home.click();
        }
        @AfterTest
        public void tearDown() throws InterruptedException
       {
            Thread.sleep(2000);
           driver.quit();
        }
}