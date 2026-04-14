package ru.netology.web.data;

import lombok.Value;
import com.github.javafaker.Faker;

import java.util.Locale;


public class DataHelper {

    private static final Faker faker = new Faker(new Locale("ru"));


    private DataHelper() {
    }


    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    @Value
    public static class CardInfo {
        String cardNumber;
        String cardId;
    }

    public static AuthInfo getValidAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }


    public static VerificationCode getValidVerificationCode() {
        return new VerificationCode("12345");
    }


    public static CardInfo getFirstCardInfo() {
        return new CardInfo("5559 0000 0000 0001", "0001");
    }

    public static CardInfo getSecondCardInfo() {
        return new CardInfo("5559 0000 0000 0002", "0002");
    }
}