package com.potter;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MethodSourceTest {
    @BeforeAll
    static void beforeAll() {
        open("https://rustxt.ru/palindrome");
    }

    private static Stream<Arguments> variations() {
        return Stream.of(
                Arguments.of("шалаш", "Это палиндром"),
                Arguments.of("кот", "Это не палиндром"),
                Arguments.of("топот", "Это палиндром")
        );
    }

    @ParameterizedTest
    @MethodSource("variations")
    public void checkTheResult(String word, String expected) {
        $x("//input[@name='palindrome']").setValue(word);
        $x("//button[text()='Проверить ']").click();
        $x("//div[@id='statusPalindrome']")
                .shouldHave(Condition.text(expected));
    }
}
