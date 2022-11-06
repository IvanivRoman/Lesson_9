package org.example;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

public class StackTest {
    @Test
    void shouldReturnTrueIfEmptyStack() {
        Stack stack = new Stack(0);
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    void shouldReturnFalseIfNotEmptyStack() {
        Stack stack = new Stack(3);
        stack.push(1);
        assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    void shouldReturnTrueIfStackFull() {
        Stack stack = new Stack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.isFull()).isTrue();
    }

    @Test
    void shouldReturnFalseIfStackNotFull() {
        Stack stack = new Stack(3);
        stack.push(1);
        stack.push(2);
        assertThat(stack.isFull()).isFalse();
    }

    @Test
    void shouldReturnLastAddedElement() {
        Stack stack = new Stack(3);
        stack.push(1);
        stack.push(2);
        assertThat(stack.readTop()).isEqualTo(2);
    }

    @Test
    void shouldThrowExceptionIfEmptyStackReadTop() {
        Stack stack = new Stack(0);
        Throwable thrown = catchThrowable(() -> stack.readTop());
        assertThat(thrown).isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    void shouldReturnStackSize() {
        Stack stack = new Stack(0);
        Stack stack1 = new Stack(1);
        stack1.push(7);
        assertThat(stack.getSize()).isEqualTo(0);
        assertThat(stack1.getSize()).isEqualTo(1);
    }

    @Test
    void shouldReturnElementIfPop() {
        Stack stack = new Stack(3);
        stack.push(1);
        stack.push(2);
        assertThat(stack.pop()).isEqualTo(2);
    }

    @Test
    void shouldThrowExceptionIfPopEmptyStack() {
        Stack stack = new Stack(3);
        Throwable thrown = catchThrowable(() -> stack.pop());
        assertThat(thrown).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void shouldAddElementToStack() {
        Stack stack = new Stack(3);
        stack.push(42);
        assertThat(stack.readTop()).isEqualTo(42);
    }

    @Test
    void shouldThrowExceptionAddElementToFullStack() {
        Stack stack = new Stack(3);
        stack.push(42);
        stack.push(43);
        stack.push(-51);
        Throwable thrown = catchThrowable(() -> stack.push(-50));
        assertThat(thrown).isInstanceOf(StackOverflowError.class);
    }
}
