package pl.sdacademy.vending.model;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class TrayTest {

    @Test
    public void shouldBeAbleToBuyLastAvailableProduct() {
        // Given
        Product definiedProduct = new Product("P1");
        Tray tray = Tray.builder("A1").product(definiedProduct).build();
        // When
        Optional<Product> boughtProduxt = tray.buyProduct();
        // Then
        assertTrue(boughtProduxt.isPresent());
        assertEquals(definiedProduct, boughtProduxt.get());
    }


}