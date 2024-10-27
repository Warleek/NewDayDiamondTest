package com.bertrand.newday.diamond;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.bertrand.newday.diamond.DiamondKata.INVALID_LETTER_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class DiamondKataTest {

    @ParameterizedTest
    @MethodSource("provideDiamondForCharacter")
    void createDiamond(char character, String diamond) {
        String result = DiamondKata.createDiamond(character);
        assertEquals(diamond, result);
    }
    @Test
    void invalidCharacters() {
        String result1 = DiamondKata.createDiamond((char) 64);
        String result2 = DiamondKata.createDiamond((char) 91);
        assertAll("Character validation:",
                () -> assertEquals(INVALID_LETTER_MESSAGE, result1, "lower bound test failed"),
                () -> assertEquals(INVALID_LETTER_MESSAGE, result2, "higher bound test failed")
        );
    }

    private static Stream<Arguments> provideDiamondForCharacter() {
        return Stream.of(
                Arguments.of('A', "A"),
                Arguments.of('B', " A \nB B\n A "),
                Arguments.of('C', "  A  \n B B \nC   C\n B B \n  A  ")

        );
    }
}