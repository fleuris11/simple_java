package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(4, calc.add(2, 2));
    }

    @Test
    public void testSubtract() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.subtract(2, 2));
    }
}