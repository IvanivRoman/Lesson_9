package org.example;

import java.util.NoSuchElementException;

public class Stack implements Stackable {

    private int [] stack;
    private int top;
    private int capacity;

    Stack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int element) {
        if (isFull()) {
            System.err.println("Stack Overflow");
            throw new StackOverflowError();
        }

        stack[++top] = element;
    }

    public int pop() {
        if (isEmpty()) {
            System.err.println("Stack is empty");
            throw new NoSuchElementException();
        }

        return stack[top--];
    }

    public int readTop() {
        return stack[top];
    }

    public int getSize(){
        return top + 1;
    }

    public void printStack(){
        for (int i: stack) {
            System.out.print(i + ", ");
        }
    }
}