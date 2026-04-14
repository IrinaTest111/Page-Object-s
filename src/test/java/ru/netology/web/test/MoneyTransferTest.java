package ru.netology.web.test;

import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {

    @Test
    void shouldTransferMoneyBetweenOwnCards() {

        var loginPage = open("http://localhost:9999", LoginPage.class);
        var verificationPage = loginPage.validLogin(DataHelper.getValidAuthInfo());
        var dashboardPage = verificationPage.verify(DataHelper.getValidVerificationCode());

        var firstCard = DataHelper.getFirstCardInfo();
        var secondCard = DataHelper.getSecondCardInfo();

        var firstCardBalanceBefore = dashboardPage.getCardBalance(firstCard);
        var secondCardBalanceBefore = dashboardPage.getCardBalance(secondCard);

        System.out.println("Баланс первой карты до перевода: " + firstCardBalanceBefore);
        System.out.println("Баланс второй карты до перевода: " + secondCardBalanceBefore);

        var transferAmount = 3000;

        var transferPage = dashboardPage.selectCardForReplenishment(firstCard);

        dashboardPage = transferPage.transfer(secondCard, transferAmount);


        var firstCardBalanceAfter = dashboardPage.getCardBalance(firstCard);
        var secondCardBalanceAfter = dashboardPage.getCardBalance(secondCard);

        System.out.println("Баланс первой карты после перевода: " + firstCardBalanceAfter);
        System.out.println("Баланс второй карты после перевода: " + secondCardBalanceAfter);


        assertEquals(firstCardBalanceBefore + transferAmount, firstCardBalanceAfter,
                "Баланс первой карты должен увеличиться на " + transferAmount);

        assertEquals(secondCardBalanceBefore - transferAmount, secondCardBalanceAfter,
                "Баланс второй карты должен уменьшиться на " + transferAmount);
    }
}