package ru.yandex.praktikum.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Поле ввода имени
    private By nameInputLocator = By.xpath("//input[@placeholder='* Имя']");
    // Поле ввода фамилии
    private By surnameInputLocator = By.xpath("//input[@placeholder='* Фамилия']");
    // Поле ввода адреса
    private By addressInputLocator = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле выбора станции метро
    private By subwayInputLocator = By.xpath("//input[@placeholder='* Станция метро']");
    // Поле ввода номера телефона
    private By phoneInputLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка далее
    private By nextButtonLocator = By.xpath("//button[text()='Далее']");
    // Поле ввода выбора даты получения самоката
    private By dateInputLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // Поле выбора срока аренды самоката
    private By rentPeriodInputLocator = By.xpath("//div[text()='* Срок аренды']");
    // Кнопка 'Заказать'
    private By createOrderButtonLocator = By.xpath("//button[contains(@class, 'Button_Middle') and text()='Заказать']");
    // Кнопка 'Да' для подтверждения заказа
    private By confirmOrderButtonLocator = By.xpath("//button[text()='Да']");
    // Заголовок 'Заказа оформлен'
    private By succesOrderTitleLocator = By.xpath("//div[contains(@class, 'Order_ModalHeader') and text()='Заказ оформлен']");
    // Кнопка 'Посмотреть статус'
    private By checkOrderStatusButtonLocator = By.xpath("//button[text()='Посмотреть статус']");
    // Поле комментарий для курьера
    private By commentImputLocator = By.xpath("//input[@placeholder='Комментарий для курьера']");

    // Локатор для станции метро
    private final String stationMenuItemLocator = "//div[contains(@class, 'Order_Text') and text()='%s']";
    // Локатор для выпадающего меню выбора срока аренды
    private final String rentPeriodItemLocator = "//div[contains(@class, 'Dropdown-option') and text()='%s']";
    // Локатор для выбора цвета на чекбоксах
    private final String colorOfScooterCheckboxLocator = "//label[contains(@class, 'Checkbox') and text()='%s']";


    public void fillInFirstOrderForm(String name, String lastName, String address, String subwayStation, String phoneNumber){
        typeName(name);
        typeLastname(lastName);
        typeAddress(address);
        typeSubwayStation(subwayStation);
        typePhoneNumber(phoneNumber);
    }
    public void typeName(String name){
        WebElement nameInput = driver.findElement(nameInputLocator);
        nameInput.sendKeys(name);
    }
    public void typeLastname(String lastName){
        WebElement surnameInput = driver.findElement(surnameInputLocator);
        surnameInput.sendKeys(lastName);
    }
    public void typeAddress(String address){
        WebElement addressInput = driver.findElement(addressInputLocator);
        addressInput.sendKeys(address);
    }
    public void typeSubwayStation(String subwayStation){
        WebElement subwayInput = driver.findElement(subwayInputLocator);
        subwayInput.click();

        WebElement subwayStationlocator = driver.findElement(By.xpath(String.format(stationMenuItemLocator, subwayStation)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", subwayStationlocator);
        subwayStationlocator.click();
    }
    public void typePhoneNumber(String phoneNumber){
        WebElement phoneInput = driver.findElement(phoneInputLocator);
        phoneInput.sendKeys(phoneNumber);
    }
    public void clickNextBtn(){
        WebElement nextBtn = driver.findElement(nextButtonLocator);
        nextBtn.click();
    }
    public void fillInSecondOrderForm(String date,String rentPeriod, String colorOfScooter, String comment){
        typeDate(date);
        chooseRentPeriod(rentPeriod);
        chooseColorOfScooter(colorOfScooter);
        typeComment(comment);
    }
    public  void typeDate(String data){
        WebElement dateInput = driver.findElement(dateInputLocator);
        dateInput.sendKeys(data, Keys.ENTER);
    }
    public void chooseRentPeriod(String rentPeriod){
        WebElement rentPeriodInput = driver.findElement(rentPeriodInputLocator);
        rentPeriodInput.click();

        WebElement rentPeriodItem = driver.findElement(By.xpath(String.format(rentPeriodItemLocator, rentPeriod)));
        rentPeriodItem.click();
    }
    public void chooseColorOfScooter(String colorOfScooter){
        WebElement colorOfScooterCheckbox = driver.findElement(By.xpath(String.format(colorOfScooterCheckboxLocator, colorOfScooter)));
        colorOfScooterCheckbox.click();
    }
    public void typeComment(String comment){
        WebElement colorOfScooterCheckbox = driver.findElement(commentImputLocator);
        colorOfScooterCheckbox.click();
        colorOfScooterCheckbox.sendKeys(comment);
    }
    public void clickOrderButton(){
        WebElement createOrderBtn = driver.findElement(createOrderButtonLocator);
        createOrderBtn.click();
    }
    public void clickConfirmOrder(){
        WebElement confirmBtn = driver.findElement(confirmOrderButtonLocator);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(confirmOrderButtonLocator));
        confirmBtn.click();
    }
    public void checkSuccessOrderTitle(){
        WebElement textOrdered = driver.findElement(succesOrderTitleLocator);
        textOrdered.isDisplayed();
    }
    public void clickOrderStatusViewing(){
        WebElement checkOrderStatusBtn = driver.findElement(checkOrderStatusButtonLocator);
        checkOrderStatusBtn.click();
    }
}
