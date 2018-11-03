package pl.sdacademy.vending.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigurationTest {
    private Configuration testedConfig;

    @Before
    public void init() {
        testedConfig = new Configuration();
    }

    @Test
    public void shouldReturnDefaultStringValueWhenPropertyIsUnknow() {
        // Given
        String unknowPropertyName = "dhyyssd";
        String expectedDefault = "javaIsAwesome";
        // When
        String propertyValue = testedConfig.getStringPropoerty(unknowPropertyName, expectedDefault);
        // Then
        assertEquals(expectedDefault, propertyValue);
    }

    @Test
    public void shouldReturnDefaultLongValueWhenPropertyIsUnknow() {
        // Given
        String unknowPropertyName = "asdddeeg";
        Long expectedDefault = 5L;
        // When
        Long propertyValue = testedConfig.getLongProperty(unknowPropertyName, expectedDefault);
        // Then
        assertEquals(expectedDefault, propertyValue);
    }

    @Test
    public void shouldReturnStringValueWhenPropertyIsKnow() {
        // Given
        String unknowPropertyName = "test.properties.string";
        String expectedDefault = "7";
        // When
        String propertyValue = testedConfig.getStringPropoerty(unknowPropertyName, expectedDefault);
        // Then
        assertEquals("5", propertyValue);
    }

    @Test
    public void shouldReturnLongValueWhenPropertyIsKnow() {
        // Given
        String unknowPropertyName = "test.properties.string";
        Long expectedDefault = 10L;
        // When
        Long propertyValue = testedConfig.getLongProperty(unknowPropertyName, expectedDefault);
        // Then
        assertEquals((Long) 5L, propertyValue);
    }


}