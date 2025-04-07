package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AdderTest {
    @Test
    public void testAdd() {
        Adder adder = new Adder();
        assertEquals(5, adder.add(2, 3));
    }
}
