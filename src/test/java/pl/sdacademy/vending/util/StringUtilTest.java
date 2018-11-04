package pl.sdacademy.vending.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void shouldReturnUnmodifiedTextIfLenghtMatched() {
        // Given
        String textToAdjust = "Ala ma kota";
        Integer expectedLenght = 11;
        // When
        String adjustText = StringUtil.adjustText(textToAdjust, expectedLenght);
        // Then
        assertEquals("Ala ma kota", adjustText);
    }

    @Test
        public void shouldTrimTooLongText() {
            // Given
        String textToAdjust = "Ala ma kota";
        Integer expectedLenght = 6;
            // When
        String adjustText = StringUtil.adjustText(textToAdjust, expectedLenght);
            // Then
        assertEquals("Ala ma", adjustText);
    }

    @Test
    public void shouldAddSpaceWhenTextHaveEvenChar() {
        // Given
        String textToAdjust = "Alam";
        Integer expectedLenght = 6;
        // When
        String adjustText = StringUtil.adjustText(textToAdjust, expectedLenght);
        // Then
        assertEquals(" Alam ", adjustText);
    }

    @Test
    public void shouldAddSpaceWhenTextHaveOddChar() {
        // Given
        String textToAdjust = "Alam";
        Integer expectedLenght = 7;
        // When
        String adjustText = StringUtil.adjustText(textToAdjust, expectedLenght);
        // Then
        assertEquals("  Alam ", adjustText);
    }



    //"abcd" do 8 znakow "  abcd  "
    //"abc" -> 8 -> "   abc  "

}