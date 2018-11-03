package pl.sdacademy.vending.model;

import org.junit.Test;
import pl.sdacademy.vending.util.Configuration;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class VendingMachineTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExeptionWhenZeroRowsConfigured() {
        // Given
        Configuration config = mock(Configuration.class);
        doReturn(0L).when(config).getLongProperty(eq("machine.size.rows"), anyLong());
        doReturn(4L).when(config).getLongProperty(eq("machine.size.cols"), anyLong());
        // When
        new VendingMachine(config);
        // Then
        fail("Exeption should be raised");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExeptionWhenUpToNineRowsConfigured() {
        // Given
        Configuration config = mock(Configuration.class);
        doReturn(10L).when(config).getLongProperty(eq("machine.size.rows"), anyLong());
        doReturn(4L).when(config).getLongProperty(eq("machine.size.cols"), anyLong());
        // When
        new VendingMachine(config);
        // Then
        fail("Exeption should be raised");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExeptionWhenZeroColsConfigured() {
        // Given
        Configuration config = mock(Configuration.class);
        doReturn(5L).when(config).getLongProperty(eq("machine.size.rows"), anyLong());
        doReturn(0L).when(config).getLongProperty(eq("machine.size.cols"), anyLong());
        // When
        new VendingMachine(config);
        // Then
        fail("Exeption should be raised");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExeptionWhenUpTo26ColsConfigured() {
        // Given
        Configuration config = mock(Configuration.class);
        doReturn(5L).when(config).getLongProperty(eq("machine.size.rows"), anyLong());
        doReturn(27L).when(config).getLongProperty(eq("machine.size.cols"), anyLong());
        // When
        new VendingMachine(config);
        // Then
        fail("Exeption should be raised");
    }

    @Test()
    public void shouldCreateTrueConfigured() {
        // Given
        Configuration config = mock(Configuration.class);
        doReturn(5L).when(config).getLongProperty(eq("machine.size.rows"), anyLong());
        doReturn(7L).when(config).getLongProperty(eq("machine.size.cols"), anyLong());
        // When
        new VendingMachine(config);
        // Then

    }
}