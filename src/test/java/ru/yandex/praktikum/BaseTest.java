package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    private WebDriverFactory webDriverFactory = new WebDriverFactory();
    private final String SITE_URL = "https://qa-scooter.praktikum-services.ru/";
    public void goTo(){
        driver.get(SITE_URL);
    }

    public void acceptCookies(){
        driver.findElement(By.xpath(".//button[contains(@class, 'App_CookieButton')]")).click();
    }

    @Before
    public void start(){
        driver = webDriverFactory.getWebDriver(System.getProperty("browser", "chrome"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void finish(){
        driver.quit();
    }
}
