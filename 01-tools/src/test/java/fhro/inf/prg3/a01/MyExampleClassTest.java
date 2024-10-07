package fhro.inf.prg3.a01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyExampleClassTest {
    @Test
    void testMultiply() {
        for(int i =-10; i < 10; i++) {
            assertEquals(i * (i - 1), new MyExampleClass().multiply(i, i - 1));
        }
    }
}