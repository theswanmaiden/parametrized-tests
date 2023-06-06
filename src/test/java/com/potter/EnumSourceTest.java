package com.potter;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class EnumSourceTest {

    @BeforeAll
    static void beforeAll() {
        open("https://rustxt.ru/palindrome");
    }

    @ParameterizedTest
    @EnumSource(Words.class)
    public void checkTheResult(Words words){
        $x("//input[@name='palindrome']").setValue(words.name());
        $x("//button[text()='Проверить ']").click();
        $x("//div[@id='statusPalindrome']")
                .shouldHave(Condition.text("Это палиндром"));

    }
}
