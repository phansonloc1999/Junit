package com.example;

import java.util.Scanner;
import java.util.Stack;

// Referenced algorithm: https://www.geeksforgeeks.org/expression-evaluation/

public class MyProgram {
    private static float calc(float a, float b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    private static boolean isOperator(char symbol) {
        if (symbol != '+' && symbol != '-' && symbol != '*' && symbol != '/') {
            return false;
        }
        return true;
    }

    private static int getPrecendence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        }
        if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    private static void performOperation(Stack<Float> operands, Stack<Character> operators) {
        char operator = operators.pop();
        float operand1 = operands.pop(), operand2 = operands.pop();
        float result = calc(operand2, operand1, operator);
        operands.push(result);
    }

    public static void main(String[] args) {
        String expression = "";
        System.out.print("Nhap bieu thuc: ");
        Scanner scanner = new Scanner(System.in);
        expression = scanner.nextLine();

        Stack<Float> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            if (symbol == ' ')
                continue;

            if (Character.isDigit(symbol)) {
                String operand = "";
                do {
                    operand += symbol;
                    i++;
                    if (i >= expression.length())
                        break;
                    symbol = expression.charAt(i);
                } while (Character.isDigit(symbol) || symbol == '.');
                operands.push(Float.parseFloat(operand));
            }

            if (symbol == '(') {
                operators.push(symbol);
                continue;
            }

            if (symbol == ')') {
                while (operators.peek() != '(') {
                    performOperation(operands, operators);
                }
                operators.pop();
                continue;
            }

            if (isOperator(symbol)) {
                while (!operators.empty() && getPrecendence(operators.peek()) >= getPrecendence(symbol)) {
                    performOperation(operands, operators);
                }
                operators.push(symbol);
                continue;
            }
        }

        while (!operators.empty()) {
            performOperation(operands, operators);
        }

        System.out.println(operands.pop());
    }
}
