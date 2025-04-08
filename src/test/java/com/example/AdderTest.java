package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AdderTest {
    @Test
    public void testAdd() {
        Adder adder = new Adder();
        assertEquals(6, adder.add(2, 3));
    }

    @Test
    public void testSubtract() {
        Adder adder = new Adder();
        assertEquals(1, adder.subtract(4, 3));
    }
}
