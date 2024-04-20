package ru.yandex.praktikum.scooter;

import org.junit.Test;
import ru.yandex.praktikum.page.ScooterPage;
import ru.yandex.praktikum.BaseTest;

// Checking "Самокат" logo.

public class LogoScooterTest extends BaseTest {

    @Test
    public void ckeckLogoScooter(){

        goTo();
        acceptCookies();

        ScooterPage scooterPage = new ScooterPage(driver);
        scooterPage.createOrderButtonInHeader();
        scooterPage.clickSamokatLogo();
        scooterPage.isSamokatPageTitleDisplayed();
    }
}
