package com.encoding.ui.Model;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public WebDriverWait wait;
    public String browser = "CHROME";
    static Logger logger = Logger.getLogger(TestBase.class);

    @BeforeTest
    public void start() {
        if ("CHROME".equals(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new EventFiringWebDriver(new ChromeDriver());
        } else if ("FIREFOX".equals(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new EventFiringWebDriver(new FirefoxDriver());
        } else if ("SAFARI".equals(browser)) {
            driver = new EventFiringWebDriver(new SafariDriver());
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }
}
