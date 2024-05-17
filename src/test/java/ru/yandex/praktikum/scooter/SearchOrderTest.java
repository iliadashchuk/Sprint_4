package ru.yandex.praktikum.scooter;

import org.junit.Test;
import ru.yandex.praktikum.page.ScooterPage;
import ru.yandex.praktikum.BaseTest;

// Searching order by incorrect number.

public class SearchOrderTest extends BaseTest {

    @Test
    public void orderNotFound(){

        goTo();
        acceptCookies();

        ScooterPage scooterPage = new ScooterPage(driver);
        scooterPage.clickOrderStatusButton();
        scooterPage.typeOrderNumber("Number");
        scooterPage.clickGoButton();
        scooterPage.orderNotFoundImg();
    }
}
