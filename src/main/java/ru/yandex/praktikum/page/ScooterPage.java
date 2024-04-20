package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ScooterPage{

    WebDriver driver;

    // Кнопка 'Статус заказа'
    private By orderStatusButtonLocator = By.xpath("//button[text()= 'Статус заказа']");
    // Поле ввода номера заказа
    private By orderNumberInputLocator = By.xpath("//input[@placeholder='Введите номер заказа']");
    // Кнопка 'Go!'
    private By goButtonLocator = By.xpath("//button[text()= 'Go!']");
    // Картинка для не найденного заказа
    private By orderNotFoundImgLocator = By.xpath("//img[@alt='Not found']");
    // Логотип самоката
    private By samokatLogoLocator = By.xpath("//a[contains(@class, 'Header_LogoScooter')]");
    // Заголовок на главной странице
    private By samokatPageTitleLocator = By.xpath("//div[contains(@class, 'Home_Header') and contains(text(), 'Самокат')]");
    // Кнопка 'Заказать' вверху страницы
    private By orderButtonInHeaderLocator = By.xpath("//div[contains(@class, 'Header')]//button[text()='Заказать']");
    // Кнопка 'Заказать' в центре страницы
    private By orderButtonInMiddleLocator = By.xpath("//button[text()='Заказать']/parent::div[contains(@class, 'Home')]");

    // Локатор для вопросов в accordion
    private  final String questionLocator = "accordion__heading-%s";
    // Локатор для ответов в accordion
    private  final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";

    public ScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSamokatLogo(){
        WebElement samokatLogo = driver.findElement(samokatLogoLocator);
        samokatLogo.click();
    }

    public boolean isSamokatPageTitleDisplayed(){
        WebElement pageTitle = driver.findElement(samokatPageTitleLocator);
        return pageTitle.isDisplayed();
    }

    public void clickOrderStatusButton(){
        WebElement orderStatusButton = driver.findElement(orderStatusButtonLocator);
        orderStatusButton.click();
    }

    public void typeOrderNumber(String orderNumber){
        WebElement orderInput = driver.findElement(orderNumberInputLocator);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(orderNumberInputLocator));
        orderInput.sendKeys(orderNumber);
    }

    public void clickGoButton(){
        WebElement goButton = driver.findElement(goButtonLocator);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(goButton));
        goButton.click();
    }

    public boolean orderNotFoundImg(){
        return driver.findElement(orderNotFoundImgLocator).isDisplayed();
    }

    public void createOrderButtonInHeader(){
        WebElement orderStatusButton = driver.findElement(orderButtonInHeaderLocator);
        orderStatusButton.click();
    }

    public void createOrderButtonInMiddle(){
        WebElement orderStatusButton = driver.findElement(orderButtonInMiddleLocator);
        orderStatusButton.click();
    }

    public void clickQuestionInAccordion(int index){
        WebElement element = driver.findElement(By.id(String.format(questionLocator, index)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean answerIsDisplayedInAccordion(String expectedAnswer){
        WebElement elementAnswer = driver.findElement(By.xpath(String.format(answerLocator, expectedAnswer)));
        return elementAnswer.isDisplayed();
    }
}
