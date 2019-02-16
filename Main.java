/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author anish
 */

public class Main {
    public static void main(String[] args) {
        Stack<Character> s1 = new Stack<Character>();
        Stack<Integer> s2 = new Stack<Integer>();
        Scanner in = new Scanner(System.in);

        String exp = in.nextLine(); // a+b-(c^d)*e/f
        postfix(exp, s1);
        System.out.println();

        exp = in.nextLine(); // 12+3*45^/
        calculate(exp, s2);
    }

    public static void calculate(String exp, Stack<Integer> s) {
        for(char c : exp.toCharArray()) {
            if(Character.isDigit(c)) {
                s.push(Character.getNumericValue(c));
            } else if(s.size() > 1 && (c == '^' || c == '*' || c == '/' || c == '+' || c == '-')) {
                int b = s.pop();
                int a = s.pop();
                s.push(operation(a, b, c));
            } else {
                System.out.println("Invalid Expression");
                return;
            }
        }
        if(s.size() == 1) {
            System.out.println(s.pop());
        } else {
            System.out.println("Invalid Expression");
        }
    }

    public static int operation(int a, int b, char c) {
        switch(c) {
            case '^' :
                return a ^ b;
            case '*' :
                return a * b;
            case '/' :
                return a / b;
            case '+' :
                return a + b;
            case '-' :
                return a - b;
        }
        return 0;
    }

    public static void postfix(String exp, Stack<Character> s) {
        for(char c : exp.toCharArray()) {
            switch(c) {
                case '(':
                    s.push(c);
                    break;
                case ')':
                    if(s.empty()) {
                        System.out.println("\nInvalid Expression");
                        return;
                    }
                    while(s.peek() != '(' && !s.empty()) {
                        System.out.print(s.pop());
                    }
                    s.pop();
                    break;
                case '^':
                    s.push(c);
                    break;
                case '/':
                    while(!s.empty()) {
                        if(s.peek() == '^' || s.peek() == '*') {
                            System.out.print(s.pop());
                        } else if(s.peek() == '(') {
                                break;
                        } else {
                            break;
                        }
                    }
                    s.push(c);
                    break;
                case '*':
                    while(!s.empty()) {
                        if(s.peek() == '^' || s.peek() == '/') {
                            System.out.print(s.pop());
                        } else if(s.peek() == '(') {
                                break;
                        } else {
                            break;
                        }
                    }
                    s.push(c);
                    break;
                case '+':
                    while(!s.empty()) {
                        if(s.peek() == '^' || s.peek() == '*' || s.peek() == '/' || s.peek() == '-') {
                            System.out.print(s.pop());
                        } else if(s.peek() == '(') {
                                break;
                        } else {
                            break;
                        }
                    }
                    s.push(c);
                    break;
                case '-':
                    while(!s.empty()) {
                        if(s.peek() == '^' || s.peek() == '*' || s.peek() == '/' || s.peek() == '+') {
                            System.out.print(s.pop());
                        } else if(s.peek() == '(') {
                                break;
                        } else {
                            break;
                        }
                    }
                    s.push(c);
                    break;
                default:
                    System.out.print(c);
            }
        }
        while(!s.empty()) {
            System.out.print(s.pop());
        }
    }
}
