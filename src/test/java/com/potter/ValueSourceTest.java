package com.potter;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

public class ValueSourceTest {

    @BeforeAll
    static void beforeAll() {
        open("https://rustxt.ru/palindrome");
    }

    @ParameterizedTest
    @ValueSource(strings = {"шалаш", "топот", "мем"})
    public void checkTheResult(String word) {
        $x("//input[@name='palindrome']").setValue(word);
        $x("//button[text()='Проверить ']").click();
        $x("//div[@id='statusPalindrome']")
                .shouldHave(Condition.text("Это палиндром"));
    }
}
