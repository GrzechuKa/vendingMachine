package pl.sdacademy.vending.util;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
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

    @Test
    @Parameters
        public void shouldPropertlyFormatMoney(Long amountToFormat, String expectedResult) {
            // Given - in parameters
            // When
        String formatedMoney = StringUtil.formatMoney(amountToFormat);
        // Then
        assertEquals(expectedResult, formatedMoney);
    }

    public Object[] parametersForShouldPropertlyFormatMoney(){
        return new Object[]{
            new Object[]{123L, "1,23"},
            new Object[]{0L, "0,00"},
            new Object[]{5L, "0,05"},
            new Object[]{12L, "0,12"},
            new Object[]{1234L, "12,34"},
            new Object[]{12345L, "123,45"},
            new Object[]{123456L, "1 234,56"},
            new Object[]{1234567L, "12 345,67"},
            new Object[]{12345678L, "123 456,78"},
            new Object[]{123456789L, "1 234 567,89"},
            new Object[]{12345998556789L, "123 459 985 567,89"},
        };
    }

}