package com.potter;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CSVSource {

    @BeforeAll
    static void beforeAll() {
        open("https://rustxt.ru/palindrome");
    }

    @ParameterizedTest
    @CsvSource({"шалаш,Это палиндром", "кот,Это не палиндром", "кошка,Это не палиндром"})
    public void checkTheResult(String word, String expected) {
        $x("//input[@name='palindrome']").setValue(word);
        $x("//button[text()='Проверить ']").click();
        $x("//div[@id='statusPalindrome']")
                .shouldHave(Condition.text(expected));
    }
}
