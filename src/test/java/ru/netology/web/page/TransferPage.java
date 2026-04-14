package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    private final SelenideElement fromCardField = $("[data-test-id='from'] input");
    private final SelenideElement amountField = $("[data-test-id='amount'] input");
    private final SelenideElement transferButton = $("[data-test-id='action-transfer']");

    public DashboardPage transfer(DataHelper.CardInfo fromCard, int amount) {
        fromCardField.setValue(fromCard.getCardNumber());
        amountField.setValue(String.valueOf(amount));
        transferButton.click();
        return new DashboardPage();
    }
}