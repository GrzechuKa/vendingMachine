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

    @Test
    public void shouldNotBeAbleToOverloadTray(){
        // Given
        Tray tray = Tray.builder("A1").build();
        for(int i=0; i < Tray.MAX_SIZE; i++){
            tray.addProduct(new Product("abc"));
        }
        Product product = new Product("P1");
        // When
        boolean result = tray.addProduct(product);
        tray.firstProductName();
        // Then
        assertFalse(result);
    }


}