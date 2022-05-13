package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MyProgramTests {
    @Test
    public void getPrecendence() {
        Assertions.assertEquals(1, MyProgram.getPrecendence('+'));
        Assertions.assertEquals(1, MyProgram.getPrecendence('-'));
        Assertions.assertEquals(2, MyProgram.getPrecendence('*'));
        Assertions.assertEquals(2, MyProgram.getPrecendence('/'));
        Assertions.assertEquals(0, MyProgram.getPrecendence('?'));
    }

    @Test
    public void performOperation() {
        Assertions.assertEquals(2.8f, MyProgram.calc(1.3f, 1.5f, '+'), 0.00001);
        Assertions.assertEquals(3.1f, MyProgram.calc(1.1f, 2, '+'), 0.00001);
        Assertions.assertEquals(4, MyProgram.calc(2, 2, '+'), 0.00001);

        Assertions.assertEquals(100, MyProgram.calc(120, 20, '-'));
        Assertions.assertEquals(63.535f, MyProgram.calc(75.535f, 12, '-'), 0.00001);
        Assertions.assertEquals(75.362f, MyProgram.calc(125.486f, 50.124f, '-'), 0.00001);

        Assertions.assertEquals(10, MyProgram.calc(2, 5, '*'), 0.00001);
        Assertions.assertEquals(2.2, MyProgram.calc(1.1f, 2, '*'), 0.00001);
        Assertions.assertEquals(6.25f, MyProgram.calc(2.5f, 2.5f, '*'), 0.00001);

        Assertions.assertEquals(100, MyProgram.calc(200, 2, '/'), 0.00001);
        Assertions.assertEquals(2.2f, MyProgram.calc(4.4f, 2, '/'), 0.00001);
        Assertions.assertEquals(3.12f, MyProgram.calc(13.26f, 4.25f, '/'), 0.00001);
    }

    @Test
    public void isOperator() {
        Assertions.assertTrue(MyProgram.isOperator('+'));
        Assertions.assertTrue(MyProgram.isOperator('-'));
        Assertions.assertTrue(MyProgram.isOperator('*'));
        Assertions.assertTrue(MyProgram.isOperator('/'));
        Assertions.assertFalse(MyProgram.isOperator('?'));
    }

    @Test
    public void calc() {
        Assertions.assertEquals(2.52f, MyProgram.calc(2.2f, 0.32f, '+'), 0.00001);
        Assertions.assertEquals(1.0f, MyProgram.calc(3.2f, 2.2f, '-'), 0.00001);
        Assertions.assertEquals(2937.0678f, MyProgram.calc(123.51f, 23.78f, '*'), 0.00001);
        Assertions.assertEquals(3.89491f, MyProgram.calc(10000, 2567.45f, '/'), 0.00001);
    }
}
