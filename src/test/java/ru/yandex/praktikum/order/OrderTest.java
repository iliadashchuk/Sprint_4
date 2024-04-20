package ru.yandex.praktikum.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.page.OrderPage;
import ru.yandex.praktikum.page.ScooterPage;
import ru.yandex.praktikum.BaseTest;

// Create order using two different "Заказать" buttons.

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final String name;
    private final String lastName;
    private final String address;
    private final String subwayStation;
    private final String phoneNumber;
    private final String date;
    private final String rentPeriod;
    private final String colorOfScooter;
    private final String comment;

    public OrderTest(String name, String lastName, String address, String subwayStation,
                     String phoneNumber, String date, String rentPeriod, String colorOfScooter, String comment){
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentPeriod = rentPeriod;
        this.colorOfScooter = colorOfScooter;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Иван", "Неиванов", "Москва, ул Правды, д 6, кв 17", "Алексеевская", "89001002000", "21.04.2024", "трое суток", "чёрный жемчуг", "Комментарий"},
                {"Неиван", "Иванов", "Москва, ул Правды, д 8", "Черкизовская", "89001002000", "19.04.2024", "сутки", "серая безысходность", "Комментарий"},
        };
    }

    @Test
    public void createOrderWithButtonInHeader(){

        goTo();
        acceptCookies();

        ScooterPage scooterPage = new ScooterPage(driver);
        scooterPage.createOrderButtonInHeader();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillInFirstOrderForm(name, lastName, address, subwayStation, phoneNumber);
        orderPage.clickNextBtn();
        orderPage.fillInSecondOrderForm(date, rentPeriod, colorOfScooter, comment);
        orderPage.clickOrderButton();
        orderPage.clickConfirmOrder();
        orderPage.checkSuccessOrderTitle();
        orderPage.clickOrderStatusViewing();
    }

    @Test
    public void createOrderWithButtonInMiddle(){

        goTo();
        acceptCookies();

        ScooterPage scooterPage = new ScooterPage(driver);
        scooterPage.createOrderButtonInMiddle();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillInFirstOrderForm(name, lastName, address, subwayStation, phoneNumber);
        orderPage.clickNextBtn();
        orderPage.fillInSecondOrderForm(date, rentPeriod, colorOfScooter, comment);
        orderPage.clickOrderButton();
        orderPage.clickConfirmOrder();
        orderPage.checkSuccessOrderTitle();
        orderPage.clickOrderStatusViewing();
    }
}
